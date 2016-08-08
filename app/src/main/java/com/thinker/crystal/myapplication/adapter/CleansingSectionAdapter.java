package com.thinker.crystal.myapplication.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thinker.crystal.myapplication.R;
import com.thinker.crystal.myapplication.activity.CleansingSelectionActivity;
import com.thinker.crystal.myapplication.databinding.AdapterCleaningSectionBinding;
import com.thinker.crystal.myapplication.model.CleaningSelection;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by techjini on 5/8/16.
 */
public class CleansingSectionAdapter extends RecyclerView.Adapter<CleansingSectionAdapter.CleansingSectionViewHolder> {
    private final TotalAmountListener mListener;
    private Context mContext;
    private List<CleaningSelection> mList;

    public CleansingSectionAdapter(Context context, List<CleaningSelection> list, TotalAmountListener listener) {
        mList = list;
        mContext = context;
        mListener = listener;
    }


    @Override
    public CleansingSectionAdapter.CleansingSectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterCleaningSectionBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.adapter_cleaning_section, parent, false);
        return new CleansingSectionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(CleansingSectionAdapter.CleansingSectionViewHolder holder, int position) {
        holder.mBinding.setData(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class CleansingSectionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final AdapterCleaningSectionBinding mBinding;

        public CleansingSectionViewHolder(AdapterCleaningSectionBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mBinding.setHandler(this);

        }

        @Override
        public void onClick(View v) {
            mList.get(getLayoutPosition()).setTotalCount(mList.get(getLayoutPosition()).getTotalCount() + 1);
            mList.get(getLayoutPosition()).notifyChange();
            mListener.totalAmount(getTotal());
        }


        private float getTotal() {
            float total = 0;


            for (int i = 0; i < mList.size(); i++) {
                CleaningSelection mobj = mList.get(i);
                total = total + mobj.getRate() * mobj.getTotalCount();
            }

            return total;
        }
    }

    public interface TotalAmountListener {
         void totalAmount(float amount);
    }
}
