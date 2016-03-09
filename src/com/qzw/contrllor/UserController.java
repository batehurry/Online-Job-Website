package com.qzw.contrllor;

import java.io.Serializable;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qzw.bean.Enterprise;
import com.qzw.bean.Jobhunter;
import com.qzw.bean.User;
import com.qzw.common.Constants;
import com.qzw.common.Json;
import com.qzw.service.DictServiceI;
import com.qzw.service.UserServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.contrllor </p>
 * <p> 类名称：UserController.java  </p>
 * <p> 类描述：用户控制器 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月2日  下午11:28:16
 * @version 1.0
 */
@Controller
@RequestMapping(value = "user")
public class UserController extends BaseContrllor {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserServiceI userService;
	
	@Autowired
	private DictServiceI dictService;
	
	/**
	 * <p> 方法名：register1 </p>
	 * <p> 方法描述：跳转到求职者注册页面 </p>
	 * <p> 返回值：ModelAndView </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "registerPage1")
	public ModelAndView registerPage1() throws Exception {
		ModelAndView mv = new ModelAndView("register1");
		mv.addObject("sex", dictService.selectDictByType(Constants.SEX));
		return mv;
	}
	
	/**
	 * <p> 方法名：register2 </p>
	 * <p> 方法描述：跳转到用人单位注册页面 </p>
	 * <p> 返回值：ModelAndView </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "registerPage2")
	public ModelAndView registerPage2() throws Exception {
		ModelAndView mv = new ModelAndView("register2");
		mv.addObject("type", dictService.selectDictByType(Constants.ENTERPRISE_TYPE));
		return mv;
	}
	
	/**
	 * <p> 方法名：register1 </p>
	 * <p> 方法描述：注册求职者信息 </p>
	 * <p> 返回值：ModelAndView </p>
	 * @param user
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "register1")
	public void register1(@RequestBody @Validated User user, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			if(userService.findUserById(user.getUserName()) != null) {
				json.setMsg("您注册的电子邮箱已经被注册！");
				super.writeJson(json);
			} else {
				Serializable id = userService.saveUser1(user);
				if (id != null) {
					json.setSuccess(true);
					json.setMsg("恭喜你，注册成功！");
					super.writeJson(json);
				} else {
					json.setMsg("对不起，注册失败！");
					super.writeJson(json);
				}
			}
		} else {
			json.setMsg("对不起，注册失败！" + errorInfo);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：register2 </p>
	 * <p> 方法描述：注册用人单位信息 </p>
	 * <p> 返回值：ModelAndView </p>
	 * @param user
	 * @param bindingResult
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "register2")
	public void register2(@RequestBody @Validated User user, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			if(userService.findUserById(user.getUserName()) != null) {
				json.setMsg("您注册的电子邮箱已经被注册！");
				super.writeJson(json);
			} else {
				Serializable id = userService.saveUser2(user);
				if (id != null) {
					json.setSuccess(true);
					json.setMsg("恭喜你，注册成功！");
					super.writeJson(json);
				} else {
					json.setMsg("对不起，注册失败！");
					super.writeJson(json);
				}
			}
		} else {
			json.setMsg("对不起，注册失败！" + errorInfo);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：userInfoPage </p>
	 * <p> 方法描述：跳转用户信息页面 </p>
	 * <p> 返回值：ModelAndView </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "userInfoPage")
	public ModelAndView userInfoPage() throws Exception {
		ModelAndView mv = new ModelAndView();
		if (Constants.JOBHUNTER.equals(getLoginUser().getRole().getId())) { // 求职者
			mv.setViewName("common/showUserInfo1");
			mv.addObject("sex", dictService.selectDictByType(Constants.SEX));
			mv.addObject("userInfo", toJsonString(getLoginUser().getJobhunter()));
		}
		if (Constants.ENTERPRISE.equals(getLoginUser().getRole().getId())) { // 企业
			mv.setViewName("common/showUserInfo2");
			mv.addObject("type", dictService.selectDictByType(Constants.ENTERPRISE_TYPE));
			mv.addObject("userInfo", toJsonString(getLoginUser().getEnterprise()));
		}
		return mv;
	}
	
	/**
	 * <p> 方法名：modUserInfo1 </p>
	 * <p> 方法描述：修改求职者的用户信息 </p>
	 * <p> 返回值：void </p>
	 * @param jobhunter
	 */
	@RequiresRoles(Constants.JOBHUNTER)
	@RequestMapping(value = "modUserInfo1")
	public void modUserInfo1(@RequestBody @Validated Jobhunter jobhunter, BindingResult bindingResult) {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			try {
				userService.updateUserInfo1(jobhunter);
				json.setSuccess(true);
				json.setMsg("修改用户信息成功，下次登录显示修改后的信息");
				logger.info(super.getLoginIP() + ":修改用户信息成功");
				super.writeJson(json);
			} catch (Exception e) {
				json.setMsg("修改用户信息失败");
				logger.error(super.getLoginIP() + ":修改用户信息失败", e);
				super.writeJson(json);
			}
		} else {
				json.setMsg(errorInfo);
				logger.info(super.getLoginIP() + ":保存简历失败:" + errorInfo);
				super.writeJson(json);
			}
	}
	
	/**
	 * <p> 方法名：modUserInfo2 </p>
	 * <p> 方法描述：修改企业的用户信息 </p>
	 * <p> 返回值：void </p>
	 * @param enterprise
	 */
	@RequiresRoles(Constants.ENTERPRISE)
	@RequestMapping(value = "modUserInfo2")
	public void modUserInfo2(@RequestBody @Validated Enterprise enterprise, BindingResult bindingResult) {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			try {
				userService.updateUserInfo2(enterprise);
				json.setSuccess(true);
				json.setMsg("修改用户信息成功，下次登录显示修改后的信息");
				logger.info(super.getLoginIP() + ":修改用户信息成功");
				super.writeJson(json);
			} catch (Exception e) {
				json.setMsg("修改用户信息失败");
				logger.error(super.getLoginIP() + ":修改用户信息失败", e);
				super.writeJson(json);
			}
		} else {
			json.setMsg(errorInfo);
			logger.info(super.getLoginIP() + ":保存简历失败:" + errorInfo);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：modPwdPage </p>
	 * <p> 方法描述：转跳更改密码页面 </p>
	 * <p> 返回值：ModelAndView </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "modPwdPage")
	public String modPwdPage() throws Exception {
		return "common/modPwd";
	}
	
	/**
	 * <p> 方法名：modPwd </p>
	 * <p> 方法描述：修改用户密码 </p>
	 * <p> 返回值：void </p>
	 * @param pwd
	 * @throws Exception
	 */
	@RequestMapping(value = "modPwd")
	public void modPwd(String pwd) throws Exception {
		Json json = new Json();
		try {
			userService.updatePwd(pwd, getLoginUser());
			json.setSuccess(true);
			json.setMsg("修改密码成功，下次登录请使用新密码");
			logger.info(super.getLoginIP() + ":修改密码成功");
			super.writeJson(json);
		} catch (Exception e) {
			json.setMsg("修改密码失败");
			logger.error(super.getLoginIP() + ":修改密码失败", e);
			super.writeJson(json);
		}
	}
	
}