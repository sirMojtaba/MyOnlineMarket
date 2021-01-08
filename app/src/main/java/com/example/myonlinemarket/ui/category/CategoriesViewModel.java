package com.example.myonlinemarket.ui.category;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myonlinemarket.model.ProductCategories;
import com.example.myonlinemarket.repository.CategoryRepository;
import com.example.myonlinemarket.repository.ProductRepository;

import java.util.List;

public class CategoriesViewModel extends ViewModel {

    private LiveData<List<ProductCategories>> mListDigital;
    private CategoryRepository mRepository;

    public CategoriesViewModel() {
        mRepository = CategoryRepository.getInstance();
    }

    public LiveData<List<ProductCategories>> getListDigital() {
        mListDigital = mRepository.getLiveDataCategoryDigital();
        return mListDigital;
    }
}