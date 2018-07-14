package com.example.ptwitchapon.burgest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.ptwitchapon.burgest.API.ConnectManager;
import com.example.ptwitchapon.burgest.Callback.EditCallback;
import com.example.ptwitchapon.burgest.Model.EditResponse;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.okhttp.ResponseBody;

import retrofit.Retrofit;

public class AccountDriverActivity extends AppCompatActivity {
    String TAG = "EditAccount";
    ConnectManager connect = new ConnectManager();
    EditCallback editCallback = new EditCallback() {
        @Override
        public void onResponse(EditResponse response, Retrofit retrofit) {
            Utils.driver.getCheckloginadmin().setFirstname(name.getText().toString());
            Utils.driver.getCheckloginadmin().setLastname(lname.getText().toString());
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

    EditText name,lname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_driver);
        name = (EditText) findViewById(R.id.reg_firstname);
        lname = (EditText) findViewById(R.id.reg_lastname);


        name.setText(Utils.driver.getCheckloginadmin().getFirstname());
        lname.setText(Utils.driver.getCheckloginadmin().getLastname());

        

    }

    public void update(View view){
        connect.edit_Account_driver(editCallback
                ,name.getText().toString()
                ,lname.getText().toString()
                ,Utils.driver.getCheckloginadmin().getId_emp());
    }
}
