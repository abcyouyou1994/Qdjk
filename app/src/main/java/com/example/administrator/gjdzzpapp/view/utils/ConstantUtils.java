package com.example.administrator.gjdzzpapp.view.utils;

public interface ConstantUtils {
    /**
     * 加载界面的两种状态
     */
    String State_bltConnect="connect";
    String STATE_SUCCESSED = "dtz";
    String STATE_FAILED = null;
    /**
     * 根据资源id跳转的界面
     */
    int PARAM2_DEBUG = 1;// 两字屏调试
    int CAR_DEBUG = 2;// 小车屏调试


    /**
     * 界面中的一些常亮
     */
    String RETURN_BLT = "return_blt";// 返回界面
    /*
    接收蓝牙数据标志
     */
    int MESSAGE_COMPLETE=1;
    int MESSAGE_FAILED=2;
}
