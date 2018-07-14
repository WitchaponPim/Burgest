package com.example.ptwitchapon.burgest.API;


import com.example.ptwitchapon.burgest.Model.DriverModel;
import com.example.ptwitchapon.burgest.Model.EditResponse;
import com.example.ptwitchapon.burgest.Model.Order;
import com.example.ptwitchapon.burgest.Model.OrderResponse;
import com.example.ptwitchapon.burgest.Model.Orderlist;
import com.example.ptwitchapon.burgest.Model.Orderlist_item;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.Model.Regis;
import com.example.ptwitchapon.burgest.Model.StoreModel;
import com.example.ptwitchapon.burgest.Model.TopupModel;
import com.example.ptwitchapon.burgest.Model.User;

import org.json.JSONObject;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("checklogin.php")
    Call<User> postLogin(@Field("email") String user, @Field("password") String pass,@Field("token") String token);

    @FormUrlEncoded
    @POST("checkadminlogin.php")
    Call<DriverModel> loginDriver(@Field("username") String user, @Field("password") String pass,@Field("token")String token);


    @FormUrlEncoded
    @POST("insertuser.php")
    Call<Regis> postRegister(@Field("fname") String name
            , @Field("lname") String lastname
            , @Field("email") String email
            , @Field("password") String password
            , @Field("tel") String tel
            , @Field("latitude") String lat);

    @FormUrlEncoded
    @POST("update-member.php")
    Call<EditResponse> editAccount(@Field("Firstname") String name
            , @Field("Lastname") String lastname
            , @Field("Email") String email
            , @Field("Tel") String tel
            , @Field("id_member") String id_member);

    @GET("menu.php")
    Call<Product> getMenu();

    @GET("get-storedetail.php")
    Call<StoreModel> getStore();

    @FormUrlEncoded
    @POST("order.php")
    Call<OrderResponse> order(@Field("strData") String data);

    @FormUrlEncoded
    @POST("order-member.php")
    Call<Orderlist> orderlist_member(@Field("id_member") String id_member);

    @FormUrlEncoded
    @POST("get-items.php")
    Call<Orderlist_item> orderlistItem(@Field("id_order") String id_order);

    @FormUrlEncoded
    @POST("get-non-topup-confirm-by-user.php")
    Call<TopupModel> getTopupstatus(@Field("id_member") String id_member);
}
