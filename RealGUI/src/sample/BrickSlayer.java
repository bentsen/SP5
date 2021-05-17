package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static sample.Constants.*;

public class BrickSlayer {
    private Stage stage;
    private Scene scene;
    private String css = this.getClass().getResource("application.css").toExternalForm();
    private Pane root;
    private ArrayList<Brick> bricks;
    private Timeline timeline;
    private Paddle paddle;
    private Ball ball;
    private Brick brick;
    private ImageViewGameObj life1;
    private ImageViewGameObj life2;
    private ImageViewGameObj life3;
    private ImageViewGameObj gameOver;
    private ImageViewGameObj completed;
    private ImageViewGameObj coin;
    private Label numberOfCoins;
    private int score = 0;
    private int coins = Main.players.get(0).getDeshCoins();
    private boolean testTop = false;
    private double delayMs = 10; // Delay for the timeline.
    private double mx; // Variable to store the mouse's X position.
    private boolean bounceBottom = false; // If true, the ball will bounce off the bottom (used for quick testing).
    private int lives = 3;
    boolean hit = false; // a boolean to used for collision between ball and brick .
    int dx, dy; // dx and dy used for changing the velocity of the ball.



    public BrickSlayer() {
        root = new Pane();
        playAudio();
        paddleAndBall();
        heartsAndCoins();
        numCoins();
        start();
        brickLayer();
        playTime();

    }

    public void playTime()
    {
        if (testTop == true) { // Repositions the ball above the blocks if testTop is true.
            ball.setX(sceneWidth / 2); // Sets X position of the ball.
            ball.setY(brickHeight / 2); // Sets Y position of the ball.
        }

        timeline = new Timeline(new KeyFrame( // Creates the timeline.
                Duration.millis(delayMs), // Implements the delay.
                (evt) -> {
                    root.setOnMouseMoved((event) -> { // Tracks the mouse's movements.
                        mx = event.getX() - paddle.getHalfWidth(); // Gets the mouse's X position.
                        paddle.setX(mx); // Sets the center of the paddle to the mouse's X position.
                    });

                    updateBall(ball); // Calls the updateBall method.
                    paddleCollision();
                    brickCollision();


                }
        ));

        timeline.setCycleCount(Animation.INDEFINITE); // Makes the cycle count indefinite.
        timeline.play(); // Starts the timeline.

    }

    public void numCoins()
    {
        numberOfCoins = new Label();
        numberOfCoins.setTranslateY(25.5);
        numberOfCoins.setTranslateX(870);
        numberOfCoins.setText(String.valueOf(coins));
        AnchorPane.setLeftAnchor(numberOfCoins,852.0);
        AnchorPane.setRightAnchor(numberOfCoins,58.0);
        numberOfCoins.setPrefWidth(90);
        numberOfCoins.setPrefHeight(21);
        numberOfCoins.setAlignment(Pos.CENTER_RIGHT);
        root.getChildren().add(numberOfCoins);
    }

    public void paddleAndBall()
    {
        Main.paddleSkinsURL.add("sample/Images/Paddles/paddle_og2.png"); // if no skin is picked Default paddleSkin will be used
        paddle = new Paddle(root, Main.paddleSkinsURL.get(0));
        paddle.setY(sceneHeight - paddle.getHeight() - 10);
        paddle.setX((sceneWidth / 2 - paddle.getHalfWidth()));

        Main.ballSkinsURL.add("sample/Images/Balls/defaultBall.png"); // if no skin is picked, Default ballSkin will be used
        ball = new Ball(root);
        ball.setY(sceneHeight - ball.getHeight() - 80); // sets the X position of the ball
        ball.setX((sceneWidth - ball.getWidth()) / 2); // sets the Y position of the ball


    }

    public void heartsAndCoins()
    {
        life1 = new ImageViewGameObj(root,"sample/Images/BrickSlayerHeart.png",30,30);
        life1.setY(15);
        life1.setX(15);
        life2  = new ImageViewGameObj(root,"sample/Images/BrickSlayerHeart.png",30,30);
        life2.setY(15);
        life2.setX(45);
        life3  = new ImageViewGameObj(root,"sample/Images/BrickSlayerHeart.png",30,30);
        life3.setY(15);
        life3.setX(75);

        coin = new ImageViewGameObj(root,"sample/Images/Coin.png",38,35);
        coin.setY(18);
        coin.setX(930);
    }

