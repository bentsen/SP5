
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

// Application class is the PARENT CLASS and Main class is the child class
public class Main extends Application
{

    public static void main(String[] args)
    {
        launch(args);

    }

    public String css = this.getClass().getResource("application.css").toExternalForm();
    public static boolean left = false, right = false;


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



