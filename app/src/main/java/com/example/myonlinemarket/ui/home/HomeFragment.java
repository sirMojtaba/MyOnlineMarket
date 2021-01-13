package com.example.myonlinemarket.ui.home;

import android.os.Bundle;
import android.util.Log;
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

    private FragmentHomeBinding mBinding;
    private HomeViewModel mHomeViewModel;
    private ProductAdapter mProductAdapterNewest;
    private ProductAdapter mProductAdapterMostVisited;
    private ProductAdapter mProductAdapterMostPopular;
    private NavController mNavController;
    private LiveData<List<Product>> mLiveDataListNewest;
    private LiveData<List<Product>> mLiveDataListMostVisited;
    private LiveData<List<Product>> mLiveDataListMostPopular;
    public static final int NEWEST_LIST_NUMBER = 0;
    public static final int MOST_VISITED_LIST_NUMBER = 1;
    public static final int MOST_POPULAR_LIST_NUMBER = 2;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHomeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        /*mProductAdapterNewest = new ProductAdapter(this, mHomeViewModel);
        mProductAdapterMostVisited = new ProductAdapter(this, mHomeViewModel);
        mProductAdapterMostPopular = new ProductAdapter(this, mHomeViewModel);*/
        Log.d("tag", "home fragment onCreate");
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        setupNewestList();
        setupMostVisitedList();
        setupMostPopularList();
        onNewestListItemSelected();
        Log.d("tag", "home fragment onCreateView");
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(view);
        Log.d("tag", "home fragment onViewCreated");
    }

    private void setupNewestList() {
        mLiveDataListNewest = mHomeViewModel.getLiveDataNewestList();
        mBinding.recyclerViewNewest.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL,
                true));
//        mBinding.recyclerViewNewest.setAdapter(mProductAdapterNewest);
        mLiveDataListNewest.observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
//                mProductAdapterNewest.setProductList(products);
                setNewestAdapter(products);
            }
        });
    }

    private void setNewestAdapter(List<Product> products) {
        if (mProductAdapterNewest == null) {
            mProductAdapterNewest = new ProductAdapter(getContext(), mHomeViewModel, NEWEST_LIST_NUMBER);
            mBinding.recyclerViewNewest.setAdapter(mProductAdapterNewest);
        }
        mProductAdapterNewest.setProductList(products);
        mProductAdapterNewest.notifyDataSetChanged();
    }

    private void setupMostVisitedList() {
        mLiveDataListMostVisited = mHomeViewModel.getLiveDataMostVisitedList();
        mBinding.recyclerViewMostVisited.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL,
                true));
//        mBinding.recyclerViewMostVisited.setAdapter(mProductAdapterMostVisited);
        mLiveDataListMostVisited.observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
//                mProductAdapterMostVisited.setProductList(products);
                setMostVisitedAdapter(products);
            }
        });
    }

    private void setMostVisitedAdapter(List<Product> products) {
        if (mProductAdapterMostVisited == null) {
            mProductAdapterMostVisited = new ProductAdapter(getContext(), mHomeViewModel, MOST_VISITED_LIST_NUMBER);
            mBinding.recyclerViewMostVisited.setAdapter(mProductAdapterMostVisited);
        }
        mProductAdapterMostVisited.setProductList(products);
        mProductAdapterMostVisited.notifyDataSetChanged();
    }

    private void setupMostPopularList() {
        mLiveDataListMostPopular = mHomeViewModel.getLiveDataMostPopularList();
        mBinding.recyclerViewMostPopular.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL,
                true));
//        mBinding.recyclerViewMostPopular.setAdapter(mProductAdapterMostPopular);
        mLiveDataListMostPopular.observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
//                mProductAdapterMostPopular.setProductList(products);
                setMostPopulardAdapter(products);
            }
        });
    }

    private void setMostPopulardAdapter(List<Product> products) {
        if (mProductAdapterMostPopular == null) {
            mProductAdapterMostPopular = new ProductAdapter(getContext(), mHomeViewModel, MOST_POPULAR_LIST_NUMBER);
            mBinding.recyclerViewMostPopular.setAdapter(mProductAdapterMostPopular);
        }
        mProductAdapterMostPopular.setProductList(products);
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