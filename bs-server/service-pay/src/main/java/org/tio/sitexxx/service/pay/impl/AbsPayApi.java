/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */package org.tio.sitexxx.service.pay.impl;

import java.util.Map;

import org.tio.http.common.HttpRequest;
import org.tio.sitexxx.service.pay.base.BasePay;
import org.tio.sitexxx.service.pay.base.BasePayReq;
import org.tio.sitexxx.service.pay.base.BasePayResp;

/**
 * 基础扩展
 * @author xufei
 * 2020年12月17日 下午1:52:15
 */
public abstract class AbsPayApi implements BasePay<BasePayReq,BasePayResp> {

	@Override
	public Map<String, Object> getConfParam() {
		return null;
	}

	@Override
	public BasePayResp openUser(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp updateUser(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp authRealname(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp bindBankCard(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp removeBankCard(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp getBankCards(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp getWalletInfo(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp getCoinItems(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp getCoinItemInfo(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp recharge(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp rechargeCallback(HttpRequest request, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp rechargeQuery(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp cost(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp back(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp sendRedpacket(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp sendRedpacketCallback(HttpRequest request, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp redpacketQuery(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp grabRedpacket(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp withhold(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp withholdCallback(HttpRequest request, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp withholdQuery(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp clientToken(BasePayReq PayQuest, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int commission(int amount) {
		// TODO Auto-generated method stub
		return 0;
	}

}
