package core.pfe.blank.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import core.pfe.blank.R;
import core.pfe.blank.activity.PlaceActivity;
import core.pfe.blank.activity.PlaceDetailsActivity;
import core.pfe.blank.model.Place;

public class CityAllAdapter  extends RecyclerView.Adapter<CityAllAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Place> places;

    public CityAllAdapter(Context context, ArrayList<Place> places) {
        this.context = context;
        this.places = places;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cityes_list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Place place = places.get(position);

        holder.name.setText(place.getName());
        Picasso.get().load(place.getPhoto()).into(holder.img);
        holder.likes.setText(String.valueOf(place.getLikes()));
        holder.comments.setText(String.valueOf(place.getComments()));




        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, PlaceDetailsActivity.class);
                i.putExtra("id",place.getId());
                context.startActivity(i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return places.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView name;
        TextView comments;
        TextView likes;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.place_all_item_image);
            name = itemView.findViewById(R.id.place_all_name_item);
            comments = itemView.findViewById(R.id.place_all_comment_item);
            likes=itemView.findViewById(R.id.place_all_like_item);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context,"id",Toast.LENGTH_LONG).show();
        }
    }
}
