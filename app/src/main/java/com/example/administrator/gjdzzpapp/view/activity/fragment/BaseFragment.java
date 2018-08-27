package com.example.administrator.gjdzzpapp.view.activity.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.gjdzzpapp.view.activity.BleActivity;
import com.example.administrator.gjdzzpapp.view.activity.fgactivity.bleActivity;
import com.example.administrator.gjdzzpapp.view.utils.ContentPage;

import java.util.ArrayList;

public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    public ContentPage contentPage;
    public ProgressDialog pdLoading;
    private bleActivity bactivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bactivity=(bleActivity)getActivity();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        /**
         * 初始化pdLoading
         */
        pdLoading = new ProgressDialog(getActivity());
        pdLoading.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pdLoading.setMessage("请稍后");
        pdLoading.setCanceledOnTouchOutside(false);
        pdLoading.setCancelable(true);
        getSuccessView();
        return contentPage;
    }

    protected abstract View getSuccessView();
    public abstract void send(String s);

    //蓝牙接受返回数据
    protected abstract Object requestData();
}
