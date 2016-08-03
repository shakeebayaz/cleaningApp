package com.thinker.crystal.myapplication.activity;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.thinker.crystal.myapplication.R;

/**
 * Created by techjini on 3/8/16.
 */
public class BaseActivity  extends AppCompatActivity {
    private Toolbar mToolbar;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);

            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    public void setTitle(String title) {
        if (mToolbar != null) {
            mToolbar.setTitle(title);
        }
    }
}
