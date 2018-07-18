package com.example.ptwitchapon.burgest.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.BasketActivity;
import com.example.ptwitchapon.burgest.Callback.ProductCallback;
import com.example.ptwitchapon.burgest.Model.Order;
import com.example.ptwitchapon.burgest.Model.Orderlist;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.Model.ProductModel;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.okhttp.ResponseBody;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit.Retrofit;

/**
 * Created by Killy77 on 21/4/2561.
 */

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.FollowViewHolder> {


    Order order;
    private Context context;
    private Activity activity;
    private static int currentPosition = 0;
    private String name;
    BasketAdapter.OnItemClickListener listener;
    ConnectManager connectManager = new ConnectManager();

    public BasketAdapter(Order order, Context context, Activity activity,BasketAdapter.OnItemClickListener listener) {
        this.order = order;
        this.context = context;
        this.activity = activity;
        this.listener = listener;

    }

    @Override
    public FollowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.basket_detail, parent, false);
        return new FollowViewHolder(v);
    }

    public interface OnItemClickListener {
        void onItemClick(Order.OrderBean orderlist, int position);
    }

    @Override
    public void onBindViewHolder(final FollowViewHolder holder, final int position) {
        final Order.OrderBean listbean = order.getOrder().get(position);
        holder.ordername.setText("Order #"+listbean.getId_product());
        ProductCallback callback = new ProductCallback() {
            @Override
            public void onResponse(ProductModel productModel, Retrofit retrofit) {
                holder.Pname.setText(productModel.getProduct().get(0).getProductName());
            }

            @Override
            public void onFailure(Throwable t) {

            }

            @Override
            public void onBodyError(ResponseBody responseBody) {

            }

            @Override
            public void onBodyErrorIsNull() {

            }
        };
        connectManager.getProduct(callback,listbean.getId_product());
        holder.price.setText(listbean.getPrice());
        holder.total.setText(listbean.getTotal());





        holder.linearLayout.setVisibility(View.GONE);

        //if the position is equals to the item position which is to be expanded
        if (currentPosition == position) {
            //creating an animation
            Animation slideDown = AnimationUtils.loadAnimation(context, R.anim.animation);

            //toggling visibility
            holder.linearLayout.setVisibility(View.VISIBLE);

            //adding sliding effect
            holder.linearLayout.startAnimation(slideDown);
        }

        holder.list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getting the position of the item to expand it
                currentPosition = position;
                //reloding the list
                notifyDataSetChanged();
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(listbean,position);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                order.getOrder().remove(position);
                Utils.order = order;

                holder.txttotal.setText(String.valueOf(BasketActivity.gettotal())+" ฿");

//                activity.startActivity(new Intent(activity,BasketActivity.class));
//                activity.finish();
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, order.getOrder().size());

            }
        });

    }

    @Override
    public int getItemCount() {
        return order.getOrder().size();
    }

    class FollowViewHolder extends RecyclerView.ViewHolder {
        TextView ordername,price,Pname,total,txttotal;
        ImageView delete;
        LinearLayout linearLayout,list_item;
        Button edit;

        FollowViewHolder(View itemView) {
            super(itemView);
            txttotal = (TextView) activity.findViewById(R.id.totaltxt);
            ordername = (TextView) itemView.findViewById(R.id.ordername);
            Pname = (TextView) itemView.findViewById(R.id.typename);
            price = (TextView) itemView.findViewById(R.id.price);
            edit = (Button) itemView.findViewById(R.id.edit) ;
            total = (TextView) itemView.findViewById(R.id.total);
            list_item = (LinearLayout) itemView.findViewById(R.id.list_item) ;
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
            delete = (ImageView) itemView.findViewById(R.id.delete);

        }
    }


}