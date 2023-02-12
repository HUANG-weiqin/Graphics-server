package parser;

import geometrics.GeomCompos;
import geometrics.geom.Line;
import parser.network.Server;

import java.io.IOException;
import java.util.ArrayList;

public class RequestParser {
    private static ResponsibleChainNode root = null;
    private RequestParser(){
        root = new NodeCircle(CmdLevel.CIRCLE);
        NodePolygone p = new NodePolygone(CmdLevel.POLYGONE,root);
        NodeLine ln = new NodeLine(CmdLevel.Line,p);
        NodeLoad load = new NodeLoad(CmdLevel.LOAD,ln);
        NodeSave save = new NodeSave(CmdLevel.SAVE,load);
    }
    private static RequestParser instance = null;

    public static RequestParser getInstance(){
        if(instance == null){
            instance = new RequestParser();
        }
        return instance;
    }

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
