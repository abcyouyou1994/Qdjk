package com.example.administrator.gjdzzpapp.model.inter;

import com.example.administrator.gjdzzpapp.presenter.callback.CallBack;

public interface IMainAModel {
    void login(String phone, String password, CallBack callBack);
}
