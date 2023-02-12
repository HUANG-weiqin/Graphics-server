package parser;

import geometrics.GeomCompos;
import geometrics.geom.Polygone;
import geometrics.tools.Points;

import java.util.ArrayList;
import java.util.List;

public class NodePolygone extends ResponsibleChainNode {
    public NodePolygone(CmdLevel polygone, ResponsibleChainNode prev) {
        super(polygone,prev);
    }

    @Override
    protected void exec(GeomCompos geom, ArrayList<Integer> args) {
        List<Points> points = new ArrayList<>();

        for(int i=0;i<args.size();i+=2){
            points.add(new Points(args.get(i),args.get(i+1)));
        }

        Polygone pl = new Polygone(points);
        geom.addGeometric(pl);
    }
}
