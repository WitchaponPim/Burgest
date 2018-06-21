package com.example.ptwitchapon.burgest;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.Callback.OrderListCallback;
import com.example.ptwitchapon.burgest.Fragment.Fm1;
import com.example.ptwitchapon.burgest.Fragment.Fm_Location;
import com.example.ptwitchapon.burgest.Fragment.OtherFM;
import com.example.ptwitchapon.burgest.Fragment.StatusTopup;
import com.example.ptwitchapon.burgest.Fragment.fm_menu;
import com.example.ptwitchapon.burgest.Model.Order;
import com.example.ptwitchapon.burgest.Model.Orderlist;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.google.gson.Gson;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import retrofit.Retrofit;

public class TabActivity extends AppCompatActivity {
    BottomNavigationView mBottomNav;
    Toolbar toolbar;
    String TAG = "Menu";
    FloatingActionButton fab;

    int REQUEST_QR_SCAN = 12345;
    ConnectManager connect = new ConnectManager();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        mBottomNav = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimary));
        getSupportActionBar().setTitle("Follow");
        toolbar.setVisibility(View.GONE);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_main, fm_menu.newInstance())
                .commit();
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Utils.user!=null) {
                    Utils.order.setId_member(Utils.user.getChecklogin().getId_member());
                    Utils.order.setOrder(Utils.orderbanlist);
                    Log.d(TAG, "onClick: "+Utils.order.getId_member()+" / "+ Utils.order.getOrder().size() );
                    Log.d(TAG, "onClick: "+Utils.user.getChecklogin().getCash()+" Bath");

                    Intent intent = new Intent(TabActivity.this,BasketActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(TabActivity.this,LoginActivity.class);
                    startActivity(intent);
                }


            }
        });

        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch(item.getItemId()){
                    case R.id.item_location:
                        toolbar.setVisibility(View.GONE);
                        fab.setVisibility(View.GONE);
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content_main, Fm_Location.newInstance())
                                .commit();
                        break;
                    case R.id.item_recent:
                        toolbar.setVisibility(View.GONE);
                        fab.setVisibility(View.VISIBLE);
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content_main, fm_menu.newInstance())
                                .commit();
                        break;
                    case R.id.item_scan :
                        if (Utils.user!=null) {
                            toolbar.setVisibility(View.VISIBLE);
                            getSupportActionBar().setTitle("My Topup");
                            fab.setVisibility(View.GONE);
                            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, StatusTopup.newInstance()).commit();
                        }else {
                            intent = new Intent(TabActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }

                        break;
                    case R.id.item_other:
                        fab.setVisibility(View.GONE);
                        toolbar.setVisibility(View.GONE);
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_main, OtherFM.newInstance()).commit();

                        break;
                    case R.id.item_favorite:
                        if (Utils.user!=null) {
                            toolbar.setVisibility(View.VISIBLE);
                            getSupportActionBar().setTitle("Follow");
                            fab.setVisibility(View.GONE);
                            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, Fm1.newInstance()).commit();
                        }else {
                            intent = new Intent(TabActivity.this, LoginActivity.class);
                            startActivity(intent);
                        }
                        break;

                    default:


                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //ดิบๆไปก่อน
        if (Utils.addup){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fm_menu.newInstance()).commit();
        }else {
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, OtherFM.newInstance()).commit();
        }

    }
}
