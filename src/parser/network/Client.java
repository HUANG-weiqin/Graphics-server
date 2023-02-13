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

    /**
     * 解析DataInputStream中的字节流，由换行符代表一条字符串的末尾，将他们转换成字符串并一个个放到cmdBuff中
     */
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

    /**
     * 将已经解析好的请求字符串返回
     * @return  返回第一个解析成功的字符串
     */
    public String readMsg() throws IOException {
        upate();
        if(cmdBuff.size() == 0)
            return "";
        return cmdBuff.removeFirst();
    }
    /**
     * 这个客户端链接断开，可以关闭socket了
     */
    public void quit() throws IOException {
        System.out.println("A client was disconnected");
        socket.close();
    }
}
