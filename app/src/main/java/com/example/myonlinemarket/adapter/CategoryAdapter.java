package com.example.myonlinemarket.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myonlinemarket.R;
import com.example.myonlinemarket.databinding.CategoryListItemBinding;
import com.example.myonlinemarket.model.ProductCategories;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context mContext;
    private List<ProductCategories> mCategoryList = new ArrayList<>();

    public void setCategoryList(List<ProductCategories> categoryList) {
        mCategoryList = categoryList;
        notifyDataSetChanged();
    }

    public CategoryAdapter(Context context) {
        mContext = context.getApplicationContext();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryListItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(mContext),
                R.layout.category_list_item,
                parent,
                false);
        return new CategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        holder.mBinding.textViewTitle.setText(mCategoryList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }


    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        CategoryListItemBinding mBinding;


        public CategoryViewHolder(CategoryListItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}
