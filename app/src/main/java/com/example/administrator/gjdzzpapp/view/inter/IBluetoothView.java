package com.example.administrator.gjdzzpapp.view.inter;

public interface IBluetoothView {
    //蓝牙状态
    public static final int MESSAGE_STATE_CHANGE = 1; // 状态改变
    public static final int MESSAGE_READ = 2;          // 读取数据
    public static final int MESSAGE_WRITE = 3;
    public static final int MESSAGE_DEVICE_NAME = 4;

    <T> T request(int requestFlag);

    <T> void response(T response, int responseFlag,int btn_flag);
     void showToast(String msg);
     void editText(String s);
}
