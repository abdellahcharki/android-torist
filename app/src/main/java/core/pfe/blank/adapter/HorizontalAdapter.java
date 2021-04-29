package core.pfe.blank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView subTitle;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            subTitle = itemView.findViewById(R.id.sub_title);
        }
    }
}