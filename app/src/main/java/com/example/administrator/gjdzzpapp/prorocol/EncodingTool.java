package com.example.administrator.gjdzzpapp.prorocol;

public class EncodingTool {
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
     * String to hexString
     */
    public static String str2HexStr(String origin) {
        byte[] bytes = origin.getBytes();
        String hex = bytesToHexString(bytes);
        return hex;
    }

    public static String hexStr2Str(String hex) {
        byte[] bb = hexStringToByte(hex);
        String rr = new String(bb);
        return rr;
    }

    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
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
    /*
     * 字体大小选择
     *
     */

    public static String getwordsize(String string) {
        String i=null;
        switch(string) {
            case "12*12":
                i="12";
                break;
            case "16*16":
                i="16";
                break;
            case "32*32":
                i="32";
                break;

        }
        return i;
    }


    /*
     * 扫描方式选择
     *
     */
    public static String getsctype(String i1) {
        String i=null;
        switch(i1) {
            case "1/16扫描":
                i="61";
                break;
            case "1/8扫描":
                i="81";
                break;
            case "2/8扫描":
                i="82";
                break;
            case "1/4扫描":
                i="41";
                break;
            case "2/4扫描":
                i="42";
                break;
            case "3/4扫描":
                i="43";
                break;
        }
        return i;
    }

    /*
     *
     * OE，data极性
     */
    public static String getpolarity(String string) {
        String i=null;
        switch(string) {
            case "0":
                i="00";
                break;
            case "1":
                i="01";
                break;

        }
        return i;
    }
    /*
     * 亮度
     */
    public static String getlightlevel(String str) {
        String i=null;
        switch(str) {

            case "1":
                i="01";
                break;
            case "2":
                i="02";
                break;
            case "3":
                i="03";
                break;
            case "4":
                i="04";
                break;
            case "5":
                i="05";
                break;
            case "6":
                i="06";
                break;
            case "7":
                i="07";
                break;
            case "8":
                i="08";
                break;
            case "9":
                i="09";
                break;
            case "10":
                i="0a";
                break;

        }

        return i;
    }
    /*
     * 得到文字移动方向
     */
    public static String getmovedirect(String string) {
        // TODO Auto-generated method stub
        String i=null;
        switch(string) {
            case "上移":
                i="01";
                break;
            case "下移":
                i="02";
                break;
            case "左移":
                i="03";
                break;
            case "右移":
                i="04";
                break;
        }
        return i;
    }
    /*
     * 得到文字移动速度
     */
    public static String getmovevelocity(String string) {
        // TODO Auto-generated method stub
        String i=null;
        switch(string) {
            case "1":
                i="01";
                break;
            case "2":
                i="02";
                break;
            case "3":
                i="03";
                break;
            case "4":
                i="04";
                break;
            case "5":
                i="05";
                break;
        }
        return i;
    }
    /*
     * 得到小车颜色
	 */
    public static String getscreenColor(String string) {
        // TODO Auto-generated method stub
        String i=null;
        switch(string) {
            case "红色":
                i="01";
                break;
            case "绿色":
                i="02";
                break;
            case "黄色":
                i="03";
                break;
        }
        return i;
    }
    /*
     * 得到小车移动方向
     */
    public static String getmodx(String string) {
        // TODO Auto-generated method stub
        String s=null;
        switch(string) {
            case "左移":
                s="01";
                break;
            case "右移":
                s="02";
                break;
        }
        return s;
    }

    public static String getcarmx(String selectedItem) {
        // TODO Auto-generated method stub
        String i=null;
        switch(selectedItem) {
            case"模型一":
                i="01";
                break;
            case"模型二":
                i="02";
                break;
            case"模型三":
                i="03";
                break;
            case"模型四":
                i="04";
                break;
            case"模型五":
                i="05";
                break;
        }
        return i;
    }
    public static String getwordmode(String selectedItem) {
        // TODO Auto-generated method stub

        String s=null;
        switch(selectedItem) {
            case"静态":
                s="01";
                break;
            case"动态":
                s="02";
                break;


        }
        return s;
    }
    public static String getcarid(String selectedItem) {
        // TODO Auto-generated method stub
        String s=null;
        switch(selectedItem) {
            case"车辆1":
                s="01";
                break;
            case"车辆2":
                s="02";
                break;
            case"车辆3":
                s="03";
                break;
        }
        return s;
    }


}
