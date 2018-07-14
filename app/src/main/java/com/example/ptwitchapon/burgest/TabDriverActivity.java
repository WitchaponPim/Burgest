package com.example.ptwitchapon.burgest;

import android.*;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.Fragment.Fm1;
import com.example.ptwitchapon.burgest.Fragment.Fm_Location;
import com.example.ptwitchapon.burgest.Fragment.OtherFM;
import com.example.ptwitchapon.burgest.Fragment.StatusTopup;
import com.example.ptwitchapon.burgest.Fragment.fm_menu;
import com.example.ptwitchapon.burgest.Fragment.fm_order_driver;
import com.example.ptwitchapon.burgest.Fragment.fm_other_driver;
import com.example.ptwitchapon.burgest.Tool.Utils;

public class TabDriverActivity extends AppCompatActivity {
    BottomNavigationView mBottomNav;
    Toolbar toolbar;
    LocationManager locationManager;
    String TAG = "Driver";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_tab);
        mBottomNav = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimary));
        getSupportActionBar().setTitle("Follow");
        toolbar.setVisibility(View.GONE);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if(ActivityCompat.checkSelfPermission(TabDriverActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                !=PackageManager.PERMISSION_GRANTED&&ActivityCompat.checkSelfPermission(TabDriverActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(TabDriverActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            Utils.toast(getApplicationContext(),"GPS not Support");
        }else if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            getLocation();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_main, fm_order_driver.newInstance())
                .commit();
        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.item_recent:
                        toolbar.setVisibility(View.GONE);
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content_main, fm_order_driver.newInstance())
                                .commit();
                        break;
                    case R.id.item_favorite:
                            toolbar.setVisibility(View.VISIBLE);
                            getSupportActionBar().setTitle("Follow");
                            getSupportFragmentManager().beginTransaction().replace(R.id.content_main
                                    , fm_order_driver.newInstance())
                                    .commit();

                        break;
                    case R.id.item_other:
                        toolbar.setVisibility(View.GONE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fm_other_driver.newInstance()).commit();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
    private void getLocation(){
        if(ActivityCompat.checkSelfPermission(TabDriverActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED&&ActivityCompat.checkSelfPermission(TabDriverActivity.this, android.Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(TabDriverActivity.this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},1);

        }else{
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if(location != null){
                double latti = location.getLatitude();
                double longi = location.getLongitude();
                Utils.mylattitude = String.valueOf(latti);
                Utils.mylongitude = String.valueOf(longi);

            }
            else{

            }
        }

    }


}
