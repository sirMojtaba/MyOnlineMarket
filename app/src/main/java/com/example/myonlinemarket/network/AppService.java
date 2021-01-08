package com.example.myonlinemarket.network;

import com.example.myonlinemarket.model.Product;
import com.example.myonlinemarket.model.ProductCategories;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface AppService {
    @GET("products")
    Call<List<Product>> getProductList(@QueryMap Map<String, String> options);

    @GET("products/categories")
    Call<List<ProductCategories>> getCategories(@QueryMap Map<String, String> options);
}
