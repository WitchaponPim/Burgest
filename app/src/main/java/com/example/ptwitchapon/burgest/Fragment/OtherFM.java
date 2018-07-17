package com.example.ptwitchapon.burgest.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.API.APIService2;
import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.API.ConnectTopup;
import com.example.ptwitchapon.burgest.AccountActivity;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_QR;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_edit;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_other;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_other_edit;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_water;
import com.example.ptwitchapon.burgest.Adapter.CustomDialog_water_edit;
import com.example.ptwitchapon.burgest.Adapter.FollowAdapter;
import com.example.ptwitchapon.burgest.Adapter.OtherAdapter;
import com.example.ptwitchapon.burgest.BasketActivity;
import com.example.ptwitchapon.burgest.Callback.StoreCallback;
import com.example.ptwitchapon.burgest.LoginActivity;

import com.example.ptwitchapon.burgest.Model.QrScan;
import com.example.ptwitchapon.burgest.Model.StoreModel;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.TabActivity;
import com.example.ptwitchapon.burgest.TabManagerActivity;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.example.ptwitchapon.burgest.TopupActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.squareup.okhttp.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;


/**
 * Created by Killy77 on 22/4/2561.
 */

public class OtherFM extends Fragment {
    RecyclerView recycleviewChick;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    String TAG="Scan";
    TextView name,cash;
    LinearLayout userdetail;
    int REQUEST_QR_SCAN = 12345;
    List<String> othermenu = new ArrayList<>();
    List<String> loginedothermenu = new ArrayList<>();
    ConnectManager connect = new ConnectManager();
    StoreCallback callback = new StoreCallback() {
        @Override
        public void onResponse(StoreModel storeModel, Retrofit retrofit) {
            Utils.storeModel = storeModel;
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

    public static OtherFM newInstance() {
        return new OtherFM();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmen_other, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        loginedothermenu.add("Account");
        loginedothermenu.add("Top Up");
        loginedothermenu.add("Scan QR");
        loginedothermenu.add("Logout");
        connect.getstore(callback);
        othermenu.add("Login/Register");


        userdetail = (LinearLayout) view.findViewById(R.id.userDetail);
        name = (TextView) view.findViewById(R.id.user);
        cash = (TextView) view.findViewById(R.id.cash);
        recycleviewChick = (RecyclerView) view.findViewById(R.id.other);
        recycleviewChick.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recycleviewChick.setLayoutManager(layoutManager);
        if(Utils.user!=null){
            settext();
        }
        if (!Utils.isLogin) {
            adapter = new OtherAdapter(getContext(), othermenu, new OtherAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position, String menu) {
                    switch (menu) {
                        case "Login/Register":
                            Intent intent = new Intent(getContext(), LoginActivity.class);
                            startActivity(intent);
                            break;
                        default:
                            break;
                    }
                }
            });
        } else {
            userdetail.setVisibility(View.VISIBLE);
            name.setText(Utils.user.getChecklogin().getFirstname()+" "+Utils.user.getChecklogin().getLastname());
            cash.setText(Utils.user.getChecklogin().getCash()+" ฿");
            adapter = new OtherAdapter(getContext(), loginedothermenu, new OtherAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position, String menu) {
                    switch (menu) {
                        case "Logout":
                            Utils.isLogin = false;
                            Utils.user = null;
                            Intent intent = new Intent(getContext(), TabActivity.class);
                            startActivity(intent);
                            getActivity().finish();
                            break;
                        case "Scan QR":
                            new IntentIntegrator(getActivity()).initiateScan();
                            break;
                        case "Account":
                            Intent intent2 = new Intent(getContext(), AccountActivity.class);
                            startActivity(intent2);
                            break;
                        case "Top Up" :
                            Intent intent1 = new Intent(getContext(), TopupActivity.class);
                            startActivity(intent1);
                            break;
                        default:
                            break;
                    }
                }
            });
        }

        recycleviewChick.setAdapter(adapter);


    }
    public void settext(){
        name.setText(Utils.user.getChecklogin().getFirstname()+" "+Utils.user.getChecklogin().getLastname());
        cash.setText(Utils.user.getChecklogin().getCash()+" ฿");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Log.d("Ammy", "fail ");
            } else {

                Log.d("Ammy", "onActivityResult: "+result.getContents());

                if (Integer.valueOf(result.getContents()) >= 10035 && Integer.valueOf(result.getContents()) <= 10039) {

                    for(int i =0;i<Utils.product.getProduct().size();i++){
                        for (int j =0;j< Utils.product.getProduct().get(i).getBurgur().size();j++){
                            if(Utils.product.getProduct().get(i).getBurgur().get(j).getId_product().equals(result.getContents())){
                                Log.d("Ammy", "QR_Other");
                                CustomDialog_other other = new CustomDialog_other(getActivity(),Utils.product.getProduct().get(i).getBurgur().get(j));
                                other.show();
                            }
                        }
                    }


                } else if (Integer.valueOf(result.getContents()) >= 10040 && Integer.valueOf(result.getContents()) <= 10045) {

                    for(int i =0;i<Utils.product.getProduct().size();i++){
                        for (int j =0;j< Utils.product.getProduct().get(i).getBurgur().size();j++){
                            if(Utils.product.getProduct().get(i).getBurgur().get(j).getId_product().equals(result.getContents())){
                                Log.d("Ammy", "QR_Water");
                                CustomDialog_water water = new CustomDialog_water(getActivity(),Utils.product.getProduct().get(i).getBurgur().get(j));
                                water.show();
                            }
                        }
                    }


                } else {

                    for(int i =0;i<Utils.product.getProduct().size();i++){
                        for (int j =0;j< Utils.product.getProduct().get(i).getBurgur().size();j++){
                            if(Utils.product.getProduct().get(i).getBurgur().get(j).getId_product().equals(result.getContents())){
                                Log.d("Ammy", "QR_Burger");
                                CustomDialog cdd = new CustomDialog(getActivity(),Utils.product.getProduct().get(i).getBurgur().get(j));
                                cdd.show();
                            }
                        }
                    }

                }

            }
        }
    }
}
