package com.example.administrator.gjdzzpapp.prorocol;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.administrator.gjdzzpapp.presenter.callback.CallBack;
import com.example.administrator.gjdzzpapp.view.utils.ConstantUtils;

import java.io.UnsupportedEncodingException;

public class DecodingTool {
    static java.text.DecimalFormat nf = new java.text.DecimalFormat("00000000");
    static java.text.DecimalFormat nf1=new java.text.DecimalFormat("0000");
    private CallBack callBack;
    private static Handler mHandler;
    private ResultReduction resultReduction;

    public static void checkPackage(byte[] temInputBuffer) {
        byte[] temp=null;
        int flag=-1,len=0;
        for(int i=0;i<temInputBuffer.length;i++){
            if(temInputBuffer[i]==constantValue.head){
                flag=i;
                break;
            }
        }
        len=temInputBuffer[flag+1];
        for(int i=0;i<len;i++){
            temp[i]=temInputBuffer[i+flag];
        }
        if(temp[len]==constantValue.tail){
            String receive=EncodingTool.bytesToHexString(temp);
            Message msg=new Message();
            Bundle data=new Bundle();
            data.putString("dtz",receive);
            msg.what=ConstantUtils.MESSAGE_COMPLETE;
            msg.setData(data);
            mHandler.sendMessage(msg);
        }
            else {
            Message msg=mHandler.obtainMessage(ConstantUtils.MESSAGE_FAILED);
            Bundle bundle=new Bundle();
            bundle.putString("error","信息不完整");
            msg.setData(bundle);
            mHandler.sendMessage(msg);
        }
    }

    public void getResponse(int rcmd, String srdata) throws UnsupportedEncodingException {
        // TODO Auto-generated method stub
        switch(rcmd&0xff) {
            case CMD.hfgzms:
                resultReduction.getHfgzms(srdata);//回复工作模式
                break;
            case CMD.con:
                resultReduction.getCon(srdata);//通用确认消息
                break;
            case CMD.hfpcxx:
                resultReduction.getHfpcxx(srdata);//回复屏参信息
                break;
            case CMD.hfwzbzszxx:
                resultReduction.getHfwzbzszxx(srdata);//回复文字报站设置信息
                break;
            case CMD.hfxcszdq:
                resultReduction.getHfxcszdq(srdata);//回复小车设置读取
                break;
            case CMD.hfxlxxdq:
                resultReduction.getHfxlxxdq(srdata);//回复线路信息读取
                break;
            case CMD.hfryjxxdq:
                resultReduction.getHfryjxxdq(srdata);//回复软硬件信息读取
                break;
            case CMD.hfwddq:
                resultReduction.getHfwddq(srdata);//回复温度读取
                break;
            case CMD.hfsjdq:
                resultReduction.getHfsjdq(srdata);//回复时间读取
                break;
            case CMD.xtfs:
                resultReduction.getXtfs(srdata);//心跳发送
                break;
            case CMD.hftxcsdq:
                resultReduction.getHftxcsdq(srdata);//回复通讯参数读取
                break;
            case CMD.hfcxsbbh:
                resultReduction.getHfcxsbbh(srdata);//回复查询设备编号
                break;
            default:

                break;
        }
    }
    public static String getpolorityIndex(String substring) {

        // TODO Auto-generated method stub
        String i=null;
        switch(substring) {
            case "00":
                i="0";
                break;
            case "01":
                i="1";
                break;
        }
        return i;
    }

    public static String getscantypeIndex(String substring) {
        // TODO Auto-generated method stub
        String i=null;
        switch(substring) {
            case "61":
                i="1/16扫描";
                break;
            case "81":
                i="1/8扫描";
                break;
            case "82":
                i="2/8扫描";
                break;
            case "41":
                i="1/4扫描";
                break;
            case"42":
                i="2/4扫描";
                break;
            case"43":
                i="3/4扫描";
                break;
        }
        return i;
    }
    public static String getlightlevelIndex(String substring) {
        // TODO Auto-generated method stub
        String i=null;
        i=String.format(substring, 10);
        return i;
    }

    public static String getwordIndex(String string) {
        // TODO Auto-generated method stub
        String i=null;
        switch(string) {
            case "12":
                i="12*12";
                break;
            case "16":
                i="16*16";
                break;
            case"24":
                i="24*24";
                break;

        }
        return i;
    }

