package geometrics;

import java.io.Serializable;

/**
 * 所有图形的父类，任何图形都要继承该类，并实现accept方法接受 一个visitor的访问
 */
public abstract class Geometric implements Serializable {
    public abstract void accept(GeomVisitor geomVisitor);
}
