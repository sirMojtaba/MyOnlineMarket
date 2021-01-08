package com.example.myonlinemarket.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.myonlinemarket.model.Product;
import com.example.myonlinemarket.model.ProductCategories;
import com.example.myonlinemarket.network.ProductDeserializer;
import com.example.myonlinemarket.network.NetworkParameters;
import com.example.myonlinemarket.network.AppService;
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

    private AppService mAppService;
    private MutableLiveData<List<Product>> mLiveDataNewestList = new MutableLiveData<>();
    private MutableLiveData<List<Product>> mLiveDataMostVisitedList = new MutableLiveData<>();
    private MutableLiveData<List<Product>> mLiveDataMostPopularList = new MutableLiveData<>();
    private MutableLiveData<List<ProductCategories>> mLiveDataDigitalList = new MutableLiveData<>();

    private ProductRepository() {
        Type type = new TypeToken<List<Product>>() {
        }.getType();
        Object productTypeAdapter = new ProductDeserializer();
        Retrofit retrofit = RetrofitInstance.getRetrofitInstance(type, productTypeAdapter);
        mAppService = retrofit.create(AppService.class);
    }

    public MutableLiveData<List<Product>> getLiveDataNewestList() {
        Call<List<Product>> call = mAppService.getProductList(NetworkParameters.queryNewestList);
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
        Call<List<Product>> call = mAppService.getProductList(NetworkParameters.queryMostVisitedList);
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
        Call<List<Product>> call = mAppService.getProductList(NetworkParameters.queryRatingList);
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

    /*public MutableLiveData<List<ProductCategories>> getLiveDataDigitalList() {
        Call<List<ProductCategories>> call = mCategoryAppService.getCategories(NetworkParameters.queryDigitalCategoryList);
        call.enqueue(new Callback<List<ProductCategories>>() {
            @Override
            public void onResponse(Call<List<ProductCategories>> call, Response<List<ProductCategories>> response) {
                mLiveDataDigitalList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ProductCategories>> call, Throwable t) {

            }
        });
        return mLiveDataDigitalList;
    }*/
}
