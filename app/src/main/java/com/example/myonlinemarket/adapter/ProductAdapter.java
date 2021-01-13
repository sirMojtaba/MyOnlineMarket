package com.example.myonlinemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myonlinemarket.R;
import com.example.myonlinemarket.databinding.ProductListItemBinding;
import com.example.myonlinemarket.model.Product;
import com.example.myonlinemarket.ui.home.HomeViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Product> mProductList = new ArrayList<>();
    private HomeViewModel mHomeViewModel;
    private Context mContext;
    public static final int ITEM_TYPE_ONE = 0;
    public static final int ITEM_TYPE_TWO = 1;
    private int mListNumber;

    public void setProductList(List<Product> productList) {
        mProductList = productList;
    }

    public ProductAdapter(Context context, HomeViewModel homeViewModel, int listNumber) {
        mContext = context;
        mHomeViewModel = homeViewModel;
        mListNumber = listNumber;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == ITEM_TYPE_ONE) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.product_list_first_item, parent, false);
            return new ImageViewHolder(view);
        } else {
            ProductListItemBinding binding = DataBindingUtil.inflate(
                    LayoutInflater.from(mContext),
                    R.layout.product_list_item,
                    parent,
                    false);
            return new ProductViewHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ImageViewHolder) {

            Picasso.get()
                    .load(imageId())
                    .centerInside()
                    .fit()
                    .into(((ImageViewHolder) holder).mImageView);
        } else {
            ((ProductViewHolder) holder).bindProduct(position - 1);
        }
    }

    public int imageId() {
        switch (mListNumber) {
            case 0:
               return R.drawable.newestlistfirstitem;
            case 1:
                return R.drawable.mostvisited;
            case 2:
                return R.drawable.mostpopular;
            default:
                return -1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_TYPE_ONE;
        } else {
            return ITEM_TYPE_TWO;
        }
    }

    @Override
    public int getItemCount() {
        return (mProductList.size());
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
            mBinding.textViewPrice.setText(mProduct.getPrice());
            Picasso.get()
                    .load(mProduct.getImageUrls().get(0))
                    .fit()
                    .centerInside()
                    .into(mBinding.imageView);
        }
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.image_view_first_item);
        }
    }
}
