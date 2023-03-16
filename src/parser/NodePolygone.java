package parser;

import geometrics.GeomCompos;
import geometrics.geom.Polygone;
import geometrics.tools.Points;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NodePolygone extends ResponsibleChainNode {
    public NodePolygone(CmdLevel polygone, ResponsibleChainNode prev) {
        super(polygone,prev);
    }
    /**
     * 绘制多边形，args中存储多边形顶点
     */
    @Override
    protected void exec(GeomCompos geom, ArrayList<Float> args) {
        List<Points> points = new ArrayList<>();

        for(int i=0;i<args.size()-3;i+=2){
            points.add(new Points(args.get(i),args.get(i+1)));
        }

        Polygone pl = new Polygone(points);
        int r = args.get(args.size()-3).intValue();
        int g = args.get(args.size()-2).intValue();
        int b = args.get(args.size()-1).intValue();
        pl.setColor(new Color(r,g,b));
        geom.addGeometric(pl);
    }
}
