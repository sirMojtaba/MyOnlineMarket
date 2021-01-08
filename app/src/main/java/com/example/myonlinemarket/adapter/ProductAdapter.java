package com.example.myonlinemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myonlinemarket.databinding.ProductListItemBinding;
import com.example.myonlinemarket.model.Product;
import com.example.myonlinemarket.R;
import com.example.myonlinemarket.ui.home.HomeViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context mContext;
    private List<Product> mProductList = new ArrayList<>();
    private HomeViewModel mHomeViewModel;

    public void setProductList(List<Product> productList) {
        mProductList = productList;
        notifyDataSetChanged();
    }

    public ProductAdapter(Context context, HomeViewModel homeViewModel) {
        mContext = context.getApplicationContext();
        mHomeViewModel = homeViewModel;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.product_list_item,
                parent,
                false);
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.bindProduct(position);
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private ProductListItemBinding mBinding;
        private Product mProduct;

        public ProductViewHolder(ProductListItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mBinding.setViewmodel(mHomeViewModel);
        }

        private void bindProduct(int position) {
            mBinding.setPosition(position);
            mBinding.executePendingBindings();
            mProduct = mProductList.get(position);
            mBinding.textViewTitle.setText(mProduct.getName());
            mBinding.textViewPrice.setText(mProduct.getPrice() + " تومان");
            Picasso.get()
                    .load(mProduct.getImageUrls().get(0))
                    .fit()
                    .centerInside()
                    .into(mBinding.imageView);
        }
    }
}
