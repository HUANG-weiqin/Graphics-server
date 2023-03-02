package parser;

import geometrics.GeomCompos;
import geometrics.geom.Circle;
import geometrics.tools.Points;

import java.awt.*;
import java.util.ArrayList;

public class NodeCircle extends ResponsibleChainNode {

    public NodeCircle(CmdLevel circle) {
        super(circle);
    }

    public NodeCircle(CmdLevel cmdLevel, ResponsibleChainNode prev) {
        super(cmdLevel, prev);
    }

    /**
     * 绘制圆形
     */
    @Override
    protected void exec(GeomCompos geom, ArrayList<Integer> args) {
        Circle circle = new Circle(new Points(args.get(0),args.get(1)),args.get(2));
        circle.setColor(new Color(args.get(3),args.get(4),args.get(5)));
        geom.addGeometric(circle);
    }
}
