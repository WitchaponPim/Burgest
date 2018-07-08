package com.example.ptwitchapon.burgest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.ptwitchapon.burgest.Fragment.fm_list;
import com.example.ptwitchapon.burgest.Fragment.fm_other;
import com.example.ptwitchapon.burgest.Fragment.fm_scan;

public class ManageActivity extends AppCompatActivity {
    BottomNavigationView mBottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        mBottomNav = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content_main, fm_list.newInstance())
                .commit();

        mBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch(item.getItemId()){
                    case R.id.item_list:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content_main, fm_list.newInstance())
                                .commit();
                        break;
                    case R.id.item_scan:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content_main, fm_scan.newInstance())
                                .commit();
                        break;
                    case R.id.item_other:
//                        toolbar.setVisibility(View.GONE);
//                        fab.setVisibility(View.VISIBLE);
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content_main, fm_other.newInstance())
                                .commit();
                        break;

                    default:


                        break;
                }
                return true;
            }
        });
    }
}