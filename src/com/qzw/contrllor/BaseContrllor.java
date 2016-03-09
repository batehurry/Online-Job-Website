package com.qzw.contrllor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.qzw.bean.User;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.contrllor </p>
 * <p> 类名称：BaseContrllor.java  </p>
 * <p> 类描述：基础的Contrllor </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年11月14日  下午2:54:39
 * @version 1.0
 */
public abstract class BaseContrllor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * request
	 */
	private NamedThreadLocal<HttpServletRequest> request = new NamedThreadLocal<HttpServletRequest>("HttpSevletRequest");
	/**
	 * response
	 */
	private NamedThreadLocal<HttpServletResponse> response = new NamedThreadLocal<HttpServletResponse>("HttpServletResponse");
	/**
	 * session
	 */
	private NamedThreadLocal<HttpSession> session = new NamedThreadLocal<HttpSession>("HttpSession");
	/**
	 * out
	 */
	private NamedThreadLocal<PrintWriter> out = new NamedThreadLocal<PrintWriter>("PrintWriter");

	/**
	 * <p> 方法名：initAttribute </p>
	 * <p> 方法描述：初始化属性 </p>
	 * <p> @param request
	 * <p> @param response </p>
	 * <p> 返回值：void </p>
	 */
	@ModelAttribute
	protected void initAttribute(HttpServletRequest request, HttpServletResponse response) {
		// 设置编码
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			logger.warn("request转换UTF-8编码异常！", e);
		}
		response.setCharacterEncoding("UTF-8");
		// 获取对象
		this.request.set(request);
		this.response.set(response);
		this.session.set(request.getSession());
		try {
			this.out.set(response.getWriter());
		} catch (IOException e) {
			logger.error("获取getResponse().getWriter()失败！", e);
		}
	}

	/**
	 * <p> 方法名：getRequest </p>
	 * <p> 方法描述：获取request对象 </p>
	 * <p> 返回值：HttpServletRequest </p>
	 * @return
	 */
	protected HttpServletRequest getRequest() {
		return request.get();
	}

	/**
	 * <p> 方法名：getResponse </p>
	 * <p> 方法描述：获取response对象 </p>
	 * <p> 返回值：HttpServletResponse </p>
	 * @return
	 */
	protected HttpServletResponse getResponse() {
		return response.get();
	}

	/**
	 * <p> 方法名：getSession </p>
	 * <p> 方法描述：获取session对象 </p>
	 * <p> 返回值：HttpSession </p>
	 * @return
	 */
	protected HttpSession getSession() {
		return session.get();
	}

	/**
	 * <p> 方法名：getOut </p>
	 * <p> 方法描述：获取out对象 </p>
	 * <p> 返回值：PrintWriter </p>
	 * @return
	 */
	protected PrintWriter getOut() {
		return out.get();
	}

	/**
	 * <p> 方法名：paramErrorInfo </p>
	 * <p> 方法描述: 把参数的错误验证信息记录到日志，并反给前台页面</p>
	 * <p> @param result
	 * <p> @return </p>
	 * <p> 返回值：List<ObjectError> </p>
	 */
	protected String paramErrorInfo(BindingResult bindingResult) {
		StringBuffer sb = new StringBuffer();
		List<ObjectError> errorList = null;
		if (bindingResult != null && bindingResult.hasErrors()) {
			errorList = bindingResult.getAllErrors();
			for (ObjectError objectError : errorList) {
				sb.append(objectError.getDefaultMessage()).append("!\r\n");
				logger.warn(objectError.toString(), objectError);
			}
		}
		return sb.toString();
	}
	
	/*校验注解
	@Null   被注释的元素必须为 null
	@NotNull    被注释的元素必须不为 null
	@AssertTrue     被注释的元素必须为 true
	@AssertFalse    被注释的元素必须为 false
	@Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值
	@Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值
	@DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值   
	@DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值   
	@Size(max=, min=)   被注释的元素的大小必须在指定的范围内   
	@Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内   
	@Past   被注释的元素必须是一个过去的日期   
	@Future     被注释的元素必须是一个将来的日期   
	@Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式   
	Hibernate Validator 附加的 constraint
	@NotBlank(message =)   验证字符串非null，且长度必须大于0   
	@Email  被注释的元素必须是电子邮箱地址   
	@Length(min=,max=)  被注释的字符串的大小必须在指定的范围内   
	@NotEmpty   被注释的字符串的必须非空   
	@Range(min=,max=,message=)  被注释的元素必须在合适的范围内*/
	
	/**
	 * <p> 方法名：getLoginUser </p>
	 * <p> 方法描述：获取当前登录用户的信息 </p>
	 * <p> 返回值：User </p>
	 * @return
	 */
	protected User getLoginUser() {
		Subject subject = SecurityUtils.getSubject();
		return (User) subject.getPrincipal();
	}
	
	/**
	 * <p> 方法名：toJsonString </p>
	 * <p> 方法描述：转换JSON字符串，其中日期按照yyyy-MM-dd HH:mm:ss的格式 </p>
	 * <p> 返回值：String </p>
	 * @param object
	 * @return
	 */
	protected String toJsonString(Object object) {
		return JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * <p> 方法名：writeJson </p>
	 * <p> 方法描述：将对象转换成JSON字符串，并响应回前台 </p>
	 * <p> @param object </p>
	 * <p> 返回值：void </p>
	 */
	protected void writeJson(Object object) {
		String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
		getResponse().setContentType("application/json;charset=UTF-8");
		getOut().write(json);
		getOut().flush();
		getOut().close();
	}
	
	/**
	 * <p> 方法名：getLoginIP </p>
	 * <p> 方法描述：获取当前用户的IP </p>
	 * <p> @return </p>
	 * <p> 返回值：String </p>
	 */
	protected String getLoginIP() {
		String ip = getRequest().getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getRemoteAddr();
		}
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			ip = "本地";
		}
		if (ip.split(",").length > 1) {
			ip = ip.split(",")[0];
		}
		return ip;
	}
	
	/**
	 * <p> 方法名：getIpInfo </p>
	 * <p> 方法描述：通过IP获取地址(需要联网，调用淘宝的IP库) </p>
	 * <p> 返回值：String </p>
	 * @param ip
	 * @return
	 * @throws IOException
	 */
	protected String getIpInfo(String ip) throws IOException {
		if (ip.equals("本地")) {
			ip = "127.0.0.1";
		}
		String info = "";
		URL url = new URL("http://ip.taobao.com/service/getIpInfo.php?ip=" + ip);
		HttpURLConnection htpcon = (HttpURLConnection) url.openConnection();
		htpcon.setRequestMethod("GET");
		htpcon.setDoOutput(true);
		htpcon.setDoInput(true);
		htpcon.setUseCaches(false);
		InputStream in = htpcon.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		StringBuffer temp = new StringBuffer();
		String line = bufferedReader.readLine();
		while (line != null) {
			temp.append(line).append("\r\n");
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		JSONObject obj = (JSONObject) JSON.parse(temp.toString());
		if (obj.getIntValue("code") == 0) {
			JSONObject data = obj.getJSONObject("data");
			info += data.getString("country") + " ";
			info += data.getString("region") + " ";
			info += data.getString("city") + " ";
			info += data.getString("isp");
		}
		return info;
	}
	
	
	/**
	 * <p> 方法名：getRes </p>
	 * <p> 方法描述：获取当前语言并绑定对应的国际化文件 </p>
	 * <p> 返回值：ResourceBundle </p>
	 * @return
	 */
	protected ResourceBundle getRes() {
		Locale locale = Locale.getDefault();
		if (getRequest() != null && getRequest().getLocale() != null) {
			locale = getRequest().getLocale();
		}
		ResourceBundle res = ResourceBundle.getBundle("messages", locale);
		return res;
	}
	
}