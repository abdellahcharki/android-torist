package core.pfe.blank.serves;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import core.pfe.blank.activity.MainActivity;
import core.pfe.blank.model.City;
import core.pfe.blank.model.Place;
import core.pfe.blank.model.PlaceItem;
import core.pfe.blank.model.SliderItem;

public class PlaceServes extends HttpRequest {

    public static  ArrayList<City> cities;
    City city;




    public ArrayList<City> getAllCityes(  ) {





        return cities;
    }


    public static ArrayList<City> getCities() {
        getCities();
        return cities;
    }

    void onResCities(ArrayList<City> cities){
        this.cities=cities;



    }

    public  Place getPlaceById(int id){

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, "http://192.168.1.123:8018/api/cityes/"+id, null,
                new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("x", "onResponse: "+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("x", "onErrorResponse: "+error.getMessage() );
            }
        });

        this.queue.add(request);
        return null;
    }

    public static void likePost(){

    }


}
