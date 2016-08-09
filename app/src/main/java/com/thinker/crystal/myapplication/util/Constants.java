package com.thinker.crystal.myapplication.util;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

/**
 * Created by shakeeb on 3/8/16.
 */
public class Constants {

    public static final int SPLASH_TIME = 2000;

    @BindingAdapter({"app:src"})
    public static void loadImageResource(ImageView view, String name) {
        try {
            Context context = view.getContext();
            int id = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
            view.setImageResource(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface BundleKeys {
        String DialogTitle = "com.thinker.crystal." + "dialogTitle";
    }
}
