package com.example.myonlinemarket.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myonlinemarket.model.Product;
import com.example.myonlinemarket.repository.ProductRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private LiveData<List<Product>> mProductListLiveData;
    private ProductRepository mProductRepository;

    public HomeViewModel() {
        mProductRepository = ProductRepository.getProductRepository();
    }

    public LiveData<List<Product>> getProductListMutableLiveData() {
        mProductListLiveData = mProductRepository.getListLiveData();
        return mProductListLiveData;
    }
}