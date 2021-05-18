package core.pfe.blank.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONObject;

import java.util.ArrayList;

import core.pfe.blank.R;
import core.pfe.blank.adapter.HomeAdapter;
import core.pfe.blank.model.HomeElement;
import core.pfe.blank.model.HomeHeader;
import core.pfe.blank.model.SliderItem;
import core.pfe.blank.serves.UserService;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView ;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ImageButton menuIcon;

    private RequestQueue requestQueue;
    HomeAdapter homeAdapter;
    ArrayList<HomeElement> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigation_view);
        menuIcon=findViewById(R.id.menu_icon);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener( this);
        navigationView.setCheckedItem(R.id.nav_profile);
        recyclerView=findViewById(R.id.main_recycler);
        list=new ArrayList<>();


        list.add(new HomeHeader());
        list.add(new SliderItem("Fes, Morocco"));
        list.add(new SliderItem("Barcelona, Espane"));
        list.add(new SliderItem("Birlen, German"));
        list.add(new SliderItem("Nice, France"));
        list.add(new SliderItem("Roma, Italy"));
        list.add(new SliderItem("Moulay Bouchta,Morocco"));
        list.add(new SliderItem("Ayoun, Morocco"));
        list.add(new SliderItem("Qustantina , Algire"));
        list.add(new SliderItem("Nador, Morocco"));
        list.add(new SliderItem("Oujda, Morroco"));
        list.add(new SliderItem("Fes, Morocco"));
        list.add(new SliderItem("Barcelona, Espane"));
        list.add(new SliderItem("Birlen, German"));
        list.add(new SliderItem("Nice, France"));
        list.add(new SliderItem("Roma, Italy"));
        list.add(new SliderItem("Moulay Bouchta,Morocco"));
        list.add(new SliderItem("Ayoun, Morocco"));
        list.add(new SliderItem("Qustantina , Algire"));
        list.add(new SliderItem("Nador, Morocco"));
        list.add(new SliderItem("Oujda, Morroco"));
        list.add(new SliderItem("Fes, Morocco"));
        list.add(new SliderItem("Barcelona, Espane"));
        list.add(new SliderItem("Birlen, German"));
        list.add(new SliderItem("Nice, France"));
        list.add(new SliderItem("Roma, Italy"));
        list.add(new SliderItem("Moulay Bouchta,Morocco"));
        list.add(new SliderItem("Ayoun, Morocco"));
        list.add(new SliderItem("Qustantina , Algire"));
        list.add(new SliderItem("Nador, Morocco"));
        list.add(new SliderItem("Oujda, Morroco"));
        list.add(new SliderItem("Fes, Morocco"));
        list.add(new SliderItem("Barcelona, Espane"));
        list.add(new SliderItem("Birlen, German"));
        list.add(new SliderItem("Nice, France"));
        list.add(new SliderItem("Roma, Italy"));
        list.add(new SliderItem("Moulay Bouchta,Morocco"));
        list.add(new SliderItem("Ayoun, Morocco"));
        list.add(new SliderItem("Qustantina , Algire"));
        list.add(new SliderItem("Nador, Morocco"));
        list.add(new SliderItem("Oujda, Morroco"));

        homeAdapter = new HomeAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(homeAdapter);


        requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/users/1", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("HTTP", "onResponse: "+response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("HTTP", "onErrorResponse: "+error);

            }
        });

        requestQueue.add(jor);

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {




        return true;
    }




    public  void navBarAction(){


    }

}