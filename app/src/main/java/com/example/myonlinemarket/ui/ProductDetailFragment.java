package com.example.myonlinemarket.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myonlinemarket.R;
import com.example.myonlinemarket.adapter.SliderAdapter;
import com.example.myonlinemarket.databinding.FragmentProductDetailBinding;
import com.example.myonlinemarket.model.Product;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;


public class ProductDetailFragment extends Fragment {

    public Product mProduct;
    private FragmentProductDetailBinding mBinding;

    public ProductDetailFragment() {
        // Required empty public constructor
    }

    public static ProductDetailFragment newInstance() {
        ProductDetailFragment fragment = new ProductDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProduct = (Product) getArguments().getSerializable("product");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail, container, false);
        mBinding.setProduct(mProduct);
        setupImageSlider();
        return mBinding.getRoot();
    }

    private void setupImageSlider() {
        mBinding.imageSlider.setSliderAdapter(new SliderAdapter(getContext(), mProduct.getImageUrls()));
        mBinding.imageSlider.setIndicatorAnimation(IndicatorAnimationType.SCALE);
        mBinding.imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
    }
}