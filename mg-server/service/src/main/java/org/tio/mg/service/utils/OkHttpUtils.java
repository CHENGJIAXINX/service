/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.utils;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.utils.json.Json;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtils {

	private static Logger log = LoggerFactory.getLogger(OkHttpUtils.class);

	private static MediaType jsonMedia = MediaType.parse("application/json; charset=utf-8");

	/**
	 * 
	 * @param url
	 * @param paramsJson
	 * @return
	 * @throws Exception
	 * 
	 */
	@SuppressWarnings("deprecation")
	public static Response postJson(String url, String paramsJson) throws Exception {
		try {
			OkHttpClient client = new OkHttpClient();
			RequestBody body = RequestBody.create(jsonMedia, paramsJson);
			Request request = new Request.Builder().url(url).post(body).build();
			Response response = client.newCall(request).execute();
			return response;
		} catch (IOException e) {
			log.error(e.toString(), e);
			throw e;
		}
	}

	/**
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 * 
	 */
	public static Response get(String url) throws Exception {
		try {
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(url).build();
			Response response = client.newCall(request).execute();
			return response;
		} catch (IOException e) {
			log.error(e.toString(), e);
			throw e;
		}
	}

	/**
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 * 
	 */
	public static Response post(String url, Map<String, Object> params) throws Exception {
		return postJson(url, Json.toJson(params));
	}

	/**
	 * 
	 * @param url
	 * @param params
	 * @param calssName
	 * @return
	 * @throws Exception
	 * 
	 */
	public static <T> T post(String url, String params, Class<T> calssName) throws Exception {
		Response response = postJson(url, params);
		T object = Json.toBean(response.body().toString(), calssName);
		return object;
	}

	/**
	 * 
	 * @param url
	 * @param params
	 * @param calssName
	 * @return
	 * @throws Exception
	 * 
	 */
	public static <T> T post(String url, Map<String, Object> params, Class<T> calssName) throws Exception {
		Response response = post(url, params);
		T object = Json.toBean(response.body().toString(), calssName);
		return object;
	}

	/**
	 * 
	 * @param url
	 * @param calssName
	 * @return
	 * @throws Exception
	 * 
	 */
	public static <T> T get(String url, Class<T> calssName) throws Exception {
		Response response = get(url);
		T object = Json.toBean(response.body().toString(), calssName);
		return object;
	}
}
