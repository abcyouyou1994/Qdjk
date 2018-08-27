package com.example.administrator.gjdzzpapp.prorocol;

public interface CMD {
    int swm=0x01&0xff;//查询工作模式
    int ssp=0x02&0xff;//设置屏参
    int rsp=0x03&0xff;//读取屏参
    int wrs=0x04&0xff;//文字报站设置
    int wrsr=0x05&0xff;//文字报站设置读取
    int cs=0x06&0xff;//小车设置
    int rcs=0x07&0xff;//小车设置读取
    int xlxxsz=0x08&0xff;//线路信息设置
    int xlxxdq=0x09&0xff;//线路信息读取
    int xcxlxxzbsz=0x0a&0xff;//小车线路站点信息设置
    int fqsz=0x2a&0xff;//分区设置
    int ryjxxdq=0x0b&0xff;//软硬件信息读取
    int wddq=0x0c&0xff;//温度读取
    int sjsz=0x0d&0xff;//时间设置
    int sjdq=0x0e&0xff;//时间读取
    int xtsz=0x20&0xff;//心跳设置
    int qr=0x22&0xff;//确认
    int txcssz=0x21&0xff;//通讯参数设置
    int txcsdq=0x23&0xff;//通讯参数读取
    int cxsbbh=0x24&0xff;//查询设备编号
    int szsbbh=0x25&0xff;//设置设备编号
    int hfgzms= 0x81;//回复工作模式
    int con= 0x82;//确认屏参
    int hfpcxx= 0x83;//回复屏参信息
    int hfwzbzszxx=0x85;//回复文字报站设置信息
    int hfxcszdq= 0x87;//回复小车设置读取
    int hfxlxxdq= 0x89;//回复线路信息读取
    int hfryjxxdq= 0x8b;//回复软硬件信息读取
    int hfwddq= 0x8c;//回复温度读取
    int hfsjdq= 0x8e;//回复时间读取
    int xtfs= 0x72;//心跳发送
    int hftxcsdq= 0x73;//回复通讯参数设置
    int hfcxsbbh= 0x74;//回复查询设备编号
    int carzt1=0x01&0xff;//小车状态zou
    int carzt2=0x02&0xff;//小车状态停
    int usualpoint=0x00&0xff;//平常点
    int ostation=0x01&0xff;//起点
    int lostation=0x02&0xff;//当前点
    int estation=0x03&0xff;//结束点
}
