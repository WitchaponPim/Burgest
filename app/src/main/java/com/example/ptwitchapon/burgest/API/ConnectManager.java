package com.example.ptwitchapon.burgest.API;

import android.util.Log;

import com.example.ptwitchapon.burgest.Callback.EditCallback;
import com.example.ptwitchapon.burgest.Callback.LoginCallback;
import com.example.ptwitchapon.burgest.Callback.MenuCallback;
import com.example.ptwitchapon.burgest.Callback.OrderCallback;
import com.example.ptwitchapon.burgest.Callback.OrderListCallback;
import com.example.ptwitchapon.burgest.Callback.OrderList_ItemCallback;
import com.example.ptwitchapon.burgest.Callback.RegisterCallback;
import com.example.ptwitchapon.burgest.Callback.TopupListCallback;
import com.example.ptwitchapon.burgest.Model.EditResponse;
import com.example.ptwitchapon.burgest.Model.Order;
import com.example.ptwitchapon.burgest.Model.OrderResponse;
import com.example.ptwitchapon.burgest.Model.Orderlist;
import com.example.ptwitchapon.burgest.Model.Orderlist_item;
import com.example.ptwitchapon.burgest.Model.Product;
import com.example.ptwitchapon.burgest.Model.Regis;
import com.example.ptwitchapon.burgest.Model.TopupModel;
import com.example.ptwitchapon.burgest.Model.User;
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONObject;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import static android.content.ContentValues.TAG;

/**
 * Created by Killy77 on 14/4/2561.
 */

public class ConnectManager {
    String API = Utils.ipHost;

    public ConnectManager() {

    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    APIService con = retrofit.create(APIService.class);

    public void login(final LoginCallback listener, String user, String pass) {
        Call call = con.postLogin(user, pass);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {
                User user = response.body();
                if (user == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(user, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });
    }
    public void register(final RegisterCallback listener, String name, String lastname, String email, String password, String tel, String lat) {
        Call call = con.postRegister(name, lastname,email,password,tel,lat);
        call.enqueue(new Callback<Regis>() {
            @Override
            public void onResponse(Response<Regis> response, Retrofit retrofit) {
                Regis regis = response.body();
                if (regis == null) {
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(regis, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });

    }
    public void getmenu(final MenuCallback listener) {
        Call call = con.getMenu();
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Response<Product> response, Retrofit retrofit) {
                Product product = response.body();
                if (product == null) {
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(product, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });

    }

    public void order(final OrderCallback listener, String order) {
        Call call = con.order(order);
        call.enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Response<OrderResponse> response, Retrofit retrofit) {
                OrderResponse orderResponse = response.body();
                if (orderResponse == null) {
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(orderResponse, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });

    }
    public void orderList(final OrderListCallback listener,String id_member) {
        Call call = con.orderlist_member(id_member);
        call.enqueue(new Callback<Orderlist>() {
            @Override
            public void onResponse(Response<Orderlist> response, Retrofit retrofit) {
                Orderlist orderlist = response.body();
                if (orderlist == null) {
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(orderlist, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });

    }

    public void orderList_item(final OrderList_ItemCallback listener, String id_order) {
        Call call = con.orderlistItem(id_order);
        call.enqueue(new Callback<Orderlist_item>() {
            @Override
            public void onResponse(Response<Orderlist_item> response, Retrofit retrofit) {
                Orderlist_item orderlist_item = response.body();
                if (orderlist_item == null) {
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(orderlist_item, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });

    }

    public void edit_Account(final EditCallback listener,String firstname
            ,String lastname
            , String email
            , String tel
            ,String id_member) {
        Call call = con.editAccount(firstname,lastname,email,tel,id_member);
        call.enqueue(new Callback<EditResponse>() {
            @Override
            public void onResponse(Response<EditResponse> response, Retrofit retrofit) {
                EditResponse edit = response.body();
                if (edit == null) {
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(edit, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });

    }
    public void getTopup(final TopupListCallback listener, String id_member) {
        Call call = con.getTopupstatus(id_member);
        call.enqueue(new Callback<TopupModel>() {
            @Override
            public void onResponse(Response<TopupModel> response, Retrofit retrofit) {
                TopupModel topup = response.body();
                if (topup == null) {
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(topup, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });

    }
}
