package com.example.ptwitchapon.burgest.Adapter;

import android.content.Context;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.Model.DeliveryOrderModel;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Witchapon on 9/4/2561.
 */

public class MainAdapter_Driver extends RecyclerView.Adapter<MainAdapter_Driver.MenuViewHolder> {


    MainAdapter_Driver.OnItemClickListener listener;
    List<DeliveryOrderModel.OrderlistBean> orderlist;

    Context context;
    public interface OnItemClickListener {
        void onItemClick(List<DeliveryOrderModel.OrderlistBean> orderlist, int position);
        void onDetailClick(List<DeliveryOrderModel.OrderlistBean> orderlist, int position);
        void onAccept(List<DeliveryOrderModel.OrderlistBean> orderlist, int position);
    }

    @Override
    public MainAdapter_Driver.MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowallorder_driver, parent, false);
        return new MainAdapter_Driver.MenuViewHolder(v);
    }


    public MainAdapter_Driver(Context context, List<DeliveryOrderModel.OrderlistBean> orderlist,MainAdapter_Driver.OnItemClickListener listener) {
        this.orderlist = orderlist;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(MainAdapter_Driver.MenuViewHolder holder, int position) {
        holder.setMenu(orderlist,position);
        holder.setIsRecyclable(false);
    }


    @Override
    public int getItemCount() {
        return orderlist.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        public TextView name,order,tel,distance;
        public Button detail,accept;
        double distance_length;
        Location order_location = new Location("order");
        Location driver_location = new Location("driver");
        public MenuViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.mem_name);
            order = (TextView) itemView.findViewById(R.id.order);
            tel = (TextView) itemView.findViewById(R.id.mem_tel);
            distance =(TextView) itemView.findViewById(R.id.mem_distance);
            detail = (Button) itemView.findViewById(R.id.btndetail);
            accept = (Button) itemView.findViewById(R.id.btnaccept);

            detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onDetailClick(orderlist,getAdapterPosition());
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(orderlist,getAdapterPosition());
                }
            });
        }

        public void setMenu(final List<DeliveryOrderModel.OrderlistBean> orderlist,int position){
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
