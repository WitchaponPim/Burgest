package com.example.ptwitchapon.burgest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.Callback.DriverOrderCallback;
import com.example.ptwitchapon.burgest.Callback.Login_DCallback;
import com.example.ptwitchapon.burgest.Callback.StockCallback;
import com.example.ptwitchapon.burgest.Model.DeliveryOrderModel;
import com.example.ptwitchapon.burgest.Model.DriverModel;
import com.example.ptwitchapon.burgest.Model.StockModel;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.squareup.okhttp.ResponseBody;

import retrofit.Retrofit;

public class LoginManagerActivity extends AppCompatActivity {
    EditText user, pass;
    ConnectManager connectManager = new ConnectManager() ;
    Login_DCallback callback = new Login_DCallback() {
        @Override
        public void onResponse(DriverModel driver, Retrofit retrofit) {
            //Driver = Manager na ja
            Utils.driver = driver;
            if (driver.getCheckloginadmin().getPosition().equals("3")){
            connectManager.getstock(stockCallback);
            }else {
                Utils.toast(getApplicationContext(),"Not your position");
            }
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
    StockCallback stockCallback = new StockCallback() {
        @Override
        public void onResponse(StockModel stock, Retrofit retrofit) {
            Utils.stock = stock;
            startActivity(new Intent(LoginManagerActivity.this,TabManagerActivity.class));
            finish();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_manager);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
    }
    public void Menu(View view){
        String a,b;
        a = user.getText().toString();
        b = pass.getText().toString();
        connectManager.loginDriver(callback,a,b, FirebaseInstanceId.getInstance().getToken());
    }
}
