package com.targetupsc.education.android.Model;

import java.util.ArrayList;

public class CategoryDetailModel {

    String CategoryName, Description,id;

    ArrayList<String> mImagesList;

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getmImagesList() {
        return mImagesList;
    }

    public void setmImagesList(ArrayList<String> mImagesList) {
        this.mImagesList = mImagesList;
    }
}
