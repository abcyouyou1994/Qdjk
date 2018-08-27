package com.example.administrator.gjdzzpapp.view.utils;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.administrator.gjdzzpapp.app.AppApplication;
import com.example.administrator.gjdzzpapp.view.activity.fgactivity.ClickButtonActivity;

public class startUtils {
    public static void startActivityById(Context context, int resId){
        Intent intent = new Intent(AppApplication.getContext(), ClickButtonActivity.class);
        intent.putExtra("resId",resId);
        context.startActivity(intent);
    }
    public static void startActivityByIdForResult(Fragment activity, int resId , int requestCode){
        Intent intent = new Intent(AppApplication.getContext(), ClickButtonActivity.class);
        intent.putExtra("resId",resId);
        activity.startActivityForResult(intent,requestCode);
    }
}
