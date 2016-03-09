package com.qzw.contrllor;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.contrllor </p>
 * <p> 类名称：LoginController.java  </p>
 * <p> 类描述：登陆注册控制器(配合shiro来登陆) </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年11月14日  下午6:48:21
 * @version 1.0
 */
@Controller
public class LoginController extends BaseContrllor {
	
	/**
	 * <p> 方法名：loginSubmit </p>
	 * <p> 方法描述：登陆认证 </p>
	 * <p> @return
	 * <p> @throws Exception </p>
	 * <p> 返回值：String </p>
	 */
	@RequestMapping(value = "/login")
	public ModelAndView login() throws Exception {
		ModelAndView mv = new ModelAndView();
		Subject subject = SecurityUtils.getSubject();// 获取当前登陆的用户
		if (subject.isAuthenticated()) {// 如果用户已经登陆则返回主页
			mv.setViewName("redirect:/index.html");
			return mv;
		}
		mv.setViewName("login");
		// shiro在认证过程中出现错误后将异常类路径通过request返回
		String exceptionClassName = (String) super.getRequest().getAttribute("shiroLoginFailure");
		if (exceptionClassName != null) {
			if ("randomCodeError".equals(exceptionClassName)) {
				mv.addObject("errmessage", "验证码错误");
			} else if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				mv.addObject("errmessage", "用户不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				mv.addObject("errmessage", "用户名/密码错误");
			} else {
				throw new Exception(exceptionClassName);// 最终在异常处理器生成未知错误
			}
		}
		return mv;
	}
	
}