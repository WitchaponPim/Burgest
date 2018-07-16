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

import com.example.ptwitchapon.burgest.BasketActivity;
import com.example.ptwitchapon.burgest.Model.Order;
import com.example.ptwitchapon.burgest.Model.Orderlist;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Killy77 on 21/4/2561.
 */

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.FollowViewHolder> {


    Order order;
    private Context context;
    private Activity activity;
    private static int currentPosition = 0;
    BasketAdapter.OnItemClickListener listener;

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

    public String getname(String name){
        String productname = null;

        switch (name){
            case "10001" :
                productname = "CHICKEN";
                break;
            case "10002" :
                productname = "CHICKEN EGG";
                break;
            case "10003" :
                productname = "CHICKEN CHEESE";
                break;
            case "10004" :
                productname = "CHICKEN CHEESE BACON";
                break;
            case "10005" :
                productname = "CHICKEN CHEESE BACON EGG";
                break;
            case "10006" :
                productname = "FISH";
                break;
            case "10007" :
                productname = "FISH EGG";
                break;
            case "10008" :
                productname = "FISH CHEESE";
                break;
            case "10009" :
                productname = "FISH CHEESE EGG";
                break;
            case "10010" :
                productname = "FISH CHEESE BACON";
                break;
            case "10011" :
                productname = "BEEF LARGE";
                break;
            case "10012" :
                productname = "BEEF LARGE CHEESE";
                break;
            case "10013" :
                productname = "BEEF LARGE BACON";
                break;
            case "10014" :
                productname = "BEEF LARGE DOUBLE CHEESE";
                break;
            case "10015" :
                productname = "BEEF LARGE CHEESE BACON";
                break;
            case "10016" :
                productname = "BEEF LARGE CHEESE BACON EGG";
                break;
            case "10017" :
                productname = "DUBLE BEEF";
                break;
            case "10018" :
                productname = "DUBLE BEEF DUBLE CHEESE";
                break;
            case "10019" :
                productname = "DUBLE BEEF DUBLE CHEESE BACON";
                break;
            case "10020" :
                productname = "BEEF";
                break;
            case "10021" :
                productname = "BEEF CHEESE";
                break;
            case "10022" :
                productname = "BEEF CHEESE BACON";
                break;
            case "10023" :
                productname = "PORK";
                break;
            case "10024" :
                productname = "PORK EGG";
                break;
            case "10025" :
                productname = "PORK CHEESE";
                break;
            case "10026" :
                productname = "PORK BACON";
                break;
            case "10027" :
                productname = "PORK CHEESE EGG";
                break;
            case "10028" :
                productname = "PORK CHEESE BACON";
                break;
            case "10029" :
                productname = "DUBLE PORK";
                break;
            case "10030" :
                productname = "PORK CHEESE BACON EGG";
                break;
            case "10031" :
                productname = "DUBLE PORK DUBLE CHEESE";
                break;
            case "10032" :
                productname = "DUBLE PORK DUBLE CHEESE BACON";
                break;
            case "10033" :
                productname = "SPICY";
                break;
            case "10034" :
                productname = "SPICY CHEESE";
                break;
            case "10035" :
                productname = "FRENFRIED SMALL";
                break;
            case "10036" :
                productname = "FRENFRIED MEDIUM";
                break;
            case "10037" :
                productname = "FRENFRIED LARGE";
                break;
            case "10038" :
                productname = "KARA-AGE";
                break;
            case "10039" :
                productname = "CHEESE BALL";
                break;
            case "10040" :
                productname = "COKE MEDIUM";
                break;
            case "10041" :
                productname = "COKE SMALL";
                break;
            case "10042" :
                productname = "SPRITE MEDIUM";
                break;
            case "10043" :
                productname = "SPRITE SMALL";
                break;
            case "10044" :
                productname = "WATER MEDIUM";
                break;
            case "10045" :
                productname = "WATER SMALL";
                break;
            case "10046" :
                productname = "SET A BEEF LARGE CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "10047" :
                productname = "SET B PORK CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "10048" :
                productname = "SET C CHICKEN CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "10049" :
                productname = "SET D SPICY CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
            case "10050" :
                productname = "SET E FISH CHEESE + FRENFRIED SMALL + COKE SMALL";
                break;
        }

        return productname;
    }
}