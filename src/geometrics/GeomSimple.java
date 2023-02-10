package geometrics;

import geometrics.tools.Points;

import java.util.ArrayList;

public abstract class GeomSimple extends Geometric{
    private ArrayList<Points> points;
    public GeomSimple(){
        points = new ArrayList<>();
    }

    protected void addPoint(Points p){
        points.add(p);
    }

    public int nbPoints(){
        return points.size();
    }

}
