package com.example.ptwitchapon.burgest.API;

import com.example.ptwitchapon.burgest.Callback.CompleteCallback;
import com.example.ptwitchapon.burgest.Callback.DriverOrderCallback;
import com.example.ptwitchapon.burgest.Callback.EditCallback;
import com.example.ptwitchapon.burgest.Callback.LoginCallback;
import com.example.ptwitchapon.burgest.Callback.Login_DCallback;
import com.example.ptwitchapon.burgest.Callback.MenuCallback;
import com.example.ptwitchapon.burgest.Callback.MyDeliveryCallback;
import com.example.ptwitchapon.burgest.Callback.OrderCallback;
import com.example.ptwitchapon.burgest.Callback.OrderListCallback;
import com.example.ptwitchapon.burgest.Callback.OrderList_ItemCallback;
import com.example.ptwitchapon.burgest.Callback.PromotionCallback;
import com.example.ptwitchapon.burgest.Callback.RegisterCallback;
import com.example.ptwitchapon.burgest.Callback.StockCallback;
import com.example.ptwitchapon.burgest.Callback.StoreCallback;
import com.example.ptwitchapon.burgest.Callback.TakeDeliveryCallback;
import com.example.ptwitchapon.burgest.Callback.TopupListCallback;
import com.example.ptwitchapon.burgest.Callback.UpdateStockCallback;
import com.example.ptwitchapon.burgest.Model.CompleteModel;
import com.example.ptwitchapon.burgest.Model.DeliveryOrderModel;
import com.example.ptwitchapon.burgest.Model.DriverModel;
import com.example.ptwitchapon.burgest.Model.EditResponse;
import com.example.ptwitchapon.burgest.Model.MyDeliverDriver;
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
import com.example.ptwitchapon.burgest.Tool.Utils;
import com.squareup.okhttp.ResponseBody;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

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

    public void login(final LoginCallback listener, String user, String pass,String token) {
        Call call = con.postLogin(user, pass,token);
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

    public void loginDriver(final Login_DCallback listener, String user, String pass,String token) {
        Call call = con.loginDriver(user, pass,token);
        call.enqueue(new Callback<DriverModel>() {
            @Override
            public void onResponse(Response<DriverModel> response, Retrofit retrofit) {
                DriverModel driver = response.body();
                if (driver == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(driver, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });
    }
    public void takediliver(final TakeDeliveryCallback listener, String id_order, String id_emp) {
        Call call = con.acceptDelivery(id_order,id_emp);
        call.enqueue(new Callback<TakeDelivery>() {
            @Override
            public void onResponse(Response<TakeDelivery> response, Retrofit retrofit) {
                TakeDelivery deliver = response.body();
                if (deliver == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(deliver, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });
    }
    public void myDeliver(final MyDeliveryCallback listener, String id_emp) {
        Call call = con.myDeliver(id_emp);
        call.enqueue(new Callback<MyDeliverDriver>() {
            @Override
            public void onResponse(Response<MyDeliverDriver> response, Retrofit retrofit) {
                MyDeliverDriver mydeliver = response.body();
                if (mydeliver == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(mydeliver, retrofit);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });
    }
    public void driver_complete(final CompleteCallback listener, String id_order,String id_status) {
        Call call = con.complete_driver(id_order,id_status);
        call.enqueue(new Callback<CompleteModel>() {
            @Override
            public void onResponse(Response<CompleteModel> response, Retrofit retrofit) {
                CompleteModel mydeliver = response.body();
                if (mydeliver == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(mydeliver, retrofit);
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
    public void getstore(final StoreCallback listener) {
        Call call = con.getStore();
        call.enqueue(new Callback<StoreModel>() {
            @Override
            public void onResponse(Response<StoreModel> response, Retrofit retrofit) {
                StoreModel store = response.body();
                if (store == null) {
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(store, retrofit);
                }
            }
            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });
    }

    public void getstock(final StockCallback listener,String id_stock) {
        Call call = con.getStock(id_stock);
        call.enqueue(new Callback<StockModel>() {
            @Override
            public void onResponse(Response<StockModel> response, Retrofit retrofit) {
                StockModel stock = response.body();
                if (stock == null) {
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(stock, retrofit);
                }
            }
            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });
    }

    public void getPromotion(final PromotionCallback listener, String id_promotion) {
        Call call = con.getPromotion(id_promotion);
        call.enqueue(new Callback<PromotionModel>() {
            @Override
            public void onResponse(Response<PromotionModel> response, Retrofit retrofit) {
                PromotionModel promotion = response.body();
                if (promotion == null) {
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(promotion, retrofit);
                }
            }
            @Override
            public void onFailure(Throwable t) {
                listener.onFailure(t);
            }
        });
    }

    public void updatestock(final UpdateStockCallback listener, String id_stock,String name , String amount,String exp) {
        Call call = con.updateStock(id_stock,name,amount,exp);
        call.enqueue(new Callback<UpdateStockResponse>() {
            @Override
            public void onResponse(Response<UpdateStockResponse> response, Retrofit retrofit) {
                UpdateStockResponse stock = response.body();
                if (stock == null) {
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);
                    } else {
                        listener.onBodyErrorIsNull();
                    }
                } else {
                    //200
                    listener.onResponse(stock, retrofit);
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
    public void edit_Account_driver(final EditCallback listener,String firstname
            ,String lastname
            ,String id_emp) {
        Call call = con.editAccount_driver(firstname,lastname,id_emp);
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
    public void getAllOrder(final DriverOrderCallback listener) {
        Call call = con.getDriverorder();
        call.enqueue(new Callback<DeliveryOrderModel>() {
            @Override
            public void onResponse(Response<DeliveryOrderModel> response, Retrofit retrofit) {
                DeliveryOrderModel topup = response.body();
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
