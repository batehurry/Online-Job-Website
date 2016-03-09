package com.qzw.common;

import java.io.Serializable;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.common </p>
 * <p> 类名称：Json.java  </p>
 * <p> 类描述：响应前台的Json数据模型 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年12月7日  上午1:55:06
 * @version 1.0
 */
public class Json implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean success = false;

	private String msg = "";

	private Object obj = null;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
