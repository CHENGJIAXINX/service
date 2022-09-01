package org.tio.sitexxx.web.server.utils;

import java.util.Random;

/**
 * @author :linjian
 * @description : 8位不重复数字
 * @createTime :2021/8/25
 * @updateTIme :
 */
public class UidUtils {
    private static int mUidLength = 8;// 默认生成uid长度

    /**
     * 获取当前设置的长度
     *
     * @return
     */
    public int getUidLength() {
        return mUidLength;
    }

    /**
     * 获取一个随机的uid
     *
     * @param uidLength 生成uid的长度
     * @return
     */
    public static int getRandomUid(int uidLength) {
        // 控制一下范围
        if (uidLength <= 1 || uidLength > 32) {
            mUidLength = 8;
        } else {
            mUidLength = uidLength;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mUidLength; i++) {
            if (i == 0) {
                sb.append((new Random().nextInt(9) + 1));
            } else {
                sb.append(new Random().nextInt(10));
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
