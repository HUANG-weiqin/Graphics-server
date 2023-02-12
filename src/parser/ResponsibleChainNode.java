package parser;

import geometrics.GeomCompos;

import java.util.ArrayList;

enum CmdLevel {
    CIRCLE,
    POLYGONE,
    Line ,
    LOAD,
    SAVE,
    LINE
}

public abstract class ResponsibleChainNode {
    protected CmdLevel level = null;
    protected ResponsibleChainNode next = null;

    public ResponsibleChainNode(CmdLevel cmdLevel, ResponsibleChainNode prev) {
        this.level = cmdLevel;
        prev.next = this;
    }

    public ResponsibleChainNode() {

    }

    public ResponsibleChainNode(CmdLevel cmdLevel) {
        this.level = cmdLevel;
    }

    public void handle(GeomCompos geom, int cmd_idx, ArrayList<Integer> args){
        if(cmd_idx > level.ordinal()){
            next.handle(geom,cmd_idx,args);
        }
        else {
            System.out.println("Request :" + this.level.name() + " " + args.toString());
            exec(geom,args);
        }
    }

    protected abstract void exec(GeomCompos geom, ArrayList<Integer> args);
}
