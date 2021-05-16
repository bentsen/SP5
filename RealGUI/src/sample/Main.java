
package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import static sample.Constants.*;
import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

// Application class is the PARENT CLASS and Main class is the child class
public class Main extends Application
{
    public String css = this.getClass().getResource("application.css").toExternalForm();
    public static ArrayList<String> paddleSkinsURL = new ArrayList<>();
    public static ArrayList<String> ballSkinsURL = new ArrayList<>();
    public static ArrayList<PaddleSkin> paddleSkins = new ArrayList<>();
    public static ArrayList<BallSkin> ballSkins = new ArrayList<>();

    public static void main(String[] args)
    {
        //should be loaded from database
        PaddleSkin paddleSkin = new PaddleSkin("Default","sample/Images/Paddles/paddle_og2.png",true);
        PaddleSkin paddleSkin1 = new PaddleSkin("Lightsaber","sample/Images/Paddles/paddlelightsaber.png", true);
        PaddleSkin paddleSkin2 = new PaddleSkin("Diamond","sample/Images/Paddles/paddlediamond.png", false);
        PaddleSkin paddleSkin3 = new PaddleSkin("Chrome","sample/Images/Paddles/paddlechrome.png", false);
        PaddleSkin paddleSkin4 = new PaddleSkin("mlg","sample/Images/Paddles/paddlemlg.png", true);
        PaddleSkin paddleSkin5 = new PaddleSkin("Nyancat","sample/Images/Paddles/paddle nyancat.png", false);
        paddleSkins.add(paddleSkin);
        paddleSkins.add(paddleSkin4);
        paddleSkins.add(paddleSkin5);
        paddleSkins.add(paddleSkin3);
        paddleSkins.add(paddleSkin2);
        paddleSkins.add(paddleSkin1);

        //shold be loaded from database
        BallSkin ballSkin = new BallSkin("Default","sample/Images/Balls/defaultBall.png",true);
        BallSkin ballSkin6 = new BallSkin("Default","sample/Images/Balls/ball steve.png",true);
        BallSkin ballSkin1 = new BallSkin("Yoda","sample/Images/Balls/ball yoda.png",false);
        BallSkin ballSkin2 = new BallSkin("Pokeball","sample/Images/Balls/ball pokeball.png",false);
        BallSkin ballSkin3 = new BallSkin("Pacman","sample/Images/Balls/ball pacman.png",true);
        BallSkin ballSkin4 = new BallSkin("Imposter","sample/Images/Balls/ball imposter.png",false);
        BallSkin ballSkin5 = new BallSkin("Gilli","sample/Images/Balls/ballgilli.png",false);
        ballSkins.add(ballSkin);
        ballSkins.add(ballSkin6);
        ballSkins.add(ballSkin1);
        ballSkins.add(ballSkin2);
        ballSkins.add(ballSkin3);
        ballSkins.add(ballSkin4);
        ballSkins.add(ballSkin5);
        launch(args);
    }




    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("hej");
            Parent root = FXMLLoader.load(getClass().getResource("Scenes/Scene1.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            Image image = new Image(new File("src/sample/Images/BrickIcon.png").toURI().toString());
            stage.getIcons().add(image);
            stage.setWidth(1000);
            stage.setHeight(600);
            stage.setResizable(false);
            stage.setTitle("Brick Slayer");
            scene.getStylesheets().add(css);

    }

}



