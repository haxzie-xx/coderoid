package com.aeiton.androidworkshop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by User on 07-Feb-17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<RecyclerModel> itemList;

    ImageView img;
    TextView name, cost;
    LinearLayout main;
    Context mContext;

    RecyclerAdapter(List<RecyclerModel> itemList, Context context){
        this.itemList = itemList;
        this.mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img);
            name = (TextView) itemView.findViewById(R.id.name);
            cost = (TextView) itemView.findViewById(R.id.cost);
            main = (LinearLayout) itemView.findViewById(R.id.main_content);
        }
    }
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_custom_recycler, parent, false);

        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

        final RecyclerModel item = itemList.get(position);
        img.setImageResource(item.getImageId());
        name.setText(item.getName());
        cost.setText(item.getPrice());
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,item.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
