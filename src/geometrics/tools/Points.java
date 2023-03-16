package geometrics.tools;

import java.io.Serializable;

public class Points implements Serializable {
    private Float x;
    private Float y;

    public Points(Float x,Float y){
        this.x = x;
        this.y = y;
    }
    public float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }
}
