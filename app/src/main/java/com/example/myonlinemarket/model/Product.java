package com.example.myonlinemarket.model;

import java.util.List;

public class Product {
    private String mName;
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

    public Product(String name, String price, List<String> URL) {
        mName = name;
        mPrice = price;
        mURL = URL;
    }
}
