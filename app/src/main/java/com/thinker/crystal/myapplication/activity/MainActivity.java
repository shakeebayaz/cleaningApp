package com.thinker.crystal.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.databinding.adapters.AdapterViewBindingAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.thinker.crystal.myapplication.R;
import com.thinker.crystal.myapplication.adapter.CleaningCategoryAdapter;
import com.thinker.crystal.myapplication.adapter.HintAdapter;
import com.thinker.crystal.myapplication.databinding.ActivityMainBinding;
import com.thinker.crystal.myapplication.model.CleaningCategory;
import com.thinker.crystal.myapplication.util.Constants;

public class MainActivity extends BaseActivity  {


    private ActivityMainBinding mBinding;
    private HintAdapter mLevelOneAdapter, mLevelTwoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
    }

    public void init() {
        setTitle("Select Area");
        mLevelOneAdapter = new HintAdapter(this, android.R.layout.simple_spinner_dropdown_item, DummyData.getLevelOneData());
        mBinding.spinLevelOne.setAdapter(mLevelOneAdapter);
        //mBinding.spinLevelOne.setOnItemSelectedListener(this);
        mBinding.spinLevelOne.setSelection(mLevelOneAdapter.getCount());

        mLevelTwoAdapter = new HintAdapter(this, android.R.layout.simple_spinner_dropdown_item, DummyData.getLevelTwoData());
        mBinding.spinLevelTwo.setAdapter(mLevelTwoAdapter);
      //  mBinding.spinLevelTwo.setOnItemSelectedListener(this);
        mBinding.spinLevelTwo.setSelection(mLevelTwoAdapter.getCount());
        mBinding.recyclerView.setAdapter(new CleaningCategoryAdapter(this, DummyData.getCleaningCategoryList()));
    }


}
