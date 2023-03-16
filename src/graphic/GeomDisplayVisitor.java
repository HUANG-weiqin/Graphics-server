package graphic;

import geometrics.GeomCompos;
import geometrics.GeomVisitor;
import geometrics.Geometric;
import geometrics.geom.Circle;
import geometrics.geom.Line;
import geometrics.geom.Polygone;
import geometrics.tools.Points;

import java.awt.*;
import java.util.ArrayList;

public class GeomDisplayVisitor implements GeomVisitor {

    private DisplayWindow w = DisplayWindow.getInstance();

    private static GeomDisplayVisitor instance;
    private GeomDisplayVisitor(){}

    private Points convert(Points p){
        int seuil_w = 20;
        int seuil_h= 20;

        float px = p.getX() + seuil_w/2;
        float py = p.getY() + seuil_h/2;

        int height = w.getFrame().getHeight();
        int width = w.getFrame().getWidth();

        Float new_w = (float) (px * width / seuil_w);
        Float new_h = (float) (py * height / seuil_h);

        return new Points(new_w,new_h);
    }

    private Integer convert(Float x){
        int seuil_w = 20;

        int width = w.getFrame().getWidth();

        Integer new_w = (int) (x * width / seuil_w);

        return new_w;
    }

    /**
     * 绘制图形的visitor，用了单例模式，因为不需要多个该visitor的实例
     */
    public static GeomDisplayVisitor getInstance(){
        if(instance == null){
            instance = new GeomDisplayVisitor();
        }
        return  instance;
    }

    @Override
    public void visit(GeomCompos geomCompos) {
        for (Geometric g :
                geomCompos.getGeometrics()) {
            g.accept(this);
        }
    }

    @Override
    public void visit(Circle c) {
        Graphics g = w.getGraphics();
        g.setColor(c.getColor());
        Points center = convert(c.getCenter());
        int r = convert(c.getR());
        g.fillOval((int) (center.getX() - r), (int) (center.getY() - r),r * 2,r * 2);
    }

    @Override
    public void visit(Polygone p) {
        int xx[] = new int[p.nbPoints()];
        int yy[] = new int[p.nbPoints()];
        int i=0;
        for (Points pt:p.getPoints()){
            Points newp = convert(pt);
            xx[i] = (int)newp.getX();
            yy[i] = (int)newp.getY();
            i+=1;
        }
        Graphics g = w.getGraphics();
        g.setColor(p.getColor());
        g.fillPolygon(xx,yy,p.nbPoints());
    }

    @Override
    public void visit(Line line) {
        Points p1 = convert(line.getPoints().get(0)) ;
        Points p2 = convert(line.getPoints().get(1)) ;
        Graphics g = w.getGraphics();
        g.setColor(line.getColor());
        g.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(),(int) p2.getY());
    }


}
