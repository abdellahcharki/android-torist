package core.pfe.blank.serves;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import core.pfe.blank.model.User;

public class UserService {
    private Context context;
    private String url;



    public UserService(Context context) {
        this.context=context;
    }


    public void findUserByEmail(String email){

    }




}




