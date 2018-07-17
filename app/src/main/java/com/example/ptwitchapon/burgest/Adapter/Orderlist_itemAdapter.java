package com.example.ptwitchapon.burgest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.Callback.OrderList_ItemCallback;
import com.example.ptwitchapon.burgest.Model.Orderlist;
import com.example.ptwitchapon.burgest.Model.Orderlist_item;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Killy77 on 21/4/2561.
 */

public class Orderlist_itemAdapter extends RecyclerView.Adapter<Orderlist_itemAdapter.FollowViewHolder> {

    String TAG = "Listview";


    Orderlist_item orderlist ;
    private Context context;


    public Orderlist_itemAdapter(Context context, Orderlist_item orderlist ) {
        this.orderlist = orderlist;
        this.context = context;

    }

    @Override
    public FollowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderlist_item_row, parent, false);
        return new FollowViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FollowViewHolder holder, final int position) {

        holder.setMenu(orderlist);

    }

    @Override
    public int getItemCount() {
        return orderlist.getItems().size();
    }

    class FollowViewHolder extends RecyclerView.ViewHolder {
        TextView proname,qty,total;
        ImageView pic;



        FollowViewHolder(View itemView) {
            super(itemView);
            proname = (TextView) itemView.findViewById(R.id.productname);
            qty = (TextView) itemView.findViewById(R.id.qty);
            total = (TextView) itemView.findViewById(R.id.totalprice);
            pic = (ImageView) itemView.findViewById(R.id.imageView1);

        }
        public void setMenu(final Orderlist_item orderlist){

        proname.setText(orderlist.getItems().get(getAdapterPosition()).getProductName());
        qty.setText(orderlist.getItems().get(getAdapterPosition()).getQty() + " Pc.");
        int total_row = Integer.valueOf(orderlist.getItems().get(getAdapterPosition()).getprice())*Integer.valueOf(orderlist.getItems().get(getAdapterPosition()).getQty());
        total.setText(String.valueOf(total_row)+" ฿.");
        Picasso.with(context)
                .load(Utils.ipPic + orderlist.getItems().get(getAdapterPosition()).getPath())
                .into(pic);
        }
    }

}