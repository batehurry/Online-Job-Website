package com.qzw.exception;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.exception </p>
 * <p> 类名称：CustomException.java  </p>
 * <p> 类描述：自定义异常类 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年11月14日  下午6:53:36
 * @version 1.0
 */
public class CustomException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String message;

	public CustomException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
