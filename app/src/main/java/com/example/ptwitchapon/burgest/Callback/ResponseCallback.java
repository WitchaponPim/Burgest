package com.example.ptwitchapon.burgest.Callback;

import com.example.ptwitchapon.burgest.Model.ResponseModel;
import com.squareup.okhttp.ResponseBody;

import retrofit.Retrofit;

/**
 * Created by Killy77 on 26/4/2561.
 */

public interface ResponseCallback {
    public void onResponse(ResponseModel responseModel, Retrofit retrofit);
    public void onFailure(Throwable t);
    public void onBodyError(ResponseBody responseBody);
    public void onBodyErrorIsNull();
}
