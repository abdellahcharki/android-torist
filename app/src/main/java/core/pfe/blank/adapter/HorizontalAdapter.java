package core.pfe.blank.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

import core.pfe.blank.activity.PlaceDetailsActivity;
import core.pfe.blank.R;
import core.pfe.blank.model.Place;
import core.pfe.blank.model.PlaceItem;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ItemViewHolder> {

    Context context;
    ArrayList<Place> horizontalList;

    public HorizontalAdapter(Context context, ArrayList<Place> horizontalList) {
        this.context = context;
        this.horizontalList = horizontalList;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.slider_sub_item,parent,false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Place current = horizontalList.get(position);
        holder.placeName.setText(current.getName());

        Picasso.get().load(current.getPhoto()).into(holder.placeImage);
        Picasso.get().load(current.getPhoto()).into(holder.placeImage);
         //holder.imageItem


        holder.placeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PlaceDetailsActivity.class);
                Toast.makeText(context,"id : "+current.getId(),Toast.LENGTH_LONG).show();
                intent.putExtra("id",current.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView placeName;
        ImageView placeImage;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            placeName = itemView.findViewById(R.id.sub_title);
            placeImage=itemView.findViewById(R.id.image_item);
        }


    }
}
