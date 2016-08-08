package com.thinker.crystal.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.thinker.crystal.myapplication.R;
import com.thinker.crystal.myapplication.activity.MainActivity;
import com.thinker.crystal.myapplication.databinding.AdapterCleaningCategoryBinding;
import com.thinker.crystal.myapplication.model.CleaningCategory;

import java.util.List;

/**
 * Created by techjini on 3/8/16.
 */
public class CleaningCategoryAdapter extends RecyclerView.Adapter<CleaningCategoryAdapter.CleaningCategoryViewHolder> {
    private final List<CleaningCategory> mList;

    private Context mContext;

    public CleaningCategoryAdapter(Context context, List<CleaningCategory> list) {
        mContext = context;
        mList = list;

    }

    @Override
    public CleaningCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterCleaningCategoryBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.adapter_cleaning_category, parent, false);
        return new CleaningCategoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CleaningCategoryViewHolder holder, int position) {
        holder.mBinding.setData(mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class CleaningCategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final AdapterCleaningCategoryBinding mBinding;

        public CleaningCategoryViewHolder(AdapterCleaningCategoryBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mBinding.setHandler(this);

        }

        @Override
        public void onClick(View v) {
            if (!((MainActivity) mContext).isSpinnerSelected()) {
                Toast.makeText(mContext, "Select Location First", Toast.LENGTH_LONG).show();
                return;
            }
            if (mList.get(getLayoutPosition()).isChecked()) {
                mList.get(getLayoutPosition()).setChecked(false);
                mList.get(getLayoutPosition()).notifyChange();
            } else {
                mList.get(getLayoutPosition()).setChecked(true);
                mList.get(getLayoutPosition()).notifyChange();
            }
        }
    }

}
