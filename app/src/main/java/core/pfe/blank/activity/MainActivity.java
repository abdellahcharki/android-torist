package core.pfe.blank.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import core.pfe.blank.R;
import core.pfe.blank.adapter.HomeAdapter;
import core.pfe.blank.model.HomeElement;
import core.pfe.blank.model.HomeHeader;
import core.pfe.blank.model.SliderItem;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    HomeAdapter homeAdapter;
    ArrayList<HomeElement> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }
}