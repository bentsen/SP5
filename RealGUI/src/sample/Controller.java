package sample;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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

import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.Constants.*;


public class Controller implements Initializable {


    private Stage stage;
    private Parent root;
    private Scene scene;
    private String css = this.getClass().getResource("application.css").toExternalForm();
    private boolean play = true;
    private String image;
    private String image2;

    @FXML
    private ImageView paddleImage;
    @FXML
    private Image myImage;
    @FXML
    private ImageView ballImage;
    @FXML
    private Image myBallImage;
    @FXML
    private Label currencyLabel;

    public void initialize(URL location, ResourceBundle resourceBundle)
    {
        currencyLabel.setText(String.valueOf(Main.players.get(0).getDeshCoins()));
    }

    public void Scene2(javafx.event.ActionEvent actionEvent) throws IOException
    {
        //LOAD SCENE2
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scenes/Scene2.fxml"));
        root = loader.load();
        Scene2Controller scene2Controller = loader.getController();
        scene2Controller.currencyLabel.setText(String.valueOf(Main.players.get(0).getDeshCoins()));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        scene.getStylesheets().add(css);
    }


    public void Scene3(javafx.event.ActionEvent actionEvent) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scenes/Scene3.fxml"));
        root = loader.load();
        Scene3Controller scene3Controller = loader.getController();
        scene3Controller.currencyLabel.setText(String.valueOf(Main.players.get(0).getDeshCoins()));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(css);
    }


    public void Scene4(javafx.event.ActionEvent actionEvent) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scenes/Scene4.fxml"));
        root = loader.load();
        Scene4Controller scene4Controller = loader.getController();
        scene4Controller.currencyLabel.setText(String.valueOf(Main.players.get(0).getDeshCoins()));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(css);
    }

    public void Scene5(javafx.event.ActionEvent actionEvent) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scenes/Scene5.fxml"));
        root = loader.load();
        Scene5Controller scene5Controller = loader.getController();
        scene5Controller.currencyLabel.setText(String.valueOf(Main.players.get(0).getDeshCoins()));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(css);
    }

    public void Scene6(MouseEvent mouseEvent) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scenes/Scene6.fxml"));
        root = loader.load();
        Scene6Controller scene6Controller = loader.getController();
        scene6Controller.currencyLabel.setText(String.valueOf(Main.players.get(0).getDeshCoins()));
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
        if(Main.paddleSkinsURL.size() == 0)
        {
            image = "Images/Paddles/paddle_og2.png";
            myImage = new Image(getClass().getResourceAsStream(image));
            paddleImage.setImage(myImage);
        }
        else if(Main.paddleSkinsURL.size() > 0)
        {
            image = Main.paddleSkinsURL.get(0);

            String original = Main.paddleSkinsURL.get(0);
            String newString = original.replace("sample/","");

            myImage = new Image(getClass().getResourceAsStream(newString));
            paddleImage.setImage(myImage);
        }
        if(Main.ballSkinsURL.size() == 0)
        {
            image2 = "Images/Balls/defaultBall.png";
            myBallImage = new Image(getClass().getResourceAsStream(image2));
            ballImage.setImage(myBallImage);
        }
        else if(Main.ballSkinsURL.size() > 0)
        {
            image2 = Main.ballSkinsURL.get(0);

            String original = Main.ballSkinsURL.get(0);
            String newString = original.replace("sample/","");

            myBallImage = new Image(getClass().getResourceAsStream(newString));
            ballImage.setImage(myBallImage);
        }

        if(play) {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(3), paddleImage);
            tt.setAutoReverse(true);
            tt.setByX(30);
            tt.setByX(770);
            tt.setCycleCount(Animation.INDEFINITE);
            tt.play();
        }
        if(play) {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(2), ballImage);
            tt.setAutoReverse(false);
            tt.setFromX(paddleImage.getX());
            tt.setFromY(10);
            tt.setToY(-600);
            tt.setCycleCount(Animation.INDEFINITE);
            tt.play();
        }
        if(play)
        {
            TranslateTransition tt = new TranslateTransition(Duration.seconds(3), ballImage);
            tt.setAutoReverse(true);
            tt.setFromX(paddleImage.getX());
            tt.setByX(770);

            tt.setCycleCount(Animation.INDEFINITE);
            play = false;
            tt.play();
        }
    }


    public void start2(ActionEvent actionEvent) throws Exception
    {
        Main.clip.stop();
        Main.music("src/sample/Music/GameMusic.wav",-10.0f);
        ((Node)actionEvent.getSource()).getScene().getWindow().hide();
        String css = this.getClass().getResource("application.css").toExternalForm();
        Stage gameStage = new Stage();
        BrickSlayer brickSlayer = new BrickSlayer();
        Scene scene = new Scene(brickSlayer.getRoot(),sceneWidth,sceneHeight);
        gameStage.setScene(scene);
        gameStage.show();
        Image image = new Image(new File("src/sample/Images/BrickIcon.png").toURI().toString());
        gameStage.getIcons().add(image);
        gameStage.setTitle("Brick Slayer");
        scene.getStylesheets().add(css);
        gameStage.setResizable(false);
    }
}
