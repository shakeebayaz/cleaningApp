package com.thinker.crystal.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import com.thinker.crystal.myapplication.R;
import com.thinker.crystal.myapplication.util.Constants;


public class SplashActivity extends Activity {
    Thread splashTread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(Constants.SPLASH_TIME);

                        finish();
                        navigateTo(MainActivity.class);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        splashTread.start();

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            synchronized (splashTread) {
                splashTread.notifyAll();
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (splashTread.isAlive())
            splashTread.interrupt();
        finish();
    }

    private void navigateTo(@SuppressWarnings("rawtypes") Class class_name) {
        startActivity(new Intent(SplashActivity.this, class_name));
    }

    @Override
    public void finish() {
        super.finish();
    }

}
