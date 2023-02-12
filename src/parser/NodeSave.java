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

    @Override
    protected void exec(GeomCompos geom, ArrayList<Integer> args) {

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
