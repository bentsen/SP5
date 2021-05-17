package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Scene2Controller implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Parent parent;
    private String css = this.getClass().getResource("application.css").toExternalForm();
    @FXML
    ImageView paddleImage;
    @FXML
    Label currencyLabel;

    //This method is called upon fxml load
    public void initialize(URL location, ResourceBundle resourceBundle)
    {
    contentSelect();

    }

    // will decide which type of content to display
    private void contentSelect()
    {
        System.out.println("Scene 2");

    }


    public void switchToScene1(MouseEvent mouseEvent) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("Scenes/Scene1.fxml"));
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(css);

    }


}

