package parser;

import geometrics.GeomCompos;
import graphic.DisplayWindow;

import java.util.ArrayList;

public class NodeClear extends ResponsibleChainNode{
    public NodeClear(CmdLevel cmdLevel, NodeSave prev) {
            super(cmdLevel, prev);
    }

    @Override
    protected void exec(GeomCompos geom, ArrayList<Float> args) {
        DisplayWindow.getInstance().clear();
    }
}