    public Ball updateBall(Ball ball) { // Method responsible for making the ball bounce off of the walls.
        ball = ball;
        ball.move(); // Calls the Ball class's move method to get the ball moving.
        int dx = ball.getDx(); // Initializes dx and sets it equal to the X velocity of the ball.
        int dy = ball.getDy(); // Initializes dy and sets it equal to the Y velocity of the ball.

        // Makes the ball bounce off of the right boundary of the window.
        if (ball.getX() > sceneWidth - ball.getHalfWidth()) {
            dx = -dx;
            ball.setDx(dx); // Changes the X velocity of the ball.
        }
        // Makes the ball bounce off of the Left boundary of the window.
        if (ball.getX() < 0 + ball.getHalfWidth()) {
            dx = -dx;
            ball.setDx(dx); // Changes the X velocity of the ball.
        }
        // Makes the ball bounce off of the bottom boundary of the window if bounceBottom is true.
        if (bounceBottom == true) {
            if (ball.getY() > sceneHeight - ball.getHalfWidth()) {
                dy = -dy;
                ball.setDy(dy); // Changes the Y velocity of the ball.
            }
        }
        // Makes the ball bounce off of the top boundary of the window if bounceBottom is true.
        if (ball.getY() < 0 + ball.getHalfHeight()) {
            dy = -dy;
            ball.setDy(dy); // Changes the X velocity of the ball.
        }
        return ball; // Returns the ball.
    }

    private BlockSide whichPartHit(Brick block) {

        final double upcorner = 63.43;
        final double botcorner = 116.56;

        final double epsilon = 0.02;

        Point2D brickFacing = new Point2D(0, -1);
        brickFacing = brickFacing.normalize();

        Point2D ballToBrick = new
                Point2D(
                ball.getX() - (block.getX() + block.getHalfWidth()),
                ball.getY() - (block.getY() + block.getHalfHeight()));
        ballToBrick = ballToBrick.normalize();
        double angle = Math.toDegrees(Math.acos(ballToBrick.dotProduct(brickFacing)));

        if (upcorner - epsilon <= angle && angle <= upcorner + epsilon) {
            // if hit close to upper corners
            return BlockSide.BLOCK_CORNER;
        } else if (botcorner - epsilon <= angle && angle <= botcorner + epsilon) {
            // if hit close to lower corners
            return BlockSide.BLOCK_CORNER;
        } else if (0 <= angle && angle < upcorner + epsilon) {
            // check top
            return BlockSide.BLOCK_TOP_BOT;
        } else if (botcorner + epsilon < angle) {
            // check bottom
            return BlockSide.BLOCK_TOP_BOT;
        } else if (upcorner + epsilon < angle && angle < botcorner - epsilon) {
            // only need 1 for this since angle is the same regardless of which
            // side we're on
            return BlockSide.BLOCK_LT_RT;
        } else {
            throw new IllegalStateException("whichPartHit failed!");
        }
    }

    public Pane getRoot() {
        return root;
    }

    public void brickLayer() {
        bricks = new ArrayList<>(); // Makes an array list.

        for (int i = brickStart; i < brickLimit; i++) { // For loop to create all 40 bricks and position them as desired.
            brick = new Brick(root, "/sample/Images/Bricks/BlueBrick.png", brickWidth, brickHeight);
            bricks.add(brick); // Adds the brick to the array list.

            brick.setX(brickWidth * i + brickBorder); // // Sets X position of the brick.
            brick.setY(brickHeight * 2); // Sets Y position of the brick.

            if (i >= secondRow && i <= endOfSecondRow) { // Creates the second row of bricks.
                brick.setX(brickWidth * (i - secondH) + brickBorder);
                brick.setY(brickHeight * rowSetter2);
            } else if (i >= thirdRow && i <= endOfThirdRow) { // Creates the third row of bricks.
                brick.setX(brickWidth * (i - thirdH) + brickBorder);
                brick.setY(brickHeight * rowSetter3);
            } else if (i >= fourthRow && i <= endOfFourthRow) { // Creates the fourth row of bricks.
                brick.setX(brickWidth * (i - fourthH) + brickBorder);
                brick.setY(brickHeight * rowSetter4);
            } else if (i >= fifthRow && i <= endOfFifthRow) { // Creates the fifth row of bricks.
                brick.setX(brickWidth * (i - fifthH) + brickBorder);
                brick.setY(brickHeight * rowSetter5);

            }
        }
        saveLevelData(bricks);
        System.out.println(bricks); // Prints the array list.

    }

    public void lifeLoss()  {
        lives -= 1;

        if(lives >= 0){
            start();
            ball.setX((sceneWidth - ball.getWidth()) / 2);
            ball.setY(sceneHeight - ball.getHeight() - 80);
            ball.setDx(0);
            ball.setDy(0);
            if(lives == 2)
            {
                life1 = new ImageViewGameObj(root,"sample/Images/BrickSlayerHeartWhite.png",30,30);
                life1.setY(15);
                life1.setX(15);
            }
            else if (lives == 1)
            {
                life2 = new ImageViewGameObj(root,"sample/Images/BrickSlayerHeartWhite.png",30,30);
                life2.setY(15);
                life2.setX(45);
            }
            else if(lives == 0)
            {
                life3 = new ImageViewGameObj(root,"sample/Images/BrickSlayerHeartWhite.png",30,30);
                life3.setY(15);
                life3.setX(75);
            }
        }
        else {
            timeline.stop(); // Stops the timeline.
            System.out.println("GameOver");
            gameOver = new ImageViewGameObj(root, "sample/Images/Game_over.png",414,60);
            gameOver.setX(280);
            gameOver.setY(220);

            gameDone();
        }
    }

