package com.example.ptwitchapon.burgest;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.ptwitchapon.burgest.API.APIService2;
import com.example.ptwitchapon.burgest.API.ConnectTopup;
import com.example.ptwitchapon.burgest.Fragment.fm_stock_manager;
import com.example.ptwitchapon.burgest.Fragment.fm_other_driver;
import com.example.ptwitchapon.burgest.Model.QrScan;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabManagerActivity extends AppCompatActivity {
    BottomNavigationView mBottomNav;
    Toolbar toolbar;
    Button scan;

    String TAG = "Driver";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_tab);
        mBottomNav = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        scan = (Button) findViewById(R.id.scan);

        toolbar.setVisibility(View.GONE);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_main, fm_stock_manager.newInstance())
                .commit();

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new IntentIntegrator(TabManagerActivity.this).initiateScan();
            }
        });

        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_recent:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content_main, fm_stock_manager.newInstance())
                                .commit();
                        break;
                    case R.id.item_other:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fm_other_driver.newInstance()).commit();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Log.d("Ammy", "fail ");
            } else {
                Log.d("Ammy", "onActivityResult: "+result.getContents());


            }
        }
    }

}
