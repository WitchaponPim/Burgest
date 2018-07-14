package com.example.ptwitchapon.burgest.Callback;

import com.example.ptwitchapon.burgest.Model.StockModel;
import com.example.ptwitchapon.burgest.Model.StoreModel;
import com.squareup.okhttp.ResponseBody;

import retrofit.Retrofit;

/**
 * Created by Killy77 on 15/4/2561.
 */

public interface StockCallback {
    public void onResponse(StockModel stock, Retrofit retrofit);
    public void onFailure(Throwable t);
    public void onBodyError(ResponseBody responseBody);
    public void onBodyErrorIsNull();
}