    public void paddleCollision()
    {
        dx = ball.getDx(); // Sets dx to the ball's X velocity.
        dy = ball.getDy(); // Sets the ball's Y velocity to dy.

        if (ball.getBounds().intersects(paddle.getBounds())) { // Determines if the ball and paddle collide.
            ball.setDy(-dy); // Changes the ball's Y velocity to the opposite direction.

            // Changes X velocity of the ball if it hits the left half of the paddle.
            if (ball.getX() < (paddle.getX() + paddle.getHalfWidth())) {
                double paddleDx = (paddle.getX() - ball.getX()) / velocityScaler;
                ball.setDx((int) paddleDx);
            }
            // Changes X velocity of the ball if it hits the right half of the paddle.
            else if (ball.getX() > (paddle.getX() + paddle.getHalfWidth())) {
                if (ball.getDx() < 0) {
                    ball.setDx(-dx);
                }
                ball.setDx(dx);
            }
        }

    }

    public void brickCollision()
    {
        for (Brick brick : bricks) { // the loop to constantly checks for collisions between the ball and the bricks.

            // Removes the brick from scene that the ball collides with.
            if (ball.getBounds().intersects(brick.getBounds())) {
                score+=5;
                root.getChildren().remove(brick.getImageView());

                Main.effect("src/sample/Music/hit.wav"); // plays sound when brick is hit
                coins++; // increments coins
                numberOfCoins.setText(String.valueOf(coins));
                hit = true;

            }
            if (ball.getBounds().intersects(brick.getBounds())) {
                whichPartHit(brick); // Calls the whichPartHit method.

                // Checks if the ball struck the top of the bottom of the block.
                if (whichPartHit(brick) == BlockSide.BLOCK_TOP_BOT) {
                    dy = ball.getDy();
                    ball.setDy(-dy); // Changes the Y velocity of the ball.
                }
                // Checks if the ball struck the left or right side of the block.
                else if (whichPartHit(brick) == BlockSide.BLOCK_LT_RT) {
                    ball.setDx(-dx); // Changes the X velocity of the ball.
                }
                // Checks if the ball struck one of the corners of the blocks.
                else if (whichPartHit(brick) == BlockSide.BLOCK_CORNER) {
                    dy = ball.getDy();
                    ball.setDx(-dx); // Changes the X velocity of the ball.
                    ball.setDy(-dy); // Changes the Y velocity of the ball.
                }
            }
        }
        if (hit) { // Removes the block from the array list that the ball strikes.

            bricks.removeIf((b) -> {
                return ball.getBounds().intersects(b.getBounds());


            });

        }

        if (bricks.size() == 1) { // ends the game if all the blocks are removed from the array list.
            timeline.stop(); // Stops the timer.

            completed = new ImageViewGameObj(root, "sample/Images/Completed.png",464,56);
            completed.setX(280);
            completed.setY(230);
            gameDone();

        }

        // if the ball goes below the bottom lifeLoss() is called and the player loses a life.
        if (ball.getY() > sceneHeight) {
            lifeLoss();
        }

    }

    public void score()
    {
        System.out.println(score);

    }


    public void start() // resets the ball to the start position.
    {
        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ball.setDy(-3);
                ball.setDx(Ball.randInRange(-10, 11));

                    root.setOnMouseClicked(null);
            }
        });

    }

    public static void saveLevelData(ArrayList<Brick> bricks) {
        FileWriter writer = null;
        try {
            writer = new FileWriter("src/sample/LevelData.txt");
            writer.write(getLevelDataFromSession(bricks));
        } catch (IOException e) {
            System.out.println("Couldn't instantiate the FileWriter in saveLevelData()");
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (NullPointerException | IOException e) {
                System.out.println("Couldn't close the FileWriter in saveLevelData()");
                e.printStackTrace();
            }
        }
    }

    public static String getLevelDataFromSession(ArrayList<Brick> bricks)
    {
        StringBuilder gameData = new StringBuilder();
        for (Brick m : bricks)
        {
            String matchData = String.format(m.getX() + ":"+ m.getY() +"\n");
            gameData.append(matchData);
        }
        return gameData.toString();
    }

    public void playAudio()
    {

    }

    public static int getUserInput(){
        System.out.print("User Input: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public void gameDone()
    {
        Button button = new Button();
        button.setText("Back to menu");
        button.setTranslateX(420);
        button.setTranslateY(330);
        button.setCursor(Cursor.HAND);
        root.getChildren().add(button);

        button.setOnAction(new EventHandler<ActionEvent>()  {
            @Override
            public void handle(ActionEvent mouseEvent)  {
                try {
                    int temp = Main.players.get(0).getDeshCoins() + coins; //add the coins gained to players currency
                    Main.players.get(0).setDeshCoins(temp);

                    Main.clip.stop();
                    Main.music("src/sample/Music/Music.wav",-10.0f);
                    Parent root = FXMLLoader.load(getClass().getResource("Scenes/Scene1.fxml"));
                    stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    scene.getStylesheets().add(css);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}
