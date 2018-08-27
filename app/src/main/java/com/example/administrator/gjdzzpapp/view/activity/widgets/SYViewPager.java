package com.example.administrator.gjdzzpapp.view.activity.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class SYViewPager extends ViewPager {
    float preX;
    float preY;
    public SYViewPager(@NonNull Context context) {
        super(context);
    }

    public SYViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public boolean onInterceptTouchEvent(MotionEvent event){
        boolean res=super.onInterceptTouchEvent(event);
        if (event.getAction()==MotionEvent.ACTION_DOWN){
            preX=event.getX();
            preY=event.getY();
        }else {
            preX=event.getX();
            preY=event.getY();
        }
        return res;
    }
}
