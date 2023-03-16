package parser;

import geometrics.GeomCompos;

import java.util.ArrayList;

/**
 这个是一个枚举类，用来解析 client 发来的信息头部的，比如client发来的message头部是 0 ... 那么就是Circle，代表要画圆形
 如果是4 那么就是Load，要读取之前保存的图形
 */
enum CmdLevel {
    CIRCLE,
    POLYGONE,
    Line ,
    LOAD,
    SAVE,
    CLEAR
}

/**
 * 责任链 模式 下的 所有链条节点的父类
 * 所有其他节点都继承于它，比如NodeCircle NodeLine等，他们都是具体负责处理某一个Client发来的请求的
 */
public abstract class ResponsibleChainNode {
    protected CmdLevel level = null; /* 此节点处理的 请求类型 比如0代表只处理圆形绘制请求 */
    protected ResponsibleChainNode next = null; /* 本节点的下一个节点 */

    public ResponsibleChainNode(CmdLevel cmdLevel, ResponsibleChainNode prev) {
        this.level = cmdLevel;
        prev.next = this;
    }

    public ResponsibleChainNode() {

    }

    public ResponsibleChainNode(CmdLevel cmdLevel) {
        this.level = cmdLevel;
    }

    /**
     * 判断该请求是否由本节点处理，若是 则执行 exec 否则将请求发往下一个节点
     * @param geom 代表屏幕上所有的的图形集合
     * @param cmd_idx 客户端的请求头  比如画圆形需要 请求头为 0
     * @param args 客户端请求的其他参数，比如画圆形需要 圆心位置和半径大小
     */
    public void handle(GeomCompos geom, Integer cmd_idx, ArrayList<Float> args){
        if(cmd_idx > level.ordinal()){
            next.handle(geom,cmd_idx,args);
        }
        else {
            System.out.println("Request :" + this.level.name() + " " + args.toString());
            exec(geom,args);
        }
    }
    /**
     * 当确认客户端请求需要本节点处理的时候，就会调用该函数执行具体操作，需要在子类中实现具体操作
     * @param geom 代表屏幕上所有的的图形集合
     * @param args 客户端请求的其他参数，比如画圆形需要 圆心位置和半径大小
     */
    protected abstract void exec(GeomCompos geom, ArrayList<Float> args);
}
