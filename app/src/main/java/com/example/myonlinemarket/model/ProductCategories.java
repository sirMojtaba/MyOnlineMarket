package com.example.myonlinemarket.model;

public class ProductCategories {

    private String mName;
    private int mId;
    private int mParentId;
    private String mImageUrl;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getParentId() {
        return mParentId;
    }

    public void setParentId(int parentId) {
        mParentId = parentId;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public ProductCategories(String name, int id, int parentId, String imageUrl) {
        mName = name;
        mId = id;
        mParentId = parentId;
        mImageUrl = imageUrl;
    }
}