    public static int getzxztIndex(String substring) {
        // TODO Auto-generated method stub
        int i=0;
        switch(substring) {
            case"01":
                i=1;
                break;
            case"02":
                i=2;
                break;

        }
        return i;
    }

    public static String getmoveveIndex(String substring) {
        // TODO Auto-generated method stub
        String i=null;
        switch(substring) {
            case"01":
                i="1";
                break;
            case"02":
                i="2";
                break;
            case"03":
                i="3";
                break;
            case"04":
                i="4";
                break;
            case"05":
                i="5";
                break;
        }
        return i;
    }

    public static String getmovedIndex(String substring) {
        // TODO Auto-generated method stub
        String i=null;
        switch(substring) {
            case"01":
                i="上移";
                break;
            case"02":
                i="下移";
                break;
            case"03":
                i="左移";
                break;
            case"04":
                i="右移";
                break;
        }
        return i;
    }

    public static String getcid(String substring) {
        // TODO Auto-generated method stub
        String s=null;
        switch(substring) {
            case "01":
                s="车辆1";
                break;
            case"02":
                s="车辆2";
                break;
            case "03":
                s="车辆3";
                break;
        }
        return s;
    }

    public static String getcmx(String substring) {
        // TODO Auto-generated method stub
        String s=null;
        switch(substring) {
            case"01":
                s="模型一";
                break;
            case"02":
                s="模型二";
                break;
            case"03":
                s="模型三";
                break;
            case"04":
                s="模型四";
                break;
            case"05":
                s="模型五";
                break;
        }
        return s;
    }

    public static String getccolor(String substring) {
        // TODO Auto-generated method stub
        String s=null;
        switch(substring) {
            case"01":
                s="红色";
                break;
            case"02":
                s="绿色";
                break;
            case"03":
                s="黄色";
                break;
        }
        return s;
    }

    public static String getmdx(String substring) {
        // TODO Auto-generated method stub

        String s=null;
        switch(substring) {
            case"01":
                s="左移";
                break;
            case"02":
                s="右移";
                break;
        }
        return s;
    }

    public void hfpcxx(String s){

    }

    /*
     *
     * String 转byte数组 数据
     *
     */
    public static byte[] hexStringToByte(String hex) {
        // TODO Auto-generated method stub
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte)( (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]))&0xff);
        }
        return result;
    }
    private static int toByte(char c) {
        byte b = (byte) "0123456789abcdef".indexOf(c);
        return b;
    }
    /*
/**
 * <pre>
 * 数据包格式
 * +——----——+——-----——+——-----+---——+——----——+——-----——+-----——+——----——+-----——+——----——+
 * |  包头	|  长度               | 设备编号     |版卡编号    | 包类型         |    |  预留           |  包 数据       | 校验和      |    包尾      |
 * +——----——+——-----——+——-----+--——+——----——+——--——+-----——+——----——+-----——+——----——+
 *     1         2       4     1        1             1               2          1
 */
    public static String getpackage(String s, int length, int cmd) {
        // TODO Auto-generated method stub
        String sdata=null;
        int palength=length/2+constantValue.basic_length;
        int jyh=palength-3;
        if(s==null) {
            sdata=String.format("%02x", constantValue.head)+nf1.format(constantValue.basic_length)+nf.format(constantValue.zpId)+String.format("%02x",constantValue.bancardid)+String.format("%02x",cmd)
                    +String.format("%02x",constantValue.remain) +nf1.format(jyh)+String.format("%02x",constantValue.tail);

        }else {
            sdata=String.format("%02x", constantValue.head)+nf1.format(palength)+nf.format(constantValue.zpId)+String.format("%02x",constantValue.bancardid)+String.format("%02x",cmd)
                    +String.format("%02x",constantValue.remain) +s+nf1.format(jyh)+String.format("%02x",constantValue.tail);
        }
        return sdata;
    }
    public static String word2hexstr(String s){
        String s1=null;
        for (int i=0;i<s.length();i++){
            s1=s1+Integer.toString(s.charAt(i),16);
        }
        return s1;
    }

    /*
     *
     * int转 String 十六进制数据
     *
     */
    public static String numToHex8(int b) {
        // TODO Auto-generated method stub

        return String.format("%02x", b);
    }

    private String inttoHex(int tf1) {
        // TODO Auto-generated method stub
        String s=numToHex8(tf1);
        return s;
    }



}
