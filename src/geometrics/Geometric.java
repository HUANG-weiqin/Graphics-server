package geometrics;

import java.io.Serializable;

public abstract class Geometric implements Serializable {
    public abstract void accept(GeomVisitor geomVisitor);
}
