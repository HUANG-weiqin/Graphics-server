package graphic;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * 调用图形接口，产生一个图形窗口，用了单例模式，因为不需要多个窗口
 */
public class DisplayWindow {

    private static DisplayWindow instance;
    private DisplayWindow(){}

    /**
     * 调用图形接口，产生一个图形窗口，用了单例模式，因为不需要多个窗口，多个客户端在同一个窗口中绘制
     */
    public static DisplayWindow getInstance(){
        if(instance == null){
            instance = new DisplayWindow("display");
        }
        return instance;
    }

    private  Frame frame;

    public Frame getFrame() {
        return frame;
    }

    public DisplayWindow(String name){
        frame = new Frame(name);
        frame.setBounds(60,60,400,400);
        frame.setVisible(true);
        //frame.setIgnoreRepaint(true);
        frame.createBufferStrategy(2);
        try {
            Thread.sleep(150);
        }
        catch (InterruptedException e){

        }

        update();
    }

    /**
     * 获得可绘制的obj
     */
    public Graphics getGraphics(){
        return  frame.getBufferStrategy().getDrawGraphics();
    }

    /**
     * 当绘制图形后，需要调用这个方法将绘制的新图形显示在屏幕上
     */
    public void update(){
        BufferStrategy strategy = frame.getBufferStrategy();
        Graphics graphics = strategy.getDrawGraphics();
        strategy.show();
        graphics.dispose();
    }

    /**
     * 清除屏幕上的绘画
     */
    public void clear(){
        BufferStrategy strategy = frame.getBufferStrategy();
        Graphics graphics = strategy.getDrawGraphics();
        Color c = graphics.getColor();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0,0,frame.getWidth(),frame.getHeight());
        graphics.setColor(c);
    }

}
