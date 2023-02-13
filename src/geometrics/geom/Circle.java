package geometrics.geom;
import geometrics.GeomSimple;
import geometrics.GeomVisitor;
import geometrics.tools.Points;

/**
 * 简单图形 圆形，由一个圆心和半径组成
 */
public class Circle extends GeomSimple {
    private Points center;
    private int R;

    public Circle(Points center,int R){
        addPoint(center);
        this.center = center;
        this.R = R;
    }

    @Override
    public void accept(GeomVisitor geomVisitor) {
        geomVisitor.visit(this);
    }

    public Points getCenter() {
        return center;
    }

    public void setCenter(Points center) {
        this.center = center;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }
}
