package org.tio.sitexxx.web.server.yanxun;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        log(1);
        log(51);
        log(52);
        log(53);
        log(101);
    }

    public static void log(int i){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized ((Integer)(i%50)){
                    try {
                        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").format(new Date())+"==>i===>"+i);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
