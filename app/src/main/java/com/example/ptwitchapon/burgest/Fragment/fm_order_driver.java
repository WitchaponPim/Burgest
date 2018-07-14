package com.example.ptwitchapon.burgest.Fragment;


import android.content.Intent;
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
import com.example.ptwitchapon.burgest.Adapter.CustomDialog;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_detailOrderlist;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_other;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_water;
import com.example.ptwitchapon.burgest.Adapter.MainAdapter;
import com.example.ptwitchapon.burgest.Adapter.MainAdapter_Driver;
import com.example.ptwitchapon.burgest.Callback.OrderList_ItemCallback;
import com.example.ptwitchapon.burgest.LoginActivity;
import com.example.ptwitchapon.burgest.Model.DeliveryOrderModel;
import com.example.ptwitchapon.burgest.Model.Orderlist_item;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.okhttp.ResponseBody;

import java.util.List;

import retrofit.Retrofit;

import static android.content.ContentValues.TAG;

/**
 * Created by ptwitchapon on 2/4/2561.
 */

public class fm_order_driver extends Fragment {
    RecyclerView recycleviewPromo;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ConnectManager connectManager = new ConnectManager();
    OrderList_ItemCallback orderList_itemCallback= new OrderList_ItemCallback() {
        @Override
        public void onResponse(Orderlist_item listItem, Retrofit retrofit) {

            CustomDialog_detailOrderlist cdd=new CustomDialog_detailOrderlist(getActivity(),listItem);
            cdd.show();
        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG,"onFailure: ");
        }

        @Override
        public void onBodyError(ResponseBody responseBody) {
            Log.d(TAG, "onBodyError: ");
        }

        @Override
        public void onBodyErrorIsNull() {
            Log.d(TAG, "onBodyErrorIsNull: ");
        }
    } ;

    public static fm_order_driver newInstance() {
        return new fm_order_driver();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fm_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycleviewPromo = (RecyclerView) view.findViewById(R.id.allorder);
        recycleviewPromo.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recycleviewPromo.setLayoutManager(layoutManager);
        adapter = new MainAdapter_Driver(getContext(), Utils.driver_allOrder.getOrderlist(), new MainAdapter_Driver.OnItemClickListener() {
            @Override
            public void onItemClick(List<DeliveryOrderModel.OrderlistBean> orderlist, int position) {
//                if (Utils.user != null) {
//                    CustomDialog cdd = new CustomDialog(getActivity(), products.getBurgur().get(position));
//                    cdd.show();
//                } else {
//                    Intent intent = new Intent(getActivity(), LoginActivity.class);
//                    startActivity(intent);
//                }
            }

            @Override
            public void onDetailClick(List<DeliveryOrderModel.OrderlistBean> orderlist, int position) {
                connectManager.orderList_item(orderList_itemCallback,orderlist.get(position).getId_order());
            }

            @Override
            public void onAccept(List<DeliveryOrderModel.OrderlistBean> orderlist, int position) {

            }
        });

        recycleviewPromo.setAdapter(adapter);
    }


}