package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class ImageViewAssets {
    private ImageView imageView;
    private double speed = 10;
    private String url;



    public ImageViewAssets(Pane root, String url)
    {
        imageView = new ImageView(url);
        imageView.setCache(true);
        root.getChildren().add(imageView);
    }


    public ImageViewAssets(Pane root, String url, double width, double height)
    {
        imageView = new ImageView(new Image(url, width, height,false,true));
        imageView.setCache(true);
        root.getChildren().add(imageView);
    }


    public double getSpeed() {
        return speed;
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


    public double getHalfWidth()
    {
        return this.getWidth() / 2;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getHalfHeight()
    {
        return this.getHeight() / 2;
    }

    @Override
    public String toString() {
        return "[GameObj: (" + this.getX() + ", " + this.getY() + ")]";
    }
}
