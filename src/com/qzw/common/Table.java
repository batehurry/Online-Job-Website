package com.qzw.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.common </p>
 * <p> 类名称：Table.java  </p>
 * <p> 类描述：Bootstrap Table 的数据模型 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年12月7日  上午1:53:06
 * @version 1.0
 */
public class Table<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 总数
	 */
	private Long total = 0L;
	/**
	 * 行内容
	 */
	private List<T> rows = new ArrayList<T>();

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}