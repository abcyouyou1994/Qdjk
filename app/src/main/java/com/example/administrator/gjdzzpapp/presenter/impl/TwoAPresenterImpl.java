package com.example.administrator.gjdzzpapp.presenter.impl;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

import com.example.administrator.gjdzzpapp.model.impl.TwoAModelImpl;
import com.example.administrator.gjdzzpapp.model.inter.ITwoAModel;
import com.example.administrator.gjdzzpapp.presenter.callback.CallBack;
import com.example.administrator.gjdzzpapp.presenter.inter.ITwoAPresenter;
import com.example.administrator.gjdzzpapp.view.inter.IMainAView;
import com.example.administrator.gjdzzpapp.view.inter.ITwoAView;

public class TwoAPresenterImpl implements ITwoAPresenter {
    private ITwoAView mITwoAView;
    private ITwoAModel mITwoAModel;
    private BluetoothAdapter mbluetoothadapter = BluetoothAdapter.getDefaultAdapter();

    public TwoAPresenterImpl(ITwoAView aITwoAView) {
        mITwoAView = aITwoAView;
        mITwoAModel = new TwoAModelImpl();
    }


    @Override
    public void getData() {
        mITwoAModel.getData(mITwoAView.getToken(), new CallBack() {
            @Override
            public void onSuccess(Object response) {
                mITwoAView.response(response, IMainAView.RESPONSE_ONE,2);

                mITwoAView.showToast("数据请求成功");
            }

            @Override
            public void onError(String t) {
                mITwoAView.response(mITwoAModel, IMainAView.RESPONSE_TWO,2);
               
                mITwoAView.showToast(t);
            }

            @Override
            public void onDataChange(String data) {

            }
        });
    }

    @Override
    public void getBle() {
        CallBack callBack=new CallBack()  {
            @Override
            public void onSuccess(Object response) {
                mITwoAView.response(response,IMainAView.RESPONSE_ONE,1);
                mITwoAView.showToast("蓝牙打开成功");
            }

            @Override
            public void onError(String t) {
                mITwoAView.response(mITwoAModel,IMainAView.RESPONSE_TWO,1);
                mITwoAView.showToast(t);
            }

            @Override
            public void onDataChange(String data) {

            }
        };
        boolean a = false;
        if(mbluetoothadapter==null){
            mITwoAView.showToast("本手机无蓝牙功能");
            //shandiao

            a=false;
           callBack.onError("蓝牙开启失败！");
        }else if (!mbluetoothadapter.isEnabled()){
            mbluetoothadapter.enable();
            callBack.onSuccess(mbluetoothadapter);
           a=true;


        }


    }

    @Override
    public void getOperation() {
        mITwoAView.showToast("跳转到维护界面");

    }
}
