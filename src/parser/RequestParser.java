package parser;

import geometrics.GeomCompos;
import parser.network.Server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RequestParser {
    private static RequestHandlerChainNode root = null;
    private RequestParser(){
        root = new NodeCircle(CmdLevel.CIRCLE);
        NodePolygone p = new NodePolygone(CmdLevel.POLYGONE,root);
    }
    private static RequestParser instance = null;

    public static RequestParser getInstance(){
        if(instance == null){
            instance = new RequestParser();
        }
        return instance;
    }

    public void update(GeomCompos screen) throws IOException {

        for(String msg: Server.getInstance().update()){
            String[] args = msg.split(" ");
            if(args.length == 0) return;

            ArrayList<Integer> params = new ArrayList<>();
            int cmd = Integer.parseInt(args[0]);

            for(int i = 0;i < args.length;++i){
                params.add(Integer.parseInt(args[i]));
            }

            root.handle(screen,cmd,params);
        }
    }

}
