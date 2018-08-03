package com.example.administrator.gjdzzpapp.view.inter;

public interface ble_DebugView {
    void sendData();
   <T> void response(T response, int responseFlag,int btnflag);
    <T> T request(int requestFlag);
    void showToast(String msg);

}
