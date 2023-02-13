package geometrics.geom;

import geometrics.GeomSimple;
import geometrics.GeomVisitor;
import geometrics.tools.Points;

/**
 * 简单图形 线段，由两个端点组成
 */
public class Line extends GeomSimple {

    public Line(Points p1, Points p2) {
        addPoint(p1);
        addPoint(p2);
    }

    @Override
    public void accept(GeomVisitor geomVisitor) {
        geomVisitor.visit(this);
    }
}
