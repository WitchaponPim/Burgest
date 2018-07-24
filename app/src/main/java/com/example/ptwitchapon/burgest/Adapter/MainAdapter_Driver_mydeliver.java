package com.example.ptwitchapon.burgest.Adapter;

import android.content.Context;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.Model.DeliveryOrderModel;
import com.example.ptwitchapon.burgest.Model.MyDeliverDriver;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;

import java.util.List;

/**
 * Created by Witchapon on 9/4/2561.
 */

public class MainAdapter_Driver_mydeliver extends RecyclerView.Adapter<MainAdapter_Driver_mydeliver.MenuViewHolder> {


    MainAdapter_Driver_mydeliver.OnItemClickListener listener;
    List<MyDeliverDriver.OrderBean> orderlist;

    Context context;
    public interface OnItemClickListener {
        void onViewmapClick(List<MyDeliverDriver.OrderBean> orderlist, int position);
        void onCompleteClick(List<MyDeliverDriver.OrderBean> orderlist, int position);
    }

    @Override
    public MainAdapter_Driver_mydeliver.MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowmyorder_driver, parent, false);
        return new MainAdapter_Driver_mydeliver.MenuViewHolder(v);
    }


    public MainAdapter_Driver_mydeliver(Context context, List<MyDeliverDriver.OrderBean> orderlist, MainAdapter_Driver_mydeliver.OnItemClickListener listener) {
        this.orderlist = orderlist;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(MainAdapter_Driver_mydeliver.MenuViewHolder holder, int position) {
        holder.setMenu(orderlist,position);
        holder.setIsRecyclable(false);
    }


    @Override
    public int getItemCount() {
        return orderlist.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        public TextView name,order,tel,distance;
        double distance_length;
        LinearLayout btn;
        Button viewmap,complete;
        Location order_location = new Location("order");
        Location driver_location = new Location("driver");
        public MenuViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.mem_name);
            order = (TextView) itemView.findViewById(R.id.order);
            tel = (TextView) itemView.findViewById(R.id.mem_tel);
            distance =(TextView) itemView.findViewById(R.id.mem_distance);
            viewmap = (Button) itemView.findViewById(R.id.viewmap);
            complete = (Button) itemView.findViewById(R.id.complete);
            btn = (LinearLayout) itemView.findViewById(R.id.btn);

            complete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onCompleteClick(orderlist,getAdapterPosition());
                }
            });

            viewmap.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onViewmapClick(orderlist,getAdapterPosition());
                }
            });
        }

        public void setMenu(final List<MyDeliverDriver.OrderBean> orderlist,int position){

            if (position == 0){
                btn.setVisibility(View.VISIBLE);
            }else {
                btn.setVisibility(View.GONE);
            }

            order_location.setLatitude(Double.valueOf(orderlist.get(position).getLatitude()));
            order_location.setLongitude(Double.valueOf(orderlist.get(position).getLongitude()));
            order_location.setAltitude(0);

            driver_location.setLatitude(Double.valueOf(Utils.mylattitude));
            driver_location.setLongitude(Double.valueOf(Utils.mylongitude));
            driver_location.setAltitude(0);

            order.setText("Order#"+orderlist.get(position).getId_order());
            name.setText(orderlist.get(position).getFirstname());
            tel.setText(orderlist.get(position).getTel());

            distance_length =  driver_location.distanceTo(order_location)/1000;
            distance.setText(String.format("%.2f", distance_length)+"km");
        }
    }
}
