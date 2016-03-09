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
import org.springframework.web.servlet.ModelAndView;

import com.qzw.bean.PublishPosition;
import com.qzw.common.Constants;
import com.qzw.common.Json;
import com.qzw.common.TableParams;
import com.qzw.service.DictServiceI;
import com.qzw.service.IndustryServiceI;
import com.qzw.service.PublishPositionServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.contrllor </p>
 * <p> 类名称：PublishPositionController.java  </p>
 * <p> 类描述：发布职位的控制器 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年12月13日  下午2:50:57
 * @version 1.0
 */
@Controller
@RequestMapping(value = "publishPosition")
public class PublishPositionController extends BaseContrllor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PublishPositionServiceI publishPositionService;
	
	@Autowired
	private IndustryServiceI industryService;
	
	@Autowired
	private DictServiceI dictService;
	
	/**
	 * <p> 方法名：allPublishPosition </p>
	 * <p> 方法描述：跳转至查询所有发布的职位的页面  </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "allPublishPosition")
	public String allPublishPosition() throws Exception {
		return "publishPosition/allPublishPosition";
	}
	
	/**
	 * <p> 方法名：publishPositionManager </p>
	 * <p> 方法描述：跳转至管理发布职位的页面 </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "publishPositionManager")
	public String publishPositionManager() throws Exception {
		return "publishPosition/publishPositionManager";
	}
	
	/**
	 * <p> 方法名：publishPositionForm </p>
	 * <p> 方法描述：跳转至发布职位细节的页面  </p>
	 * <p> 返回值：ModelAndView </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "publishPositionForm")
	public ModelAndView publishPositionForm() throws Exception {
		ModelAndView mv = new ModelAndView("publishPosition/publishPositionForm");
		mv.addObject("salary", dictService.selectDictByType(Constants.SALARY));
		mv.addObject("industry", industryService.selectIndustry());
		return mv;
	}
	
	/**
	 * <p> 方法名：publishPositionDetail </p>
	 * <p> 方法描述：跳转至发布职位详情页面 </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "publishPositionDetail")
	public String publishPositionDetail() throws Exception {
		return "publishPosition/publishPositionDetail";
	}
	
	/**
	 * <p> 方法名：publishPositionTable </p>
	 * <p> 方法描述：通过当前用户查询发布的职位 </p>
	 * <p> 返回值：void </p>
	 * @param tableParams
	 * @throws Exception
	 */
	@RequestMapping(value = "publishPositionTable")
	public void publishPositionTable(@RequestBody TableParams tableParams) throws Exception {
		super.writeJson(publishPositionService.selectPublishPosition(tableParams, super.getLoginUser()));
	}
	
	/**
	 * <p> 方法名：savePublishPosition </p>
	 * <p> 方法描述：保存发布的职位 </p>
	 * <p> 返回值：void </p>
	 * @param publishPosition
	 * @param bindingResult
	 * @throws Exception
	 */
	@RequestMapping(value = "savePublishPosition")
	public void savePublishPosition(@RequestBody @Validated PublishPosition publishPosition, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			publishPosition.setUser(getLoginUser());
			try {
				Serializable id = publishPositionService.savePublishPosition(publishPosition);
				if (id != null) {
					json.setSuccess(true);
					json.setMsg("保存成功");
					logger.info(super.getLoginIP() + ":保存发布的职位成功");
					super.writeJson(json);
				} else {
					json.setMsg("服务器繁忙，保存失败");
					logger.error(super.getLoginIP() + "保存发布的职位失败");
					super.writeJson(json);
				}
			} catch (Exception e) {
				json.setMsg("服务器繁忙，保存失败");
				logger.error(super.getLoginIP() + "保存发布的职位失败");
				super.writeJson(json);
			}
		} else {
			json.setMsg(errorInfo);
			logger.info(super.getLoginIP() + ":保存发布的职位失败:" + errorInfo);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：editPublishPosition </p>
	 * <p> 方法描述：修改发布的职位 </p>
	 * <p> 返回值：void </p>
	 * @param publishPosition
	 * @param bindingResult
	 * @throws Exception
	 */
	@RequestMapping(value = "editPublishPosition")
	public void editPublishPosition(@RequestBody @Validated PublishPosition publishPosition, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			publishPosition.setUser(getLoginUser());
			try {
				publishPositionService.editPublishPosition(publishPosition);
				json.setSuccess(true);
				json.setMsg("修改成功");
				logger.info(super.getLoginIP() + ":修改发布的职位成功");
				super.writeJson(json);
			} catch (Exception e) {
				json.setMsg("服务器繁忙，修改失败");
				logger.error(super.getLoginIP() + "修改发布的职位失败");
				super.writeJson(json);
			}
		} else {
			json.setMsg(errorInfo);
			logger.info(super.getLoginIP() + ":修改发布的职位失败:" + errorInfo);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：deletePublishPosition </p>
	 * <p> 方法描述：删除发布的职位 </p>
	 * <p> 返回值：void </p>
	 * @param ids
	 * @throws Exception
	 */
	@RequestMapping(value = "deleteVitae")
	public void deletePublishPosition(String ids) throws Exception {
		Json json = new Json();
		try {
			int falg = publishPositionService.deletePublishPosition(ids);
			if(falg > 0) {
				json.setSuccess(true);
				json.setMsg("删除成功");
				logger.info(super.getLoginIP() + ":删除发布的职位成功");
				super.writeJson(json);
			} else if (falg == -1) {
				json.setMsg("发布的职位已被其他信息关联，不能删除");
				super.writeJson(json);
			} else {
				json.setMsg("服务器繁忙，删除失败");
				logger.info(super.getLoginIP() + ":删除发布的职位失败");
				super.writeJson(json);
			}
		} catch (Exception e) {
			json.setMsg("服务器繁忙，删除失败");
			logger.error(super.getLoginIP() + ":删除发布的职位失败", e);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：allPublishPositionTable </p>
	 * <p> 方法描述：所在正在招聘的职位 </p>
	 * <p> 返回值：void </p>
	 * @param tableParams
	 * @throws Exception
	 */
	@RequestMapping(value = "allPublishPositionTable")
	public void allPublishPositionTable(@RequestBody TableParams tableParams) throws Exception {
		super.writeJson(publishPositionService.selectPublishPosition(tableParams));
	}
	
}