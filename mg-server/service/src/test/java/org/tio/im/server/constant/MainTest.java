/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.im.server.constant;

import org.tio.mg.service.utils.UidUtils;

public class MainTest {

    public MainTest() {

    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(UidUtils.getRandomUid(6));
        }
    }

}
