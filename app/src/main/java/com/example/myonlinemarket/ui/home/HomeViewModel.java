package com.example.myonlinemarket.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myonlinemarket.model.Product;
import com.example.myonlinemarket.repository.ProductRepository;

import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Product>> mProductListMutableLiveData;
    private ProductRepository mProductRepository;

    public HomeViewModel() {
        mProductRepository = ProductRepository.getProductRepository();
    }

    public MutableLiveData<List<Product>> getProductListMutableLiveData() {
        mProductListMutableLiveData = mProductRepository.getListLiveData();
        return mProductListMutableLiveData;
    }
}