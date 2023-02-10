package parser.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket socket;
    private DataInputStream in;
    public Client(Socket sc) throws IOException {
        socket = sc;
        in = new DataInputStream(sc.getInputStream());
    }

    public String readtMsg() throws IOException {
        if(in.available() == 0)
            return "";
        return in.readUTF();
    }

    public void quit() throws IOException {
        socket.close();
    }
}
