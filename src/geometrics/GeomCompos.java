package geometrics;

import java.util.ArrayList;

/**
 * 与简单图形，GeomSimple相对，不能单独存在，由一系列图形组成，可以看作是图形的集合geometrics
 */
public class GeomCompos extends Geometric{

    private ArrayList<Geometric> geometrics;

    public GeomCompos(){
        geometrics = new ArrayList<>();
    }

    public void addGeometric(Geometric geom){
        geometrics.add(geom);
    }

    public void MergeGeomCompos(GeomCompos other){
        geometrics.addAll(other.geometrics);
    }

    public ArrayList<Geometric> getGeometrics() {
        return geometrics;
    }

    @Override
    public void accept(GeomVisitor geomVisitor) {
        geomVisitor.visit(this);
    }

    public void clear(){geometrics.clear();}
}
