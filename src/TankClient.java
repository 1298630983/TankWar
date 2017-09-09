import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Jason on 2017/9/8.
 */
public class TankClient extends Frame{
    int x = 50 , y = 50;
    Image offScreenImage = null;

    public static void main(String[] args) {
        new TankClient().lanuchFrame();
    }

    public void lanuchFrame() {
        setBounds(x,y,800,600);
        setResizable(false);
        setTitle("TankWar");
        setBackground(Color.green);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
        new Thread(new PaintThread()).start();
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,30,30);
        g.setColor(c);

        y += 5;
    }

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(800,600);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.green);
        gOffScreen.fillRect(0,0,800,600);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);
    }

    private class PaintThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                repaint();
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
