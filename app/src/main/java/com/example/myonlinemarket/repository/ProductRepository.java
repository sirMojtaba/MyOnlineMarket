package com.example.myonlinemarket.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.myonlinemarket.model.Product;
import com.example.myonlinemarket.network.GetProductListDeserializer;
import com.example.myonlinemarket.network.NetworkParameters;
import com.example.myonlinemarket.network.ProductService;
import com.example.myonlinemarket.network.RetrofitInstance;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProductRepository {

    private static ProductRepository sProductRepository;

    public static ProductRepository getProductRepository() {
        if (sProductRepository == null)
            sProductRepository = new ProductRepository();
        return sProductRepository;
    }

    private ProductService mProductService;
    private MutableLiveData<List<Product>> mListLiveData = new MutableLiveData<>();

    private ProductRepository() {
        Type type = new TypeToken<List<Product>>() {}.getType();
        Object typeAdapter = new GetProductListDeserializer();
        Retrofit retrofit = RetrofitInstance.getRetrofitInstance(type, typeAdapter);
        mProductService = retrofit.create(ProductService.class);
    }

    public MutableLiveData<List<Product>> getListLiveData() {

        Call<List<Product>> call = mProductService.getProductList(NetworkParameters.queryNewestList);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mListLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
        return mListLiveData;
    }
}
