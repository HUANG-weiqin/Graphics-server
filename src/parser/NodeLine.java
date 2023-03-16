package parser;

import geometrics.GeomCompos;
import geometrics.geom.Line;
import geometrics.tools.Points;

import java.awt.*;
import java.util.ArrayList;

public class NodeLine extends ResponsibleChainNode{
    public NodeLine(CmdLevel cmdLevel, ResponsibleChainNode prev) {
        super(cmdLevel, prev);
    }

    /**
     * 绘制线段
     */
    @Override
    protected void exec(GeomCompos geom, ArrayList<Float> args) {
        Points p1 = new Points(args.get(0),args.get(1));
        Points p2 = new Points(args.get(2),args.get(3));
        Line line = new Line(p1,p2);
        line.setColor(new Color(args.get(4),args.get(5),args.get(6)));
        geom.addGeometric(line);
    }
}
