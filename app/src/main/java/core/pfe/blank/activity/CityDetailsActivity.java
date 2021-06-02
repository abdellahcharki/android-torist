package core.pfe.blank.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import core.pfe.blank.R;
import core.pfe.blank.adapter.CityAllAdapter;
import core.pfe.blank.model.City;
import core.pfe.blank.model.Place;
import core.pfe.blank.serves.HttpRequest;

public class CityDetailsActivity extends AppCompatActivity {
    ImageView mainImageCity;
    TextView nameCity;
    TextView numberOfPlace;
    TextView discCity;
    Intent intent;
    ArrayList<Place> list;

ProgressDialog dialog;

RequestQueue queue;

    CityAllAdapter adapter;
    RecyclerView cityRecycler;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_details);
        cityRecycler = findViewById(R.id.resycler_city);



        list=new ArrayList<>();
        queue = Volley.newRequestQueue(this);


        mainImageCity = findViewById(R.id.city_img);
        nameCity = findViewById(R.id.city_name);
        numberOfPlace = findViewById(R.id.number_of_place);
        discCity = findViewById(R.id.city_disc);

        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage("please wait ...");
        dialog.show();


        int cid  =  getIntent().getIntExtra("id",0);


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, "http://192.168.1.123:8018/api/citys/"+cid, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {

                    String photo = response.getString("photo_v");
                    Log.d("photo", "onResponse: "+photo);
                    if(!photo.startsWith("http")) photo = HttpRequest.uploads+"/"+photo;

                    JSONArray placesArray = response.getJSONArray("responsPlace");

                    ArrayList<Place> places = new ArrayList<>();

                    for (int i =0; i<placesArray.length();i++){
                       JSONObject object = (JSONObject) placesArray.get(i);
                       int p_id   = object.getInt("id_place");
                       String p_name = object.getString("nom_place");
                       String p_photo = object.getString("photo");
                        if(!p_photo.startsWith("http")) p_photo = HttpRequest.uploads+"/"+p_photo;
                       places.add(new Place(p_id,p_name,p_photo));
                    }


                    City c = new City(response.getInt("id_ville"),photo,response.getString("nom_ville"),response.getString("nom_pays"),response.getString("desc"),null,places);



                    // set varible data
                    Picasso.get().load(photo).into(mainImageCity);
                    numberOfPlace.setText( " "+places.size()+" place");
                    discCity.setText(c.getDisc());
                    nameCity.setText(" "+c.getName()+", "+c.getCountry());

                    adapter = new CityAllAdapter(CityDetailsActivity.this,places);

                    cityRecycler.setMinimumHeight(430*places.size());

                    cityRecycler.setLayoutManager(new LinearLayoutManager(CityDetailsActivity.this));
                    cityRecycler.setHasFixedSize(false);


                    cityRecycler.setAdapter(adapter);



                    dialog.dismiss();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

//                City c = new City()



            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);












    }
}