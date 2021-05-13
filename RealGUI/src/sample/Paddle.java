package sample;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static sample.Constants.*;

public class Paddle {
    private ImageView imageView;

    public Paddle(Pane root)
    {
        ImageViewGameObj paddle = new ImageViewGameObj(root,"/sample/Images/paddleog2.png");
        paddle.setY(height - paddle.getHeight()-10);
        paddle.setX((width - paddle.getWidth())/2);
    }



    public Bounds getBounds()
    {
        return imageView.getBoundsInParent();
    }
}
