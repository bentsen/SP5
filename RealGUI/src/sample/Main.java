
package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import static sample.Constants.*;
import javax.imageio.IIOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

// Application class is the PARENT CLASS and Main class is the child class
public class Main extends Application
{
    public String css = this.getClass().getResource("application.css").toExternalForm();
    public static ArrayList<PaddleSkin> paddleSkins = new ArrayList<>();
    public static ArrayList<BallSkin> ballSkins = new ArrayList<>();
    public static ArrayList<Player> players = new ArrayList<>();
    public static DBConnector connector = new DBConnector();
    public static Clip clip;
    public static Clip effectClip;

    public static void main(String[] args)
    {
        paddleSkins = connector.loadPaddleSkin();
        ballSkins = connector.loadBallSkin();
        players = connector.loadPlayer();
        launch(args);
    }


    public static void music(String musicPath, float volume)
    {
        try
        {
            File music = new File(musicPath);
            if(music.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(music);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                FloatControl gainControl =
                        (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(volume); // Reduce volume by decibels.
                clip.start();
            }
            else
            {
                System.out.println("Cant find file");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void effect(String musicPath)
    {
        try
        {

            File music = new File(musicPath);
            if(music.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(music);
                effectClip = AudioSystem.getClip();
                effectClip.open(audioInput);
                effectClip.start();

            }
            else
            {
                System.out.println("Cant find file");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setOnCloseRequest(
                event -> {
                    connector.savePlayers();
                    connector.saveBallSkin();
                    connector.savePaddleSkin();
                });
            music("src/sample/Music/IntroMusic.wav",-10.0f);
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

    public static String getEquipped()
    {
        for(PaddleSkin p : paddleSkins)
        {
            if(p.isEquipped())
            {
                return p.getUrl();
            }
        }
        System.out.println("There is no PaddleSkin equipped");
        return null;
    }

    public static String getEquippedBall()
    {
        for(BallSkin b : ballSkins)
        {
            if(b.isEquipped())
            {
                return b.getUrl();
            }
        }
        System.out.println("There is no PaddleSkin equipped");
        return null;
    }

}



