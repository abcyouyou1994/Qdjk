package com.example.administrator.gjdzzpapp.model.inter;

import com.example.administrator.gjdzzpapp.presenter.callback.CallBack;

public interface ITwoAModel {
    /*请求数据*/
    void getData(String token, CallBack callBack);
    void equipment_debug();
    void equipment_maintain();
    //  void getBle();
    // void getOperation();
}
