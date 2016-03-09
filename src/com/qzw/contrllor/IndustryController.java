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
import org.springframework.web.bind.annotation.RequestMethod;

import com.qzw.bean.Industry;
import com.qzw.common.Constants;
import com.qzw.common.Json;
import com.qzw.common.TableParams;
import com.qzw.service.IndustryServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.contrllor </p>
 * <p> 类名称：IndustryController.java  </p>
 * <p> 类描述：行业的控制器 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月2日  下午11:27:31
 * @version 1.0
 */
@Controller
@RequestMapping(value = "industry")
public class IndustryController extends BaseContrllor {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IndustryServiceI industryService;
	
	/**
	 * <p> 方法名：industryManager </p>
	 * <p> 方法描述：转跳行业管理页面 </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "industryManager")
	public String industryManager() throws Exception {
		return "industry/industryManager";
	}
	
	/**
	 * <p> 方法名：industryForm </p>
	 * <p> 方法描述：转跳行业表单页面 </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "industryForm")
	public String industryForm() throws Exception {
		return "industry/industryForm";
	}
	
	/**
	 * <p> 方法名：industryTable </p>
	 * <p> 方法描述：行业的数据表格 </p>
	 * <p> 返回值：void </p>
	 * @param tableParams
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "industryTable", method = RequestMethod.POST)
	public void industryTable(@RequestBody TableParams tableParams) throws Exception {
		super.writeJson(industryService.selectIndustry(tableParams));
	}
	
	/**
	 * <p> 方法名：deleteIndustry </p>
	 * <p> 方法描述：批量删除行业 </p>
	 * <p> 返回值：void </p>
	 * @param ids
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "deleteIndustry", method = RequestMethod.POST)
	public void deleteIndustry(String ids) throws Exception {
		Json json = new Json();
		try {
			int count = industryService.deleteIndustry(ids);
			if (count > 0 ) {
				json.setSuccess(true);
				json.setMsg("删除成功");
				super.writeJson(json);
			} else if (count == -1) {
				json.setMsg("行业已被其他信息关联，不能删除");
				super.writeJson(json);
			} else {
				logger.error(super.getLoginIP() + "删除行业失败");
				json.setMsg("服务器繁忙，删除失败");
				super.writeJson(json);
			}
		} catch (Exception e) {
			logger.error(super.getLoginIP() + "删除行业失败", e);
			json.setMsg("服务器繁忙，删除失败");
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：saveIndustry </p>
	 * <p> 方法描述：保存行业 </p>
	 * <p> 返回值：void </p>
	 * @param industry
	 * @param bindingResult
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "saveIndustry", method = RequestMethod.POST)
	public void saveIndustry(@RequestBody @Validated Industry industry, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			try {
				Serializable id = industryService.saveIndustry(industry);
				if (id != null) {
					json.setSuccess(true);
					json.setMsg("保存成功");
					logger.info(super.getLoginIP() + ":保存行业成功");
					super.writeJson(json);
				} else {
					json.setMsg("服务器繁忙，保存失败");
					logger.error(super.getLoginIP() + "保存行业失败");
					super.writeJson(json);
				}
			} catch (Exception e) {
				json.setMsg("服务器繁忙，保存失败");
				logger.error(super.getLoginIP() + "保存行业失败", e);
				super.writeJson(json);
			}
		} else {
			json.setMsg("修改失败," + errorInfo);
			logger.info(super.getLoginIP() + ":保存简历失败:" + errorInfo);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：editIndustry </p>
	 * <p> 方法描述：编辑行业 </p>
	 * <p> 返回值：void </p>
	 * @param industry
	 * @param bindingResult
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "editIndustry", method = RequestMethod.POST)
	public void editIndustry(@RequestBody @Validated Industry industry, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			try {
				industryService.updateIndustry(industry);
			} catch (Exception e) {
				json.setMsg("服务器繁忙，修改失败");
				logger.error(super.getLoginIP() + "修改行业失败", e);
				super.writeJson(json);
			}
			json.setSuccess(true);
			json.setMsg("修改成功");
			logger.info(super.getLoginIP() + ":修改行业成功");
			super.writeJson(json);
		} else {
			json.setMsg("修改失败," + errorInfo);
			super.writeJson(json);
		}
	}
	
}