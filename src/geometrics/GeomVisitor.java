package geometrics;

import geometrics.simple.Circle;

public interface GeomVisitor {

    void  visit(GeomCompos g);
    void visit(Circle c);
}
