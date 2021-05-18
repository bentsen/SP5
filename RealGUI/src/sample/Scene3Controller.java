package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Scene3Controller implements Initializable {


    private Stage stage;
    private Scene scene;
    private Parent parent;
    private String css = this.getClass().getResource("application.css").toExternalForm();
    private boolean play = true;
    @FXML
    Label currencyLabel;
    @FXML
    Label number1Label;

    public void initialize(URL location, ResourceBundle resourceBundle)
    {
        number1Label.setText("1. " + Main.players.get(0).getName() + " " + Main.players.get(0).getScore());
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
