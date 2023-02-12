package parser.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Client {
    private Socket socket;
    private DataInputStream in;

    private LinkedList<String> cmdBuff = new LinkedList<>();

    private void upate() throws IOException{
        if(in.available() == 0)return;
        byte [] buff = new byte[1024 * 5];
        int nb = in.read(buff);
        String res = new String(buff,0,nb,"UTF-8");
        List<String> tmps = Arrays.asList(res.split("\n"));
        cmdBuff.addAll(tmps);
    }
    public Client(Socket sc) throws IOException {
        socket = sc;
        in = new DataInputStream(sc.getInputStream());
    }

    public String readMsg() throws IOException {
        upate();
        if(cmdBuff.size() == 0)
            return "";
        return cmdBuff.removeFirst();
    }

    public void quit() throws IOException {
        System.out.println("A client was disconnected");
        socket.close();
    }
}
