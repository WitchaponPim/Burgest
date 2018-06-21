package com.example.ptwitchapon.burgest.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_detailOrderlist;
import com.example.ptwitchapon.burgest.Adapter.FollowAdapter;

import com.example.ptwitchapon.burgest.Callback.OrderListCallback;
import com.example.ptwitchapon.burgest.Callback.OrderList_ItemCallback;
import com.example.ptwitchapon.burgest.Model.Orderlist;
import com.example.ptwitchapon.burgest.Model.Orderlist_item;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Util;

import java.util.List;

import retrofit.Retrofit;

import static android.content.ContentValues.TAG;

/**
 * Created by Killy77 on 21/4/2561.
 */

public class Fm1 extends Fragment {
    RecyclerView recycleviewChick;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    ConnectManager connect = new ConnectManager();

    OrderList_ItemCallback orderList_itemCallback= new OrderList_ItemCallback() {
        @Override
        public void onResponse(Orderlist_item listItem, Retrofit retrofit) {
            Log.d("dialog", "onResponse: "+listItem.getItems().get(0).getProductName());
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

    OrderListCallback orderListCallback = new OrderListCallback() {
        @Override
        public void onResponse(Orderlist orderlist, Retrofit retrofit) {
            adapter = new FollowAdapter(getContext(), orderlist.getItems(), new FollowAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(List<Orderlist.ItemsBean> orderlist, int position) {
                    connect.orderList_item(orderList_itemCallback,orderlist.get(position).getId_order());
                }
            });
            recycleviewChick.setAdapter(adapter);
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


    public static Fm1 newInstance() {
        return new Fm1();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        connect.orderList(orderListCallback,Utils.user.getChecklogin().getId_member());
        return inflater.inflate(R.layout.fragment_fm, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycleviewChick = (RecyclerView) view.findViewById(R.id.test);
        recycleviewChick.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recycleviewChick.setLayoutManager(layoutManager);

    }



}
