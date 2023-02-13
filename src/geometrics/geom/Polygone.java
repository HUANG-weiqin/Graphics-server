package geometrics.geom;

import geometrics.GeomSimple;
import geometrics.GeomVisitor;
import geometrics.tools.Points;

import java.util.List;

/**
 * 简单图形多边形，由一系列顶点组成
 */
public class Polygone extends GeomSimple {
    public Polygone(List<Points> points) {
        for (Points p: points){
            addPoint(p);
        }
    }

    @Override
    public void accept(GeomVisitor geomVisitor) {
        geomVisitor.visit(this);
    }
}
