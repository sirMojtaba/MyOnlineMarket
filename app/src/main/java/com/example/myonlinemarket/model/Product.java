package com.example.myonlinemarket.model;

import android.net.Uri;

import java.net.URI;
import java.net.URL;

import retrofit2.http.Url;

public class Product {
    private String mName;
    private String mPrice;
    private Uri mURL;

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

    public Uri getURL() {
        return mURL;
    }

    public void setURL(Uri URL) {
        mURL = URL;
    }

    public Product(String name, String price) {
        mName = name;
        mPrice = price;
    }
}
