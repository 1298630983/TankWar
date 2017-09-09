import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Jason on 2017/9/8.
 */
public class TankClient extends Frame{
    public static void main(String[] args) {
        new TankClient().lanuchFrame();
    }

    public void lanuchFrame() {
        setBounds(100,100,800,600);
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
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(50,50,30,30);
        g.setColor(c);
    }
}
