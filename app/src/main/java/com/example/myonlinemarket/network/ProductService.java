package com.example.myonlinemarket.network;

import com.example.myonlinemarket.model.Product;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ProductService {

    @GET(".")
    Call<List<Product>> getProductList(@QueryMap Map<String, String> );

}
