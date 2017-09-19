import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

/**
 * Created by Jason on 2017/9/8.
 */
public class TankClient extends Frame{
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    Tank myTank = new Tank(50,50,true, Tank.Direction.STOP,this);

    Explode e = new Explode(70,70,this);

    List<Missile> missiles = new ArrayList<Missile>();
    List<Explode> explodes = new ArrayList<Explode>();
    List<Tank> tanks = new ArrayList<Tank>();

    Image offScreenImage = null;

    public static void main(String[] args) {
        new TankClient().lanuchFrame();
    }

    public void lanuchFrame() {
        for (int i = 0; i < 10; i++) {
            tanks.add(new Tank(50 + 40*(i + 1), 50,false, Tank.Direction.D,this));
        }
        setBounds(400,300,GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("TankWar");
        setBackground(Color.green);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new KeyMonitor());
        setVisible(true);
        new Thread(new PaintThread()).start();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("missiles counts : " + missiles.size(),60,60);
        g.drawString("explode counts : " + explodes.size(), 60,70);
        g.drawString("tanks counts : " + tanks.size(), 60, 80);

        myTank.draw(g);
        for (int i = 0; i < missiles.size(); i++) {
            Missile m = missiles.get(i);
            m.hitTank(myTank);
            m.hitTanks(tanks);
            m.draw(g);
            //if (!m.isLive()) missiles.remove(m);
            //else m.draw(g);
        }

        for (int i = 0; i < explodes.size(); i++) {
            Explode e = explodes.get(i);
            e.draw(g);
        }

        for (int i = 0; i < tanks.size(); i++) {
            Tank t = tanks.get(i);
            t.draw(g);
        }
    }

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.green);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
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

    private class KeyMonitor extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            myTank.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            myTank.keyReleased(e);
        }
    }
}
