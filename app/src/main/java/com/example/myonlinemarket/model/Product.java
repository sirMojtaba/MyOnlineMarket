package com.example.myonlinemarket.model;

import android.text.Html;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private String mName;
    private String mDescription;
    private String mPrice;
    private List<String> mURL;

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

    public List<String> getURL() {
        return mURL;
    }

    public void setURL(List<String> URL) {
        mURL = URL;
    }

    public String getDescription() {
        return Html.fromHtml(mDescription).toString();
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Product(String name, String description, String price, List<String> URL) {
        mName = name;
        mDescription = description;
        mPrice = price;
        mURL = URL;
    }
}
