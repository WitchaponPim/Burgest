package com.example.ptwitchapon.burgest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText ;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.Callback.EditCallback;
import com.example.ptwitchapon.burgest.Model.EditResponse;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Util;

import retrofit.Retrofit;

public class AccountActivity extends AppCompatActivity {
    String TAG = "EditAccount";
    ConnectManager connect = new ConnectManager();
    EditCallback editCallback = new EditCallback() {
        @Override
        public void onResponse(EditResponse response, Retrofit retrofit) {
            Utils.user.getChecklogin().setFirstname(name.getText().toString());
            Utils.user.getChecklogin().setLastname(lname.getText().toString());
            Utils.user.getChecklogin().setEmail(email.getText().toString());
            Utils.user.getChecklogin().setTel(tel.getText().toString());
            Utils.toast(getApplicationContext(),response.getUpdate().getDescription());
            onBackPressed();
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

    EditText name,lname,tel,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        name = (EditText) findViewById(R.id.reg_firstname);
        lname = (EditText) findViewById(R.id.reg_lastname);
        tel = (EditText) findViewById(R.id.reg_tel);
        email = (EditText) findViewById(R.id.reg_email);

        name.setText(Utils.user.getChecklogin().getFirstname());
        lname.setText(Utils.user.getChecklogin().getLastname());
        tel.setText(Utils.user.getChecklogin().getTel());
        email.setText(Utils.user.getChecklogin().getEmail());
        
        

    }

    public void update(View view){
        connect.edit_Account(editCallback
                ,name.getText().toString()
                ,lname.getText().toString()
                ,email.getText().toString()
                ,tel.getText().toString()
                ,Utils.user.getChecklogin().getId_member());
    }
}
