package com.fc.information.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>Table: StoreFinance</p>
 * <p>Description: 店铺财务明细表</p>
 * @author xiaoyj
 * @date 2019-06-27 15:29:56
 */
public class StoreFinance implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id; // 
	private Integer storeId; // 
	private String storeType; // 店铺类型
	private Integer optUserId; // 操作人ID
	private String optUserName; // 操作人
	private String optType; // 操作类型
	private BigDecimal amount; // 金额
	private BigDecimal accounts; // 余额
	private Integer iid; // 对应的订单ID等
	private String iidType; // 对应的记录类型
	private String extension; // 扩展字段
	private String remark; // 备注
	private Integer dateline; // 时间
	private Integer isHandle; // 是否已处理，1已处理
	private Integer type; // 是否兑换枫币 0否 1是
	private String iidSn; // 来源订单编号
	private Integer inType; // 入账类型
	private BigDecimal changAccounts; // 账户余额改变
	private BigDecimal changBalancing; // 待结算改变
	private BigDecimal changWithdrawals; // 可提现改变
	private BigDecimal changWithdrawalsing; // 提现中改变
	private BigDecimal changDeposit; // 保证金改变
	private BigDecimal changPromotion; // 推广费改变

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	
	public Integer getStoreId() {
		return this.storeId;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	
	public String getStoreType() {
		return this.storeType;
	}
	public void setOptUserId(Integer optUserId) {
		this.optUserId = optUserId;
	}
	
	public Integer getOptUserId() {
		return this.optUserId;
	}
	public void setOptUserName(String optUserName) {
		this.optUserName = optUserName;
	}
	
	public String getOptUserName() {
		return this.optUserName;
	}
	public void setOptType(String optType) {
		this.optType = optType;
	}
	
	public String getOptType() {
		return this.optType;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public BigDecimal getAmount() {
		return this.amount;
	}
	public void setAccounts(BigDecimal accounts) {
		this.accounts = accounts;
	}
	
	public BigDecimal getAccounts() {
		return this.accounts;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	
	public Integer getIid() {
		return this.iid;
	}
	public void setIidType(String iidType) {
		this.iidType = iidType;
	}
	
	public String getIidType() {
		return this.iidType;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	public String getExtension() {
		return this.extension;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getRemark() {
		return this.remark;
	}
	public void setDateline(Integer dateline) {
		this.dateline = dateline;
	}
	
	public Integer getDateline() {
		return this.dateline;
	}
	public void setIsHandle(Integer isHandle) {
		this.isHandle = isHandle;
	}
	
	public Integer getIsHandle() {
		return this.isHandle;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getType() {
		return this.type;
	}
	public void setIidSn(String iidSn) {
		this.iidSn = iidSn;
	}
	
	public String getIidSn() {
		return this.iidSn;
	}
	public void setInType(Integer inType) {
		this.inType = inType;
	}
	
	public Integer getInType() {
		return this.inType;
	}
	public void setChangAccounts(BigDecimal changAccounts) {
		this.changAccounts = changAccounts;
	}
	
	public BigDecimal getChangAccounts() {
		return this.changAccounts;
	}
	public void setChangBalancing(BigDecimal changBalancing) {
		this.changBalancing = changBalancing;
	}
	
	public BigDecimal getChangBalancing() {
		return this.changBalancing;
	}
	public void setChangWithdrawals(BigDecimal changWithdrawals) {
		this.changWithdrawals = changWithdrawals;
	}
	
	public BigDecimal getChangWithdrawals() {
		return this.changWithdrawals;
	}
	public void setChangWithdrawalsing(BigDecimal changWithdrawalsing) {
		this.changWithdrawalsing = changWithdrawalsing;
	}
	
	public BigDecimal getChangWithdrawalsing() {
		return this.changWithdrawalsing;
	}
	public void setChangDeposit(BigDecimal changDeposit) {
		this.changDeposit = changDeposit;
	}
	
	public BigDecimal getChangDeposit() {
		return this.changDeposit;
	}
	public void setChangPromotion(BigDecimal changPromotion) {
		this.changPromotion = changPromotion;
	}
	
	public BigDecimal getChangPromotion() {
		return this.changPromotion;
	}

    @Override
    public String toString () {
    	return "StoreFinance{" + 
	    	"id=" + id + 
	    	", storeId=" + storeId + 
	    	", storeType=" + storeType + 
	    	", optUserId=" + optUserId + 
	    	", optUserName=" + optUserName + 
	    	", optType=" + optType + 
	    	", amount=" + amount + 
	    	", accounts=" + accounts + 
	    	", iid=" + iid + 
	    	", iidType=" + iidType + 
	    	", extension=" + extension + 
	    	", remark=" + remark + 
	    	", dateline=" + dateline + 
	    	", isHandle=" + isHandle + 
	    	", type=" + type + 
	    	", iidSn=" + iidSn + 
	    	", inType=" + inType + 
	    	", changAccounts=" + changAccounts + 
	    	", changBalancing=" + changBalancing + 
	    	", changWithdrawals=" + changWithdrawals + 
	    	", changWithdrawalsing=" + changWithdrawalsing + 
	    	", changDeposit=" + changDeposit + 
	    	", changPromotion=" + changPromotion + 
	    	"}";
    }
}