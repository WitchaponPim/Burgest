package com.example.ptwitchapon.burgest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.Model.StockDetailModel;
import com.example.ptwitchapon.burgest.Model.StockDetailModel;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.picasso.Picasso;

/**
 * Created by Killy77 on 21/4/2561.
 */

public class Stock_itemAdapter extends RecyclerView.Adapter<Stock_itemAdapter.FollowViewHolder> {

    String TAG = "Listview";


    StockDetailModel orderlist ;
    private Context context;


    public Stock_itemAdapter(Context context, StockDetailModel orderlist ) {
        this.orderlist = orderlist;
        this.context = context;

    }

    @Override
    public FollowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.stock_item_row, parent, false);
        return new FollowViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FollowViewHolder holder, final int position) {

        holder.setMenu(orderlist);

    }

    @Override
    public int getItemCount() {
        return orderlist.getStock().size();
    }

    class FollowViewHolder extends RecyclerView.ViewHolder {
        TextView proname,qty,total;

        FollowViewHolder(View itemView) {
            super(itemView);
            proname = (TextView) itemView.findViewById(R.id.productname);
            qty = (TextView) itemView.findViewById(R.id.qty);
            total = (TextView) itemView.findViewById(R.id.totalprice);


        }
        public void setMenu(final StockDetailModel orderlist){

        proname.setText("Lot#"+orderlist.getStock().get(getAdapterPosition()).getId_stockdetail());
        qty.setText("Amount : "+orderlist.getStock().get(getAdapterPosition()).getAmount());
        total.setText("EXP : "+orderlist.getStock().get(getAdapterPosition()).getExpire_date());

        }
    }

}