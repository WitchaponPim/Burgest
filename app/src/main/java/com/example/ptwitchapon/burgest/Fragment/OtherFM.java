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
import com.example.ptwitchapon.burgest.API.ConnectTopup;
import com.example.ptwitchapon.burgest.AccountActivity;
import com.example.ptwitchapon.burgest.Adapter.FollowAdapter;
import com.example.ptwitchapon.burgest.Adapter.OtherAdapter;
import com.example.ptwitchapon.burgest.LoginActivity;

import com.example.ptwitchapon.burgest.Model.QrScan;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.TabActivity;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.example.ptwitchapon.burgest.TopupActivity;
import com.google.zxing.integration.android.IntentIntegrator;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
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

        othermenu.add("Login/Register");

        userdetail = (LinearLayout) view.findViewById(R.id.userDetail);
        name = (TextView) view.findViewById(R.id.user);
        cash = (TextView) view.findViewById(R.id.cash);
        recycleviewChick = (RecyclerView) view.findViewById(R.id.other);
        recycleviewChick.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recycleviewChick.setLayoutManager(layoutManager);

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_QR_SCAN && resultCode == RESULT_OK) {
            String contents = data.getStringExtra("SCAN_RESULT");

            String id = contents.replace("http://localhost/hamburger/inc/qrupdate.php?id=","");
//            Utils.toast(getContext(),id);
//
//            RequestBody idp = RequestBody.create(MediaType.parse("text/plain"), id);

            APIService2 getResponse = ConnectTopup.getClient().create(APIService2.class);
            Call<QrScan> call = getResponse.Scan(id);
            call.enqueue(new Callback<QrScan>() {
                @Override
                public void onResponse(Call<QrScan> call, Response<QrScan> response) {
                    Utils.itemScan = response.body();
                    Log.d(TAG, "onResponse: "+response.body().getChecklogin().getDescription().getProductName());

                }
                @Override
                public void onFailure(Call<QrScan> call, Throwable t) {

                    Log.d(TAG, "onFailure: "+t.toString());
                }
            });

        }
    }
}
