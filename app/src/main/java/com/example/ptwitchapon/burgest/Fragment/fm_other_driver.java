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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ptwitchapon.burgest.API.APIService2;
import com.example.ptwitchapon.burgest.API.ConnectTopup;
import com.example.ptwitchapon.burgest.AccountActivity;
import com.example.ptwitchapon.burgest.AccountDriverActivity;
import com.example.ptwitchapon.burgest.Adapter.OtherAdapter;
import com.example.ptwitchapon.burgest.LoginActivity;
import com.example.ptwitchapon.burgest.Model.QrScan;
import com.example.ptwitchapon.burgest.R;
import com.example.ptwitchapon.burgest.SelectTypeActivity;
import com.example.ptwitchapon.burgest.TabActivity;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.example.ptwitchapon.burgest.TopupActivity;
import com.google.zxing.integration.android.IntentIntegrator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;


/**
 * Created by Killy77 on 22/4/2561.
 */

public class fm_other_driver extends Fragment {
    RecyclerView recycleviewChick;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    String TAG="Scan";
    TextView name,cash;
    int REQUEST_QR_SCAN = 12345;
    List<String> othermenu = new ArrayList<>();
    List<String> loginedothermenu = new ArrayList<>();

    public static fm_other_driver newInstance() {
        return new fm_other_driver();
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
        loginedothermenu.add("Logout");

        recycleviewChick = (RecyclerView) view.findViewById(R.id.other);
        recycleviewChick.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recycleviewChick.setLayoutManager(layoutManager);
            adapter = new OtherAdapter(getContext(), loginedothermenu, new OtherAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position, String menu) {
                    switch (menu) {
                        case "Logout":
                            Utils.driver = null;
                            Intent intent = new Intent(getContext(), SelectTypeActivity.class);
                            startActivity(intent);
                            getActivity().finish();
                            break;
                        case "Account":
                            Intent intent2 = new Intent(getContext(),AccountDriverActivity.class);
                            startActivity(intent2);
                            break;
                        default:
                            break;
                    }
                }
            });
        recycleviewChick.setAdapter(adapter);
    }
}
