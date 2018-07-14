package com.example.ptwitchapon.burgest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
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
import com.example.ptwitchapon.burgest.Tool.Utils;

public class TabDriverActivity extends AppCompatActivity {
    BottomNavigationView mBottomNav;
    Toolbar toolbar;
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
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fm_order_driver.newInstance()).commit();

                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }


}
