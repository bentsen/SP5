package sample;

public interface Constants {
    public static final int sceneWidth = 1000; // width of the scene

    public static final int sceneHeight = 600; // height of the scene

    public static final int brickBorder = 100; //Number of empty pixels around the brick.

    public static final int brickWidth = 80; // brick width

    public static final int brickHeight = 30; // height of bricks

    public static final int velocityScaler = 5; // Rescales the velocity of the ball so it does not go too fast.


    /******************************************************************
                    Used in the bricklayer() method
     ******************************************************************/
    public static final int brickLimit = 42; // Limiter for the for loop.

    public static final int brickStart = 1; // Initializer for the for loop.

    public static final int secondRow= 9; // starts the second row of bricks.

    public static final int secondH = 8; // Resets the multiplier for the 2nd row of bricks.

    public static final int rowSetter2 = 3; // Sets the 2nd rows Y position to 3 times the bricks height.

    public static final int endOfSecondRow = 16; // Last brick of the second row.

    public static final int thirdRow = 18;

    public static final int thirdH = 17;

    public static final int rowSetter3 = 4;

    public static final int endOfThirdRow = 25;

    public static final int fourthRow= 26;

    public static final int fourthH = 25;

    public static final int rowSetter4 = 5;

    public static final int endOfFourthRow = 33;

    public static final int fifthRow = 34;

    public static final int fifthH = 33;

    public static final int rowSetter5 = 6;

    public static final int endOfFifthRow = 41;

}
