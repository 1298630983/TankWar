import java.awt.*;

/**
 * Created by Jason on 2017/9/20.
 */
public class Blood {
    int x, y, w, h;
    int step = 0;
    private boolean live = true;
    TankClient tc;
    private int[][] pos = {
            {350,300},{360,256},{420,270},{400,250},{370,200},{320,180},{300,150}
    };

    public Blood() {
        x = pos[0][0];
        y = pos[0][1];
        w = h = 15;
    }

    public void draw(Graphics g) {
        if (!live) return;
        Color c = g.getColor();
        g.setColor(Color.MAGENTA);
        g.fillRect(x, y, w, h);
        g.setColor(c);

        move();
    }

    private void move() {
        step++;
        if (step == pos.length) {
            step = 0;
        }
        x = pos[step][0];
        y = pos[step][1];
    }

    public Rectangle getRec() {
        return new Rectangle(x, y, w, h);
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
