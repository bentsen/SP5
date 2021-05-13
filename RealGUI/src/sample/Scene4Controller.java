package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Scene4Controller {


    private Stage stage;
    private Scene scene;
    private Parent parent;
    private String css = this.getClass().getResource("application.css").toExternalForm();
    private boolean play = true;
    private String Image = "Images/PaddleSkins/PaddleSkin1.png";
    private int count = 1;

    @FXML
    ImageView skinsImage;
    @FXML
    Image myImage = new Image(getClass().getResourceAsStream(Image));


    public void switchToScene1(MouseEvent mouseEvent) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("Scenes/Scene1.fxml"));
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(css);
    }

    public void nextSkin(MouseEvent mouseEvent)
    {
        count++;
        Image = "Images/PaddleSkins/PaddleSkin" + count + ".png";
        myImage = new Image(getClass().getResourceAsStream(Image));
        skinsImage.setImage(myImage);
        System.out.println(Image);
    }

    public void lastSkin(MouseEvent mouseEvent)
    {
        count--;
        Image = "Images/PaddleSkins/PaddleSkin" + count + ".png";
        myImage = new Image(getClass().getResourceAsStream(Image));
        skinsImage.setImage(myImage);
        System.out.println(Image);
    }
}
