package parser;

import geometrics.GeomCompos;
import geometrics.geom.Circle;
import geometrics.tools.Points;

import java.util.ArrayList;

public class NodePolygone extends RequestHandlerChainNode{
    public NodePolygone(CmdLevel polygone, RequestHandlerChainNode prev) {
        super(polygone,prev);
    }

    @Override
    protected void exec(GeomCompos geom, ArrayList<Integer> args) {
        Circle circle = new Circle(new Points(args.get(0),args.get(1)),args.get(2));
    }
}
