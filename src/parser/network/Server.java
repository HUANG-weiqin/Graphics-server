package parser.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Server implements Runnable{
    private ServerSocket ss = null;
    private List<Client> clients = new Vector<>();

    private static Server instance = null;
    private Server(){}

    public static Server getInstance()throws IOException {
        if(instance == null){
            instance = new Server();
            instance.ss = new ServerSocket(8888);
        }
        instance.run();
        return instance;
    }


    public List<String> update() throws IOException {

        List<String> res = new LinkedList<>();
        List<Client> toRemove = new LinkedList<>();
         for(Client c : clients){
             System.out.println(clients.size());
            String msg = c.readtMsg();
            if(msg.length() == 0)
                continue;
            if(msg.equals("quit")){
                toRemove.add(c);
                c.quit();
            }
            else
                res.add(msg);
        }

         clients.removeAll(toRemove);
         toRemove.clear();

         return  res;
    }


    @Override
    public void run() {
        try {
            Socket sc = ss.accept();
            clients.add(new Client(sc));
            System.out.println("newcomer");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}