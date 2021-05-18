package sample;

import javafx.scene.layout.Pane;

import java.util.Random;

public class Ball extends ImageViewAssets {
    int dy;
    int dx;

    public Ball(Pane root, String url)
    {
        super(root, url);
        dx = 0;
        dy = 0;

    }

      //Moves the ball.
    public void move() {
        this.setY(this.getY() + this.getDy());
        this.setX(this.getX() + this.getDx());
    }

    public static int randInRange(int min, int max) {
        Random r = new Random();
        int rand;
        rand = r.ints(min, (max + 1)).findFirst().getAsInt();
        if (rand == 0)
        {
            return rand+1;
        }else {
            return rand;
        }

    }

    // returns the centre x point of the ball
    public double getX()
    {
        return super.getX()+this.getHalfWidth();
    }

    public double getY()
    {
        return super.getY() + this.getHalfHeight();
    }

    public void setX(double cx)
    {
        super.setX(cx - this.getHalfWidth());
    }

    public void setY(double cy)
    {
        super.setY(cy - this.getHalfHeight());
    }

    public int getDy() {
        return dy;
    }

    public int getDx() {
        return dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }
}
