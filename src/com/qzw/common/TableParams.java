package com.qzw.common;

import java.io.Serializable;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.common </p>
 * <p> 类名称：TableParams.java  </p>
 * <p> 类描述：Bootstrap Table 的参数模型 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年12月7日  上午1:54:29
 * @version 1.0
 */
public class TableParams implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 每页的记录数
	 */
	private int limit;// rows
	/**
	 * 起始的记录数
	 */
	private int offset;// page
	/**
	 * 排序字段名称
	 */
	private String sort;
	/**
	 * 排序顺序(asc、desc)
	 */
	private String order;
	/**
	 * 搜索字段
	 */
	private String search;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

}
