package geometrics.tools;

import java.io.Serializable;

public class Points implements Serializable {
    private int x;
    private int y;

    public Points(int x,int y){
        this.x = x;
        this.y = y;
    }

    public Points(Integer x,Integer y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
