package com.Hanfu.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class Utils {
    /**
     * 弹出键盘
     */
    public static void showInput(final EditText et, Context context) {
        et.requestFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
        imm.showSoftInput(et, InputMethodManager.SHOW_IMPLICIT);
    }

    /**
     * 隐藏键盘
     */
    public static void hideInput(Context context, Activity activity) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
        View v = activity.getWindow().peekDecorView();
        if (null != v) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }

    /**
     * comment的动画
     */
    public static  void commentAnimate(Activity activity, Context context,EditText et, LinearLayout ll, CardView cv){
        ll.animate()
                .translationX(0)
                .alpha(1)
                .start();

        et.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                showInput(et, context);
                cv.animate()
                        .translationX(0)
                        .alpha(1)
                        .setInterpolator(new AccelerateDecelerateInterpolator())
                        .start();
                ll.animate()
                        .translationX(-100)
                        .alpha(0)
                        .start();
                ll.setVisibility(View.GONE);
                cv.setVisibility(View.VISIBLE);
            } else {
                hideInput(context, activity);
                ll.animate()
                        .translationX(0)
                        .alpha(1)
                        .setInterpolator(new AccelerateDecelerateInterpolator())
                        .start();
                cv.animate()
                        .translationX(-100)
                        .alpha(0)
                        .start();
                ll.setVisibility(View.VISIBLE);
                cv.setVisibility(View.GONE);
            }
        });
    }
}
