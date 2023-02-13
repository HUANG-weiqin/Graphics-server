package geometrics;

import geometrics.geom.Circle;
import geometrics.geom.Line;
import geometrics.geom.Polygone;

/**
 * visitor模式，用来解耦图形内容，和绘制方法，比如目前用awt 库来绘制，实现在GeomDisplayVisitor里，之后如果想用其他的库来画，只需要实现另一个 visitor即可，不需要
 * 更改任何 图形 的代码
 */
public interface GeomVisitor {

    void  visit(GeomCompos g);
    void visit(Circle c);
    void  visit(Polygone p);

    void visit(Line line);
}
