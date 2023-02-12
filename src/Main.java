import geometrics.GeomCompos;
import geometrics.GeomVisitor;
import graphic.DisplayWindow;
import graphic.GeomDisplayVisitor;
import geometrics.geom.Circle;
import geometrics.tools.Points;
import parser.RequestParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            GeomCompos rootGeom = new GeomCompos();

            while (true) {
                boolean changed = RequestParser.getInstance().update(rootGeom);
                if (changed) {
                    GeomDisplayVisitor.getInstance().visit(rootGeom);
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}