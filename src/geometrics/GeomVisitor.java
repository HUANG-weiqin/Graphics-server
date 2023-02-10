package geometrics;

import geometrics.geom.Circle;

public interface GeomVisitor {

    void  visit(GeomCompos g);
    void visit(Circle c);
}
