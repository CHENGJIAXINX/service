package org.tio.sitexxx.servicecommon.vo;

import cn.hutool.core.util.StrUtil;
import org.tio.utils.jfinal.P;
import org.tio.utils.jfinal.Prop;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 多语言
 */
public class MulLauUtils {
    private static Prop cnProp = null;
    private static Prop viProp = null;

    private static final ConcurrentHashMap<String, Prop> cnMap = new ConcurrentHashMap();
    private static final ConcurrentHashMap<String, Prop> viMap = new ConcurrentHashMap();

    public static void clear(){
        cnProp = null;
        viProp = null;
        cnMap.clear();
        viMap.clear();
    }

    public static Prop useCN(String fileName) {
        Prop result = (Prop)cnMap.get(fileName);
        if (result == null) {
            synchronized(MulLauUtils.class) {
                result = (Prop)cnMap.get(fileName);
                if (result == null) {
                    result = new Prop(fileName);
                    cnMap.put(fileName, result);
                    if (cnProp == null) {
                        cnProp = result;
                    }
                }
            }
        }
        return result;
    }

    public static Prop useVI(String fileName) {
        Prop result = (Prop)viMap.get(fileName);
        if (result == null) {
            synchronized(MulLauUtils.class) {
                result = (Prop)viMap.get(fileName);
                if (result == null) {
                    result = new Prop(fileName);
                    viMap.put(fileName, result);
                    if (viProp == null) {
                        viProp = result;
                    }
                }
            }
        }
        return result;
    }

    public static String getCnMsg(String code){
        if (cnProp == null){
            MulLauUtils.useCN("resp-msg-cn.properties");
        }
        return cnProp.get(String.valueOf(code));
    }

    public static String getViMsg(String code){
        if (viProp == null){
            MulLauUtils.useVI("resp-msg-vi.properties");
        }
        return viProp.get(String.valueOf(code));
    }

    public static String getMsg(String msg){
        String ret = null;
        if (Const.CURR_LAU.equals("vi")){
            ret =  getViMsg(msg);
        }else {
            ret = getCnMsg(msg);
        }
        if (StrUtil.isBlank(ret)){
            return msg;
        }
        return ret;
    }
}
