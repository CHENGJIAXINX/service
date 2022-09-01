package org.tio.mg.service.utils;

import cn.hutool.core.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tanyaowu
 * 2019年7月21日 上午11:20:15
 */
public class IpUtils {

    @SuppressWarnings("unused")
    private static Logger log = LoggerFactory.getLogger(IpUtils.class);

    public IpUtils() {
    }

    public static void main(String[] args) {

    }

    public static String randomIp() {
        String ip = RandomUtil.randomInt(2, 100) + "." + RandomUtil.randomInt(2, 100) + "." + RandomUtil.randomInt(2, 100) + "." + RandomUtil.randomInt(2, 100);
        return ip;
    }
}
