package sample;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Map {

    int id;
    Boolean locked;

    public Map(int id, boolean locked)
    {
        this.id = id;
        this.locked = locked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}
