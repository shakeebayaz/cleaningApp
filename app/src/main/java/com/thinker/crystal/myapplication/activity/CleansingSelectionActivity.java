package com.thinker.crystal.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.thinker.crystal.myapplication.R;
import com.thinker.crystal.myapplication.adapter.CleansingSectionAdapter;
import com.thinker.crystal.myapplication.databinding.ActivityCleaningSelectBinding;

/**
 * Created by Shakeeb on 5/8/16.
 */
public class CleansingSelectionActivity extends BaseActivity implements CleansingSectionAdapter.TotalAmountListener{
    private ActivityCleaningSelectBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_cleaning_select);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.setAdapter(new CleansingSectionAdapter(this, DummyData.getCleaningSectionList(),this));
        setTitle("Select Section");
    }

    @Override
    public void totalAmount(float amount) {
        mBinding.setTotal(amount);
    }
}
