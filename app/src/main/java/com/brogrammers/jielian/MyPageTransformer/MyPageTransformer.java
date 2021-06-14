package com.brogrammers.jielian.MyPageTransformer;

import android.util.DisplayMetrics;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.viewpager2.widget.ViewPager2;

import org.jetbrains.annotations.NotNull;

public class MyPageTransformer implements ViewPager2.PageTransformer {


    @Override
    public void transformPage(@NonNull @NotNull View page, float position) {

//        float absPos = Math.abs(position);
//
//        page.setTranslationX(absPos * 500f);
//        page.setTranslationY(absPos * 500f);
//        page.setScaleX(1f);
//        page.setScaleY(1f);
//
//        if (position < -1) {
//            page.setAlpha(0.1f);
//
//            if (position <= 1) {
//                page.setAlpha(Math.max(0.2f, 1 - Math.abs(position)));
//            } else {
//                page.setAlpha(0.1f);
//            }
//        }

        ViewPager2 viewPager = (ViewPager2) page.getParent().getParent();
        float offset = position * -(2 * 30 + 20);

        if (viewPager.getOrientation() == ViewPager2.ORIENTATION_HORIZONTAL) {
            if (ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                page.setTranslationX(-offset);
            } else {
                page.setTranslationX(offset);
            }
        } else {
            page.setTranslationY(offset);
        }

    }

}
