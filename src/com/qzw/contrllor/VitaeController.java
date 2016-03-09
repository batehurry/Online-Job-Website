package com.qzw.contrllor;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qzw.bean.EducationExp;
import com.qzw.bean.Vitae;
import com.qzw.bean.WorkExp;
import com.qzw.common.Constants;
import com.qzw.common.Json;
import com.qzw.common.TableParams;
import com.qzw.contrllor.validation.ValidGroup1;
import com.qzw.service.DictServiceI;
import com.qzw.service.IndustryServiceI;
import com.qzw.service.VitaeServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.contrllor </p>
 * <p> 类名称：VitaeController.java  </p>
 * <p> 类描述：简历的控制器 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年12月25日  下午3:31:44
 * @version 1.0
 */
@Controller
@RequestMapping(value = "vitae")
public class VitaeController extends BaseContrllor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private VitaeServiceI vitaeService;
	
	@Autowired
	private IndustryServiceI industryService;
	
	@Autowired
	private DictServiceI dictService;
	
	/**
	 * <p> 方法名：chooseVitae </p>
	 * <p> 方法描述：转跳简历选择页面 </p>
	 * <p> 返回值：ModelAndView </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "chooseVitae")
	public ModelAndView chooseVitae() throws Exception {
		ModelAndView mv = new ModelAndView("vitae/chooseVitae");
		mv.addObject("vitaeList", vitaeService.selectVitae(getLoginUser()));
		return mv;
	}

	/**
	 * <p> 方法名：vitae </p>
	 * <p> 方法描述：跳转简历管理界面 </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "vitae")
	public String vitae() throws Exception {
		return "vitae/vitaeManager";
	}
	
	/**
	 * <p> 方法名：vitaeDetail </p>
	 * <p> 方法描述：跳转简历详情页面 </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "vitaeDetail")
	public String vitaeDetail() throws Exception {
		return "vitae/vitaeDetail";
	}
	
	/**
	 * <p> 方法名：vitaeDetail </p>
	 * <p> 方法描述：跳转简历详情页面 </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "educationExpDetail")
	public String educationExpDetail() throws Exception {
		return "vitae/educationExpDetail";
	}
	
	/**
	 * <p> 方法名：vitaeDetail </p>
	 * <p> 方法描述：跳转简历详情页面 </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "workExpDetail")
	public String workExpDetail() throws Exception {
		return "vitae/workExpDetail";
	}
	
	/**
	 * <p> 方法名：vitaeTable </p>
	 * <p> 方法描述：简历的Table数据 </p>
	 * <p> 返回值：void </p>
	 * @param tableParams
	 * @throws Exception
	 */
	@RequestMapping(value = "vitaeTable")
	public void vitaeTable(@RequestBody TableParams tableParams) throws Exception {
		super.writeJson(vitaeService.selectVitae(tableParams, super.getLoginUser()));
	}
	
	/**
	 * <p> 方法名：educationExpTable </p>
	 * <p> 方法描述：教育经历的Table数据 </p>
	 * <p> 返回值：void </p>
	 * @param tableParams
	 * @throws Exception
	 */
	@RequestMapping(value = "educationExpTable")
	public void educationExpTable(@RequestBody TableParams tableParams) throws Exception {
		super.writeJson(vitaeService.selectEducationExp(tableParams, super.getLoginUser()));
	}
	
	/**
	 * <p> 方法名：workExpTable </p>
	 * <p> 方法描述：工作经验的Table数据 </p>
	 * <p> 返回值：void </p>
	 * @param tableParams
	 * @throws Exception
	 */
	@RequestMapping(value = "workExpTable")
	public void workExpTable(@RequestBody TableParams tableParams) throws Exception {
		super.writeJson(vitaeService.selectWorkExp(tableParams, super.getLoginUser()));
	}

	/**
	 * <p> 方法名：createVitae </p>
	 * <p> 方法描述：跳转简历详情页面 </p>
	 * <p> 返回值：ModelAndView </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "vitaeForm")
	public ModelAndView vitaeForm() throws Exception {
		ModelAndView mv = new ModelAndView("vitae/vitaeForm");
		mv.addObject("sex", dictService.selectDictByType(Constants.SEX));
		mv.addObject("salary", dictService.selectDictByType(Constants.SALARY));
		mv.addObject("married", dictService.selectDictByType(Constants.MARRIED));
		mv.addObject("workExpState", dictService.selectDictByType(Constants.WORK_EXP_STATE));
		mv.addObject("workState", dictService.selectDictByType(Constants.WORK_STATE));
		mv.addObject("workType", dictService.selectDictByType(Constants.WORK_TYPE));
		mv.addObject("industry", industryService.selectIndustry());
		mv.addObject("educationExpList", vitaeService.selectEducationExp(super.getLoginUser()));
		mv.addObject("workExpList", vitaeService.selectWorkExp(super.getLoginUser()));
		return mv;
	}
	
	/**
	 * <p> 方法名：createEducationExp </p>
	 * <p> 方法描述：跳转教育经历详情页面 </p>
	 * <p> 返回值：ModelAndView </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "educationExpForm")
	public String educationExpForm() throws Exception {
		return "vitae/educationExpForm";
	}

	/**
	 * <p> 方法名：createWorkExp </p>
	 * <p> 方法描述：跳转工作经验详情页面 </p>
	 * <p> 返回值：ModelAndView </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "workExpForm")
	public String workExpForm() throws Exception {
		return "vitae/workExpForm";
	}
	
	@RequestMapping(value = "saveVitae", method = RequestMethod.POST)
	public void saveVitae(@RequestBody @Validated(value = ValidGroup1.class) Vitae vitae, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			vitae.setUser(getLoginUser());
			try {
				Serializable id = vitaeService.saveVitae(vitae);
				if (id != null) {
					json.setSuccess(true);
					json.setMsg("保存成功");
					logger.info(super.getLoginIP() + ":保存简历成功");
					super.writeJson(json);
				} else {
					json.setMsg("服务器繁忙，保存失败");
					logger.error(super.getLoginIP() + "保存简历失败");
					super.writeJson(json);
				}
			} catch (Exception e) {
				json.setMsg("服务器繁忙，保存失败");
				logger.error(super.getLoginIP() + "保存简历失败", e);
				super.writeJson(json);
			}
		} else {
			json.setMsg(errorInfo);
			logger.info(super.getLoginIP() + ":保存简历失败:" + errorInfo);
			super.writeJson(json);
		}
	}

	@RequestMapping(value = "saveEducationExp", method = RequestMethod.POST)
	public void saveEducationExp(@RequestBody @Validated EducationExp educationExp, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			educationExp.setUser(getLoginUser());
			try {
				Serializable id = vitaeService.saveEducationExp(educationExp);
				if (id != null) {
					json.setSuccess(true);
					json.setMsg("保存成功");
					logger.info(super.getLoginIP() + ":保存教育经历成功");
					super.writeJson(json);
				} else {
					json.setMsg("服务器繁忙，保存失败");
					logger.error(super.getLoginIP() + "保存教育经历失败");
					super.writeJson(json);
				}
			} catch (Exception e) {
				json.setMsg("服务器繁忙，保存失败");
				logger.error(super.getLoginIP() + "保存教育经历失败", e);
				super.writeJson(json);
			}
		} else {
			json.setMsg(errorInfo);
			logger.info(super.getLoginIP() + ":保存教育经历失败:" + errorInfo);
			super.writeJson(json);
		}
	}

	@RequestMapping(value = "saveWorkExp", method = RequestMethod.POST)
	public void saveWorkExp(@RequestBody @Validated(value = { ValidGroup1.class }) WorkExp workExp, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			workExp.setUser(getLoginUser());
			try {
				Serializable id = vitaeService.saveWorkExp(workExp);
				if (id != null) {
					json.setSuccess(true);
					json.setMsg("保存成功");
					logger.info(super.getLoginIP() + ":保存工作经历成功");
					super.writeJson(json);
				} else {
					json.setMsg("服务器繁忙，保存失败");
					logger.error(super.getLoginIP() + "保存工作经历失败");
					super.writeJson(json);
				}
			} catch (Exception e) {
				json.setMsg("服务器繁忙，保存失败");
				logger.error(super.getLoginIP() + "保存工作经历失败", e);
				super.writeJson(json);
			}
		} else {
			json.setMsg("修改失败," + errorInfo);
			logger.info(super.getLoginIP() + ":保存工作经历失败:" + errorInfo);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：editVitae </p>
	 * <p> 方法描述：修改简历 </p>
	 * <p> 返回值：void </p>
	 * @param vitae
	 * @param bindingResult
	 * @throws Exception
	 */
	@RequestMapping(value = "editVitae", method = RequestMethod.POST)
	public void editVitae(@RequestBody @Validated Vitae vitae, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			try {
				vitaeService.editVitae(vitae);
			} catch (Exception e) {
				json.setMsg("服务器繁忙，修改失败");
				logger.error(super.getLoginIP() + "修改简历失败", e);
				super.writeJson(json);
			}
			json.setSuccess(true);
			json.setMsg("修改成功");
			logger.info(super.getLoginIP() + ":修改简历成功");
			super.writeJson(json);
		} else {
			json.setMsg("修改失败," + errorInfo);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：editEducationExp </p>
	 * <p> 方法描述：修改教育经历 </p>
	 * <p> 返回值：void </p>
	 * @param educationExp
	 * @param bindingResult
	 * @throws Exception
	 */
	@RequestMapping(value = "editEducationExp", method = RequestMethod.POST)
	public void editEducationExp(@RequestBody @Validated EducationExp educationExp, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			try {
				vitaeService.editEducationExp(educationExp);
			} catch (Exception e) {
				json.setMsg("服务器繁忙，修改失败");
				logger.error(super.getLoginIP() + "修改教育经历失败", e);
				super.writeJson(json);
			}
			json.setSuccess(true);
			json.setMsg("修改成功");
			logger.info(super.getLoginIP() + ":修改教育经历成功");
			super.writeJson(json);
		} else {
			json.setMsg("修改失败," + errorInfo);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：editWorkExp </p>
	 * <p> 方法描述：修改工作经验 </p>
	 * <p> 返回值：void </p>
	 * @param workExp
	 * @param bindingResult
	 * @throws Exception
	 */
	@RequestMapping(value = "editWorkExp", method = RequestMethod.POST)
	public void editWorkExp(@RequestBody @Validated WorkExp workExp, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			try {
				vitaeService.editWorkExp(workExp);
			} catch (Exception e) {
				json.setMsg("服务器繁忙，修改失败");
				logger.error(super.getLoginIP() + "修改工作经验失败", e);
				super.writeJson(json);
			}
			json.setSuccess(true);
			json.setMsg("修改成功");
			logger.info(super.getLoginIP() + ":修改工作经验成功");
			super.writeJson(json);
		} else {
			json.setMsg("修改失败," + errorInfo);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：deleteVitae </p>
	 * <p> 方法描述：删除简历 </p>
	 * <p> 返回值：void </p>
	 * @param ids
	 * @throws Exception
	 */
	@RequestMapping(value = "deleteVitae", method = RequestMethod.POST)
	public void deleteVitae(String ids) throws Exception {
		Json json = new Json();
		try {
			int falg = vitaeService.deleteVitae(ids);
			if(falg > 0) {
				json.setSuccess(true);
				json.setMsg("删除成功");
				logger.info(super.getLoginIP() + ":删除简历成功");
				super.writeJson(json);
			} else if (falg == -1) {
				json.setMsg("简历已被其他信息关联，不能删除");
				super.writeJson(json);
			} else {
				json.setMsg("服务器繁忙，删除失败");
				logger.info(super.getLoginIP() + ":删除简历失败");
				super.writeJson(json);
			}
		} catch (Exception e) {
			json.setMsg("服务器繁忙，删除失败");
			logger.error(super.getLoginIP() + ":删除简历失败", e);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：deleteEducationExp </p>
	 * <p> 方法描述：删除教育经历 </p>
	 * <p> 返回值：void </p>
	 * @param ids
	 * @throws Exception
	 */
	@RequestMapping(value = "deleteEducationExp", method = RequestMethod.POST)
	public void deleteEducationExp(String ids) throws Exception {
		Json json = new Json();
		try {
			int falg = vitaeService.deleteEducationExp(ids);
			if(falg > 0) {
				json.setSuccess(true);
				json.setMsg("删除成功");
				logger.info(super.getLoginIP() + ":删除教育经历成功");
				super.writeJson(json);
			} else if (falg == -1) {
				json.setMsg("教育经历已被其他信息关联，不能删除");
				super.writeJson(json);
			} else {
				json.setMsg("服务器繁忙，删除失败");
				logger.info(super.getLoginIP() + ":删除教育经历失败");
				super.writeJson(json);
			}
		} catch (Exception e) {
			json.setMsg("服务器繁忙，删除失败");
			logger.error(super.getLoginIP() + ":删除教育经历失败", e);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：deleteWorkExp </p>
	 * <p> 方法描述：删除工作经验 </p>
	 * <p> 返回值：void </p>
	 * @param ids
	 * @throws Exception
	 */
	@RequestMapping(value = "deleteWorkExp", method = RequestMethod.POST)
	public void deleteWorkExp(String ids) throws Exception {
		Json json = new Json();
		try {
			int falg = vitaeService.deleteWorkExp(ids);
			if(falg > 0) {
				json.setSuccess(true);
				json.setMsg("删除成功");
				logger.info(super.getLoginIP() + ":删除工作经验成功");
				super.writeJson(json);
			} else if (falg == -1) {
				json.setMsg("工作经验已被其他信息关联，不能删除");
				super.writeJson(json);
			} else {
				json.setMsg("服务器繁忙，删除失败");
				logger.info(super.getLoginIP() + ":删除工作经验失败");
				super.writeJson(json);
			}
		} catch (Exception e) {
			json.setMsg("服务器繁忙，删除失败");
			logger.error(super.getLoginIP() + ":删除工作经验失败", e);
			super.writeJson(json);
		}
	}

}