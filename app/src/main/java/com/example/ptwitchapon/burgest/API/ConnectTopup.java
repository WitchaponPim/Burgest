package com.example.ptwitchapon.burgest.API;

import com.example.ptwitchapon.burgest.Tool.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Killy77 on 14/6/2561.
 */

public class ConnectTopup {
    public static final String BASE_URL = Utils.ipHost;
    private static Retrofit retrofit = null;
    public static int unique_id;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
