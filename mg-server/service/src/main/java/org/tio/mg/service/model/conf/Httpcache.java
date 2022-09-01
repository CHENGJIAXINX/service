/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */
package org.tio.mg.service.model.conf;

import java.util.Objects;

import org.tio.mg.service.model.conf.base.BaseHttpcache;
import org.tio.sitexxx.servicecommon.vo.Const;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Httpcache extends BaseHttpcache<Httpcache> {
	public static final Httpcache dao = new Httpcache().dao();

	private String[] paramArray = null;

	private String[] cookieArray = null;

	private boolean useUidAsKey = false;

	private boolean useLoginedAsKey = false;
	
	private boolean hasPageNumber = false;

	private Object httpCacheMeta = null;

	public boolean isUseUidAsKey() {
		return useUidAsKey;
	}

	public void setUseUidAsKey(boolean useUidAsKey) {
		this.useUidAsKey = useUidAsKey;
	}

	public boolean isUseLoginedAsKey() {
		return useLoginedAsKey;
	}

	public void setUseLoginedAsKey(boolean useLoginedAsKey) {
		this.useLoginedAsKey = useLoginedAsKey;
	}

	public String[] getParamArray() {
		return paramArray;
	}

	public void setParamArray(String[] paramArray) {
		this.paramArray = paramArray;
		
		if (paramArray != null) {
			for (String param : paramArray) {
				if (Objects.equals(param, Const.PARAM_NAME_PAGENUMBER)) {
					this.hasPageNumber = true;
				}
			}
		}
	}

	public String[] getCookieArray() {
		return cookieArray;
	}

	public void setCookieArray(String[] cookieArray) {
		this.cookieArray = cookieArray;
	}

	public Object getHttpCacheMeta() {
		return httpCacheMeta;
	}

	public void setHttpCacheMeta(Object httpCacheMeta) {
		this.httpCacheMeta = httpCacheMeta;
	}

	public boolean isHasPageNumber() {
		return hasPageNumber;
	}

	public void setHasPageNumber(boolean hasPageNumber) {
		this.hasPageNumber = hasPageNumber;
	}

}
