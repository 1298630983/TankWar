import java.awt.*;

/**
 * Created by Jason on 2017/9/9.
 */
public class Missile {
    public static final int XSPEED = 10;
    public static final int YSPEED = 10;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    private TankClient tc;

    int x, y;
    Tank.Direction dir;

    public boolean isLive() {
        return live;
    }

    private boolean live = true;

    public Missile(int x, int y, Tank.Direction dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Missile(int x, int y, Tank.Direction dir, TankClient tc) {
        this(x, y, dir);
        this.tc = tc;
    }

    public void draw(Graphics g) {
        if (!live) {
            tc.missiles.remove(this);
            return;
        }
        Color c = g.getColor();
        g.setColor(Color.black);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(c);
        
        move();
    }

    private void move() {
        switch (dir) {
            case L:
                x -= XSPEED;
                break;
            case LU:
                x -= XSPEED;
                y -= YSPEED;
                break;
            case U:
                y -= YSPEED;
                break;
            case UR:
                x += XSPEED;
                y -= YSPEED;
                break;
            case R:
                x += XSPEED;
                break;
            case RD:
                x += XSPEED;
                y += YSPEED;
                break;
            case D:
                y += YSPEED;
                break;
            case LD:
                x -= XSPEED;
                y += YSPEED;
                break;
        }
        if (x < 0 || y < 0 || x > TankClient.GAME_WIDTH || y > TankClient.GAME_HEIGHT) {
            live = false;
            tc.missiles.remove(this);
        }
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public boolean hitTank(Tank t) {
        if (this.getRect().intersects(t.getRect()) && t.isLive()) {
            t.setLive(false);
            this.live = false;
            return true;
        }
        return false;
    }
}
