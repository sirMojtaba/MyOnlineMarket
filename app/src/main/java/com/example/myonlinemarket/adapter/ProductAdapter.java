package com.example.myonlinemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myonlinemarket.model.Product;
import com.example.myonlinemarket.R;
import com.example.myonlinemarket.databinding.RecyclerItemBinding;
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
        RecyclerItemBinding recyclerItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.recycler_item,
                parent,
                false);
        return new ProductViewHolder(recyclerItemBinding);
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
        private RecyclerItemBinding mRecyclerItemBinding;
        private Product mProduct;

        public ProductViewHolder(RecyclerItemBinding recyclerItemBinding) {
            super(recyclerItemBinding.getRoot());
            mRecyclerItemBinding = recyclerItemBinding;
            mRecyclerItemBinding.setViewmodel(mHomeViewModel);
        }

        private void bindProduct(int position) {
            mRecyclerItemBinding.setPosition(position);
            mRecyclerItemBinding.executePendingBindings();
            mProduct = mProductList.get(position);
            mRecyclerItemBinding.textViewTitle.setText(mProduct.getName());
            mRecyclerItemBinding.textViewPrice.setText(mProduct.getPrice() + " تومان");
            Picasso.get()
                    .load(mProduct.getImageUrls().get(0))
                    .fit()
                    .centerInside()
                    .into(mRecyclerItemBinding.imageView);
        }
    }
}
