package com.qzw.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.interceptors </p>
 * <p> 类名称：EncodingInterceptor.java  </p>
 * <p> 类描述：字符集拦截器 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年11月21日  下午9:07:05
 * @version 1.0
 */
public class EncodingInterceptor extends HandlerInterceptorAdapter {
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		return true;
	}
}
