package com.example.ptwitchapon.burgest.Fragment;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.ptwitchapon.burgest.API.ConnectManager;

import com.example.ptwitchapon.burgest.Adapter.MainAdapter_Driver_mydeliver;
import com.example.ptwitchapon.burgest.Callback.CompleteCallback;
import com.example.ptwitchapon.burgest.Callback.MyDeliveryCallback;
import com.example.ptwitchapon.burgest.Callback.ResponseCallback;
import com.example.ptwitchapon.burgest.MapsActivity;
import com.example.ptwitchapon.burgest.Model.CompleteModel;
import com.example.ptwitchapon.burgest.Model.MyDeliverDriver;
import com.example.ptwitchapon.burgest.Model.ResponseModel;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.squareup.okhttp.ResponseBody;

import java.util.List;

import retrofit.Retrofit;

/**
 * Created by ptwitchapon on 2/4/2561.
 */

public class fm_myorder_driver extends Fragment {
    RecyclerView recycleviewPromo;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    BottomNavigationView mBottomNav;
    ConnectManager connectManager = new ConnectManager();
    ResponseCallback responseCallback = new ResponseCallback() {
        @Override
        public void onResponse(ResponseModel responseModel, Retrofit retrofit) {
            Utils.toast(getContext(),responseModel.getDescribtion());
            connectManager.myDeliver(myDeliveryCallback,Utils.driver.getCheckloginadmin().getId_emp());
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
    MyDeliveryCallback myDeliveryCallback = new MyDeliveryCallback() {
        @Override
        public void onResponse(MyDeliverDriver myDeliverDriver, Retrofit retrofit) {
            Utils.driver_myOrder = myDeliverDriver;
            adapter = new MainAdapter_Driver_mydeliver(getContext(), Utils.driver_myOrder.getOrder(), new MainAdapter_Driver_mydeliver.OnItemClickListener() {
                @Override
                public void onViewmapClick(List<MyDeliverDriver.OrderBean> orderlist, int position) {
                    Utils.toast(getContext(),"Lat : "+orderlist.get(position).getLatitude()+"Lng : "+orderlist.get(position).getLongitude());
                    Utils.latview = Double.valueOf(orderlist.get(position).getLatitude());
                    Utils.lngview = Double.valueOf(orderlist.get(position).getLongitude());
                    startActivity(new Intent(getActivity(), MapsActivity.class));
                }

                @Override
                public void onCompleteClick(List<MyDeliverDriver.OrderBean> orderlist, int position) {
                 connectManager.updateStatusType(responseCallback,orderlist.get(position).getId_order(),"1");
                }
            });
            recycleviewPromo.setAdapter(adapter);
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
    public static fm_myorder_driver newInstance() {
        return new fm_myorder_driver();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        connectManager.myDeliver(myDeliveryCallback, Utils.driver.getCheckloginadmin().getId_emp());
        return inflater.inflate(R.layout.fm_mylist, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBottomNav = (BottomNavigationView) getActivity().findViewById(R.id.bottom_nav_view);
        recycleviewPromo = (RecyclerView) view.findViewById(R.id.myorder);
        recycleviewPromo.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recycleviewPromo.setLayoutManager(layoutManager);

    }

    @Override
    public void onResume() {
        super.onResume();
        connectManager.myDeliver(myDeliveryCallback, Utils.driver.getCheckloginadmin().getId_emp());
    }


}