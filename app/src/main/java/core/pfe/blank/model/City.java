package core.pfe.blank.model;

import java.util.ArrayList;
import java.util.Date;

public class City {
    private int id;
    private String country;
    private String name;
    private Date creatAt;
    private String img;
    private String disc;
    private ArrayList<Place> places;


    public City(int id, String img, String name, String country, String  disc,Date creatAt, ArrayList<Place> places) {
        this.id = id;
        this.country = country;
        this.name = name;
        this.creatAt = creatAt;
        this.img = img;
        this.disc=disc;
        this.places = places;
    }



    public  City(int id,String name,String country,ArrayList<Place> places){
        this.id=id;
        this.name=name;
        this.country=country;
        this.places=places;
    }

    public City() {

    }


    public String getDisc() {
        return disc;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public Date getCreatAt() {
        return creatAt;
    }

    public String getImg() {
        return img;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }
}
