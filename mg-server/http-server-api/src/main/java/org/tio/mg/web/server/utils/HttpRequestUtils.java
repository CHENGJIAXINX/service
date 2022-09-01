package org.tio.mg.web.server.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :linjian
 * @description :
 * @createTime :2021/9/24
 * @updateTIme :
 */
public class HttpRequestUtils {

    private static HttpRequestUtils instance = null;

    private HttpRequestUtils() {
    }

    public static HttpRequestUtils getInstance() {
        if (instance == null) {
            synchronized (HttpRequestUtils.class) {
                if (instance == null) {
                    instance = new HttpRequestUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 发送post请求
     *
     * @param url
     * @param paramsMap
     * @return
     */
    public String sendPost(String url, Map<String, Object> paramsMap) {
        try {
            JSONObject param = new JSONObject();
            for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
                param.put(entry.getKey(), entry.getValue());
            }
            StringBuilder sb = new StringBuilder();
            URL urlObj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
            //post请求不能使用缓存
            conn.setUseCaches(false);
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在http正文内，因此�?��设为true, 默认情况下是false;
            conn.setDoOutput(true);
            // 设置是否从httpUrlConnection读入，默认情况下是true;
            conn.setDoInput(true);
            // 设定请求的方法为"POST"，默认是GET
            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8))) {
                writer.write(param.toJSONString());
                writer.flush();
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                String tmpLine;
                while ((tmpLine = reader.readLine()) != null) {
                    sb.append(tmpLine);
                }
            }
            conn.disconnect();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getUrlParams(Map<String, Object> paramsMap) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        String result = sb.toString();
        int i = result.lastIndexOf("&");
        return result.substring(0, i);
    }
}
