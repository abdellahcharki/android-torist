package core.pfe.blank.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import core.pfe.blank.R;
import core.pfe.blank.adapter.HomeAdapter;
import core.pfe.blank.model.City;
import core.pfe.blank.model.HomeElement;
import core.pfe.blank.model.Place;
import core.pfe.blank.model.SliderItem;
import core.pfe.blank.serves.HttpRequest;
import core.pfe.blank.serves.PlaceServes;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RequestQueue queue;


    RecyclerView recyclerView ;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ImageButton menuIcon;
    ImageButton goAccount;
    HomeAdapter homeAdapter;


    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        queue = Volley.newRequestQueue(this);



        goAccount=findViewById(R.id.go_account);
        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigation_view);
        menuIcon=findViewById(R.id.menu_icon);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener( this);
        navigationView.setCheckedItem(R.id.nav_profile);
        recyclerView=findViewById(R.id.main_recycler);






dialog = new ProgressDialog(this);
dialog.setMessage("Plase wait ...");
dialog.setMax(1);
dialog.setCancelable(false);
dialog.show();



        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "http://192.168.1.123:8018/api/cityes", null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                         ArrayList<City> cities = new ArrayList<>();
                        int id;
                        String cityName;
                        String country;
                        City city;
                        JSONArray placesArray;

                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject res = (JSONObject) response.get(i);
                                ArrayList<Place> places = new ArrayList<>();

                                id = res.getInt("id_ville");
                                cityName = res.getString("nom_ville");
                                country = res.getString("nom_pays");
                                placesArray = res.getJSONArray("responsPlace");
                                 for (int j = 0; j < placesArray.length(); j++) {

                                    JSONObject placeObj = (JSONObject) placesArray.get(j);

                                    int pid = placeObj.getInt("id_place");
                                    String pname = placeObj.getString("nom_place");


                                    //String photo = "http://192.168.1.123:8018/uploadsPlace/"+placeObj.getString("photo");
                                    String photo = placeObj.getString("photo");


                                    if(!photo.startsWith("http")){
                                        photo = HttpRequest.uploads+"/"+photo;
                                    }



                                    Place place = new Place(pid, pname, photo);
                                    places.add(place);
                                }


                                city = new City(id, cityName, country, places);
                                if(city.getPlaces().size()>0)  cities.add(city);
                                //cities.add(city);

                                if (cities.size()>0) dialog.dismiss();
                                else {
                                    startActivity(new Intent(MainActivity.this,ErroreActivity.class));
                                }
                                homeAdapter = new HomeAdapter(MainActivity.this,cities);
                                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                                recyclerView.setHasFixedSize(true);
                                recyclerView.setAdapter(homeAdapter);


                            } catch (JSONException e) {
                                e.printStackTrace();

                                startActivity(new Intent(MainActivity.this,ErroreActivity.class));
                             }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        this.queue.add(request);













        goAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AccountActivity.class);
                startActivity(i);
            }
        });



    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {




        return true;
    }




    public  void navBarAction(){


    }





}