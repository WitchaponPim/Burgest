package com.example.ptwitchapon.burgest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.Model.Order;
import com.example.ptwitchapon.burgest.Model.Orderlist;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.picasso.Picasso;

/**
 * Created by Killy77 on 21/4/2561.
 */

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.FollowViewHolder> {


    Order order;
    private Context context;

    private static int currentPosition = 0;

    public BasketAdapter(Order order, Context context) {
        this.order = order;
        this.context = context;
    }

    @Override
    public FollowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.basket_detail, parent, false);
        return new FollowViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FollowViewHolder holder, final int position) {
        Order.OrderBean listbean = order.getOrder().get(position);
        holder.ordername.setText("Order #"+listbean.getId_product());
        holder.Pname.setText(getname(listbean.getId_product()));
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
    }

    @Override
    public int getItemCount() {
        return order.getOrder().size();
    }

    class FollowViewHolder extends RecyclerView.ViewHolder {
        TextView ordername,price,Pname,total;
        ImageView imageView;
        LinearLayout linearLayout,list_item;

        FollowViewHolder(View itemView) {
            super(itemView);
            ordername = (TextView) itemView.findViewById(R.id.ordername);
            Pname = (TextView) itemView.findViewById(R.id.typename);
            price = (TextView) itemView.findViewById(R.id.price);

            total = (TextView) itemView.findViewById(R.id.total);
            list_item = (LinearLayout) itemView.findViewById(R.id.list_item) ;
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }

    public String getname(String name){
        String productname = null;

        switch (name){
            case "1" :
                productname = "CHICKEN";
                break;
            case "2" :
                productname = "CHICKEN EGG";
                break;
            case "3" :
                productname = "CHICKEN CHEESE";
                break;
            case "4" :
                productname = "CHICKEN CHEESE BACON";
                break;
            case "5" :
                productname = "CHICKEN CHEESE BACON EGG";
                break;
            case "6" :
                productname = "FISH";
                break;
            case "7" :
                productname = "FISH EGG";
                break;
            case "8" :
                productname = "FISH CHEESE";
                break;
            case "9" :
                productname = "FISH CHEESE EGG";
                break;
            case "10" :
                productname = "FISH CHEESE BACON";
                break;
            case "11" :
                productname = "BEEF LARGE";
                break;
            case "12" :
                productname = "BEEF LARGE CHEESE";
                break;
            case "13" :
                productname = "BEEF LARGE BACON";
                break;
            case "14" :
                productname = "BEEF LARGE DOUBLE CHEESE";
                break;
            case "15" :
                productname = "BEEF LARGE CHEESE BACON";
                break;
            case "16" :
                productname = "BEEF LARGE CHEESE BACON EGG";
                break;
            case "17" :
                productname = "DUBLE BEEF";
                break;
            case "18" :
                productname = "DUBLE BEEF DUBLE CHEESE";
                break;
            case "19" :
                productname = "DUBLE BEEF DUBLE CHEESE BACON";
                break;
            case "20" :
                productname = "BEEF";
                break;
            case "21" :
                productname = "BEEF CHEESE";
                break;
            case "22" :
                productname = "BEEF CHEESE BACON";
                break;
            case "23" :
                productname = "PORK";
                break;
            case "24" :
                productname = "PORK EGG";
                break;
            case "25" :
                productname = "PORK CHEESE";
                break;
            case "26" :
                productname = "PORK BACON";
                break;
            case "27" :
                productname = "PORK CHEESE EGG";
                break;
            case "28" :
                productname = "PORK CHEESE BACON";
                break;
            case "29" :
                productname = "DUBLE PORK";
                break;
            case "30" :
                productname = "PORK CHEESE BACON EGG";
                break;
            case "31" :
                productname = "DUBLE PORK DUBLE CHEESE";
                break;
            case "32" :
                productname = "DUBLE PORK DUBLE CHEESE BACON";
                break;
            case "33" :
                productname = "SPICY";
                break;
            case "34" :
                productname = "SPICY CHEESE";
                break;
            case "35" :
                productname = "FRENFRIED SMALL";
                break;
            case "36" :
                productname = "FRENFRIED MEDIUM";
                break;
            case "37" :
                productname = "FRENFRIED LARGE";
                break;
            case "38" :
                productname = "KARA-AGE";
                break;
            case "39" :
                productname = "CHEESE BALL";
                break;
            case "40" :
                productname = "COKE MEDIUM";
                break;
            case "41" :
                productname = "COKE SMALL";
                break;
            case "42" :
                productname = "SPRITE MEDIUM";
                break;
            case "43" :
                productname = "SPRITE SMALL";
                break;
            case "44" :
                productname = "WATER MEDIUM";
                break;
            case "45" :
                productname = "WATER SMALL";
                break;
            case "46" :
                productname = "SET A BEEF LARGE CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "47" :
                productname = "SET B PORK CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "48" :
                productname = "SET C CHICKEN CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "49" :
                productname = "SET D SPICY CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "50" :
                productname = "SET E FISH CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
        }

        return productname;
    }
}