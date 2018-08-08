package com.example.administrator.gjdzzpapp.model.inter;

import com.example.administrator.gjdzzpapp.presenter.callback.CallBack;

public interface IOperationAModel {
    void getDZZPData(String token, final CallBack callBack);
}
