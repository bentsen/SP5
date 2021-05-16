package sample;

public class Player
{
    String name;
    int score;
    int deshCoins;
    public Player(String name, int score, int deshCoins)
    {
        this.deshCoins = deshCoins;
        this.name = name;
        this.score = score;
    }

        //GETTERS AND SETTERS
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    public int getDeshCoins() { return deshCoins; }

    public void setDeshCoins(int deshCoins) { this.deshCoins = deshCoins; }
}
