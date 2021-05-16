package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Random;

import static sample.Constants.*;

public class Ball extends ImageViewGameObj{
    int dy;
    int dx;

    public Ball(Pane root)
    {
        super(root, Main.ballSkinsURL.get(0));
        dx = 0;
        dy = 0;

    }

    /**
     * Moves the ball according to it's velocity without any bouncing.
     */
    public void move() {
        this.setY(this.getY() + this.getDy());
        this.setX(this.getX() + this.getDx());
    }

    public static int randInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();
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
