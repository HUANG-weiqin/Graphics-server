package parser;

import geometrics.GeomCompos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class NodeSave extends ResponsibleChainNode{
    public NodeSave(CmdLevel cmdLevel, ResponsibleChainNode prev) {
        super(cmdLevel, prev);
    }

    /**
     * 将当前的屏幕图形 object 保存为一个文件，下次要用可以直接将这个object读取并显示
     */
    @Override
    protected void exec(GeomCompos geom, ArrayList<Float> args) {

        try {
            FileOutputStream fo = new FileOutputStream("GomeSaved.geom");

            ObjectOutputStream out = new ObjectOutputStream(fo);
            out.writeObject(geom);
            out.close();
            fo.close();
            System.out.println("Save file ok");
        }
        catch (IOException i){
            System.out.println("Cant save file");
        }

    }
}
