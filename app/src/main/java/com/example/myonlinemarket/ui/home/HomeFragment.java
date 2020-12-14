package com.example.myonlinemarket.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myonlinemarket.adapter.ProductAdapter;
import com.example.myonlinemarket.databinding.FragmentHomeBinding;
import com.example.myonlinemarket.model.Product;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding mFragmentHomeBinding;
    private HomeViewModel mHomeViewModel;
    private ProductAdapter mProductAdapter;
    private LiveData<List<Product>> mLiveDataListNewest;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mFragmentHomeBinding = FragmentHomeBinding.inflate(inflater);
        mHomeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        mLiveDataListNewest = mHomeViewModel.getProductListMutableLiveData();
        mFragmentHomeBinding.recyclerViewNewest.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL,
                true));
        mProductAdapter = new ProductAdapter(getContext());
        mFragmentHomeBinding.recyclerViewNewest.setAdapter(mProductAdapter);
        mLiveDataListNewest.observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                mProductAdapter.setProductList(products);
            }
        });
        return mFragmentHomeBinding.getRoot();
    }
}