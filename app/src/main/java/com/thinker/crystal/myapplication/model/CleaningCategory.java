package com.thinker.crystal.myapplication.model;

import android.databinding.BaseObservable;
import android.databinding.Observable;

/**
 * Created by techjini on 3/8/16.
 */
public class CleaningCategory extends BaseObservable {
    private String categoryName;
    private int categoryId;
    private boolean isChecked;

    public String getCategoryName() {
        return categoryName;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
