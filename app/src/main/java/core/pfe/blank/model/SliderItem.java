package core.pfe.blank.model;

import java.util.ArrayList;

import core.pfe.blank.R;

public class SliderItem extends HomeElement {
    int id;
    String title;
    ArrayList<PlaceItem> placeList;


    public SliderItem(int id, String title, ArrayList<PlaceItem> placeList) {
        this.id = id;
        this.title = title;
        this.placeList = placeList;
    }

    public int getId() {
        return id;
    }

    public ArrayList<PlaceItem> getPlaceList() {
        return placeList;
    }

    public SliderItem(int id, String title) {
        this.title = title;
        this.id = id;
    }

    public SliderItem(int type) {
        this.type = type;
    }


    public SliderItem(String title, int img) {
        this(1);
        this.title = title;
     }

    public SliderItem(String title) {
        this(1);
        this.title = title;

    }



    public String getTitle() {
        return title;
    }


}
