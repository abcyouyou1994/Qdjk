package com.example.administrator.gjdzzpapp.view.inter;

import com.example.administrator.gjdzzpapp.base.BaseMvpView;

public interface IMainAView extends BaseMvpView {
    //请求标记
    int REQUEST_ONE = 0;
    int REQUEST_TWO = 1;
    int REQUEST_THREE = 2;
    //响应标记
    int RESPONSE_ONE = 0;
    int RESPONSE_TWO = 1;
    int RESPONSE_THREE = 2;

    <T> T request(int requestFlag);

    <T> void response(T response, int responseFlag);

    /*新增*/
    void showToast(String msg);

    String getPhone();

    String getPassword();
}
