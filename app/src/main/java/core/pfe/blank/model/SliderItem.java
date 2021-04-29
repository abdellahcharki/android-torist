package core.pfe.blank.model;

import java.util.ArrayList;

public class SliderItem extends HomeElement{
    String title;




    public SliderItem(int type) {
        this.type = type;

    }

    public SliderItem(String title) {
        this(1);
        this.title = title;

    }



    public String getTitle() {
        return title;
    }


}
