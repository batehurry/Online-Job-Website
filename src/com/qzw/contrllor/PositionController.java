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
import org.springframework.web.servlet.ModelAndView;

import com.qzw.bean.Position;
import com.qzw.common.Constants;
import com.qzw.common.Json;
import com.qzw.common.TableParams;
import com.qzw.service.IndustryServiceI;
import com.qzw.service.PositionServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.contrllor </p>
 * <p> 类名称：PositionController.java  </p>
 * <p> 类描述：职位的控制器 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月2日  下午11:27:50
 * @version 1.0
 */
@Controller
@RequestMapping(value = "position")
public class PositionController extends BaseContrllor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PositionServiceI positionService;
	
	@Autowired
	private IndustryServiceI industryService;
	
	/**
	 * <p> 方法名：loadPost </p>
	 * <p> 方法描述：通过职位id加载职位 </p>
	 * <p> 返回值：void </p>
	 * @param id
	 * @throws Exception
	 */
	@RequestMapping(value = "loadPosition")
	public void loadPosition(String id) throws Exception {
		super.writeJson(positionService.selectPositionByIndustryId(id));
	}
	
	/**
	 * <p> 方法名：positionManager </p>
	 * <p> 方法描述：跳转职位管理页面 </p>
	 * <p> 返回值：String </p>
	 * @return
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "positionManager")
	public String positionManager() {
		return "position/positionManager";
	}
	
	/**
	 * <p> 方法名：positionForm </p>
	 * <p> 方法描述：跳转职位表单页面 </p>
	 * <p> 返回值：ModelAndView </p>
	 * @return
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "positionForm")
	public ModelAndView positionForm() throws Exception {
		ModelAndView mv = new ModelAndView("position/positionForm");
		mv.addObject("industry", industryService.selectIndustry());
		return mv;
	}
	
	/**
	 * <p> 方法名：PositionTable </p>
	 * <p> 方法描述：职位的数据表格 </p>
	 * <p> 返回值：void </p>
	 * @param tableParams
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "positionTable", method = RequestMethod.POST)
	public void PositionTable(@RequestBody TableParams tableParams) throws Exception {
		super.writeJson(positionService.selectPosition(tableParams));
	}
	
	/**
	 * <p> 方法名：deletePosition </p>
	 * <p> 方法描述：批量删除职位 </p>
	 * <p> 返回值：void </p>
	 * @param ids
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "deletePosition", method = RequestMethod.POST)
	public void deletePosition(String ids) throws Exception {
		Json json = new Json();
		try {
			int count = positionService.deletePosition(ids);
			if (count != 0 ) {
				json.setSuccess(true);
				json.setMsg("删除成功");
				super.writeJson(json);
			} else if (count == -1) {
				json.setMsg("职位已被其他信息关联，不能删除");
				super.writeJson(json);
			} else {
				logger.error(super.getLoginIP() + "删除职位失败");
				json.setMsg("服务器繁忙，删除失败");
				super.writeJson(json);
			}
		} catch (Exception e) {
			logger.error(super.getLoginIP() + "删除职位失败", e);
			json.setMsg("服务器繁忙，删除失败");
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：savePosition </p>
	 * <p> 方法描述：保存职位 </p>
	 * <p> 返回值：void </p>
	 * @param Position
	 * @param bindingResult
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "savePosition", method = RequestMethod.POST)
	public void savePosition(@RequestBody @Validated Position Position, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			try {
				Serializable id = positionService.savePosition(Position);
				if (id != null) {
					json.setSuccess(true);
					json.setMsg("保存成功");
					logger.info(super.getLoginIP() + ":保存职位成功");
					super.writeJson(json);
				} else {
					json.setMsg("服务器繁忙，保存失败");
					logger.error(super.getLoginIP() + "保存职位失败");
					super.writeJson(json);
				}
			} catch (Exception e) {
				json.setMsg("服务器繁忙，保存失败");
				logger.error(super.getLoginIP() + "保存职位失败", e);
				super.writeJson(json);
			}
		} else {
			json.setMsg("修改失败," + errorInfo);
			logger.info(super.getLoginIP() + ":保存简历失败:" + errorInfo);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：editPosition </p>
	 * <p> 方法描述：编辑职位 </p>
	 * <p> 返回值：void </p>
	 * @param Position
	 * @param bindingResult
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "editPosition", method = RequestMethod.POST)
	public void editPosition(@RequestBody @Validated Position position, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			try {
				positionService.updaetePosition(position);
			} catch (Exception e) {
				json.setMsg("服务器繁忙，修改失败");
				logger.error(super.getLoginIP() + "修改职位失败", e);
				super.writeJson(json);
			}
			json.setSuccess(true);
			json.setMsg("修改成功");
			logger.info(super.getLoginIP() + ":修改职位成功");
			super.writeJson(json);
		} else {
			json.setMsg("修改失败," + errorInfo);
			super.writeJson(json);
		}
	}
	
}