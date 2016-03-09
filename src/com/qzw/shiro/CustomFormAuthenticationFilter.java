package com.qzw.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.shiro </p>
 * <p> 类名称：CustomFormAuthenticationFilter.java  </p>
 * <p> 类描述：自定义FormAuthenticationFilter，认证之前实现 验证码校验 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月2日  下午11:25:30
 * @version 1.0
 */
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
	
	/* (non-Javadoc)
	 * @see org.apache.shiro.web.filter.authc.FormAuthenticationFilter#onAccessDenied(javax.servlet.ServletRequest, javax.servlet.ServletResponse)
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request,
			ServletResponse response) throws Exception {
		// 在这里进行验证码的校验
		// 从session获取正确验证码
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();
		// 取出session的验证码（正确的验证码）
		String validateCode = (String) session.getAttribute("vCode");
		if (null != validateCode) {
			validateCode = validateCode.toLowerCase();
		}
		// 取出页面的验证码
		// 输入的验证和session中的验证进行对比
		String randomcode = httpServletRequest.getParameter("validateCode");
		if (null != randomcode) {
			randomcode = randomcode.toLowerCase();
		}
		if (randomcode != null && validateCode != null && !randomcode.equals(validateCode)) {
			// 如果校验失败，将验证码错误失败信息，通过shiroLoginFailure设置到request中
			httpServletRequest.setAttribute("shiroLoginFailure", "randomCodeError");
			// 拒绝访问，不再校验账号和密码
			return true;
		}
		return super.onAccessDenied(request, response);
	}
}