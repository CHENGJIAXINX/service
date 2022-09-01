/*
 * 使用本软件请从杭州钛特云有限公司获取授权，其它途径获取本软件的行为皆为侵权行为
 * 本源代码由杭州钛特云科技有限公司授权给娄底大新土石方施工有限公司使用
 */package org.tio.sitexxx.service.pay.impl.pay5u;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tio.http.common.HttpRequest;
import org.tio.jfinal.plugin.activerecord.Db;
import org.tio.sitexxx.service.model.main.User;
import org.tio.sitexxx.service.model.main.WxUserGrabRedItem;
import org.tio.sitexxx.service.model.main.WxUserRechargeItem;
import org.tio.sitexxx.service.model.main.WxUserSendRedItem;
import org.tio.sitexxx.service.model.main.WxUserWallet;
import org.tio.sitexxx.service.model.main.WxUserWithholdCount;
import org.tio.sitexxx.service.model.main.WxUserWithholdItem;
import org.tio.sitexxx.service.pay.base.BasePay;
import org.tio.sitexxx.service.pay.base.BasePayReq;
import org.tio.sitexxx.service.pay.base.BasePayResp;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.ClientToken5UResp;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.Excep5UResp;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.GrabRedpacket5UResp;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.Open5UResp;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.Recharge5UResp;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.RechargeCallback5UResp;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.RechargeQuery5UResp;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.Redpacket5UResp;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.RedpacketCallback5UResp;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.RedpacketQuery5UResp;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.UpdateOpen5UResp;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.Wallet5UResp;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.Withhold5UResp;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.WithholdCallback5UResp;
import org.tio.sitexxx.service.pay.impl.pay5u.resp.WithholdQuery5UResp;
import org.tio.sitexxx.service.pay.service.PayService;
import org.tio.sitexxx.service.pay.service.WalletQueueApi;
import org.tio.sitexxx.service.service.atom.AbsAtom;
import org.tio.sitexxx.service.service.atom.AbsTxAtom;
import org.tio.sitexxx.service.service.base.UserService;
import org.tio.sitexxx.service.service.conf.BankConfService;
import org.tio.sitexxx.service.service.conf.ConfService;
import org.tio.sitexxx.service.utils.LockUtils.LockPrefix;
import org.tio.sitexxx.service.utils.RetUtils;
import org.tio.sitexxx.service.vo.ClientTokenVo;
import org.tio.sitexxx.servicecommon.vo.Const;
import org.tio.sitexxx.servicecommon.vo.Devicetype;
import org.tio.sitexxx.service.vo.GrabRedpacketVo;
import org.tio.sitexxx.service.vo.OpenVo;
import org.tio.sitexxx.servicecommon.vo.PayConst;
import org.tio.sitexxx.service.vo.RechargeQueryVo;
import org.tio.sitexxx.service.vo.RechargeVo;
import org.tio.sitexxx.service.vo.RedpacketQueryVo;
import org.tio.sitexxx.service.vo.RequestExt;
import org.tio.sitexxx.servicecommon.vo.RequestKey;
import org.tio.sitexxx.service.vo.SendRedpacketVo;
import org.tio.sitexxx.service.vo.UpdateOpenVo;
import org.tio.sitexxx.service.vo.WalletVo;
import org.tio.sitexxx.service.vo.WithholdQueryVo;
import org.tio.sitexxx.service.vo.WithholdVo;
import org.tio.utils.json.Json;
import org.tio.utils.lock.LockUtils;

import com.alibaba.fastjson15.JSONObject;
import com.upay.sdk.exception.HmacVerifyException;
import com.upay.sdk.exception.RequestException;
import com.upay.sdk.exception.ResponseException;
import com.upay.sdk.exception.UnknownException;
import com.upay.sdk.executer.ResultListenerAdpater;
import com.upay.sdk.onlinepay.executer.OnlinePayOrderExecuter;
import com.upay.sdk.webox.builder.ClientTokenBuilder;
import com.upay.sdk.webox.builder.RechargeBuilder;
import com.upay.sdk.webox.builder.RechargeQueryBuilder;
import com.upay.sdk.webox.builder.RedPacketBuilder;
import com.upay.sdk.webox.builder.RedPacketGrabBuilder;
import com.upay.sdk.webox.builder.RedPacketQueryBuilder;
import com.upay.sdk.webox.builder.WalletCreateBuilder;
import com.upay.sdk.webox.builder.WalletQueryBuilder;
import com.upay.sdk.webox.builder.WalletUpdateWalletInfoBuilder;
import com.upay.sdk.webox.builder.WithholdingBuilder;
import com.upay.sdk.webox.builder.WithholdingQueryBuilder;
import com.upay.sdk.webox.executer.ClientTokenExecuter;
import com.upay.sdk.webox.executer.RechargeExecuter;
import com.upay.sdk.webox.executer.RedPacketExecuter;
import com.upay.sdk.webox.executer.WalletExecuter;
import com.upay.sdk.webox.executer.WithholdingExecuter;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

public class Pay5uApi implements BasePay<BasePayReq,BasePayResp> {
	
	private static Logger	log	= LoggerFactory.getLogger(Pay5uApi.class);
	
    private static final String ENCRYPT_KEY = "encryptKey";
    private static final String MERCHANT_ID = "merchantId";
	
	/**
	 * 请求服务机器随机码
	 */
	private Integer payReqIdIndex = 1;
	
	/**
	 * 易支付本地手续费设置-暂不设
	 */
	@Override
	public int commission(int amount) {
		Integer rate = ConfService.getInt(Const.ConfMapping.WX_WALLET_WITHHOLD_COMMISSION, 5);
		Integer withholdconst = ConfService.getInt(Const.ConfMapping.WX_WALLET_WITHHOLD_COMMISSION_CONST, 50);
		Integer commission = amount * rate / 1000 + withholdconst;
		return amount - commission;
	}
	
	
	
