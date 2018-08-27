package com.example.administrator.gjdzzpapp.view.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public abstract class ContentPage extends FrameLayout {
    public ContentPage(Context context) {
        super(context);
    }

    public ContentPage( Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public ContentPage( Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //定义加载状态常量
    enum PageState{
        STATE_LOADING(0),
        STATE_SUCCESS(1),
        STATE_ERROR(2);

        private int value;

        PageState(int value) {
            this.value=value;
        }
        public int getValue(){return value;}
    }

    private PageState mstate=PageState.STATE_LOADING;
    private View loadingView;
    private View errorview;
    private View successView;

}
