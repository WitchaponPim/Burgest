package com.example.ptwitchapon.burgest.API;

import com.example.ptwitchapon.burgest.Model.AddTopupModel;
import com.example.ptwitchapon.burgest.Model.QrScan;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Killy77 on 14/6/2561.
 */

public interface APIService2 {
//    @FormUrlEncoded
//    @Multipart
//    @POST("add-topup.php")
//    Call<AddTopupModel> uploadFile(@Field("id_member") String id_member,@Field("amount") String amount
//            , @Part MultipartBody.Part file, @Part("image") RequestBody name);


    @Multipart
    @POST("add-topup.php")
    Call<AddTopupModel> uploadFile(@Part("id_member") RequestBody id_member,@Part("amount") RequestBody amount
            ,@Part MultipartBody.Part file, @Part("image") RequestBody name);

    @FormUrlEncoded
    @POST("qrupdate.php")
    Call<QrScan> Scan(@Field("id") String id);
}
