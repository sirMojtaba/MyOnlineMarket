package com.example.myonlinemarket.ui.home;

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

import com.example.myonlinemarket.R;
import com.example.myonlinemarket.adapter.ProductAdapter;
import com.example.myonlinemarket.databinding.FragmentHomeBinding;
import com.example.myonlinemarket.model.Product;
import com.example.myonlinemarket.network.ProductService;
import com.example.myonlinemarket.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding mFragmentHomeBinding;
    private HomeViewModel mHomeViewModel;
    private ProductAdapter mProductAdapter;
    private LiveData<List<Product>> mProductList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProductAdapter = new ProductAdapter(getContext(), (List<Product>) mProductList);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mFragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        mHomeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        mProductList = mHomeViewModel.getProductListMutableLiveData();

        mProductList.observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                mFragmentHomeBinding.recyclerViewNewest.setLayoutManager(new LinearLayoutManager(getContext()));
                mFragmentHomeBinding.recyclerViewNewest.setAdapter(mProductAdapter);
            }
        });
        return mFragmentHomeBinding.getRoot();
    }
}