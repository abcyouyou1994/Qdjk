package com.example.administrator.gjdzzpapp.model.inter;

import com.example.administrator.gjdzzpapp.presenter.callback.CallBack;

import javax.security.auth.callback.Callback;

public interface IOperationAModel {
    void getDZZPData(String token, final CallBack callBack);
}