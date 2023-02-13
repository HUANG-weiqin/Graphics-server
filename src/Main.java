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
            GeomCompos rootGeom = new GeomCompos(); /*代表整个屏幕的 图形集合*/

            while (true) {
                boolean changed = RequestParser.getInstance().update(rootGeom);/*解析并处理请求，返回是否有新的图形被加入*/
                if (changed) {
                    GeomDisplayVisitor.getInstance().visit(rootGeom);/*如果有新的图形被加入了，那么要用visitor访问他们，通过visitor做出对应处理，在这里就是通过awt绘制*/
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}