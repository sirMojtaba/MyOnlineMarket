package com.example.myonlinemarket.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myonlinemarket.model.Product;
import com.example.myonlinemarket.repository.ProductRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private LiveData<List<Product>> mLiveDataNewestList;
    private LiveData<List<Product>> mLiveDataMostVisitedList;
    private LiveData<List<Product>> mLiveDataMostPopularList;
    private MutableLiveData<Product> mProductLiveData = new MutableLiveData<>();
    private ProductRepository mProductRepository;

    public HomeViewModel() {
        mProductRepository = ProductRepository.getProductRepository();
    }

    public LiveData<List<Product>> getLiveDataNewestList() {
        Log.d("tag2", "getLiveDataNewestList");
        mLiveDataNewestList = mProductRepository.getLiveDataNewestList();
        return mLiveDataNewestList;
    }

    public LiveData<List<Product>> getLiveDataMostVisitedList() {
        Log.d("tag2", "getLiveDataMostVisitedList");
        mLiveDataMostVisitedList = mProductRepository.getLiveDataMostVisitedList();
        return mLiveDataMostVisitedList;
    }

    public LiveData<List<Product>> getLiveDataMostPopularList() {
        Log.d("tag2", "getLiveDataMostPopularList");
        mLiveDataMostPopularList = mProductRepository.getLiveDataMostPopularList();
        return mLiveDataMostPopularList;
    }

    public MutableLiveData<Product> getProductLiveData() {
        return mProductLiveData;
    }

    public void setProductLiveData(MutableLiveData<Product> productLiveData) {
        mProductLiveData = productLiveData;
    }

    public void onItemSelected(int position){
        mProductLiveData.setValue(mLiveDataNewestList.getValue().get(position));

    }
}