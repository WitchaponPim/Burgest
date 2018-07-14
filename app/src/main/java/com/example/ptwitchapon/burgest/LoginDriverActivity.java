package com.example.ptwitchapon.burgest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.Callback.DriverOrderCallback;
import com.example.ptwitchapon.burgest.Callback.Login_DCallback;
import com.example.ptwitchapon.burgest.Model.DeliveryOrderModel;
import com.example.ptwitchapon.burgest.Model.DriverModel;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.squareup.okhttp.ResponseBody;

import retrofit.Retrofit;

public class LoginDriverActivity extends AppCompatActivity {
    EditText user, pass;
    ConnectManager connectManager = new ConnectManager() ;
    Login_DCallback callback = new Login_DCallback() {
        @Override
        public void onResponse(DriverModel driver, Retrofit retrofit) {

            Utils.driver = driver;
//            if (driver.getCheckloginadmin().getPosition().equals("2")){
                FirebaseMessaging.getInstance().subscribeToTopic("Driver");
                Utils.toast(getApplicationContext(),driver.getCheckloginadmin().getFirstname());
                connectManager.getAllOrder(driverOrderCallback);

//            }else {
//                Utils.toast(getApplicationContext(),"Not your position");
//            }
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
    DriverOrderCallback driverOrderCallback = new DriverOrderCallback() {
        @Override
        public void onResponse(DeliveryOrderModel delivery, Retrofit retrofit) {
            Utils.driver_allOrder = delivery;
            startActivity(new Intent(LoginDriverActivity.this,TabDriverActivity.class));
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
        setContentView(R.layout.activity_login_driver);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
    }

    public void Menu(View view){
        String a,b;
        a = user.getText().toString();
        b = pass.getText().toString();
        connectManager.loginDriver(callback,a,b, FirebaseInstanceId.getInstance().getToken());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // FirebaseMessaging.getInstance().unsubscribeFromTopic("Driver");
    }
}
