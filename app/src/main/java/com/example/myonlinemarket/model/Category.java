package com.example.myonlinemarket.model;

public class Category {

    private String mName;
    private int mId;
    private int mParentId;

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

    public Category(String name, int id, int parentId) {
        mName = name;
        mId = id;
        mParentId = parentId;
    }
}
