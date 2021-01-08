package com.example.myonlinemarket.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myonlinemarket.R;
import com.example.myonlinemarket.adapter.CategoryAdapter;
import com.example.myonlinemarket.databinding.FragmentCategoriesBinding;
import com.example.myonlinemarket.model.ProductCategories;

import java.util.List;

public class CategoriesFragment extends Fragment {

    private CategoriesViewModel mCategoriesViewModel;
    private FragmentCategoriesBinding mBinding;
    private CategoryAdapter mDigitalAdapter;
    private CategoryAdapter mClothesAdapter;
    private CategoryAdapter mBookAdapter;
    private CategoryAdapter mFoodAdapter;
    private LiveData<List<ProductCategories>> mDigitalList;
    private LiveData<List<ProductCategories>> mClothesList;
    private LiveData<List<ProductCategories>> mBookList;
    private LiveData<List<ProductCategories>> mFoodList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCategoriesViewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);
        mDigitalAdapter = new CategoryAdapter(getContext());
        mClothesAdapter = new CategoryAdapter(getContext());
        mBookAdapter = new CategoryAdapter(getContext());
        mFoodAdapter = new CategoryAdapter(getContext());
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_categories, container, false);
        setupDigitalList();
        setupClothesList();
        setupBooklList();
        setupFoodList();
        return mBinding.getRoot();
    }

    private void setupDigitalList() {
        mDigitalList = mCategoriesViewModel.getDigitalList();
        mBinding.recyclerViewDigital.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, true));
        mBinding.recyclerViewDigital.setAdapter(mDigitalAdapter);
        mDigitalList.observe(getViewLifecycleOwner(), new Observer<List<ProductCategories>>() {
            @Override
            public void onChanged(List<ProductCategories> productCategories) {
                mDigitalAdapter.setCategoryList(productCategories);

            }
        });
    }

    private void setupClothesList() {
        mClothesList = mCategoriesViewModel.getClothesList();
        mBinding.recyclerViewClothes.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, true));
        mBinding.recyclerViewClothes.setAdapter(mClothesAdapter);
        mClothesList.observe(getViewLifecycleOwner(), new Observer<List<ProductCategories>>() {
            @Override
            public void onChanged(List<ProductCategories> productCategories) {
                mClothesAdapter.setCategoryList(productCategories);

            }
        });
    }

    private void setupBooklList() {
        mBookList = mCategoriesViewModel.getBookList();
        mBinding.recyclerViewBook.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, true));
        mBinding.recyclerViewBook.setAdapter(mBookAdapter);
        mBookList.observe(getViewLifecycleOwner(), new Observer<List<ProductCategories>>() {
            @Override
            public void onChanged(List<ProductCategories> productCategories) {
                mBookAdapter.setCategoryList(productCategories);

            }
        });
    }

    private void setupFoodList() {
        mFoodList = mCategoriesViewModel.getFoodList();
        mBinding.recyclerViewFood.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, true));
        mBinding.recyclerViewFood.setAdapter(mFoodAdapter);
        mFoodList.observe(getViewLifecycleOwner(), new Observer<List<ProductCategories>>() {
            @Override
            public void onChanged(List<ProductCategories> productCategories) {
                mFoodAdapter.setCategoryList(productCategories);

            }
        });
    }
}