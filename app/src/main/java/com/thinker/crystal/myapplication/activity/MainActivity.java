package com.thinker.crystal.myapplication.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.adapters.AdapterViewBindingAdapter;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
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

public class MainActivity extends BaseActivity implements View.OnClickListener {


    private ActivityMainBinding mBinding;
    private HintAdapter mLevelOneAdapter, mLevelTwoAdapter;
    private boolean isLevelOneSelected, isLevelTwoSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
    }

    public boolean isSpinnerSelected() {
        return isLevelOneSelected && isLevelTwoSelected;
    }

    public void init() {
        setTitle("Select Area");
        mBinding.setHandler(this);
        mLevelOneAdapter = new HintAdapter(this, android.R.layout.simple_spinner_dropdown_item, DummyData.getLevelOneData());
        mBinding.spinLevelOne.setAdapter(mLevelOneAdapter);
        mBinding.spinLevelTwo.setEnabled(false);
        mBinding.spinLevelOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mLevelOneAdapter.size() - 1 != position) {
                    isLevelOneSelected = true;
                    mBinding.spinLevelTwo.setEnabled(true);
                    mBinding.levelOneTic.setImageResource(R.drawable.ic_tick_mark_active);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mBinding.spinLevelOne.setSelection(mLevelOneAdapter.getCount());

        mLevelTwoAdapter = new HintAdapter(this, android.R.layout.simple_spinner_dropdown_item, DummyData.getLevelTwoData());
        mBinding.spinLevelTwo.setAdapter(mLevelTwoAdapter);
        mBinding.spinLevelTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mLevelTwoAdapter.size() - 1 != position) {
                    isLevelTwoSelected = true;
                    mBinding.levelTwoTick.setImageResource(R.drawable.ic_tick_mark_active);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mBinding.spinLevelTwo.setSelection(mLevelTwoAdapter.getCount());
        mBinding.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mBinding.recyclerView.setAdapter(new CleaningCategoryAdapter(this, DummyData.getCleaningCategoryList()));
    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, CleansingSelectionActivity.class));
    }


}
