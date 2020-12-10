package com.example.myonlinemarket;

public class Product {
    private String mName;
    private String mPrice;

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

    public Product(String name, String price) {
        mName = name;
        mPrice = price;
    }
}
