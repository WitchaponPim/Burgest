package com.example.ptwitchapon.burgest.API;


import com.example.ptwitchapon.burgest.Model.CompleteModel;
import com.example.ptwitchapon.burgest.Model.DeliveryOrderModel;
import com.example.ptwitchapon.burgest.Model.DriverModel;
import com.example.ptwitchapon.burgest.Model.EditResponse;
import com.example.ptwitchapon.burgest.Model.MyDeliverDriver;
import com.example.ptwitchapon.burgest.Model.Order;
import com.example.ptwitchapon.burgest.Model.OrderResponse;
import com.example.ptwitchapon.burgest.Model.Orderlist;
import com.example.ptwitchapon.burgest.Model.Orderlist_item;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.Model.PromotionModel;
import com.example.ptwitchapon.burgest.Model.Regis;
import com.example.ptwitchapon.burgest.Model.StockModel;
import com.example.ptwitchapon.burgest.Model.StoreModel;
import com.example.ptwitchapon.burgest.Model.TakeDelivery;
import com.example.ptwitchapon.burgest.Model.TopupModel;
import com.example.ptwitchapon.burgest.Model.UpdateStockResponse;
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

    @FormUrlEncoded
    @POST("update-emp.php")
    Call<EditResponse> editAccount_driver(@Field("Firstname") String name
            , @Field("Lastname") String lastname
            , @Field("id_emp") String id_emp);

    @FormUrlEncoded
    @POST("update-status.php")
    Call<CompleteModel> complete_driver(@Field("id_order") String name
            , @Field("id_status") String id_status);


    @GET("menu.php")
    Call<Product> getMenu();

    @GET("get-storedetail.php")
    Call<StoreModel> getStore();

    @FormUrlEncoded
    @POST("get-stock.php")
    Call<StockModel> getStock(@Field("id_stock") String id_stock);

    @FormUrlEncoded
    @POST("get-promotion.php")
    Call<PromotionModel> getPromotion(@Field("id_promotion") String id_promotion);

    @FormUrlEncoded
    @POST("update-stock.php")
    Call<UpdateStockResponse> updateStock(@Field("id_stock") String id_stock
            ,@Field("name") String name
            ,@Field("amount") String amount
            ,@Field("EXP") String exp);

    @GET("get-order-delivery.php")
    Call<DeliveryOrderModel> getDriverorder();


    @FormUrlEncoded
    @POST("get-delivery.php")
    Call<MyDeliverDriver> myDeliver(@Field("id_emp") String id_emp);


    @FormUrlEncoded
    @POST("order.php")
    Call<OrderResponse> order(@Field("strData") String data);


    @FormUrlEncoded
    @POST("take-delivery.php")
    Call<TakeDelivery> acceptDelivery(@Field("id_order") String id_order,@Field("id_emp") String id_emp);

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
