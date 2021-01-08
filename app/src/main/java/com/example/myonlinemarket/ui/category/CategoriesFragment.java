package com.example.myonlinemarket.ui.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    private CategoryAdapter mAdapter;
    private LiveData<List<ProductCategories>> mListDigital;
//    private List<ProductCategories> mListClothes;
//    private List<ProductCategories> mListBook;
//    private List<ProductCategories> mListFood;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCategoriesViewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);
        mAdapter = new CategoryAdapter(getContext());
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_categories, container, false);
        mListDigital = mCategoriesViewModel.getListDigital();
        mBinding.recyclerViewDigital.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, true));
        mBinding.recyclerViewDigital.setAdapter(mAdapter);
        mListDigital.observe(getViewLifecycleOwner(), new Observer<List<ProductCategories>>() {
            @Override
            public void onChanged(List<ProductCategories> productCategories) {
                mAdapter.setCategoryList(productCategories);

            }
        });
        return mBinding.getRoot();
    }
}