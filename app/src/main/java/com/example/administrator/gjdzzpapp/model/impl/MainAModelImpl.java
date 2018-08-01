package com.example.administrator.gjdzzpapp.model.impl;

import android.os.Handler;
import android.os.Looper;

import com.example.administrator.gjdzzpapp.model.inter.IMainAModel;
import com.example.administrator.gjdzzpapp.presenter.callback.CallBack;

public class MainAModelImpl implements IMainAModel {
    private Handler handler = new Handler(Looper.getMainLooper());//主线程handler一步处理

    String usernamep="admin";//从moudle层查询用户以及其对应密码
    String upassword="admin";
    String sss="我是"+usernamep+"用户";//从moudle层读取是哪个用户
    @Override
    public void login(final String username, final String password, final CallBack callBack) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(username.equals(usernamep)&&password.equals(upassword))

                    callBack.onSuccess(sss);
                else
                   callBack.onError("用户名密码错误，请重新输入");
            }
        }, 2000);
    }


}
