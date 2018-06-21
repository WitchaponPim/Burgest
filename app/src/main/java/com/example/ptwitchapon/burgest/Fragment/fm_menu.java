package com.example.ptwitchapon.burgest.Fragment;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.example.ptwitchapon.burgest.Adapter.CustomDialog;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_other;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_water;
import com.example.ptwitchapon.burgest.Adapter.MainAdapter;
import com.example.ptwitchapon.burgest.LoginActivity;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.TabActivity;
import com.example.ptwitchapon.burgest.Tool.Utils;

/**
 * Created by ptwitchapon on 2/4/2561.
 */

public class fm_menu extends Fragment {
    RecyclerView recycleviewPromo,recycleviewBeef,recycleviewBeefL, recyclerviewChickSp, recycleviewChick, recycleviewPork,recycleviewFish,recycleviewOther,recycleviewWater;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    public static fm_menu newInstance() {
        return new fm_menu();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fm_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycleviewChick = (RecyclerView) view.findViewById(R.id.chick);
        recycleviewChick.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycleviewChick.setLayoutManager(layoutManager);
        adapter = new MainAdapter(getContext(), Utils.product.getProduct().get(0), new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product.ProductBean products, int position) {
                if (Utils.user!=null) {
                    CustomDialog cdd=new CustomDialog(getActivity(),products.getBurgur().get(position));
                    cdd.show();
                }else {
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        recycleviewChick.setAdapter(adapter);

        recycleviewPromo = (RecyclerView) view.findViewById(R.id.promotion);
        recycleviewPromo.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycleviewPromo.setLayoutManager(layoutManager);
        adapter = new MainAdapter(getContext(), Utils.product.getProduct().get(8), new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product.ProductBean products, int position) {
                if (Utils.user!=null) {
                    CustomDialog cdd=new CustomDialog(getActivity(),products.getBurgur().get(position));
                    cdd.show();
                }else {
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        recycleviewPromo.setAdapter(adapter);

        recycleviewFish = (RecyclerView) view.findViewById(R.id.fish);
        recycleviewFish.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycleviewFish.setLayoutManager(layoutManager);
        adapter = new MainAdapter(getContext(),Utils.product.getProduct().get(1), new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product.ProductBean products, int position) {
                if (Utils.user!=null) {
                    CustomDialog cdd=new CustomDialog(getActivity(),products.getBurgur().get(position));
                    cdd.show();
                }else {
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }

            }
        });
        recycleviewFish.setAdapter(adapter);

        recycleviewBeef = (RecyclerView) view.findViewById(R.id.beef);
        recycleviewBeef.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycleviewBeef.setLayoutManager(layoutManager);
        adapter = new MainAdapter(getContext(),Utils.product.getProduct().get(3), new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product.ProductBean products, int position) {
                if (Utils.user!=null) {
                    CustomDialog cdd=new CustomDialog(getActivity(),products.getBurgur().get(position));
                    cdd.show();
                }else {
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }

            }
        });
        recycleviewBeef.setAdapter(adapter);

        recycleviewBeefL = (RecyclerView) view.findViewById(R.id.beefL);
        recycleviewBeefL.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycleviewBeefL.setLayoutManager(layoutManager);
        adapter = new MainAdapter(getContext(),Utils.product.getProduct().get(2), new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product.ProductBean products, int position) {
                if (Utils.user!=null) {
                    CustomDialog cdd=new CustomDialog(getActivity(),products.getBurgur().get(position));
                    cdd.show();
                }else {
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }

            }
        });
        recycleviewBeefL.setAdapter(adapter);


        recycleviewPork = (RecyclerView) view.findViewById(R.id.pork);
        recycleviewPork.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycleviewPork.setLayoutManager(layoutManager);
        adapter = new MainAdapter(getContext(),Utils.product.getProduct().get(4), new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product.ProductBean products, int position) {
                if (Utils.user!=null) {
                    CustomDialog cdd=new CustomDialog(getActivity(),products.getBurgur().get(position));
                    cdd.show();
                }else {
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        recycleviewPork.setAdapter(adapter);


        recyclerviewChickSp = (RecyclerView) view.findViewById(R.id.chicksp);
        recyclerviewChickSp.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerviewChickSp.setLayoutManager(layoutManager);
        adapter = new MainAdapter(getContext(),Utils.product.getProduct().get(5), new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product.ProductBean products, int position) {
                if (Utils.user!=null) {
                    CustomDialog cdd=new CustomDialog(getActivity(),products.getBurgur().get(position));
                    cdd.show();
                }else {
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }

            }
        });
        recyclerviewChickSp.setAdapter(adapter);


        recycleviewOther = (RecyclerView) view.findViewById(R.id.orther);
        recycleviewOther.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycleviewOther.setLayoutManager(layoutManager);
        adapter = new MainAdapter(getContext(),Utils.product.getProduct().get(6), new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product.ProductBean products, int position) {
                if (Utils.user!=null) {
                    CustomDialog_other cdd=new CustomDialog_other(getActivity(),products.getBurgur().get(position));
                    cdd.show();
                }else {
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        recycleviewOther.setAdapter(adapter);

        recycleviewWater = (RecyclerView) view.findViewById(R.id.water);
        recycleviewWater.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recycleviewWater.setLayoutManager(layoutManager);
        adapter = new MainAdapter(getContext(),Utils.product.getProduct().get(7), new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product.ProductBean products, int position) {
                if (Utils.user!=null) {
                    CustomDialog_water cdd=new CustomDialog_water(getActivity(),products.getBurgur().get(position));
                    cdd.show();
                }else {
                    Intent intent = new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        recycleviewWater.setAdapter(adapter);
    }

    private View.OnClickListener onCloseClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };



}