import geometrics.GeomCompos;
import geometrics.GeomVisitor;
import geometrics.Geometric;
import geometrics.simple.Circle;

public class GeomDisplayVisitor implements GeomVisitor{

    private DisplayWindow w = DisplayWindow.getInstance();

    private static GeomDisplayVisitor instance;
    private GeomDisplayVisitor(){}

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
        w.getGraphics().drawOval(c.getCenter().getX(),c.getCenter().getY(),c.getR(),c.getR());
        w.update();

    }
}
