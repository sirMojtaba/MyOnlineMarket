package com.example.myonlinemarket.repository;

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
        if (sRepository == null) {
            sRepository = new CategoryRepository();
        }
        return sRepository;
    }

    private CategoryRepository() {
        Type type = new TypeToken<List<ProductCategories>>(){}.getType();
        Object object = new CategoryDeserializer();
        Retrofit retrofit = RetrofitInstance.getRetrofitInstance(type, object);
        mAppService = retrofit.create(AppService.class);
    }

    private MutableLiveData<List<ProductCategories>> mLiveDataCategoryDigital = new MutableLiveData<>();
    private AppService mAppService;

    public MutableLiveData<List<ProductCategories>> getLiveDataCategoryDigital() {
        Call<List<ProductCategories>> call = mAppService.getCategories(NetworkParameters.queryDigitalCategoryList,
                NetworkParameters.DIGITAL_CATEGORY_ID);
        call.enqueue(new Callback<List<ProductCategories>>() {
            @Override
            public void onResponse(Call<List<ProductCategories>> call, Response<List<ProductCategories>> response) {
                mLiveDataCategoryDigital.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ProductCategories>> call, Throwable t) {

            }
        });
        return mLiveDataCategoryDigital;
    }
}
