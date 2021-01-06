package com.example.myonlinemarket.ui.home;

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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myonlinemarket.R;
import com.example.myonlinemarket.adapter.ProductAdapter;
import com.example.myonlinemarket.databinding.FragmentHomeBinding;
import com.example.myonlinemarket.model.Product;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding mFragmentHomeBinding;
    private HomeViewModel mHomeViewModel;
    private ProductAdapter mProductAdapterNewest;
    private ProductAdapter mProductAdapterMostVisited;
    private ProductAdapter mProductAdapterMostPopular;
    private LiveData<List<Product>> mLiveDataListNewest;
    private LiveData<List<Product>> mLiveDataListMostVisited;
    private LiveData<List<Product>> mLiveDataListMostPopular;
    private NavController mNavController;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHomeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        mProductAdapterNewest = new ProductAdapter(getContext(), mHomeViewModel);
        mProductAdapterMostVisited = new ProductAdapter(getContext(), mHomeViewModel);
        mProductAdapterMostPopular = new ProductAdapter(getContext(), mHomeViewModel);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mFragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        setupNewestList();
        setupMostVisitedList();
        setupMostPopularList();
        onNewestListItemSelected();
        return mFragmentHomeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(view);
    }

    private void setupNewestList() {
        mLiveDataListNewest = mHomeViewModel.getLiveDataNewestList();
        mFragmentHomeBinding.recyclerViewNewest.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL,
                true));
        mFragmentHomeBinding.recyclerViewNewest.setAdapter(mProductAdapterNewest);
        mLiveDataListNewest.observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                mProductAdapterNewest.setProductList(products);
            }
        });
    }

    private void setupMostVisitedList() {
        mLiveDataListMostVisited = mHomeViewModel.getLiveDataMostVisitedList();
        mFragmentHomeBinding.recyclerViewMostVisited.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL,
                true));
        mFragmentHomeBinding.recyclerViewMostVisited.setAdapter(mProductAdapterMostVisited);
        mLiveDataListMostVisited.observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                mProductAdapterMostVisited.setProductList(products);
            }
        });
    }

    private void setupMostPopularList() {
        mLiveDataListMostPopular = mHomeViewModel.getLiveDataMostPopularList();
        mFragmentHomeBinding.recyclerViewMostPopular.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL,
                true));
        mFragmentHomeBinding.recyclerViewMostPopular.setAdapter(mProductAdapterMostPopular);
        mLiveDataListMostPopular.observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                mProductAdapterMostPopular.setProductList(products);
            }
        });
    }

    private void onNewestListItemSelected() {
        mHomeViewModel.getLiveDataProduct().observe(getViewLifecycleOwner(), new Observer<Product>() {
            @Override
            public void onChanged(Product product) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("product", product);
                mNavController.navigate(R.id.action_navigation_home_to_productDetailFragment, bundle);
            }
        });
    }
}