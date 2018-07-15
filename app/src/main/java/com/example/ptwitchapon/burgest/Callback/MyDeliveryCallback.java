package com.example.ptwitchapon.burgest.Callback;

import com.example.ptwitchapon.burgest.Model.MyDeliverDriver;
import com.example.ptwitchapon.burgest.Model.TakeDelivery;
import com.squareup.okhttp.ResponseBody;

import retrofit.Retrofit;

/**
 * Created by Killy77 on 29/4/2561.
 */

public interface MyDeliveryCallback {
    public void onResponse(MyDeliverDriver myDeliverDriver, Retrofit retrofit);
    public void onFailure(Throwable t);
    public void onBodyError(ResponseBody responseBody);
    public void onBodyErrorIsNull();
}
