import java.awt.*;
import java.awt.image.BufferStrategy;

public class DisplayWindow {

    private static DisplayWindow instance;
    private DisplayWindow(){}

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
        frame.setIgnoreRepaint(true);
        frame.createBufferStrategy(2);
        try {
            Thread.sleep(150);
        }
        catch (InterruptedException e){

        }

        update();
    }

    public Graphics getGraphics(){
        return  frame.getBufferStrategy().getDrawGraphics();
    }

    public void update(){
        BufferStrategy strategy = frame.getBufferStrategy();
        Graphics graphics = strategy.getDrawGraphics();
        strategy.show();
        graphics.dispose();
    }

}
