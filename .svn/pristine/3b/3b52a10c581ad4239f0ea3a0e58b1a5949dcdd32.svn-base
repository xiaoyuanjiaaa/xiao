package com.fc.protocol.server.demo.persistance.mybatis;

import java.io.Serializable;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Company: </p> 
 * @author wanghw
 * @date 2016年3月21日
 */
public class Page implements Serializable {
	// serial id
	private static final long serialVersionUID = 710290672655076891L;

	// 每页显示记录数
	private int rows = 10;
	// 总页数
	private int totalPage;
	// 总记录数
	private int totalResult;
	// 当前页
	private int page;
	// 当前记录起始索引
	private int currentResult;
	// 排序字段，多个字段中间逗号分隔
	private String sidx;
	// 升序或降序
	private String sord = "asc";
	//是否计算总数
	private boolean showTotal = true;

	public int getTotalPage() {
		if (totalResult % rows == 0)
			totalPage = totalResult / rows;
		else
			totalPage = totalResult / rows + 1;
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public int getCurrentPage() {
		return page <= 0 ? 1 : page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCurrentResult() {
		currentResult = (getCurrentPage() - 1) * rows;
		return currentResult < 0 ? 0 : currentResult;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public int getPage() {
		return page;
	}

	public boolean isShowTotal() {
		return showTotal;
	}

	public void setShowTotal(boolean showTotal) {
		this.showTotal = showTotal;
	}

	public Page() {

	}

	public Page(int page, int rows, boolean showTotal, String sidx, String sord) {
		super();
		this.page = page;
		this.rows = rows;
		this.showTotal = showTotal;
		this.sidx = sidx;
		this.sord = sord;
	}

}
