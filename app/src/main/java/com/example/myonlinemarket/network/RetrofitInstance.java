package com.example.myonlinemarket.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static final String BASE_URL = "https://woocommerce.maktabsharif.ir/wp-json/wc/v3";
    private static Retrofit sRetrofit;

    public static Retrofit getRetrofitInstance(){
        if (sRetrofit == null){
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }
}
