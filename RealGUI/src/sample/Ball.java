package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import static sample.Constants.*;

public class Ball {
    private ImageView imageView;
    ImageViewGameObj ball;
    ImageViewGameObj paddle;
    int  dy = 3;

    public Ball(Pane root)
    {

        ball = new ImageViewGameObj(root,"/sample/Images/defaultBall.png");
        ball.setY(height - ball.getHeight() -100);
        ball.setX((width - ball.getWidth())/2);
//        timeLine(ball, paddle);


    }

    public void timeLine(ImageViewGameObj a, ImageViewGameObj b)
    {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(100),
                (evt) ->{a.setY(a.getY() + dy);
                    if (a.getBounds().intersects(b.getBounds()))
                    {
                        dy = -dy;
                    } }
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public double getX(){
        return ball.getX();
    }

    public double getY(){
        return ball.getY();
    }

    public Bounds getBounds()
    {
        return imageView.getBoundsInParent();
    }




}
