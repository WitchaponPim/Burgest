package com.example.ptwitchapon.burgest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.picasso.Picasso;

/**
 * Created by Witchapon on 9/4/2561.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MenuViewHolder> {


    MainAdapter.OnItemClickListener listener;
    Product.ProductBean products;
    Context context;
    public interface OnItemClickListener {
        void onItemClick(Product.ProductBean products, int position);
    }

    @Override
    public MainAdapter.MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (products.getName().equals("Promotion")){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowpromo, parent, false);
        }else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        }


        return new MainAdapter.MenuViewHolder(v);
    }


    public MainAdapter(Context context, Product.ProductBean products, MainAdapter.OnItemClickListener listener) {
        this.products = products;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(MainAdapter.MenuViewHolder holder, int position) {
        holder.setMenu(products);
        holder.setIsRecyclable(false);
    }


    @Override
    public int getItemCount() {
        return products.getBurgur().size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView name,price;


        public MenuViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.burger);
            price = (TextView) itemView.findViewById(R.id.price);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(products,getAdapterPosition());
                }
            });
        }

        public void setMenu(final Product.ProductBean products){
            if (products.getName().equals("Promotion")){
                if(!products.getBurgur().get(getAdapterPosition()).getPath().equals("")) {
                    Picasso.with(context)
                            .load(Utils.ipPic + products.getBurgur().get(getAdapterPosition()).getPath())
                            .into(imageView);
                }
            }else {
                name.setText(products.getBurgur().get(getAdapterPosition()).getProductName());
                price.setText(products.getBurgur().get(getAdapterPosition()).getPrice());
                if(!products.getBurgur().get(getAdapterPosition()).getPath().equals("")) {
                    Picasso.with(context)
                            .load(Utils.ipPic + products.getBurgur().get(getAdapterPosition()).getPath())
                            .into(imageView);
                }
            }

        }
    }
}
