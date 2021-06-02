package core.pfe.blank.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import core.pfe.blank.activity.CityDetailsActivity;
import core.pfe.blank.R;
import core.pfe.blank.model.City;
import core.pfe.blank.model.HomeElement;
import core.pfe.blank.model.PlaceItem;
import core.pfe.blank.model.SliderItem;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    ArrayList<City> cities;
    Context context;

    public HomeAdapter(Context context,ArrayList<City> cities) {
        this.cities = cities;
        this.context = context;
    }


    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.slider_home_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
       City c = cities.get(position);
        holder.title.setText(""+c.getName()+", "+c.getCountry());


        HorizontalAdapter adapter = new HorizontalAdapter(context,c.getPlaces());
        holder.horizontal.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        holder.horizontal.setHasFixedSize(false);
        holder.horizontal.setAdapter(adapter);




        holder.sliderHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,CityDetailsActivity.class);
                i.putExtra("id",c.getId());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        RecyclerView horizontal;
        LinearLayout sliderHeader;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.slider_title);
            horizontal = itemView.findViewById(R.id.horizontal_recyclerview);
            sliderHeader = itemView.findViewById(R.id.slider_header);
        }
    }
}
