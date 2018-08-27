package com.example.administrator.gjdzzpapp.view.activity.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;


public class NoScrollView extends ViewPager {
    public NoScrollView( Context context) {
        super(context);
    }

    public NoScrollView( Context context,  AttributeSet attrs) {
        super(context, attrs);
    }
    public boolean onTouchEvent(MotionEvent ev){
        return false;
    }
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }
}
