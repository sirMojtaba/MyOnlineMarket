package com.example.myonlinemarket.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

import com.example.myonlinemarket.R;
import com.example.myonlinemarket.databinding.FragmentProductDetailBinding;
import com.example.myonlinemarket.databinding.SliderItemBinding;
import com.example.myonlinemarket.model.Product;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;
    private SliderItemBinding mBinding;
    private List<String> mUrls;

    public SliderAdapter(Context context, List<String> urls) {
        this.context = context;
        this.mUrls = urls;
    }

    public void renewItems(List<String> urls) {
        this.mUrls = urls;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        this.mUrls.remove(position);
        notifyDataSetChanged();
    }

    public void addItem(String url) {
        this.mUrls.add(url);
        notifyDataSetChanged();
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        mBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.slider_item,
                parent,
                false);
        return new SliderAdapterVH(mBinding);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {
        Picasso.get()
                .load(mUrls.get(position))
                .fit()
                .centerInside()
                .into(viewHolder.mBinding.imageView);
    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return mUrls.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        SliderItemBinding mBinding;

        public SliderAdapterVH(SliderItemBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}