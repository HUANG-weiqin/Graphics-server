package geometrics;

import geometrics.tools.Points;

import java.util.ArrayList;
import java.util.List;
/**
 * 简单图形，与GeomCompos相对，是一个单独的图形，比如多边形，圆形，线段，由一系列端点points组成
 */
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

    public ArrayList<Points> getPoints(){
        return points;
    }

}
