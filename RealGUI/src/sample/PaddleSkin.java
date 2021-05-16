package sample;

public class PaddleSkin
{
    String name;
    String url;
    boolean owned;

    public PaddleSkin(String name, String url, boolean owned)
    {
        this.name = name;
        this.url = url;
        this.owned = owned;
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
