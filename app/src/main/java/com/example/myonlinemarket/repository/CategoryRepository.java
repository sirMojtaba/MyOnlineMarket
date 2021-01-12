package com.example.myonlinemarket.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.myonlinemarket.model.ProductCategories;
import com.example.myonlinemarket.network.AppService;
import com.example.myonlinemarket.network.CategoryDeserializer;
import com.example.myonlinemarket.network.NetworkParameters;
import com.example.myonlinemarket.network.RetrofitInstance;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CategoryRepository {

    private static CategoryRepository sRepository;

    public static CategoryRepository getInstance() {
        if (sRepository == null)
            sRepository = new CategoryRepository();
        return sRepository;
    }

    private AppService mAppService;
    private MutableLiveData<List<ProductCategories>> mLiveDataDigital = new MutableLiveData<>();
    private MutableLiveData<List<ProductCategories>> mLiveDataClothes = new MutableLiveData<>();
    private MutableLiveData<List<ProductCategories>> mLiveDataBook = new MutableLiveData<>();
    private MutableLiveData<List<ProductCategories>> mLiveDataFood = new MutableLiveData<>();

    private CategoryRepository() {
        Type type = new TypeToken<List<ProductCategories>>() {
        }.getType();
        try {
            Object object = new CategoryDeserializer();
            Retrofit retrofit = RetrofitInstance.getRetrofitInstance(type, object);
            mAppService = retrofit.create(AppService.class);

        } catch (Exception e) {
            Log.d("tag", "category repository catch" + e.getMessage());
        }
        Log.d("tag", "category repository");
    }

    public MutableLiveData<List<ProductCategories>> getLiveDataDigital() {
        Call<List<ProductCategories>> call = mAppService.getCategories(NetworkParameters.queryDigitalCategoryList,
                NetworkParameters.DIGITAL_ID);
        call.enqueue(new Callback<List<ProductCategories>>() {
            @Override
            public void onResponse(Call<List<ProductCategories>> call, Response<List<ProductCategories>> response) {
                mLiveDataDigital.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ProductCategories>> call, Throwable t) {

            }
        });
        return mLiveDataDigital;
    }

    public MutableLiveData<List<ProductCategories>> getLiveDataClothes() {
        Call<List<ProductCategories>> call = mAppService.getCategories(NetworkParameters.queryDigitalCategoryList,
                NetworkParameters.CLOTHES_ID);
        call.enqueue(new Callback<List<ProductCategories>>() {
            @Override
            public void onResponse(Call<List<ProductCategories>> call, Response<List<ProductCategories>> response) {
                mLiveDataClothes.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ProductCategories>> call, Throwable t) {

            }
        });
        return mLiveDataClothes;
    }

    public MutableLiveData<List<ProductCategories>> getLiveDataBook() {
        Call<List<ProductCategories>> call = mAppService.getCategories(NetworkParameters.queryDigitalCategoryList,
                NetworkParameters.BOOK_ID);
        call.enqueue(new Callback<List<ProductCategories>>() {
            @Override
            public void onResponse(Call<List<ProductCategories>> call, Response<List<ProductCategories>> response) {
                mLiveDataBook.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ProductCategories>> call, Throwable t) {

            }
        });
        return mLiveDataBook;
    }

    public MutableLiveData<List<ProductCategories>> getLiveDataFood() {
        Call<List<ProductCategories>> call = mAppService.getCategories(NetworkParameters.queryDigitalCategoryList,
                NetworkParameters.FOOD_ID);
        call.enqueue(new Callback<List<ProductCategories>>() {
            @Override
            public void onResponse(Call<List<ProductCategories>> call, Response<List<ProductCategories>> response) {
                mLiveDataFood.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ProductCategories>> call, Throwable t) {

            }
        });
        return mLiveDataFood;
    }
}
