package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import static sample.Constants.*;

public class BrickSlayer {
    private Pane root;
    private int dy = 3;

    public BrickSlayer()
    {
        root = new Pane();
       // Paddle paddle = new Paddle(root);
       // Ball ball = new Ball(root);
       ImageViewGameObj paddle = new ImageViewGameObj(root,"sample/Images/Paddles/Paddle_og2.png",145,25);
       paddle.setY(height - paddle.getHeight()-10);
       paddle.setX((width - paddle.getWidth())/2);
       ImageViewGameObj ball = new ImageViewGameObj(root,"sample/Images/Balls/defaultBall.png");
       ball.setY(height - ball.getHeight() -100);
       ball.setX((width - ball.getWidth())/2);

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(10),
               (evt) ->{ball.setY(ball.getY() + dy);
                    if (ball.getBounds().intersects(paddle.getBounds()))
                    {
                        dy = -dy;
                    }
                    if(ball.getY() <= 0)
                    {
                        dy = 3;
                    }
                }
        ));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        root.setOnMouseMoved((evt) -> {
            System.out.println("Mouse at: (" +evt.getX() + ", " + evt.getY() + ")");
        });
    }

    public Pane getRoot()
    {
        return root;
    }

}
