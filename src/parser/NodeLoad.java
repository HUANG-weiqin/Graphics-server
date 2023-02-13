package parser;

import geometrics.GeomCompos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class NodeLoad extends ResponsibleChainNode{
    public NodeLoad(CmdLevel cmdLevel, ResponsibleChainNode prev) {
        super(cmdLevel, prev);
    }

    /**
     * 读取上次保存的图形，并显示到屏幕上
     */
    @Override
    protected void exec(GeomCompos geom, ArrayList<Integer> args) {
        try{
            FileInputStream fi = new FileInputStream("GomeSaved.geom");
            ObjectInputStream in = new ObjectInputStream(fi);
            GeomCompos tmp = (GeomCompos) in.readObject();
            geom.getGeometrics().clear();
            geom.MergeGeomCompos(tmp);
            in.close();
            fi.close();
        }
        catch (IOException i)
        {
            System.out.println(i);
        }
        catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
