package com.thinker.crystal.myapplication.activity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.thinker.crystal.myapplication.R;
import com.thinker.crystal.myapplication.databinding.ActivityQuotationBinding;
import com.thinker.crystal.myapplication.dialog.QuotationSucessDialog;

/**
 * Created by techjini on 8/8/16.
 */
public class QuotationActivity extends BaseActivity implements View.OnClickListener, QuotationSucessDialog.DialogListner {
    private ActivityQuotationBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_quotation);
        mBinding.emailId.setText(getPrimaryEmail());
        mBinding.setHandler(this);
        setTitle("Quotation");
    }

    private String getPrimaryEmail() {
        Account[] accounts = AccountManager.get(this).getAccounts();
        String primaryEmail = null;
        if (accounts != null && accounts.length > 0) {
            for (Account account : accounts) {
                if (account.type.equals("com.google")) {
                    primaryEmail = account.name;
                }
            }
        }
        if (!TextUtils.isEmpty(primaryEmail)) {
            return String.valueOf(primaryEmail);
        }
        return "";
    }

    @Override
    public void onClick(View v) {
        QuotationSucessDialog successDialog = QuotationSucessDialog.newInstance("Thanks for choosing our service \n we'll get back to you");
        successDialog.setDialogListner(this);
        successDialog.show(getFragmentManager(), "Sucess");
    }

    @Override
    public void onDialogButtonClicked() {
        startActivity(new Intent(this, MainActivity.class).
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }
}