	/* 
	 * 易支付开户逻辑，未添加查询同步逻辑
	 */
	@Override
	public BasePayResp openUser(BasePayReq PayQuest,Integer uid) {
		OpenVo userVo = OpenVo.toBean(PayQuest.getParams());
		WalletCreateBuilder builder = new WalletCreateBuilder(getMerchantid());
		builder.setRequestId(getReqId()).setMerchantId(getMerchantid())
				.setMerchantUserId(userVo.getUid() + "")
				.setName(userVo.getName())
				.setIdCardType(userVo.getCardtype())
				.setIdCardNo(userVo.getCardno())
				.setMobile(userVo.getMobile())
				.setProfession(userVo.getProfession())
				.setIp(userVo.getIp())
				.setMac(userVo.getMac())
				.setNickName(userVo.getName());
		BasePayResp basePayResp = new BasePayResp();
		WalletExecuter executer = new WalletExecuter();
		try {
			executer.bothCreate(builder, new ResultListenerAdpater() {
				@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					Open5UResp resp = Json.toBean(msg, Open5UResp.class);
					if(resp.getWalletStatus().equals(Pay5UConst.WalletStatus.ACTIVATE)) {
						//TODO:XUFEI-业务数据保存
						AbsAtom atom = new AbsTxAtom() {
							
							@Override
							public boolean noTxRun() {
								WxUserWallet wallet = new WxUserWallet();
								wallet.setUid(userVo.getUid());
								wallet.setReqid(resp.getRequestId());
								wallet.setBizid(resp.getMerchantId());
								wallet.setWalletid(resp.getWalletId());
								wallet.setOperatorstatus(StatusToYesOrNo(resp.getOperatorRzStatus()));
								wallet.setRealnamestatus(StatusToYesOrNo(resp.getIdCardRzStatus()));
								wallet.setIp(getIp(PayQuest));
								wallet.setDevice(getDeviceType(getReqExt(PayQuest)));
								wallet.setAppversion(getAppVersion(getReqExt(PayQuest)));
								boolean save = wallet.save();
								if(!save) {
									log.error("钱包开户异常：{}",Json.toJson(resp));
									return failRet("保存钱包逻辑失败");
								}
								User user = new User();
								user.setOpenflag(Const.YesOrNo.YES);
								user.setOpenid(wallet.getId());
								user.setId(userVo.getUid());
								boolean update = user.update();
								if(!update) {
									return failRet("修改用户钱包逻辑异常");
								}
								return true;
							}
						};
						boolean tx = Db.use(Const.Db.TIO_SITE_MAIN).tx(atom);
						if(!tx) {
							basePayResp.setOk(false);
							basePayResp.setMsg(RetUtils.getRetMsg(atom.getRetObj()));
						} else {
							UserService.ME._clearCache(userVo.getUid());
							basePayResp.setOk(true);
						}
					} else {
						String walletid = resp.getWalletId();
						if(StrUtil.isNotBlank(walletid)) {
							ReentrantReadWriteLock rwLock = LockUtils.getReentrantReadWriteLock(LockPrefix.CHAT_WALLET_OPEN + "." + userVo.getUid(), WxUserWallet.class);
							WriteLock writeLock = rwLock.writeLock();
							writeLock.lock();
							try {
								User user = UserService.ME.getById(userVo.getUid());
								if(user != null && Objects.equals(user.getOpenflag(), Const.YesOrNo.NO)) {
									AbsAtom atom = new AbsTxAtom() {
										
										@Override
										public boolean noTxRun() {
											WxUserWallet wallet = new WxUserWallet();
											wallet.setUid(userVo.getUid());
											wallet.setReqid(resp.getRequestId());
											wallet.setBizid(resp.getMerchantId());
											wallet.setWalletid(resp.getWalletId());
											wallet.setExcepsyn(Const.YesOrNo.NO);
											boolean save = wallet.save();
											if(!save) {
												log.error("钱包补偿开户异常：{}",Json.toJson(resp));
												return failRet("保存钱包逻辑失败");
											}
											User user = new User();
											user.setOpenflag(Const.YesOrNo.YES);
											user.setOpenid(wallet.getId());
											user.setId(userVo.getUid());
											boolean update = user.update();
											if(!update) {
												return failRet("修改用户钱包逻辑异常");
											}
											return true;
										}
									};
									boolean tx = Db.use(Const.Db.TIO_SITE_MAIN).tx(atom);
									if(!tx) {
										basePayResp.setOk(false);
										basePayResp.setMsg(RetUtils.getRetMsg(atom.getRetObj()));
									} else {
										UserService.ME._clearCache(userVo.getUid());
										basePayResp.setOk(false);
										basePayResp.setMsg(resp.getErrorMessage() + ",但已补偿开户");
									}
								} else {
									basePayResp.setOk(false);
									basePayResp.setMsg(resp.getErrorMessage());
								}
							} catch (Exception e) {
								log.error("",e);
							} finally {
								writeLock.unlock();
							}
						} else {
							basePayResp.setOk(false);
							basePayResp.setMsg(resp.getErrorMessage());
						}
					}
					basePayResp.setResp(resp.toMap());
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}

				@Override
				public void pending(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("待处理");
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常,{}",e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}",e.getMessage());
		} catch (RequestException e) {
			log.error("请求异常,{}",e.getMessage());
		} catch (UnknownException e) {
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		}
		return basePayResp;
	}

	@Override
	public BasePayResp authRealname(BasePayReq PayQuest,Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp bindBankCard(BasePayReq PayQuest,Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp removeBankCard(BasePayReq PayQuest,Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp getBankCards(BasePayReq PayQuest,Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * 钱包信息
	 */
	@Override
	public BasePayResp getWalletInfo(BasePayReq PayQuest,Integer uid) {
		WalletVo walletVo = WalletVo.toBean(PayQuest.getParams());
		BasePayResp basePayResp = new BasePayResp();
		String merchantId = getMerchantid();
        String walletId = walletVo.getWalletid();
        WalletQueryBuilder builder = new WalletQueryBuilder(merchantId);
        builder.setMerchantId(merchantId)
               .setWalletId(walletId);
        WalletExecuter executer = new WalletExecuter();
        try {
            executer.bothQUery(builder, new ResultListenerAdpater() {
            	@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					Wallet5UResp resp = Json.toBean(msg, Wallet5UResp.class);
					if(resp.getWalletStatus().equals(Pay5UConst.WalletStatus.ACTIVATE)) {
						basePayResp.setOk(true);
						WalletQueueApi.joinWalletQueue(resp.toAllMap(), uid);
					} else {
						basePayResp.setOk(false);
						basePayResp.setMsg("钱包异常：状态-" + resp.getWalletStatus());
					}
					basePayResp.setResp(resp.toMap());
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}

				@Override
				public void pending(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("待处理");
				}
            });
        } catch (ResponseException e) {
			log.error("响应异常,{}",e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}",e.getMessage());
		} catch (RequestException e) {
			log.error("请求异常,{}",e.getMessage());
		} catch (UnknownException e) {
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		}
		return basePayResp;
	}

	@Override
	public BasePayResp getCoinItems(BasePayReq PayQuest,Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp getCoinItemInfo(BasePayReq PayQuest,Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp cost(BasePayReq PayQuest,Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp back(BasePayReq PayQuest,Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePayResp sendRedpacket(BasePayReq PayQuest,Integer uid) {
		SendRedpacketVo redpacketVo = SendRedpacketVo.toBean(PayQuest.getParams());
		Short timeout = ConfService.getShort(Const.ConfMapping.WX_WALLET_REDPACKET_PAY_TIMEOUT, (short) 5);
		String notifyUrl = Pay5UConst.CallBackUrl.REDPACKET + redpacketVo.getUid();
		if(StrUtil.isNotBlank(redpacketVo.getNotifyUrl())) {
			notifyUrl = redpacketVo.getNotifyUrl();
		}
		String packetType = "";
		if(Objects.equals(redpacketVo.getPacketType(), PayConst.RedPackMode.LUCK)) {
			packetType = Pay5UConst.RedPacketType.GROUP_LUCK;
		} else if(redpacketVo.getPacketCount() > 1) {
			packetType = Pay5UConst.RedPacketType.GROUP_NORMAL;
		} else {
			packetType = Pay5UConst.RedPacketType.ONE_TO_ONE;
		}
		BasePayResp basePayResp = new BasePayResp();
		RedPacketBuilder builder = new RedPacketBuilder(getMerchantid());
		builder.setRequestId(getReqId())
				.setWalletId(redpacketVo.getWalletid())
				.setAmount(redpacketVo.getAmount())
				.setSingleAmount(redpacketVo.getSingleAmount())
				.setCurrency(redpacketVo.getCurrency())
				.setPacketType(packetType)
				.setPacketCount(redpacketVo.getPacketCount() + "")
				.setNotifyUrl(notifyUrl)
				.setRemark(redpacketVo.getRemark())
				.setTimeout(timeout + "")
				;
		RedPacketExecuter executer = new RedPacketExecuter();
		try {
			executer.bothCreate(builder, new ResultListenerAdpater() {
				@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					Redpacket5UResp resp = Json.toBean(msg, Redpacket5UResp.class);
					if(resp.getOrderStatus().equals(Pay5UConst.RechargeStatus.INIT)) {
						WxUserSendRedItem redItem = new WxUserSendRedItem();
						redItem.setUid(uid);
						redItem.setChatbizid(redpacketVo.getBizid());
						redItem.setMode(redpacketVo.getPacketType());
						redItem.setChatmode(redpacketVo.getChatmode());
						redItem.setReqid(resp.getRequestId());
						redItem.setBizid(resp.getMerchantId());
						redItem.setSerialnumber(resp.getSerialNumber());
						redItem.setPacketcount(redpacketVo.getPacketCount());
						redItem.setWalletid(resp.getWalletId());
						redItem.setCurrency(resp.getCurrency());
						redItem.setAmount(Integer.parseInt(resp.getAmount()));
						redItem.setToken(resp.getToken());
						redItem.setTimeout(timeout);
						redItem.setRemark(resp.getRemark());
						redItem.setBizcreattime(resp.getCreateDateTime());
						redItem.setStatus(resp.getOrderStatus());
						redItem.setIp(getIp(PayQuest));
						redItem.setDevice(getDeviceType(getReqExt(PayQuest)));
						redItem.setAppversion(getAppVersion(getReqExt(PayQuest)));
						boolean save = redItem.save();
						if(!save) {
							basePayResp.setOk(false);
							basePayResp.setMsg("初始化发红包订单数据失败");
							log.error("初始化发红包订单数据失败");
						} else {
							basePayResp.setOk(true);
						}
					} else {
						basePayResp.setOk(false);
						basePayResp.setMsg("错误状态：" + resp.getOrderStatus());
						log.error("初始化发红包订单数据失败:{}",resp.getOrderStatus());
					}
					Map<String, Object> map = resp.toMap();
					map.put("packetCount",redpacketVo.getPacketCount());
					map.put("packetType",redpacketVo.getPacketType());
					map.put("singleAmount",redpacketVo.getSingleAmount());
					basePayResp.setResp(map);
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}

				@Override
				public void pending(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("待处理");
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常,{}",e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}",e.getMessage());
		} catch (RequestException e) {
			log.error("请求异常,{}",e.getMessage());
		} catch (UnknownException e) {
			log.error("其它异常,{}",e.getMessage());
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		}
		return basePayResp;
	}
	

	/**
	 * 红包查询
	 */
	@Override
	public BasePayResp redpacketQuery(BasePayReq PayQuest, Integer uid) {
		RedpacketQueryVo redpacketVo = RedpacketQueryVo.toBean(PayQuest.getParams());
		String queryType = "SIMPLE";
		if(StrUtil.isNotBlank(redpacketVo.getQueryType())) {
			queryType = redpacketVo.getQueryType();
		}
		BasePayResp basePayResp = new BasePayResp();
		RedPacketQueryBuilder builder = new RedPacketQueryBuilder(getMerchantid());
		builder.setRequestId(redpacketVo.getReqid())
		.setQueryType(queryType);
		RedPacketExecuter executer = new RedPacketExecuter();
		try {
			executer.bothQuery(builder, new ResultListenerAdpater() {
				@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					RedpacketQuery5UResp resp = Json.toBean(msg, RedpacketQuery5UResp.class);
					if(resp.getOrderStatus().equals(Pay5UConst.RedPacketStatus.SUCCESS) || resp.getOrderStatus().equals(Pay5UConst.RedPacketStatus.TIMEOUT)) {
						log.error("查询的红包已完成：{}",Json.toJson(redpacketVo.getSend()));
					}
					basePayResp.setResp(resp.toMap());
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}

				@Override
				public void pending(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("待处理");
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常,{}",e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}",e.getMessage());
		} catch (RequestException e) {
			log.error("请求异常,{}",e.getMessage());
		} catch (UnknownException e) {
			log.error("其它异常,{}",e.getMessage());
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		}
		return basePayResp;
	}



	/**
	 * 发红包
	 */
	@Override
	public BasePayResp sendRedpacketCallback(HttpRequest request, Integer uid) {
		BasePayResp basePayResp = new BasePayResp();
		try {
			OnlinePayOrderExecuter executer = new OnlinePayOrderExecuter();
			JSONObject json = JSONObject.parseObject(new String(request.getBody(), "utf-8"));
			String encryptKey = request.getHeader(ENCRYPT_KEY.toLowerCase());
			String merchantId = request.getHeader(MERCHANT_ID.toLowerCase());
			json.put(ENCRYPT_KEY, encryptKey);
			json.put(MERCHANT_ID, merchantId);

			executer.bothCipherCallback(json, new ResultListenerAdpater() {

				@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					RedpacketCallback5UResp resp = Json.toBean(msg, RedpacketCallback5UResp.class);
					WxUserSendRedItem item = WxUserSendRedItem.dao.findFirst("select * from wx_user_send_red_item where serialnumber = ?",resp.getSerialNumber());
					if(item == null) {
						basePayResp.setOk(false);
						log.error("发红包回调接口中，发现订单不存在：{}",Json.toJson(resp));
						basePayResp.setMsg("订单不存在");
					} else {
						WalletQueueApi.joinWalletQueue(resp.toAllMap(), uid);
						basePayResp.setOk(true);
					}
					basePayResp.setResp(resp.toMap());
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常,{}", e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}", e.getMessage());
		} catch (UnknownException e) {
			log.error("其它异常,{}",e.getMessage());
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		} catch (UnsupportedEncodingException e) {
			log.error("解析流失败,{}", e.getMessage());
		}
		return basePayResp;
	}
	
	
	
	/**
	 * 抢红包
	 */
	@Override
	public BasePayResp grabRedpacket(BasePayReq PayQuest, Integer uid) {
		GrabRedpacketVo grabVo = GrabRedpacketVo.toBean(PayQuest.getParams());
		WxUserSendRedItem item = WxUserSendRedItem.dao.findFirst("select * from wx_user_send_red_item where serialnumber = ?",grabVo.getSerialnumber());
		BasePayResp basePayResp = new BasePayResp();
		String checkStr = checkRedpacket(item);
		if(StrUtil.isNotBlank(checkStr)) {
			basePayResp.setOk(false);
			basePayResp.setMsg(checkStr);
			return basePayResp;
		}
		String reqId = item.getSerialnumber() + payReqIdIndex + RandomUtil.randomNumbers(12);
		RedPacketGrabBuilder builder = new RedPacketGrabBuilder(getMerchantid());
		builder.setRequestId(reqId)
				.setSerialNumber(grabVo.getSerialnumber())
				.setWalletId(grabVo.getWalletid());
		RedPacketExecuter executer = new RedPacketExecuter();
		try {
			executer.bothGrab(builder, new ResultListenerAdpater() {
				@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					GrabRedpacket5UResp resp = Json.toBean(msg, GrabRedpacket5UResp.class);
					if(resp.getOrderStatus().equals(Pay5UConst.RechargeStatus.SUCCESS)) {
						WxUserGrabRedItem grabRedItem = new WxUserGrabRedItem();
						grabRedItem.setUid(uid);
						grabRedItem.setSendid(item.getId());
						grabRedItem.setSenduid(item.getUid());
						grabRedItem.setSendwalletid(item.getWalletid());
						grabRedItem.setSendserialnumber(item.getSerialnumber());
						grabRedItem.setReqid(resp.getRequestId());
						grabRedItem.setBizid(resp.getMerchantId());
						grabRedItem.setChatbizid(grabVo.getBizid());
						grabRedItem.setChatmode(grabVo.getChatmode());
						grabRedItem.setSerialnumber(resp.getSerialNumber());
						grabRedItem.setWalletid(resp.getReceiveWalletId());
						grabRedItem.setAmount(Integer.parseInt(resp.getAmount()));
						grabRedItem.setBizcompletetime(resp.getCompleteDateTime());
						grabRedItem.setStatus(resp.getOrderStatus());
						grabRedItem.setIp(getIp(PayQuest));
						grabRedItem.setCoinsyn(PayConst.CoinSyn.NO);
						grabRedItem.setDevice(getDeviceType(getReqExt(PayQuest)));
						grabRedItem.setAppversion(getAppVersion(getReqExt(PayQuest)));
						boolean save = grabRedItem.save();
						if(!save) {
							basePayResp.setOk(false);
							basePayResp.setMsg("抢红包订单数据失败");
							log.error("抢红包订单数据失败");
						} else {
							//此处进入红包用户得队列中，以避免资源死锁
							WalletQueueApi.joinWalletQueue(grabRedItem.toAllMap(), item.getUid());
							basePayResp.setOk(true);
						}
					} else {
						basePayResp.setOk(false);
						basePayResp.setMsg("错误状态：" + resp.getOrderStatus());
						log.error("初始化发红包订单数据失败:{}",resp.getOrderStatus());
					}
					basePayResp.setResp(resp.toMap());
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}

				@Override
				public void pending(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("待处理");
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常,{}",e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}",e.getMessage());
		} catch (RequestException e) {
			log.error("请求异常,{}",e.getMessage());
		} catch (UnknownException e) {
			log.error("其它异常,{}",e.getMessage());
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		}
		return basePayResp;
	}

	@Override
	public Map<String, Object> getConfParam() {
		Map<String, Object> conf = new HashMap<String, Object>();
		conf.put("merchantid", Const.WALLET_MERCHANTID);
		return conf;
	}

	
	/**
	 * @return
	 * @author xufei
	 * 2020年11月3日 下午5:05:47
	 */
	private String getMerchantid() {
		return (String) getConfParam().get("merchantid");
	}
	
	/**
	 * 请求编号
	 * @return
	 * @author xufei
	 * 2020年11月3日 下午5:20:10
	 */
	private synchronized String getReqId() {
		return DateUtil.format(new Date(), DatePattern.PURE_DATETIME_MS_PATTERN) + payReqIdIndex + RandomUtil.randomNumbers(14);
	}

	
	/**
	 * yes或者No的状态转换
	 * @param status
	 * @return
	 * @author xufei
	 * 2020年11月12日 下午2:29:47
	 */
	private Byte StatusToYesOrNo(String status) {
		switch (status) {
		case "SUCCESS":
			return Const.YesOrNo.YES;
		default:
			return Const.YesOrNo.NO;
		}
	}

	/** 
	 * 修改开户信息：昵称和手机号
	 */
	@Override
	public BasePayResp updateUser(BasePayReq PayQuest,Integer uid) {
		UpdateOpenVo userVo = UpdateOpenVo.toBean(PayQuest.getParams());
		User user = UserService.ME.getById(userVo.getUid());
		BasePayResp basePayResp = new BasePayResp();
		if(user == null || Objects.equals(user.getOpenflag(), Const.YesOrNo.NO)) {
			basePayResp.setOk(false);
			basePayResp.setMsg("用户信息为空或者未开户");
			return basePayResp;
		}
		if(!user.getWalletid().equals(userVo.getWalletid())) {
			basePayResp.setOk(false);
			basePayResp.setMsg("钱包id不一致");
			return basePayResp;
		}
		String reqid = getReqId();
		WalletUpdateWalletInfoBuilder builder = new WalletUpdateWalletInfoBuilder(getMerchantid());
        builder.setRequestId(reqid).setMerchantId(getMerchantid())
                .setWalletId(userVo.getWalletid())
                .setMobile(userVo.getMobile())
                .setNickName(userVo.getNickName());
		WalletExecuter executer = new WalletExecuter();
		try {
			executer.bothUpdateWalletInfo(builder, new ResultListenerAdpater() {
				@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					UpdateOpen5UResp resp = Json.toBean(msg, UpdateOpen5UResp.class);
					if(resp.getModifyStatus().equals(Pay5UConst.Status.SUCCESS)) {
						//TODO:XUFEI-业务数据保存
						WxUserWallet wallet = new WxUserWallet();
						wallet.setId(user.getOpenid());
						wallet.setOperatorstatus(StatusToYesOrNo(resp.getOperatorRzStatus()));
						boolean update = wallet.update();
						if(!update) {
							basePayResp.setOk(false);
							basePayResp.setMsg("修改本地数据异常");
						} else {
							basePayResp.setOk(true);
						}
					} else {
						
						basePayResp.setOk(false);
						basePayResp.setMsg(resp.getErrorMessage());
					}
					basePayResp.setResp(resp.toMap());
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}

				@Override
				public void pending(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("待处理");
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常,{}",e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}",e.getMessage());
		} catch (RequestException e) {
			log.error("请求异常,{}",e.getMessage());
		} catch (UnknownException e) {
			log.error("其它异常,{}",e.getMessage());
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		}
		return basePayResp;
	}

	/**
	 * 获取客户端token
	 */
	@Override
	public BasePayResp clientToken(BasePayReq PayQuest, Integer uid) {
		ClientTokenVo tokenVo = ClientTokenVo.toBean(PayQuest.getParams());
		BasePayResp basePayResp = new BasePayResp();
		ClientTokenBuilder builder = new ClientTokenBuilder(getMerchantid());
		builder.setRequestId(getReqId())
				.setWalletId(tokenVo.getWalletid())
				.setBusinessType(tokenVo.getBizType());
		ClientTokenExecuter executer = new ClientTokenExecuter();
		try {
			executer.bothCreate(builder, new ResultListenerAdpater() {
				@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					ClientToken5UResp resp = Json.toBean(msg, ClientToken5UResp.class);
					if(resp.getCreateStatus().equals(Pay5UConst.Status.SUCCESS)) {
						//TODO:XUFEI-此处记录日志，但只有记录作用，因为token只能用一次
						basePayResp.setOk(true);
					} else {
						basePayResp.setOk(false);
						basePayResp.setMsg(resp.getErrorMessage());
					}
					basePayResp.setResp(resp.toMap());
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}

				@Override
				public void pending(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("待处理");
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常,{}",e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}",e.getMessage());
		} catch (RequestException e) {
			log.error("请求异常,{}",e.getMessage());
		} catch (UnknownException e) {
			log.error("其它异常,{}",e.getMessage());
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		}
		return basePayResp;
	}

	/**
	 * 充值接口
	 */
	@Override
	public BasePayResp recharge(BasePayReq PayQuest,Integer uid) {
		RechargeVo rechargeVo = RechargeVo.toBean(PayQuest.getParams());
		String notifyUrl = Pay5UConst.CallBackUrl.RECHARGE + rechargeVo.getUid();
		if(StrUtil.isNotBlank(rechargeVo.getNotifyUrl())) {
			notifyUrl = rechargeVo.getNotifyUrl();
		}
		Short timeout = ConfService.getShort(Const.ConfMapping.WX_WALLET_RECHARGE_TIMEOUT, (short) 5);
		BasePayResp basePayResp = new BasePayResp();
		RechargeBuilder builder = new RechargeBuilder(getMerchantid());
		builder.setRequestId(getReqId())
		.setWalletId(rechargeVo.getWalletid())
		.setAmount(rechargeVo.getAmount())
		.setRemark(rechargeVo.getRemark())
		.setTimeout(timeout + "")
		.setCurrency(rechargeVo.getCurrency())
		.setNotifyUrl(notifyUrl);
		RechargeExecuter executer = new RechargeExecuter();
		try {
			executer.bothRecharge(builder, new ResultListenerAdpater() {
				@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					Recharge5UResp resp = Json.toBean(msg, Recharge5UResp.class);
					if(resp.getOrderStatus().equals(Pay5UConst.RechargeStatus.INIT)) {
						WxUserRechargeItem recharge = new WxUserRechargeItem();
						recharge.setUid(uid);
						recharge.setReqid(resp.getRequestId());
						recharge.setBizid(resp.getMerchantId());
						recharge.setSerialnumber(resp.getSerialNumber());
						recharge.setWalletid(resp.getWalletId());
						recharge.setCurrency(resp.getCurrency());
						recharge.setTimeout(timeout);
						recharge.setAmount(Integer.parseInt(resp.getAmount()));
						recharge.setToken(resp.getToken());
						recharge.setRemark(resp.getRemark());
						recharge.setBizcompletetime(resp.getCreateDateTime());
						recharge.setStatus(resp.getOrderStatus());
						recharge.setIp(getIp(PayQuest));
						recharge.setDevice(getDeviceType(getReqExt(PayQuest)));
						recharge.setAppversion(getAppVersion(getReqExt(PayQuest)));
						boolean save = recharge.save();
						if(!save) {
							basePayResp.setOk(false);
							basePayResp.setMsg("初始化充值订单数据失败");
							log.error("初始化充值订单数据失败");
						} else {
							basePayResp.setOk(true);
							log.error("充值同步保存成功：{}" + recharge.getSerialnumber());
						}
					} else {
						basePayResp.setOk(true);
						basePayResp.setMsg("错误状态：" + resp.getOrderStatus());
					}
					basePayResp.setResp(resp.toMap());
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}

				@Override
				public void pending(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("待处理");
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常,{}",e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}",e.getMessage());
		} catch (RequestException e) {
			log.error("请求异常,{}",e.getMessage());
		} catch (UnknownException e) {
			log.error("其它异常,{}",e.getMessage());
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		}
		return basePayResp;
	}
	
	/**
	 * 充值查询
	 */
	@Override
	public BasePayResp rechargeQuery(BasePayReq PayQuest,Integer uid) {
		RechargeQueryVo rechargeQuery = RechargeQueryVo.toBean(PayQuest.getParams());
		WxUserRechargeItem item = WxUserRechargeItem.dao.findFirst("select * from wx_user_recharge_item where serialnumber = ?",rechargeQuery.getSerialnumber());
		BasePayResp basePayResp = new BasePayResp();
		if(item == null) {
			basePayResp.setOk(false);
			log.error("充值查询接口中，发现订单不存在：{}",Json.toJson(rechargeQuery));
			basePayResp.setMsg("订单不存在");
			return basePayResp;
		}
		
		return rechargeQueryNoCheck(item);
	}
	
	/**
	 * 充值回调 
	 * 此方法只有记录不存在时，才进行fail输出
	 * 订单错误也是正常数据
	 */
	@Override
	public BasePayResp rechargeCallback(HttpRequest request,Integer uid) {
		BasePayResp basePayResp = new BasePayResp();
		try {
			OnlinePayOrderExecuter executer = new OnlinePayOrderExecuter();
			JSONObject json = JSONObject.parseObject(new String(request.getBody(), "utf-8"));
			String encryptKey = request.getHeader(ENCRYPT_KEY.toLowerCase());
			String merchantId = request.getHeader(MERCHANT_ID.toLowerCase());
			json.put(ENCRYPT_KEY, encryptKey);
			json.put(MERCHANT_ID, merchantId);

			executer.bothCipherCallback(json, new ResultListenerAdpater() {

				@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					RechargeCallback5UResp resp = Json.toBean(msg, RechargeCallback5UResp.class);
					WxUserRechargeItem item = WxUserRechargeItem.dao.findFirst("select * from wx_user_recharge_item where serialnumber = ?",resp.getSerialNumber());
					if(item == null) {
						basePayResp.setOk(false);
						log.error("支付回调接口中，发现订单不存在：{}",Json.toJson(resp));
						basePayResp.setMsg("订单不存在");
					} else {
						WalletQueueApi.joinWalletQueue(resp.toAllMap(), uid);
						basePayResp.setOk(true);
					}
					basePayResp.setResp(resp.toMap());
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常,{}", e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}", e.getMessage());
		} catch (UnknownException e) {
			log.error("其它异常,{}",e.getMessage());
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		} catch (UnsupportedEncodingException e) {
			log.error("解析流失败,{}", e.getMessage());
		}
		return basePayResp;
	}

	/**
	 * 提现
	 */
	@Override
	public BasePayResp withhold(BasePayReq PayQuest, Integer uid) {
		WxUserWithholdCount count = PayService.me.initWihtCount(uid, "");
		if(count == null) {
			BasePayResp basePayResp = new BasePayResp();
			basePayResp.setOk(false);
			log.error("系统初始化提现次数异常为空,{}",Json.toJson(PayQuest));
			basePayResp.setMsg("系统异常");
			return basePayResp;
		}
		Integer maxCount = ConfService.getInt(Const.ConfMapping.WX_WALLET_WITHHOLD_MAX_COUNT, 100);
		if(count.getCount() > maxCount) {
			BasePayResp basePayResp = new BasePayResp();
			basePayResp.setOk(false);
			log.error("提现次数超限：{}",Json.toJson(count));
			basePayResp.setMsg("提现次数已超上限");
			return basePayResp;
		}
		WithholdVo withholdVo = WithholdVo.toBean(PayQuest.getParams());
		String notifyUrl = Pay5UConst.CallBackUrl.WITHHOLD + withholdVo.getUid();
		if(StrUtil.isNotBlank(withholdVo.getNotifyUrl())) {
			notifyUrl = withholdVo.getNotifyUrl();
		}
		Integer _amount = Integer.parseInt(withholdVo.getAmount());
		Integer minAmount = ConfService.getInt(Const.ConfMapping.WX_WALLET_WITHHOLD_MIN_AMOUT, 10000);
		if(_amount < minAmount) {
			BasePayResp basePayResp = new BasePayResp();
			basePayResp.setOk(false);
			log.error("提现金额太小：{}",Json.toJson(count));
			basePayResp.setMsg("单次提现金额不低于" + minAmount /100 + "元");
			return basePayResp;
		}
		BasePayResp basePayResp = new BasePayResp();

        WithholdingBuilder builder = new WithholdingBuilder(getMerchantid());
        int commission = commission(_amount);
        Short timeout = ConfService.getShort(Const.ConfMapping.WX_WALLET_WITHHOLD_TIMEOUT, (short) 5);
        builder.setRequestId(getReqId())
                .setWalletId(withholdVo.getWalletid())
                .setAmount(withholdVo.getAmount())
                .setTimeout(timeout + "")
                .setArrivalAmount(commission + "")
                .setCurrency(withholdVo.getCurrency())
                .setRemark(withholdVo.getRemark())
                .setNotifyUrl(notifyUrl);
        WithholdingExecuter executer = new WithholdingExecuter();
        try {
            executer.bothWithholding(builder, new ResultListenerAdpater() {
                @Override
                public void success(JSONObject jsonObject) {
                	String msg = jsonObject.toJSONString();
					Withhold5UResp resp = Json.toBean(msg, Withhold5UResp.class);
					if(resp.getOrderStatus().equals(Pay5UConst.RechargeStatus.INIT)) {
						WxUserWithholdItem withhold = new WxUserWithholdItem();
						withhold.setUid(uid);
						withhold.setReqid(resp.getRequestId());
						withhold.setBizid(resp.getMerchantId());
						withhold.setSerialnumber(resp.getSerialNumber());
						withhold.setWalletid(resp.getWalletId());
						withhold.setCurrency(resp.getCurrency());
						withhold.setAmount(Integer.parseInt(resp.getAmount()));
						withhold.setArrivalamount(Integer.parseInt(resp.getArrivalAmount()));
						withhold.setToken(resp.getToken());
						withhold.setRemark(resp.getRemark());
						withhold.setTimeout(timeout);
						withhold.setBizcompletetime(resp.getCreateDateTime());
						withhold.setStatus(resp.getOrderStatus());
						withhold.setIp(getIp(PayQuest));
						withhold.setDevice(getDeviceType(getReqExt(PayQuest)));
						withhold.setAppversion(getAppVersion(getReqExt(PayQuest)));
						boolean save = withhold.save();
						if(!save) {
							basePayResp.setOk(false);
							basePayResp.setMsg("初始化提现订单数据失败");
						} else {
							basePayResp.setOk(true);
						}
					} else {
						basePayResp.setOk(true);
						basePayResp.setMsg("错误状态：" + resp.getOrderStatus());
					}
					basePayResp.setResp(resp.toMap());
                }

                @Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}

				@Override
				public void pending(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("待处理");
				}

            });
        } catch (ResponseException e) {
			log.error("响应异常,{}",e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}",e.getMessage());
		} catch (RequestException e) {
			log.error("请求异常,{}",e.getMessage());
		} catch (UnknownException e) {
			log.error("其它异常,{}",e.getMessage());
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		}
		return basePayResp;
	}
	
	/**
	 * 提现查询
	 */
	@Override
	public BasePayResp withholdQuery(BasePayReq PayQuest,Integer uid) {
		WithholdQueryVo withholdQueryVo = WithholdQueryVo.toBean(PayQuest.getParams());
		WxUserWithholdItem item = WxUserWithholdItem.dao.findFirst("select * from wx_user_withhold_item where serialnumber = ?",withholdQueryVo.getSerialnumber());
		BasePayResp basePayResp = new BasePayResp();
		if(item == null) {
			basePayResp.setOk(false);
			log.error("提现查询接口中，发现订单不存在：{}",Json.toJson(withholdQueryVo));
			basePayResp.setMsg("订单不存在");
			return basePayResp;
		}
		return withholdQueryNoCheck(item);
	}

	/**
	 * 提现回调
	 */
	@Override
	public BasePayResp withholdCallback(HttpRequest request, Integer uid) {
		BasePayResp basePayResp = new BasePayResp();
		try {
			WxUserWithholdCount count = PayService.me.initWihtCount(uid, "");
			if(count == null) {
				basePayResp.setOk(false);
				log.error("系统初始化提现次数异常为空");
				basePayResp.setMsg("系统异常");
				return basePayResp;
			}
			boolean withholdupdate = PayService.me.updateWithholdCount(count.getId());
			if(!withholdupdate) {
				basePayResp.setOk(false);
				log.error("系统系统次数更新异常,{}");
				basePayResp.setMsg("系统次数更新异常");
				return basePayResp;
			}
			OnlinePayOrderExecuter executer = new OnlinePayOrderExecuter();
			JSONObject json = JSONObject.parseObject(new String(request.getBody(), "utf-8"));
			String encryptKey = request.getHeader(ENCRYPT_KEY.toLowerCase());
			String merchantId = request.getHeader(MERCHANT_ID.toLowerCase());
			json.put(ENCRYPT_KEY, encryptKey);
			json.put(MERCHANT_ID, merchantId);

			executer.bothCipherCallback(json, new ResultListenerAdpater() {

				@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					WithholdCallback5UResp resp = Json.toBean(msg, WithholdCallback5UResp.class);
					WxUserWithholdItem item = WxUserWithholdItem.dao.findFirst("select * from wx_user_withhold_item where serialnumber = ?",resp.getSerialNumber());
					if(item == null) {
						basePayResp.setOk(false);
						log.error("提现回调接口中，发现订单不存在：{}",Json.toJson(resp));
						basePayResp.setMsg("订单不存在");
					} else {
						WalletQueueApi.joinWalletQueue(resp.toAllMap(), uid);
						basePayResp.setOk(true);
					}
					basePayResp.setResp(resp.toMap());
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常,{}", e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}", e.getMessage());
		} catch (UnknownException e) {
			log.error("其它异常,{}",e.getMessage());
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		} catch (UnsupportedEncodingException e) {
			log.error("解析流失败,{}", e.getMessage());
		}
		return basePayResp;
	}
	
	/**
	 * @param redItem
	 * @return
	 * @author xufei
	 * 2020年11月23日 下午6:03:34
	 */
	private String checkRedpacket(WxUserSendRedItem redItem) {
		if(redItem == null) {
			return "红包不存在";
		}
		if(Objects.equals(redItem.getStatus(), Pay5UConst.RedPacketStatus.SUCCESS)) {
			return "红包已抢完";
		}
		if(Objects.equals(redItem.getStatus(), Pay5UConst.RedPacketStatus.TIMEOUT)) {
			return "红包已超时";
		}
		if(!Objects.equals(redItem.getStatus(), Pay5UConst.RedPacketStatus.SEND)) {
			return "红包异常";
		}
		return "";
	}
	
	
	/**
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年11月22日 下午9:19:59
	 */
	private RequestExt getReqExt(BasePayReq PayQuest) {
		HttpRequest request = PayQuest.getRequest();
		if(request == null) {
			return null;
		}
		return (RequestExt)request.getAttribute(RequestKey.REQUEST_EXT);
	}
	
	/**
	 * 设备
	 * @param ext
	 * @return
	 * @author xufei
	 * 2020年11月22日 下午9:19:56
	 */
	private Byte getDeviceType(RequestExt ext) {
		if(ext == null) {
			return Devicetype.SYS_TASK.getValue();
		}
		return ext.getDeviceType();
	}
	
	/**
	 * 客户端ip
	 * @param PayQuest
	 * @return
	 * @author xufei
	 * 2020年11月22日 下午9:22:42
	 */
	private String getIp(BasePayReq PayQuest) {
		HttpRequest request = PayQuest.getRequest();
		if(request == null) {
			return "0.0.0.0";
		}
		return request.getClientIp();
	}
	
	/**
	 * app版本号
	 * @param ext
	 * @return
	 * @author xufei
	 * 2020年11月22日 下午9:23:47
	 */
	private String getAppVersion(RequestExt ext) {
		if(ext == null) {
			return "0.0.0";
		}
		return ext.getAppVersion();
	}
	
	/**
	 * @param item
	 * @return
	 * @author xufei
	 * 2020年11月26日 下午2:54:36
	 */
	public BasePayResp rechargeQueryNoCheck(WxUserRechargeItem item) {
		BasePayResp basePayResp = new BasePayResp();
		RechargeQueryBuilder builder = new RechargeQueryBuilder(getMerchantid());
		builder.setRequestId(item.getReqid());
		RechargeExecuter executer = new RechargeExecuter();
		try {
			executer.bothRechargeQuery(builder, new ResultListenerAdpater() {
				@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					RechargeQuery5UResp resp = Json.toBean(msg, RechargeQuery5UResp.class);
					Map<String, Object> map = item.toAllMap();
					map.put("bankicon", BankConfService.getString(resp.getBankCode()));
					map.put("bankcode", resp.getBankCode());
					map.put("bankname", resp.getBankName());
					map.put("bankcardnumber", resp.getBankCardNumber());
					map.put("bizcreattime", resp.getCreateDateTime());
					map.put("ordererrormsg", resp.getOrderErrorMessage());
					map.put("status", resp.getOrderStatus());
					map.put("bizcompletetime",resp.getCompleteDateTime());
					WalletQueueApi.joinWalletQueue(map, item.getUid());
					basePayResp.setOk(true);
					Map<String, Object> retmap = resp.toMap();
					retmap.put("bankicon", BankConfService.getString(resp.getBankCode()));
					basePayResp.setResp(retmap);
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}

				@Override
				public void pending(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("待处理");
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常,{}",e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}",e.getMessage());
		} catch (RequestException e) {
			log.error("请求异常,{}",e.getMessage());
		} catch (UnknownException e) {
			log.error("其它异常,{}",e.getMessage());
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		}
		return basePayResp;
	}
	
	/**
	 * @param item
	 * @return
	 * @author xufei
	 * 2020年12月3日 上午11:07:56
	 */
	public BasePayResp rechargeAgainCallback(WxUserRechargeItem item) {
		BasePayResp basePayResp = new BasePayResp();
		RechargeQueryBuilder builder = new RechargeQueryBuilder(getMerchantid());
		builder.setRequestId(item.getReqid());
		RechargeExecuter executer = new RechargeExecuter();
		try {
			executer.bothRechargeQuery(builder, new ResultListenerAdpater() {
				@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					RechargeQuery5UResp resp = Json.toBean(msg, RechargeQuery5UResp.class);
					basePayResp.setOk(true);
					Map<String, Object> map = resp.toAllMap();
					map.put(PayConst.ApiClassName.API_MAP_KEY,PayConst.ApiClassName.RECHARGE_CALLBACK);
					map.put("again", "again");
					WalletQueueApi.joinWalletQueue(map, item.getUid());
					basePayResp.setResp(map);
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}

				@Override
				public void pending(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("待处理");
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常,{}",e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}",e.getMessage());
		} catch (RequestException e) {
			log.error("请求异常,{}",e.getMessage());
		} catch (UnknownException e) {
			log.error("其它异常,{}",e.getMessage());
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		}
		return basePayResp;
	}
	
	
	/**
	 * @param item
	 * @return
	 * @author xufei
	 * 2020年11月26日 下午3:53:30
	 */
	public BasePayResp withholdQueryNoCheck(WxUserWithholdItem item) {
		BasePayResp basePayResp = new BasePayResp();
		WithholdingQueryBuilder builder = new WithholdingQueryBuilder(getMerchantid());
		builder.setRequestId(item.getReqid());
		WithholdingExecuter executer = new WithholdingExecuter();
		try {
			executer.bothWithholdingQuery(builder, new ResultListenerAdpater() {
				@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					WithholdQuery5UResp resp = Json.toBean(msg, WithholdQuery5UResp.class);
					basePayResp.setOk(true);
					Map<String, Object> map = item.toAllMap();
					map.put("bankicon", BankConfService.getString(resp.getBankCode()));
					map.put("bankcode", resp.getBankCode());
					map.put("bankname", resp.getBankName());
					map.put("bankcardnumber", resp.getBankCardNumber());
					map.put("bizcreattime", resp.getCreateDateTime());
					map.put("ordererrormsg", resp.getOrderErrorMessage());
					map.put("status", resp.getOrderStatus());
					map.put("bizcompletetime",resp.getCompleteDateTime());
					WalletQueueApi.joinWalletQueue(map, item.getUid());
					Map<String, Object> retmap = resp.toMap();
					retmap.put("bankicon", BankConfService.getString(resp.getBankCode()));
					basePayResp.setResp(retmap);
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}

				@Override
				public void pending(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("待处理");
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常,{}",e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}",e.getMessage());
		} catch (RequestException e) {
			log.error("请求异常,{}",e.getMessage());
		} catch (UnknownException e) {
			log.error("其它异常,{}",e.getMessage());
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		}
		return basePayResp;
	}
	
	/**
	 * 
	 * @param item
	 * @return
	 * @author xufei
	 * 2020年12月3日 上午10:51:32
	 */
	public BasePayResp withholdAgainCallback(WxUserWithholdItem item) {
		BasePayResp basePayResp = new BasePayResp();
		WithholdingQueryBuilder builder = new WithholdingQueryBuilder(getMerchantid());
		builder.setRequestId(item.getReqid());
		WithholdingExecuter executer = new WithholdingExecuter();
		try {
			executer.bothWithholdingQuery(builder, new ResultListenerAdpater() {
				@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					WithholdQuery5UResp resp = Json.toBean(msg, WithholdQuery5UResp.class);
					basePayResp.setOk(true);
					Map<String, Object> map = resp.toAllMap();
					map.put(PayConst.ApiClassName.API_MAP_KEY,PayConst.ApiClassName.WITHHOLD_CALLBACK);
					map.put("again", "again");
					WalletQueueApi.joinWalletQueue(map, item.getUid());
					basePayResp.setResp(map);
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}

				@Override
				public void pending(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("待处理");
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常,{}",e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}",e.getMessage());
		} catch (RequestException e) {
			log.error("请求异常,{}",e.getMessage());
		} catch (UnknownException e) {
			log.error("其它异常,{}",e.getMessage());
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		}
		return basePayResp;
	}
	
	
	/**
	 * 红包补偿回调
	 * @param redItem
	 * @return
	 * @author xufei
	 * 2020年12月3日 上午11:26:03
	 */
	public BasePayResp redpacketAgainCallback(WxUserSendRedItem redItem) {
		String queryType = "SIMPLE";
		BasePayResp basePayResp = new BasePayResp();
		RedPacketQueryBuilder builder = new RedPacketQueryBuilder(getMerchantid());
		builder.setRequestId(redItem.getReqid())
		.setQueryType(queryType);
				;
		RedPacketExecuter executer = new RedPacketExecuter();
		try {
			executer.bothQuery(builder, new ResultListenerAdpater() {
				@Override
				public void success(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					RedpacketQuery5UResp resp = Json.toBean(msg, RedpacketQuery5UResp.class);
					Map<String, Object> map = resp.toAllMap();
					map.put(PayConst.ApiClassName.API_MAP_KEY,PayConst.ApiClassName.REDPACKET_CALLBACK);
					map.put("again", "again");
					WalletQueueApi.joinWalletQueue(map, redItem.getUid());
					basePayResp.setResp(map);
				}

				@Override
				public void failure(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("响应失败");
				}

				@Override
				public void pending(JSONObject jsonObject) {
					String msg = jsonObject.toJSONString();
					log.error(msg);
					basePayResp.setOk(false);
					basePayResp.setMsg("待处理");
				}
			});
		} catch (ResponseException e) {
			log.error("响应异常,{}",e.getMessage());
		} catch (HmacVerifyException e) {
			log.error("签名验证异常,{}",e.getMessage());
		} catch (RequestException e) {
			log.error("请求异常,{}",e.getMessage());
		} catch (UnknownException e) {
			log.error("其它异常,{}",e.getMessage());
			String err = e.getMessage();
			Excep5UResp resp = Json.toBean(err, Excep5UResp.class);
			basePayResp.setResp(resp.toMap());
			basePayResp.setOk(false);
			basePayResp.setMsg(resp.getErrorMessage());
			return basePayResp;
		}
		return basePayResp;
	}
	
}
