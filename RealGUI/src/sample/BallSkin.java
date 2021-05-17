package sample;

public class BallSkin
{
    String name;
    String url;
    boolean owned;
    int price;

    public BallSkin(String name, String url, boolean owned, int price)
    {
        this.price = price;
        this.name = name;
        this.url = url;
        this.owned = owned;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isOwned() {
        return owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }
}
