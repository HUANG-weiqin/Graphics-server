package geometrics;

import geometrics.geom.Circle;
import geometrics.geom.Line;
import geometrics.geom.Polygone;

public interface GeomVisitor {

    void  visit(GeomCompos g);
    void visit(Circle c);
    void  visit(Polygone p);

    void visit(Line line);
}
