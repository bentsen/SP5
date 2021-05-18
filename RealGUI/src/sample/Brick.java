package sample;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

import static sample.Constants.*;

public class Brick extends ImageViewAssets {
    String url;
    private ArrayList<Brick> bricks;


    public Brick(Pane root, String url, int width, int height) {
        super(root, url, brickWidth, brickHeight);
    }


    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setX(double cx) { // Sets the X position of the block.
        super.setX(cx);
    }

    @Override
    public void setY(double cy) {
        super.setY(cy - this.getHalfHeight());
    } // Sets the Y position of the block.

    @Override
    public String toString() {
        return super.toString();
    }
}
