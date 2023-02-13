package parser;

import geometrics.GeomCompos;
import parser.network.Server;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 客户端请求解析器，将字符串形态的客户端请求解析转成可处理的形态，并交由责任链处理
 */
public class RequestParser {
    /**
     *  责任链条的头部节点，所有解析成功的请求都将从头顺序传递下去直到找到了对应的处理节点
     */
    private static ResponsibleChainNode root = null;
    private RequestParser(){
        root = new NodeCircle(CmdLevel.CIRCLE);
        NodePolygone p = new NodePolygone(CmdLevel.POLYGONE,root);
        NodeLine ln = new NodeLine(CmdLevel.Line,p);
        NodeLoad load = new NodeLoad(CmdLevel.LOAD,ln);
        NodeSave save = new NodeSave(CmdLevel.SAVE,load);
    }
    private static RequestParser instance = null;

    /**
     * 解析器是单例模式，因为没必要有多个解析器
     */
    public static RequestParser getInstance(){
        if(instance == null){
            instance = new RequestParser();
        }
        return instance;
    }

    /**
     * 判断该请求是否由本节点处理，若是 则执行 exec 否则将请求发往下一个节点
     * @param screen 代表屏幕上所有的的图形集合，因为解析后的指令可能会在这上面添加新的图形
     * @return 返回是否有新的图形被添加进了screen中
     */
    public boolean update(GeomCompos screen) throws IOException {
        try {
            for(String msg: Server.getInstance().update()){
                String[] args = msg.split(" ");
                if(args.length == 0) return false;

                ArrayList<Integer> params = new ArrayList<>();
                int cmd = Integer.parseInt(args[0]);

                for(int i = 1;i < args.length;++i){
                    params.add(Integer.parseInt(args[i]));
                }

                root.handle(screen,cmd,params);
                return  true;
            }
        }
        catch (NumberFormatException ex)
        {
            System.out.println(ex);
        }
        return  false;
    }

}
