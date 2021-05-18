package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene4Controller {


    private Stage stage;
    private Scene scene;
    private String css = this.getClass().getResource("application.css").toExternalForm();
    private String Image = "Images/Shop/Paddle/PaddleShop1.png";
    private int count = 1;
    private int arrayCount = 0;
    private boolean owned = false;
    private boolean paddle = true;
    private boolean ball = false;
    @FXML
   private ImageView skinsImage;
    @FXML
   private Image myImage = new Image(getClass().getResourceAsStream(Image));
    @FXML
   private Button buy;
    @FXML
   private Button equip;
    @FXML
    Label currencyLabel;


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
        if(paddle == true && ball == false)
        {
            if(count < 6)
            {
                arrayCount++;
                if(Main.paddleSkins.get(arrayCount).isOwned())
                {
                    count++;
                    ownerShip(false,true,"Owned.png","Images/Shop/Paddle/PaddleShop");
                }
                else if(!Main.paddleSkins.get(arrayCount).isOwned())
                {
                    count++;
                    ownerShip(true,false,".png","Images/Shop/Paddle/PaddleShop");
                }
            }
        }
       else if(paddle == false && ball == true)
        {
            if(count < 7)
            {
                arrayCount++;
                if(Main.ballSkins.get(arrayCount).isOwned())
                {
                    count++;
                    ownerShip(false,true,"Owned.png","Images/Shop/Ball/BallShop");
                }
                else if(!Main.ballSkins.get(arrayCount).isOwned())
                {
                    count++;
                    ownerShip(true,false,".png","Images/Shop/Ball/BallShop");
                }
            }
        }
    }

    public void lastSkin(MouseEvent mouseEvent)
    {
        if(paddle == true && ball == false)
        {
            if(count > 1)
            {
                arrayCount--;

                if(Main.paddleSkins.get(arrayCount).isOwned())
                {
                    count--;
                    ownerShip(false,true,"Owned.png","Images/Shop/Paddle/PaddleShop");
                }
                else if(!Main.paddleSkins.get(arrayCount).isOwned())
                {
                    count--;
                    ownerShip(true,false,".png","Images/Shop/Paddle/PaddleShop");
                }
            }
        }
        else if(paddle == false && ball == true)
        {
            if(count > 1)
            {
                arrayCount--;
                if(Main.ballSkins.get(arrayCount).isOwned())
                {
                    count--;
                    ownerShip(false,true,"Owned.png","Images/Shop/Ball/BallShop");
                }
                else if(!Main.ballSkins.get(arrayCount).isOwned())
                {
                    count--;
                    ownerShip(true,false,".png","Images/Shop/Ball/BallShop");
                }
            }
        }
    }


    public void PaddleClick(ActionEvent actionEvent)
    {

        paddleOrBall(false,true,"Images/Shop/Paddle/PaddleShop1.png");
    }

    public void BallClick(ActionEvent actionEvent)
    {
        paddleOrBall(true,false,"Images/Shop/Ball/BallShop1.png");
    }


    public void Buy(ActionEvent actionEvent)
    {
        if(paddle == true && ball == false)
        {
            if(Main.players.get(0).getDeshCoins() >= Main.paddleSkins.get(arrayCount).getPrice())
            {
                Main.paddleSkins.get(arrayCount).setOwned(true);
                int temp = Main.players.get(0).getDeshCoins() - Main.paddleSkins.get(arrayCount).getPrice();
                Main.players.get(0).setDeshCoins(temp);
                currencyLabel.setText(String.valueOf(Main.players.get(0).getDeshCoins()));

                Image = "Images/Shop/Paddle/PaddleShop" + count + "Owned.png";
                myImage = new Image(getClass().getResourceAsStream(Image));
                skinsImage.setImage(myImage);

                equip.setVisible(true);
                buy.setVisible(false);
            }
            else
            {
                lowOnMoney();
            }
        }

        else if(paddle == false && ball == true)
        {
            if(Main.players.get(0).getDeshCoins() >= Main.ballSkins.get(arrayCount).getPrice())
            {
                Main.ballSkins.get(arrayCount).setOwned(true);
                int temp = Main.players.get(0).getDeshCoins() - Main.ballSkins.get(arrayCount).getPrice();
                Main.players.get(0).setDeshCoins(temp);
                currencyLabel.setText(String.valueOf(Main.players.get(0).getDeshCoins()));

                Image = "Images/Shop/Ball/BallShop" + count + "Owned.png";
                myImage = new Image(getClass().getResourceAsStream(Image));
                skinsImage.setImage(myImage);

                equip.setVisible(true);
                buy.setVisible(false);
            }
            else
            {
               lowOnMoney();
            }
        }

    }
    public void equip(ActionEvent event) //Equip skins
    {
        String paddleURL = "";
        String ballURL = "";

        if(paddle == true && ball == false) //Equip PaddleSkin
        {
            switch (count)
         {
            case 1:
                paddleURL = "sample/Images/Paddles/paddle_og2.png";

                break;
            case 2:
                paddleURL = "sample/Images/Paddles/paddlemlg.png";
                break;
            case 3:
                paddleURL = "sample/Images/Paddles/paddle nyancat.png";
                break;

            case 4:
                paddleURL = "sample/Images/Paddles/paddlechrome.png";
                break;
            case 5:
                paddleURL = "sample/Images/Paddles/paddlediamond.png";
                break;
            case 6:
                paddleURL = "sample/Images/Paddles/paddlelightsaber.png";
                break;

         }

            for(int i = 0; i < Main.paddleSkins.size(); i++) {
                Main.paddleSkins.get(i).setEquipped(false);
            }
            String targetURL = paddleURL;
            for(PaddleSkin c : Main.paddleSkins) {
                if (targetURL.equals(c.getUrl()))
                {
                    c.setEquipped(true);
                }
            }
        }

        else if(paddle == false && ball == true) //Equip BallSkin
        {
            switch (count)
            {
                case 1:
                    ballURL = "sample/Images/Balls/defaultBall.png";
                    break;
                case 2:
                    ballURL = "sample/Images/Balls/ball steve.png";
                    break;
                case 3:
                    ballURL = "sample/Images/Balls/ball yoda.png";
                    break;

                case 4:
                    ballURL = "sample/Images/Balls/ball pokeball.png";
                    break;
                case 5:
                    ballURL = "sample/Images/Balls/ball pacman.png";
                    break;
                case 6:
                    ballURL = "sample/Images/Balls/ball imposter.png";
                    break;
                case 7:
                    ballURL = "sample/Images/Balls/ballgilli.png";
                    break;

            }
            for(int i = 0; i < Main.ballSkins.size(); i++) {
                Main.ballSkins.get(i).setEquipped(false);
            }
            String targetURL = ballURL;
            for(BallSkin c : Main.ballSkins) {
                if (targetURL.equals(c.getUrl()))
                {
                    c.setEquipped(true);
                }
            }
        }

    }

    public void ownerShip(boolean b, boolean e, String ownedOrNot, String url)
    {
        equip.setVisible(e);
        buy.setVisible(b);
        Image = url + count + ownedOrNot;
        myImage = new Image(getClass().getResourceAsStream(Image));
        skinsImage.setImage(myImage);
    }

    public void paddleOrBall(boolean b, boolean p, String url)
    {
        arrayCount = 0;
        count = 1;
        paddle = p;
        ball = b;
        Image = url;
        myImage = new Image(getClass().getResourceAsStream(Image));
        skinsImage.setImage(myImage);
    }

    public void lowOnMoney()
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Currency");
        alert.setHeaderText("Not enough Ruaffu Coins");
        alert.setContentText("play to earn more Ruaffu Coins");
        stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("sample/Images/BrickIcon.png"));
        DialogPane myDialog = alert.getDialogPane();
        myDialog.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        myDialog.getStyleClass().add("myDialog");
        alert.showAndWait();
    }

}
