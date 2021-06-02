package core.pfe.blank.model;

import core.pfe.blank.R;

public class PlaceItem {
    private   int id;
    private String name;
    private int img = R.drawable.default_placeholder;

    public PlaceItem(){}

    public PlaceItem(int id, String name, int img) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public PlaceItem(int id, String name) {
        this.id = id;
        this.name = name;
    }


}
