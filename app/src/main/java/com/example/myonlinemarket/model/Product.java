package com.example.myonlinemarket.model;

import android.text.Html;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private String mName;
    private String mDescription;
    private String mPrice;
    private List<String> mImageUrls;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public List<String> getImageUrls() {
        return mImageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        mImageUrls = imageUrls;
    }

    public String getDescription() {
        return Html.fromHtml(mDescription).toString();
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    /*public String getFetcherImage(){
        if (mImageUrls == null || mImageUrls.size()==0)
            return null;
        return mImageUrls.get(0);
    }*/

    public Product(String name, String description, String price, List<String> ImageUrls) {
        mName = name;
        mDescription = description;
        mPrice = price;
        mImageUrls = ImageUrls;
    }
}
