package com.thinker.crystal.myapplication.model;

import android.databinding.BaseObservable;

/**
 * Created by Shakeeb on 5/8/16.
 */
public class CleaningSelection extends BaseObservable {
    private float rate;
    private String cleaningSectionName;
    private int totalCount;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getCleaningSectionName() {
        return cleaningSectionName;
    }

    public void setCleaningSectionName(String cleaningSectionName) {
        this.cleaningSectionName = cleaningSectionName;
    }
}
