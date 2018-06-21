package com.example.ptwitchapon.burgest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.Model.Product;

import com.example.ptwitchapon.burgest.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Witchapon on 9/4/2561.
 */

public class OtherAdapter extends RecyclerView.Adapter<OtherAdapter.MenuViewHolder> {


    OtherAdapter.OnItemClickListener listener;
    List<String> othermenu = new ArrayList<>();
    Context context;
    public interface OnItemClickListener {
        void onItemClick(int position,String menu);
    }

    @Override
    public OtherAdapter.MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.other_row, parent, false);
        return new OtherAdapter.MenuViewHolder(v);
    }

    public OtherAdapter(Context context,List<String> othermenu, OtherAdapter.OnItemClickListener listener) {
        this.othermenu = othermenu;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(OtherAdapter.MenuViewHolder holder, int position) {
        holder.setMenu(othermenu,position);
        holder.setIsRecyclable(false);
    }


    @Override
    public int getItemCount() {
        return othermenu.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public MenuViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.other_name);
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(getAdapterPosition(),othermenu.get(getAdapterPosition()));
                }
            });
//            price = (TextView) itemView.findViewById(R.id.price);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    listener.onItemClick(products,getAdapterPosition());
//                }
//            });
        }

        public void setMenu(final List<String> othermenu,int position){
//            name.setText(products.getBurgur().get(getAdapterPosition()).getProductName());
//            price.setText(products.getBurgur().get(getAdapterPosition()).getPrice());
//            if(!products.getBurgur().get(getAdapterPosition()).getPath().equals("")) {
//                Picasso.with(context)
//                        .load("http://10.10.95.104/hamburger/image/" + products.getBurgur().get(getAdapterPosition()).getPath())
//                        .into(imageView);
//            }
            name.setText(othermenu.get(position));
        }
    }
}
