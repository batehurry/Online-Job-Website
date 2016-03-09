package com.qzw.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.exception </p>
 * <p> 类名称：CustomExceptionResolver.java  </p>
 * <p> 类描述：自定义SpringMVC异常处理器 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年11月14日  下午6:53:51
 * @version 1.0
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 前端控制器DispatcherServlet在进行HandlerMapping、调用HandlerAdapter执行Handler过程中，如果遇到异常就会执行此方法
	// handler最终要执行的Handler，它的真实身份是HandlerMethod
	// Exception ex就是接收到异常信息
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		// 输出异常
		logger.error("系统异常信息：", ex);
		// 统一异常处理代码
		// 针对系统自定义的CustomException异常，就可以直接从异常类中获取异常信息，将异常处理在错误页面展示
		// 异常信息
		String message = null;
		CustomException customException = null;
		// 如果ex是自定义的异常，直接取出异常信息
		if (ex instanceof CustomException) {
			customException = (CustomException) ex;
		} else {
			// 针对非CustomException异常，对这类重新构造成一个CustomException，异常信息为“未知错误”
			customException = new CustomException("未知错误");
		}
		// 错误 信息
		message = customException.getMessage();
		// 转向到错误 页面
		ModelAndView mv = new ModelAndView("error.html");
		mv.addObject("message", message);
		return mv;
	}
}