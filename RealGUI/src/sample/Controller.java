package sample;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.EventHandler;

import java.io.File;
import java.io.IOException;

import static sample.Constants.height;
import static sample.Constants.width;

public class Controller {


    private Stage stage;
    private Parent root;
    private Scene scene;
    private Parent parent;
    private String css = this.getClass().getResource("application.css").toExternalForm();
    private boolean play = true;
    private boolean left = false, right = false;

    @FXML
    private ImageView paddleImage;


    public void Scene2(javafx.event.ActionEvent actionEvent) throws IOException
    {
        //LOAD SCENE2
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scenes/Scene2.fxml"));
        root = loader.load();
        Scene2Controller scene2Controller = loader.getController();

        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        scene.getStylesheets().add(css);

    }


    public void Scene3(javafx.event.ActionEvent actionEvent) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("Scenes/Scene3.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(css);
    }

    public void Scene4(javafx.event.ActionEvent actionEvent) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("Scenes/Scene4.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(css);
    }

    public void Scene5(javafx.event.ActionEvent actionEvent) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("Scenes/Scene5.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(css);
    }

    public void Scene6(MouseEvent mouseEvent) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("Scenes/Scene6.fxml"));
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(css);
    }

    public void exitGame(javafx.event.ActionEvent actionEvent) throws IOException
    {
        System.exit(0);
    }


    public void setPosition()
    {

        if(play == true) {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(3), paddleImage);
            tt.setAutoReverse(true);
            tt.setByX(30);
            tt.setByX(770);
            tt.setCycleCount(Animation.INDEFINITE);
            play = false;
            tt.play();
        }
    }


    public void start2(ActionEvent actionEvent) throws Exception
    {
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        String css = this.getClass().getResource("application.css").toExternalForm();
        Stage gameStage = new Stage();
        BrickSlayer brickSlayer = new BrickSlayer();
        Scene scene = new Scene(brickSlayer.getRoot(), width, height);
        gameStage.setScene(scene);
        gameStage.show();
        Image image = new Image(new File("src/sample/Images/BrickIcon.png").toURI().toString());
        gameStage.getIcons().add(image);
        gameStage.setTitle("Brick Slayer");
        scene.getStylesheets().add(css);
    }
}
