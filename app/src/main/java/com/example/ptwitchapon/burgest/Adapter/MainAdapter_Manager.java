package com.example.ptwitchapon.burgest.Adapter;

import android.content.Context;
import android.location.Location;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.Model.DeliveryOrderModel;
import com.example.ptwitchapon.burgest.Model.StockModel;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;

import java.util.List;

/**
 * Created by Witchapon on 9/4/2561.
 */

public class MainAdapter_Manager extends RecyclerView.Adapter<MainAdapter_Manager.MenuViewHolder> {


    MainAdapter_Manager.OnItemClickListener listener;
    List<StockModel.StocksBean> stock;

    Context context;
    public interface OnItemClickListener {
        void onItemClick(List<StockModel.StocksBean> stock, int position);

    }

    @Override
    public MainAdapter_Manager.MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowstock_manager, parent, false);
        return new MainAdapter_Manager.MenuViewHolder(v);
    }


    public MainAdapter_Manager(Context context, List<StockModel.StocksBean> stock, MainAdapter_Manager.OnItemClickListener listener) {
        this.stock = stock;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(MainAdapter_Manager.MenuViewHolder holder, int position) {
        holder.setMenu(stock,position);
        holder.setIsRecyclable(false);
    }


    @Override
    public int getItemCount() {
        return stock.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView id,name,amount,exp;

        public MenuViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.stock_id);
            name = (TextView) itemView.findViewById(R.id.stock_name);
            amount = (TextView) itemView.findViewById(R.id.stock_amount);
            exp = (TextView) itemView.findViewById(R.id.stock_exp);

        }

        public void setMenu(final List<StockModel.StocksBean> stock,int position){
            id.setText(stock.get(position).getId_stock());
            name.setText(stock.get(position).getName());
            amount.setText(stock.get(position).getAmount());
            if (stock.get(position).getEXP()!=null&&!stock.get(position).getEXP().equals("")){
                exp.setText(stock.get(position).getEXP());
            }else {
                exp.setText("--/--/--");
            }


        }
    }
}
