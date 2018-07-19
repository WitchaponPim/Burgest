package com.example.ptwitchapon.burgest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.okhttp.ResponseBody;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit.Retrofit;

/**
 * Created by Killy77 on 21/4/2561.
 */

public class FollowAdapter extends RecyclerView.Adapter<FollowAdapter.FollowViewHolder> {

    String TAG = "Listview";

    FollowAdapter.OnItemClickListener listener;
    List<Orderlist.ItemsBean> orderlist = new ArrayList<>();

    Context context;


    public FollowAdapter(Context context,List<Orderlist.ItemsBean> orderlist,FollowAdapter.OnItemClickListener listener) {
        this.orderlist = orderlist;
        this.context = context;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(List<Orderlist.ItemsBean> orderlist, int position);
        void onConfirm(List<Orderlist.ItemsBean> orderlist, int position);
    }

    @Override
    public FollowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.follow_detail, parent, false);
        return new FollowViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FollowViewHolder holder, final int position) {
        Orderlist.ItemsBean items = orderlist.get(position);

        holder.textOrder.setText("Order : "+items.getId_order());
//        holder.count.setText(items.getFirstname());
        holder.status.setText(items.getStatus());

        holder.status.setBackgroundResource(getcolor(items.getId_status()));
        if (items.getStatus_type()!=null) {
            if (items.getStatus_type().equals("0")) {
                holder.confirm_a.setVisibility(View.GONE);
            } else {
                holder.confirm_a.setVisibility(View.VISIBLE);
            }
        }

    }

    @Override
    public int getItemCount() {
        return orderlist.size();
    }

    class FollowViewHolder extends RecyclerView.ViewHolder {
        TextView textOrder,textstatus,message;
        Button status;
        LinearLayout confirm_a;
        Button btn_check,btn_confirm;
        ListView listView;


        FollowViewHolder(View itemView) {
            super(itemView);
            status = (Button) itemView.findViewById(R.id.textstatus);
            textOrder = (TextView) itemView.findViewById(R.id.textOrder);
            confirm_a = (LinearLayout) itemView.findViewById(R.id.confrimArea);
            btn_check = (Button) itemView.findViewById(R.id.check);
            btn_confirm = (Button) itemView.findViewById(R.id.complete);
            //------------------------------------------------------------//
//            count = (TextView) itemView.findViewById(R.id.count);
            btn_check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(orderlist,getAdapterPosition());
                }
            });
            btn_confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onConfirm(orderlist,getAdapterPosition());
                }
            });
            status.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(orderlist,getAdapterPosition());
                }
            });




        }
    }
    public int getcolor(String status){
        int colorres = 0;

        switch (status){
            case "1":
                colorres = R.color.colorS1;
                break;
            case "2":
                colorres = R.color.colorS2;
                break;
            case "3":
                colorres = R.color.colorS3;
                break;
            case "4":
                colorres = R.color.colorPrimary;
                break;
        }

        return colorres;
    }

}