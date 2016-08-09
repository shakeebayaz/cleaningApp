package com.thinker.crystal.myapplication.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.thinker.crystal.myapplication.util.Constants;

/**
 * Created by Shakeeb on 28/1/16.
 */
public class QuotationSucessDialog extends DialogFragment {
    private DialogListner dialogOkListner;
    private String mMessage;
    public interface DialogListner{
        void onDialogButtonClicked();
    }

    public void setDialogListner(DialogListner listener){
        dialogOkListner=listener;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        return new AlertDialog.Builder(getActivity())
                // Set Dialog Icon
                        // Set Dialog Title
                .setTitle("Success")
                                 // Set Dialog Message
                .setMessage(mMessage)

                        // Positive button
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if(dialogOkListner!=null)
                        dialogOkListner.onDialogButtonClicked();

                    }
                })
                  .create();
    }
    //
    public static QuotationSucessDialog newInstance(String message) {
        QuotationSucessDialog fragment = new QuotationSucessDialog();
        Bundle args = new Bundle();
        args.putString(Constants.BundleKeys.DialogTitle, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMessage = getArguments().getString(Constants.BundleKeys.DialogTitle);
        }
    }



}
