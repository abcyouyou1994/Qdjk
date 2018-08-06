package com.example.administrator.gjdzzpapp.prorocol;

import com.example.administrator.gjdzzpapp.presenter.callback.CallBack;

import java.io.UnsupportedEncodingException;

class ResultReduction {
    private DecodingTool decodingTool;
    private CallBack callBack;
    /*
     * 回复工作模式
     */
    public static void getHfgzms(String srdata) {
        // TODO Auto-generated method stub
        switch(srdata) {
            case "00":

                break;
            case"01":

                break;
        }

    }


    /*
     * 通用确认消息
     */
    public static void getCon(String srdata) {
        // TODO Auto-generated method stub

        switch(srdata) {
            case "00":

                break;
            case"01":

                break;
            case"02":

                break;
            case"03":

                break;

        }

    }


    /*
     * 回复屏参信息
     */
    public void getHfpcxx(String srdata) {
        // TODO Auto-generated method stub
        int swl=Integer.parseInt(srdata.substring(0, 2),16);

        int shl=Integer.parseInt(srdata.substring(2,4),16);

        String datali=decodingTool.getpolorityIndex(srdata.substring(4,6));


        String OEli=decodingTool.getpolorityIndex(srdata.substring(6, 8));

        String sctyl=decodingTool.getscantypeIndex(srdata.substring(8,10));



        String ll2=decodingTool.getlightlevelIndex(srdata.substring(10,12));


//        if(TestSwing.flag2==1) {
//
//            TestSwing.screenwidth.setText(String.valueOf(swl));
//            TestSwing.screenheight.setText(String.valueOf(shl));
//            TestSwing.scantypesl.setText(sctyl);
//            TestSwing.dataposl.setText(datali);
//            TestSwing.OEposl.setText(OEli);
//            TestSwing.lightls2.setText(ll2);
//        }else if(TestSwing.flag2==2) {
//            TestSwing.screenwidthx.setText(String.valueOf(swl));
//            TestSwing.screenheightx.setText(String.valueOf(shl));
//            TestSwing.scantypexc.setText(sctyl);
//
//            TestSwing.Datapxc.setText(datali);
//
//            TestSwing.OEpxc.setText(OEli);
//            TestSwing.llxc.setText(ll2);
//        }

    }

    /*
     * 回复文字报站设置信息
     */
    public void getHfwzbzszxx(String srdata) throws UnsupportedEncodingException {
        // TODO Auto-generated method stub
        int saddress=Integer.parseInt(srdata.substring(0, 2), 16);

        int length=(Integer.parseInt(srdata.substring(2,4),16))*2;

        String lid = null;
        byte[] temp=decodingTool.hexStringToByte(srdata.substring(4,4+length));
        lid = new String(temp,"gbk");
        String zw=decodingTool.getwordIndex(srdata.substring(length+4,length+6));
        int zxzt=decodingTool.getzxztIndex(srdata.substring(length+6,length+8));
//        if(zxzt==1) {
//            TestSwing.scanaddress.setText(String.valueOf(saddress));
//            TestSwing.roadidl.setText(lid);
//            TestSwing.wordsl.setText(zw);
//            TestSwing.wordxsl.setText("静态");
//        }else if(zxzt==2){
//            String moved=RSEncoderTool.getmovedIndex(srdata.substring(length+8,length+10));
//            String moveve=RSEncoderTool.getmoveveIndex(srdata.substring(length+10,length+12));
//            TestSwing.scanaddress.setText(String.valueOf(saddress));
//            TestSwing.roadidl.setText(lid);
//            TestSwing.wordsl.setText(zw);
//            TestSwing.wordxsl.setText("动态");
//            TestSwing.wordmdl.setText(moved);
//            TestSwing.wordmvl.setText(moveve);
//        }
    }

    /*
     *回复小车设置读取
     */
    public  void getHfxcszdq(String srdata) {
        // TODO Auto-generated method stub

        String cid=decodingTool.getcid(srdata.substring(0, 2));

        String mdx=decodingTool.getmdx(srdata.substring(2, 4));


        String cmx=decodingTool.getcmx(srdata.substring(4, 6));



        String clolor=decodingTool.getccolor(srdata.substring(6,8));



    }

    /*
     * 回复线路信息读取
     */
    public void getHfxlxxdq(String srdata) throws UnsupportedEncodingException {
        // TODO Auto-generated method stub
        int length=(Integer.parseInt(srdata.substring(0,2), 16))*2;
        String lid=new String((decodingTool.hexStringToByte(srdata.substring(2,2+length))),"GBK");
        int saddress=Integer.parseInt(srdata.substring(length+2, length+4), 16);
        int stnum=Integer.parseInt(srdata.substring(length+4,length+6), 16);

    }

    /*
     * 回复软硬件信息读取
     */
    public static void getHfryjxxdq(String srdata) {
        // TODO Auto-generated method stub

    }

    /*
     * 回复温度读取
     */
    public static void getHfwddq(String srdata) {
        // TODO Auto-generated method stub
        int tem=Integer.parseInt(srdata, 16);
       
    }

    /*
     * 回复时间读取
     */
    public static void getHfsjdq(String srdata) {
        // TODO Auto-generated method stub

    }

    /*
     * 心跳发送
     */
    public static void getXtfs(String srdata) {
        // TODO Auto-generated method stub

    }

    /*
     * 回复通讯参数读取
     */
    public static void getHftxcsdq(String srdata) {
        // TODO Auto-generated method stub

    }

    /*
     * 回复查询设备编号
     */
    public static void getHfcxsbbh(String srdata) {
        // TODO Auto-generated method stub

    }
}
