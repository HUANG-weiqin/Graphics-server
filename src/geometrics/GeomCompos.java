package geometrics;

import java.util.ArrayList;

public class GeomCompos extends Geometric{

    private ArrayList<Geometric> geometrics;

    public GeomCompos(){
        geometrics = new ArrayList<>();
    }

    public void addGeometric(Geometric geom){
        geometrics.add(geom);
    }

    public ArrayList<Geometric> getGeometrics() {
        return geometrics;
    }

    @Override
    public void accept(GeomVisitor geomVisitor) {
        geomVisitor.visit(this);
    }
}
