package com.example.ptwitchapon.burgest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.Callback.RegisterCallback;
import com.example.ptwitchapon.burgest.Model.Regis;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.okhttp.ResponseBody;

import retrofit.Retrofit;

public class RegisterActivity extends AppCompatActivity {
    String TAG="Register";
    EditText reg_name, reg_lname, reg_email, reg_password, reg_confpass, reg_tel;
    String email,password;
    ConnectManager connect = new ConnectManager();
    RegisterCallback registerCallback = new RegisterCallback() {
        @Override
        public void onResponse(Regis regis, Retrofit retrofit) {
            if(!regis.getChecklogin().getStatus().equals("success")){
                Utils.toast(getApplicationContext(),regis.getChecklogin().getDescription());
            }else{
                Utils.toast(getApplicationContext(),regis.getChecklogin().getDescription());
                onBackPressed();
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        reg_name = (EditText) findViewById(R.id.reg_name);
        reg_lname = (EditText) findViewById(R.id.reg_lastname);
        reg_email = (EditText) findViewById(R.id.reg_email);
        reg_password = (EditText) findViewById(R.id.reg_pass);
        reg_confpass = (EditText) findViewById(R.id.reg_confpass);
        reg_tel = (EditText) findViewById(R.id.reg_tel);

    }

    public void CreateUser(String email, String password) {
        Log.d(TAG, email + password);

    }

    // [START validate_form]
    private boolean validateForm() {
        boolean valid = true;
        email = reg_email.getText().toString();
        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            reg_email.setError(getString(R.string.require_email));
            valid = false;
        } else {
            reg_email.setError(null);

        }
        password = reg_password.getText().toString();
        if (TextUtils.isEmpty(password) || password.length() < 6) {
            reg_password.setError(getString(R.string.require_password));
            valid = false;
        } else {
            reg_password.setError(null);
        }
        String cofirmPass = reg_confpass.getText().toString();
        if(!password.equals(cofirmPass)){
            reg_confpass.setError(getString(R.string.invalid_pass_confirm));
            valid = false;

        }else {
            reg_confpass.setError(null);
        }

        return valid;
    }

    public void register(View view) {
        email = reg_email.getText().toString().trim();
        password = reg_password.getText().toString().trim();
        if (validateForm()) {
            connect.register(registerCallback, reg_name.getText().toString()
                    ,reg_lname.getText().toString()
                    ,reg_email.getText().toString()
                    ,reg_confpass.getText().toString()
                    ,reg_tel.getText().toString(),"97845632");
        } else {
            Utils.toast(getApplicationContext(),"validation failed");
            Log.d(TAG, "validation failed");
        }

    }

}
