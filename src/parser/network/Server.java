package parser.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Server implements Runnable{
    private ServerSocket ss = null;
    private List<Client> clients = new Vector<>();/* 所有已经链接的客户端列表 */

    private static Server instance = null;
    private Server(){}

    /**
     * server也是一个单例模式，返回server的唯一instance同时监听8080端口
     */
    public static Server getInstance()throws IOException {
        if(instance == null){
            instance = new Server();
            instance.ss = new ServerSocket(8080);
            Thread thread = new Thread(instance);/*开启另一个线程执行run方法用来监听端口等待客户端tcp链接*/
            thread.start();
        }
        return instance;
    }


    /**
     * 遍历所有已经链接的客户端，并读取他们的请求，将他们的请求放入 一个list中返回，如果请求是 quit 字符串，那么这个客户端断开链接
     * @return  返回所有客户端的请求字符串到一个 list中
     */
    public List<String> update() throws IOException {
        List<String> res = new LinkedList<>();
        List<Client> toRemove = new LinkedList<>();
         for(Client c : clients){
            String msg = c.readMsg();
            if(msg.length() == 0)
                continue;
            System.out.println(msg);
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

    /**
     * 另一个线程执行 server run方法，在这个方法中，监听端口等待客户端tcp链接
     * 之所以用另一个线程执行，是因为 ss.accept方法是阻塞的，直到等到一个tcp链接为止都会卡在这一行不往下执行
     */
    @Override
    public void run() {
        try {
            while (true){
                Socket sc = ss.accept();
                clients.add(new Client(sc));
                System.out.println("new client :" + clients.size());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
