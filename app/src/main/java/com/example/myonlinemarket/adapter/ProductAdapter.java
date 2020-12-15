package com.example.myonlinemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myonlinemarket.model.Product;
import com.example.myonlinemarket.R;
import com.example.myonlinemarket.databinding.ListItemProductBinding;
import com.example.myonlinemarket.ui.home.HomeViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context mContext;
    private List<Product> mProductList = new ArrayList<>();
    private HomeViewModel mHomeViewModel;

    public List<Product> getProductList() {
        return mProductList;
    }

    public void setProductList(List<Product> productList) {
        mProductList = productList;
    }

    public ProductAdapter(Context context, HomeViewModel homeViewModel) {
        mContext = context.getApplicationContext();
        mHomeViewModel = homeViewModel;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemProductBinding listItemProductBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.list_item_product,
                parent,
                false);
        return new ProductViewHolder(listItemProductBinding);
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
        private ListItemProductBinding mListItemProductBinding;
        private Product mProduct;

        public ProductViewHolder(ListItemProductBinding listItemProductBinding) {
            super(listItemProductBinding.getRoot());
            mListItemProductBinding = listItemProductBinding;
            mListItemProductBinding.setViewmodel(mHomeViewModel);
        }

        private void bindProduct(int position) {
            mListItemProductBinding.setPosition(position);
            mListItemProductBinding.executePendingBindings();
            mProduct = mProductList.get(position);
            mListItemProductBinding.textViewTitle.setText(mProduct.getName());
            mListItemProductBinding.textViewPrice.setText(mProduct.getPrice() + " تومان");
            Picasso.get()
                    .load(mProduct.getURL().get(0))
                    .into(mListItemProductBinding.imageView);
        }
    }
}
