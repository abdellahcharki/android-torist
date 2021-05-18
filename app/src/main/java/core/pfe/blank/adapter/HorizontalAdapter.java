package core.pfe.blank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import core.pfe.blank.R;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ItemViewHolder> {

    Context context;
    ArrayList<String> horizontalList;

    public HorizontalAdapter(Context context, ArrayList<String> horizontalList) {
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
        holder.subTitle.setText(horizontalList.get(position));
        // holder.imageItem
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView subTitle;
        ImageView imageItem;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            subTitle = itemView.findViewById(R.id.sub_title);
            imageItem=itemView.findViewById(R.id.image_item);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context,"click",Toast.LENGTH_LONG).show();
        }
    }
}
