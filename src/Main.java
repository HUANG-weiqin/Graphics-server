import geometrics.GeomCompos;
import graphic.GeomDisplayVisitor;
import geometrics.geom.Circle;
import geometrics.tools.Points;
import parser.RequestParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        GeomCompos rootGeom = new GeomCompos();

        while (true){
            RequestParser.getInstance().update(rootGeom);
        }

    }
}