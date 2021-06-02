package core.pfe.blank.model;

import java.util.Date;

public class Comment {


    private int rid;
    private int uid;
    private String username;
    private float rat;
    private String comment;
    private Date date;
    private int likes;


    public Comment(int rid, int uid, float rat) {
        this.rid = rid;
        this.uid = uid;
        this.rat = rat;
        this.likes =0;
    }

    public boolean toggleLike(){

        return false;
    }


}
