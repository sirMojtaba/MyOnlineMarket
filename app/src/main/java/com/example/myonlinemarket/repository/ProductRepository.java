package com.example.myonlinemarket.repository;

import android.util.Log;

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
    private MutableLiveData<List<Product>> mLiveDataNewestList = new MutableLiveData<>();
    private MutableLiveData<List<Product>> mLiveDataMostVisitedList = new MutableLiveData<>();
    private MutableLiveData<List<Product>> mLiveDataMostPopularList = new MutableLiveData<>();

    private ProductRepository() {
        Type type = new TypeToken<List<Product>>() {}.getType();
        Object typeAdapter = new GetProductListDeserializer();
        Retrofit retrofit = RetrofitInstance.getRetrofitInstance(type, typeAdapter);
        mProductService = retrofit.create(ProductService.class);
    }

    public MutableLiveData<List<Product>> getLiveDataNewestList() {
        Log.d("tag3", "getLiveDataNewestList");
        Call<List<Product>> call = mProductService.getProductList(NetworkParameters.queryNewestList);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mLiveDataNewestList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
        return mLiveDataNewestList;
    }

    public MutableLiveData<List<Product>> getLiveDataMostVisitedList() {
        Log.d("tag3", "getLiveDataMostVisitedList");
        Call<List<Product>> call = mProductService.getProductList(NetworkParameters.queryMostVisitedList);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mLiveDataMostVisitedList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
        return mLiveDataMostVisitedList;
    }

    public MutableLiveData<List<Product>> getLiveDataMostPopularList() {
        Log.d("tag3", "getLiveDataMostPopularList");
        Call<List<Product>> call = mProductService.getProductList(NetworkParameters.queryRatingList);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mLiveDataMostPopularList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
        return mLiveDataMostPopularList;
    }
}
