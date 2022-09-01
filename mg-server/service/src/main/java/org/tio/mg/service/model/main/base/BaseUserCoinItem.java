package org.tio.mg.service.model.main.base;

import org.tio.mg.service.jf.TioModel;
import org.tio.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUserCoinItem<M extends BaseUserCoinItem<M>> extends TioModel<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}

	/**
	 * 冗余用户uid
	 */
	public void setUid(java.lang.Integer uid) {
		set("uid", uid);
	}
	
	/**
	 * 冗余用户uid
	 */
	public java.lang.Integer getUid() {
		return getInt("uid");
	}

	/**
	 * 业务id
	 */
	public void setBizid(java.lang.Integer bizid) {
		set("bizid", bizid);
	}
	
	/**
	 * 业务id
	 */
	public java.lang.Integer getBizid() {
		return getInt("bizid");
	}

	/**
	 * 币种模式：1：牛币；2：牛丸；3：钱包
	 */
	public void setCoinmode(java.lang.Byte coinmode) {
		set("coinmode", coinmode);
	}
	
	/**
	 * 币种模式：1：牛币；2：牛丸；3：钱包
	 */
	public java.lang.Byte getCoinmode() {
		return getByte("coinmode");
	}

	/**
	 * 收支：1：收入；2：支出
	 */
	public void setCoinflag(java.lang.Byte coinflag) {
		set("coinflag", coinflag);
	}
	
	/**
	 * 收支：1：收入；2：支出
	 */
	public java.lang.Byte getCoinflag() {
		return getByte("coinflag");
	}

	/**
	 * 类型：1：充值；2：送礼消费；3：道具消费；4：道具买入；5：活动；6：竞猜；13：签到；14：注册；15:红包提现；16：红包退款；17：世界杯；18：课程
	 */
	public void setType(java.lang.Byte type) {
		set("type", type);
	}
	
	/**
	 * 类型：1：充值；2：送礼消费；3：道具消费；4：道具买入；5：活动；6：竞猜；13：签到；14：注册；15:红包提现；16：红包退款；17：世界杯；18：课程
	 */
	public java.lang.Byte getType() {
		return getByte("type");
	}

	/**
	 * 新增经验
	 */
	public void setAddexp(java.lang.Double addexp) {
		set("addexp", addexp);
	}
	
	/**
	 * 新增经验
	 */
	public java.lang.Double getAddexp() {
		return getDouble("addexp");
	}

	/**
	 * 牛币数
	 */
	public void setCoin(java.lang.Double coin) {
		set("coin", coin);
	}
	
	/**
	 * 牛币数
	 */
	public java.lang.Double getCoin() {
		return getDouble("coin");
	}

	/**
	 * 牛丸数
	 */
	public void setFreecoin(java.lang.Double freecoin) {
		set("freecoin", freecoin);
	}
	
	/**
	 * 牛丸数
	 */
	public java.lang.Double getFreecoin() {
		return getDouble("freecoin");
	}

	/**
	 * 人民币
	 */
	public void setCny(java.lang.Double cny) {
		set("cny", cny);
	}
	
	/**
	 * 人民币
	 */
	public java.lang.Double getCny() {
		return getDouble("cny");
	}

	/**
	 * 数量
	 */
	public void setNum(java.lang.Integer num) {
		set("num", num);
	}
	
	/**
	 * 数量
	 */
	public java.lang.Integer getNum() {
		return getInt("num");
	}

	/**
	 * 新增贡献值
	 */
	public void setAdddevote(java.lang.Double adddevote) {
		set("adddevote", adddevote);
	}
	
	/**
	 * 新增贡献值
	 */
	public java.lang.Double getAdddevote() {
		return getDouble("adddevote");
	}

	/**
	 * 机器人支付：1：自付；2：代付
	 */
	public void setRobotpay(java.lang.Byte robotpay) {
		set("robotpay", robotpay);
	}
	
	/**
	 * 机器人支付：1：自付；2：代付
	 */
	public java.lang.Byte getRobotpay() {
		return getByte("robotpay");
	}

	/**
	 * 优惠金额
	 */
	public void setRebatecoin(java.lang.Double rebatecoin) {
		set("rebatecoin", rebatecoin);
	}
	
	/**
	 * 优惠金额
	 */
	public java.lang.Double getRebatecoin() {
		return getDouble("rebatecoin");
	}

	/**
	 * 备注
	 */
	public void setRemark(java.lang.String remark) {
		set("remark", remark);
	}
	
	/**
	 * 备注
	 */
	public java.lang.String getRemark() {
		return getStr("remark");
	}

	/**
	 * 创建时间
	 */
	public void setCreatetime(java.util.Date createtime) {
		set("createtime", createtime);
	}
	
	/**
	 * 创建时间
	 */
	public java.util.Date getCreatetime() {
		return get("createtime");
	}

	/**
	 * 修改时间
	 */
	public void setUpdatetime(java.util.Date updatetime) {
		set("updatetime", updatetime);
	}
	
	/**
	 * 修改时间
	 */
	public java.util.Date getUpdatetime() {
		return get("updatetime");
	}

}
