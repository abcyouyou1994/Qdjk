package com.example.administrator.gjdzzpapp.model.impl;

import android.os.Handler;
import android.os.Looper;

import com.example.administrator.gjdzzpapp.model.inter.IMainAModel;
import com.example.administrator.gjdzzpapp.presenter.callback.CallBack;

public class MainAModelImpl implements IMainAModel {
    private Handler handler = new Handler(Looper.getMainLooper());//主线程handler一步处理
    String sss="我是A用户";
    @Override
    public void login(final String phone, final String password, final CallBack callBack) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(phone.equals("13641222647")&&password.equals("123456"))

                    callBack.onSuccess(sss);
                else
                   callBack.onError("用户名密码错误，请重新输入");
            }
        }, 2000);
    }
}
