import java.awt.*;

/**
 * Created by Jason on 2017/9/19.
 */
public class Explode {
    int x, y;
    private boolean live = true;
    private TankClient tc;

    int[] diameter = {4, 7, 12, 20, 29, 50, 30, 20, 6};
    int step = 0;

    public Explode(int x, int y, TankClient tc) {
        this.x = x;
        this.y = y;
        this.tc = tc;
    }

    public void draw(Graphics g) {
        if (!live) {
            tc.explodes.remove(this);
            return;
        }

        if (step == diameter.length) {
            live = false;
            step = 0;
            return;
        }

        Color c = g.getColor();
        g.setColor(Color.orange);
        g.fillOval(x, y, diameter[step], diameter[step]);
        g.setColor(c);
        step++;
    }
}
