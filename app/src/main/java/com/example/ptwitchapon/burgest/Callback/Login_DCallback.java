package com.example.ptwitchapon.burgest.Callback;

import com.example.ptwitchapon.burgest.Model.DriverModel;
import com.example.ptwitchapon.burgest.Model.User;
import com.squareup.okhttp.ResponseBody;

import java.sql.Driver;

import retrofit.Retrofit;

/**
 * Created by Killy77 on 14/4/2561.
 */
public interface Login_DCallback {
    public void onResponse(DriverModel driver, Retrofit retrofit);
    public void onFailure(Throwable t);
    public void onBodyError(ResponseBody responseBody);
    public void onBodyErrorIsNull();
}
