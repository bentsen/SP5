package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class ImageViewGameObj {
    private ImageView imageView;


    public ImageViewGameObj(Pane root, String url)
    {
        imageView = new ImageView(url);
        imageView.setCache(true);
        root.getChildren().add(imageView);
    }


    public ImageViewGameObj(Pane root, String url, double width, double height)
    {
        imageView = new ImageView(new Image(url, width, height,false,true));
        imageView.setCache(true);
        root.getChildren().add(imageView);
    }



    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public double getHeight()
    {
        return imageView.getImage().getHeight();
    }

    public double getWidth()
    {
        return imageView.getImage().getWidth();
    }

    public void setX(double x)
    {
        imageView.setX(x);
    }

    public void setY(double y)
    {
        imageView.setY(y);
    }

    public double getX(){
        return imageView.getX();
    }

    public double getY(){
        return imageView.getY();
    }

    public Bounds getBounds()
    {
        return imageView.getBoundsInParent();
    }
}
