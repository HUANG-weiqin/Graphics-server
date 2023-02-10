import geometrics.simple.Circle;
import geometrics.tools.Points;

public class Main {
    public static void main(String[] args){
        Circle c = new Circle(new Points(30,100),50);
        GeomDisplayVisitor.getInstance().visit(c);
    }
}