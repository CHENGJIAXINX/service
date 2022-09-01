package org.tio.sitexxx.servicecommon.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
    static SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    public synchronized static String getSerial(){
        return format.format(new Date())+(int)(Math.random()*1000);
    }

    public static String getRandom8Str(){
        int i = (int) (Math.random()*100000000);
        if (i < 10000000){
            i = 10000000+i;
        }
        return String.valueOf(i);
    }

    public static void main(String[] args) {
        System.out.println(getRandom8Str());
    }
}
