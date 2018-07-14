package com.example.ptwitchapon.burgest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ptwitchapon.burgest.Adapter.OtherAdapter;
import com.example.ptwitchapon.burgest.Adapter.TypeAdapter;

import java.util.ArrayList;
import java.util.List;

public class SelectTypeActivity extends AppCompatActivity {
    String TAG = "Setype";
    RecyclerView type;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type);



        type = (RecyclerView) findViewById(R.id.type);
        type.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        type.setLayoutManager(layoutManager);
        adapter = new TypeAdapter(getApplicationContext(), new TypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, String menu) {
                switch (position){
                    case 0:
                        //member
                        startActivity(new Intent(SelectTypeActivity.this,SplashActivity.class));
                        finish();
                        break;
                    case 1:
                        //driver
                        startActivity(new Intent(SelectTypeActivity.this,LoginDriverActivity.class));
                        finish();
                        break;
                    case 2:
                        //member
                        startActivity(new Intent(SelectTypeActivity.this,ManageActivity.class));
                        finish();
                        break;
                }
            }
        });

        type.setAdapter(adapter);
    }

}
