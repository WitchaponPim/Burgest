package com.example.ptwitchapon.burgest;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.Callback.LoginCallback;
import com.example.ptwitchapon.burgest.Callback.MenuCallback;
import com.example.ptwitchapon.burgest.Callback.OrderCallback;
import com.example.ptwitchapon.burgest.Model.Order;
import com.example.ptwitchapon.burgest.Model.OrderResponse;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.Model.User;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit.Retrofit;

public class LoginActivity extends AppCompatActivity {
    String TAG = "Oat";
    TextView register;
    EditText user, pass;
    ConnectManager connect = new ConnectManager();
    LoginCallback loginCallback = new LoginCallback() {
        @Override
        public void onResponse(User user, Retrofit retrofit) {
            if (!user.getChecklogin().getCode().equals("200")) {
                Utils.toast(getApplicationContext(), "ว๊าย password ผิด");
                Log.d(TAG, "onResponse: ");
            } else {
                Utils.user = user;
                Utils.isLogin = true;
                Utils.toast(getApplicationContext(),"your money : "+Utils.user.getChecklogin().getCash());
//                Intent intent = new Intent(LoginActivity.this, TabActivity.class);
//                startActivity(intent);
                onBackPressed();
                Log.d(TAG, "onResponse: ");
            }
        }

        @Override
        public void onFailure(Throwable t) {
            Utils.toast(getApplicationContext(), t.toString());
            Log.d(TAG, "onFailure: " + t.toString());
        }

        @Override
        public void onBodyError(ResponseBody responseBody) {
            Utils.toast(getApplicationContext(), responseBody.toString());
            Log.d(TAG, "onBodyError: " + responseBody.toString());
        }

        @Override
        public void onBodyErrorIsNull() {
            Utils.toast(getApplicationContext(), "null!");
            Log.d(TAG, "onBodyErrorIsNull: ");
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register = (TextView) findViewById(R.id.regis);
        user = (EditText) findViewById(R.id.user);
        pass = (EditText) findViewById(R.id.pass);
        
        //connect.login (loginCallback,"a1@a.com","123456",FirebaseInstanceId.getInstance().getToken());
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    public void Menu(View view){
        String a,b;
        a = user.getText().toString();
        b = pass.getText().toString();
        connect.login(loginCallback,a,b,FirebaseInstanceId.getInstance().getToken());
    }


    public void subscribe(View view) {

        FirebaseMessaging.getInstance().subscribeToTopic("news");

    }
    public void unsubscribe(View view) {

        FirebaseMessaging.getInstance().unsubscribeFromTopic("news");

    }



}
