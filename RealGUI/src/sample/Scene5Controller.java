package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Scene5Controller implements Initializable {


   private String Image = "Images/Maps/Map1.png";
    @FXML
   private Label headerLabel;
    @FXML
   private ImageView myImageView;
    @FXML
   private Image myImage = new Image(getClass().getResourceAsStream(Image));
    @FXML
   private ImageView imageLocked;
    @FXML
    Label currencyLabel;


    private int count = 1;
    private int arrayCount = 0;
    private Stage stage;
    private Scene scene;
    private Parent parent;
    private String css = this.getClass().getResource("application.css").toExternalForm();

    ArrayList<Map> maps = new ArrayList<>();

    public void initialize(URL location, ResourceBundle resourceBundle)
    {
        mapCompleted();
        imageLocked.visibleProperty().set(false);
    }

    // will decide which type of content to display
    private void contentSelect()
    {
        System.out.println("Scene 5");

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

    public void nextLevel(MouseEvent mouseEvent)
    {
        if(count < 10) {

            count++;
            arrayCount++;

            Image = "Images/Maps/Map" + (count) + ".png";
            myImage = new Image(getClass().getResourceAsStream(Image));
            headerLabel.setText("Level " + (count));
            myImageView.setImage(myImage);

            if(maps.get(arrayCount).getLocked() == true)
            {
                System.out.println("locked");
                imageLocked.visibleProperty().set(true);
            }
            else if(maps.get(arrayCount).getLocked() == false)
            {
                System.out.println("not locked");
                imageLocked.visibleProperty().set(false);
            }


        }

    }

    public void lastLevel(MouseEvent mouseEvent)
    {

        if(count >= 2)
        {
            count--;
            arrayCount--;
            Image = "Images/Maps/Map" + (count) +".png";
            myImage = new Image(getClass().getResourceAsStream(Image));
            headerLabel.setText("Level " + (count));
            myImageView.setImage(myImage);


            if(maps.get(arrayCount).getLocked() == true)
            {
                System.out.println("locked");
                imageLocked.visibleProperty().set(true);
            }
            else if(maps.get(arrayCount).getLocked() == false)
            {
                System.out.println("not locked");
                imageLocked.visibleProperty().set(false);
            }

        }
    }

    public void mapCompleted()
    {
        //the maps should come from sql
        Map map = new Map(1,false);
        Map map2 = new Map(2,true);
        Map map3 = new Map(3,true);
        Map map4 = new Map(4,true);
        Map map5 = new Map(5,true);
        Map map6 = new Map(6,true);
        Map map7 = new Map(7,true);
        Map map8 = new Map(8,true);
        Map map9 = new Map(9,true);
        Map map10 = new Map(10,true);
        maps.add(map);
        maps.add(map2);
        maps.add(map3);
        maps.add(map4);
        maps.add(map5);
        maps.add(map6);
        maps.add(map7);
        maps.add(map8);
        maps.add(map9);
        maps.add(map10);
    }

}
