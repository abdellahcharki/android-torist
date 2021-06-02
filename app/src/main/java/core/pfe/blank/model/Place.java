package core.pfe.blank.model;

import core.pfe.blank.R;

public class Place {

    private int id;
    private String photo;
    private String name;
    private String disc ;
    private String city ;
    private String country ;
     private double x;
    private double y ;
    private int likes ;
    private int comments ;
    private Review review;

    public String getPhoto() {
        return photo;
    }


    public Place(int id , String name, String photo ){
        this.id=id;
        this.name=name;
        this.photo = photo;
    }


    public  Place(){

         id=1;
        name="jbel amrggou";
         disc = "liewoi  weoiruweiorweoirw";
         city = "Fes";
         country = "Morroco";
         x =    13.32221;
         y =  2.2222222;
         likes = 19;
         comments = 103;
          review = null;
    }

    public Place(int id, String name, String city, String country , String disc, String photo,int likes, int comments, double x, double y,  Review review) {
        this.id = id;
        this.name = name;
        this.disc = disc;
        this.city = city;
        this.country = country;
        this.photo = photo;
        this.x = x;
        this.y = y;
        this.likes = likes;
        this.comments = comments;
        this.review = review;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDisc() {
        return disc;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }

    public Review getReview() {
        return review;
    }
}
