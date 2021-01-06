package com.example.myonlinemarket.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myonlinemarket.model.Product;
import com.example.myonlinemarket.repository.ProductRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private ProductRepository mProductRepository;
    private LiveData<List<Product>> mLiveDataNewestList;
    private LiveData<List<Product>> mLiveDataMostVisitedList;
    private LiveData<List<Product>> mLiveDataMostPopularList;
    private MutableLiveData<Product> mLiveDataProduct = new MutableLiveData<>();

    public HomeViewModel() {
        mProductRepository = ProductRepository.getProductRepository();
    }

    public LiveData<List<Product>> getLiveDataNewestList() {
        mLiveDataNewestList = mProductRepository.getLiveDataNewestList();
        return mLiveDataNewestList;
    }

    public LiveData<List<Product>> getLiveDataMostVisitedList() {
        mLiveDataMostVisitedList = mProductRepository.getLiveDataMostVisitedList();
        return mLiveDataMostVisitedList;
    }

    public LiveData<List<Product>> getLiveDataMostPopularList() {
        mLiveDataMostPopularList = mProductRepository.getLiveDataMostPopularList();
        return mLiveDataMostPopularList;
    }

    public MutableLiveData<Product> getLiveDataProduct() {
        return mLiveDataProduct;
    }

    public void onItemSelected(int position){
        mLiveDataProduct.setValue(mLiveDataNewestList.getValue().get(position));
    }
}