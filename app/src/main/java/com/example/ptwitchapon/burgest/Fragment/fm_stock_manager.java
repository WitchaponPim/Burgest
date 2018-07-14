package com.example.ptwitchapon.burgest.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_detailOrderlist;
import com.example.ptwitchapon.burgest.Adapter.MainAdapter_Driver;
import com.example.ptwitchapon.burgest.Adapter.MainAdapter_Manager;
import com.example.ptwitchapon.burgest.Callback.OrderList_ItemCallback;
import com.example.ptwitchapon.burgest.Model.DeliveryOrderModel;
import com.example.ptwitchapon.burgest.Model.Orderlist_item;
import com.example.ptwitchapon.burgest.Model.StockModel;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.okhttp.ResponseBody;

import java.util.List;

import retrofit.Retrofit;

import static android.content.ContentValues.TAG;

/**
 * Created by ptwitchapon on 2/4/2561.
 */

public class fm_stock_manager extends Fragment {
    RecyclerView recycleviewPromo;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    public static fm_stock_manager newInstance() {
        return new fm_stock_manager();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fm_stock, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycleviewPromo = (RecyclerView) view.findViewById(R.id.stock);
        recycleviewPromo.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recycleviewPromo.setLayoutManager(layoutManager);
        Log.d("Ammy", "onViewCreated: "+Utils.stock.getStocks().size());
        adapter = new MainAdapter_Manager(getContext(), Utils.stock.getStocks(), new MainAdapter_Manager.OnItemClickListener() {
            @Override
            public void onItemClick(List<StockModel.StocksBean> orderlist, int position) {

            }

        });

        recycleviewPromo.setAdapter(adapter);
    }


}