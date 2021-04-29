package core.pfe.blank.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import core.pfe.blank.R;
import core.pfe.blank.model.HomeElement;
import core.pfe.blank.model.SliderItem;

public class HomeAdapter extends RecyclerView.Adapter{

    ArrayList<HomeElement> homeElements;
    Context context;


    public HomeAdapter( Context context,ArrayList<HomeElement> homeElements) {
        this.homeElements = homeElements;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if( homeElements.get(position).type==0 ) return 0;// is header
         return 1;// slider item
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if( viewType==0)
            return new HomeHeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.home_header,parent,false));
        else
            return new SliderHomeItemViewHolder(LayoutInflater.from(context).inflate(R.layout.slider_home_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if( homeElements.get(position).type!=0 ){
            SliderHomeItemViewHolder h = (SliderHomeItemViewHolder) holder;
            SliderItem sliderItem = (SliderItem) homeElements.get(position);
            h.textView.setText(sliderItem.getTitle());

            ArrayList<String> sublist = new ArrayList<>();
            sublist.add("dhdhd");
            sublist.add("dhdhd");
            sublist.add("dhdhd");
            sublist.add("dhdhd");
            sublist.add("dhdhd");


HorizontalAdapter horizontalAdapter = new HorizontalAdapter(context,sublist);
h.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            h.recyclerView.setHasFixedSize(false);

            h.recyclerView.setAdapter(horizontalAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return homeElements.size();
    }


    public class HomeHeaderViewHolder extends RecyclerView.ViewHolder{
        public HomeHeaderViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }


    public class SliderHomeItemViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        RecyclerView recyclerView;
        public SliderHomeItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView= itemView.findViewById(R.id.slider_title);
            recyclerView=itemView.findViewById(R.id.horizontal_recyclerview);
        }
    }



}
