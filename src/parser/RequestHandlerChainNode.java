package parser;

import geometrics.GeomCompos;

import java.util.ArrayList;

enum CmdLevel {
    CIRCLE,
    POLYGONE,
    LINE
}

public abstract class RequestHandlerChainNode {
    protected CmdLevel level = null;
    protected RequestHandlerChainNode next = null;

    public RequestHandlerChainNode(CmdLevel cmdLevel,RequestHandlerChainNode prev) {
        this.level = cmdLevel;
        prev.next = this;
    }

    public RequestHandlerChainNode() {

    }

    public RequestHandlerChainNode(CmdLevel cmdLevel) {
        this.level = cmdLevel;
    }

    public void handle(GeomCompos geom, int cmd_idx, ArrayList<Integer> args){
        if(cmd_idx < level.ordinal()){
            next.handle(geom,cmd_idx,args);
        }
        else {
            exec(geom,args);
        }
    }

    protected abstract void exec(GeomCompos geom, ArrayList<Integer> args);
}
