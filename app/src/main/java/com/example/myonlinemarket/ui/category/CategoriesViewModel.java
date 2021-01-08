package com.example.myonlinemarket.ui.category;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myonlinemarket.model.ProductCategories;
import com.example.myonlinemarket.repository.CategoryRepository;

import java.util.List;

public class CategoriesViewModel extends ViewModel {

    private LiveData<List<ProductCategories>> mDigitalList;
    private LiveData<List<ProductCategories>> mClothesList;
    private LiveData<List<ProductCategories>> mBookList;
    private LiveData<List<ProductCategories>> mFoodList;
    private CategoryRepository mRepository;

    public CategoriesViewModel() {
        mRepository = CategoryRepository.getInstance();
    }

    public LiveData<List<ProductCategories>> getDigitalList() {
        mDigitalList = mRepository.getLiveDataDigital();
        return mDigitalList;
    }

    public LiveData<List<ProductCategories>> getClothesList() {
        mClothesList = mRepository.getLiveDataClothes();
        return mClothesList;
    }

    public LiveData<List<ProductCategories>> getBookList() {
        mBookList = mRepository.getLiveDataBook();
        return mBookList;
    }

    public LiveData<List<ProductCategories>> getFoodList() {
        mFoodList = mRepository.getLiveDataFood();
        return mFoodList;
    }
}