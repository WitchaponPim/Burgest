package com.example.ptwitchapon.burgest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.Callback.MenuCallback;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.okhttp.ResponseBody;

import retrofit.Retrofit;

public class SplashActivity extends AppCompatActivity {
    String TAG= "Slpash";
    ConnectManager connect = new ConnectManager();
    MenuCallback callback = new MenuCallback() {
        @Override
        public void onResponse(Product product, Retrofit retrofit) {
            Utils.product = product;
            Utils.toast(getApplicationContext(), "Ready");
            Intent intent = new Intent(SplashActivity.this,TabActivity.class);
            startActivity(intent);
            finish();
            Log.d(TAG, "onResponse: " + Utils.product.getProduct().toArray().toString());

        }

        @Override
        public void onFailure(Throwable t) {
            Log.d(TAG, "onFailure: ");
        }

        @Override
        public void onBodyError(ResponseBody responseBody) {
            Log.d(TAG, "onBodyError: ");
        }

        @Override
        public void onBodyErrorIsNull() {
            Log.d(TAG, "onBodyErrorIsNull: ");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        connect.getmenu(callback);

    }
}
