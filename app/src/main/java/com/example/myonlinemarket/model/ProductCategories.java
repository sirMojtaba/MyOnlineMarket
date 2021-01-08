package com.example.myonlinemarket.model;

public class ProductCategories {

    private String mName;
    private String mId;
    private String mParentId;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getParentId() {
        return mParentId;
    }

    public void setParentId(String parentId) {
        mParentId = parentId;
    }

    public ProductCategories(String name, String id, String parentId) {
        mName = name;
        mId = id;
        mParentId = parentId;
    }
}
