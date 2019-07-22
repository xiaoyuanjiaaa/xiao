package com.fc.member.store.user.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>Table: StoreLicense</p>
 * <p>Description: 服务模板表</p>
 * @author xiaoyj
 * @date 2019-06-28 11:15:43
 */
public class StoreLicense implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id; // 
	private String sname; // 服务名称
	private String code; // 
	private String useType; // 使用的地方
	private String carpart; // 隶属系统
	private Float taskTime; // 所需工时
	private BigDecimal sfee; // 服务费用
	private Long prizeFee; // 师傅奖金
	private Integer sScore; // 难度系数
	private String sLogo; // 资质logo图片
	private Integer priceUnit; // 计价方式
	private String description; // 服务介绍
	private Integer sortOrder; // 
	private String requireEquipment; // 设备要求，以，隔开
	private String requireTools; // 工具要求，以，隔开
	private String requireStaff; // 人员要求，以，隔开
	private String sstoreSubsidy; // 门店补贴
	private String techSubsidy; // 师傅补贴
	private Integer isShow; // 是否显示（1：是，0：否）
	private Integer valuationWay; // 计价方式 1计数 2计次
	private Integer limitNum; // 数量限制
	private BigDecimal balancePrice; // 
	private Integer cateId; // fc_service_category分类id
	private Integer serviceChargeWayId; // 服务计价方式id
	private Integer imagesId; // 图片id
	private String materialParams; // 用料参数 多个以逗号隔开
	private String serviceImgs; // 服务主图片 多个以逗号隔开
	private String installStandardUrl; // 安装标准URL
	private String serviceFlowUrl; // 服务流程URL
	private String serviceNote; // 新版本的服务介绍
	private String serviceFlow; // 服务流程
	private String installStandard; // 安装标准

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public String getSname() {
		return this.sname;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	public void setUseType(String useType) {
		this.useType = useType;
	}
	
	public String getUseType() {
		return this.useType;
	}
	public void setCarpart(String carpart) {
		this.carpart = carpart;
	}
	
	public String getCarpart() {
		return this.carpart;
	}
	public void setTaskTime(Float taskTime) {
		this.taskTime = taskTime;
	}
	
	public Float getTaskTime() {
		return this.taskTime;
	}
	public void setSfee(BigDecimal sfee) {
		this.sfee = sfee;
	}
	
	public BigDecimal getSfee() {
		return this.sfee;
	}
	public void setPrizeFee(Long prizeFee) {
		this.prizeFee = prizeFee;
	}
	
	public Long getPrizeFee() {
		return this.prizeFee;
	}
	public void setSScore(Integer sScore) {
		this.sScore = sScore;
	}
	
	public Integer getSScore() {
		return this.sScore;
	}
	public void setSLogo(String sLogo) {
		this.sLogo = sLogo;
	}
	
	public String getSLogo() {
		return this.sLogo;
	}
	public void setPriceUnit(Integer priceUnit) {
		this.priceUnit = priceUnit;
	}
	
	public Integer getPriceUnit() {
		return this.priceUnit;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	
	public Integer getSortOrder() {
		return this.sortOrder;
	}
	public void setRequireEquipment(String requireEquipment) {
		this.requireEquipment = requireEquipment;
	}
	
	public String getRequireEquipment() {
		return this.requireEquipment;
	}
	public void setRequireTools(String requireTools) {
		this.requireTools = requireTools;
	}
	
	public String getRequireTools() {
		return this.requireTools;
	}
	public void setRequireStaff(String requireStaff) {
		this.requireStaff = requireStaff;
	}
	
	public String getRequireStaff() {
		return this.requireStaff;
	}
	public void setSstoreSubsidy(String sstoreSubsidy) {
		this.sstoreSubsidy = sstoreSubsidy;
	}
	
	public String getSstoreSubsidy() {
		return this.sstoreSubsidy;
	}
	public void setTechSubsidy(String techSubsidy) {
		this.techSubsidy = techSubsidy;
	}
	
	public String getTechSubsidy() {
		return this.techSubsidy;
	}
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	
	public Integer getIsShow() {
		return this.isShow;
	}
	public void setValuationWay(Integer valuationWay) {
		this.valuationWay = valuationWay;
	}
	
	public Integer getValuationWay() {
		return this.valuationWay;
	}
	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}
	
	public Integer getLimitNum() {
		return this.limitNum;
	}
	public void setBalancePrice(BigDecimal balancePrice) {
		this.balancePrice = balancePrice;
	}
	
	public BigDecimal getBalancePrice() {
		return this.balancePrice;
	}
	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}
	
	public Integer getCateId() {
		return this.cateId;
	}
	public void setServiceChargeWayId(Integer serviceChargeWayId) {
		this.serviceChargeWayId = serviceChargeWayId;
	}
	
	public Integer getServiceChargeWayId() {
		return this.serviceChargeWayId;
	}
	public void setImagesId(Integer imagesId) {
		this.imagesId = imagesId;
	}
	
	public Integer getImagesId() {
		return this.imagesId;
	}
	public void setMaterialParams(String materialParams) {
		this.materialParams = materialParams;
	}
	
	public String getMaterialParams() {
		return this.materialParams;
	}
	public void setServiceImgs(String serviceImgs) {
		this.serviceImgs = serviceImgs;
	}
	
	public String getServiceImgs() {
		return this.serviceImgs;
	}
	public void setInstallStandardUrl(String installStandardUrl) {
		this.installStandardUrl = installStandardUrl;
	}
	
	public String getInstallStandardUrl() {
		return this.installStandardUrl;
	}
	public void setServiceFlowUrl(String serviceFlowUrl) {
		this.serviceFlowUrl = serviceFlowUrl;
	}
	
	public String getServiceFlowUrl() {
		return this.serviceFlowUrl;
	}
	public void setServiceNote(String serviceNote) {
		this.serviceNote = serviceNote;
	}
	
	public String getServiceNote() {
		return this.serviceNote;
	}
	public void setServiceFlow(String serviceFlow) {
		this.serviceFlow = serviceFlow;
	}
	
	public String getServiceFlow() {
		return this.serviceFlow;
	}
	public void setInstallStandard(String installStandard) {
		this.installStandard = installStandard;
	}
	
	public String getInstallStandard() {
		return this.installStandard;
	}

    @Override
    public String toString () {
    	return "StoreLicense{" + 
	    	"id=" + id + 
	    	", sname=" + sname + 
	    	", code=" + code + 
	    	", useType=" + useType + 
	    	", carpart=" + carpart + 
	    	", taskTime=" + taskTime + 
	    	", sfee=" + sfee + 
	    	", prizeFee=" + prizeFee + 
	    	", sScore=" + sScore + 
	    	", sLogo=" + sLogo + 
	    	", priceUnit=" + priceUnit + 
	    	", description=" + description + 
	    	", sortOrder=" + sortOrder + 
	    	", requireEquipment=" + requireEquipment + 
	    	", requireTools=" + requireTools + 
	    	", requireStaff=" + requireStaff + 
	    	", sstoreSubsidy=" + sstoreSubsidy + 
	    	", techSubsidy=" + techSubsidy + 
	    	", isShow=" + isShow + 
	    	", valuationWay=" + valuationWay + 
	    	", limitNum=" + limitNum + 
	    	", balancePrice=" + balancePrice + 
	    	", cateId=" + cateId + 
	    	", serviceChargeWayId=" + serviceChargeWayId + 
	    	", imagesId=" + imagesId + 
	    	", materialParams=" + materialParams + 
	    	", serviceImgs=" + serviceImgs + 
	    	", installStandardUrl=" + installStandardUrl + 
	    	", serviceFlowUrl=" + serviceFlowUrl + 
	    	", serviceNote=" + serviceNote + 
	    	", serviceFlow=" + serviceFlow + 
	    	", installStandard=" + installStandard + 
	    	"}";
    }
}