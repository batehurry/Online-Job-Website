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

import com.qzw.bean.News;
import com.qzw.common.Constants;
import com.qzw.common.Json;
import com.qzw.common.TableParams;
import com.qzw.service.NewsServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.contrllor </p>
 * <p> 类名称：NewsController.java  </p>
 * <p> 类描述：新闻的控制器 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月2日  下午4:53:37
 * @version 1.0
 */
@Controller
@RequestMapping(value = "news")
public class NewsController extends BaseContrllor {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private NewsServiceI newsService;
	
	/**
	 * <p> 方法名：newsDetail </p>
	 * <p> 方法描述：转跳新闻详情页面 </p>
	 * <p> 返回值：ModelAndView </p>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "newsDetail")
	public ModelAndView newsDetail(String id) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("news", newsService.selectNewsById(id));
		return mv;
	}
	
	/**
	 * <p> 方法名：newsManager </p>
	 * <p> 方法描述：转跳新闻管理页面 </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "newsManager")
	public String newsManager() throws Exception {
		return "news/newsManager";
	}
	
	/**
	 * <p> 方法名：newsForm </p>
	 * <p> 方法描述：转跳新闻表单页面 </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "newsForm")
	public String newsForm() throws Exception {
		return "news/newsForm";
	}
	
	/**
	 * <p> 方法名：newsTable </p>
	 * <p> 方法描述：新闻的数据表格 </p>
	 * <p> 返回值：void </p>
	 * @param tableParams
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "newsTable", method = RequestMethod.POST)
	public void newsTable(@RequestBody TableParams tableParams) throws Exception {
		super.writeJson(newsService.selectNews(tableParams));
	}
	
	/**
	 * <p> 方法名：deleteNews </p>
	 * <p> 方法描述：批量删除新闻 </p>
	 * <p> 返回值：void </p>
	 * @param ids
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "deleteNews", method = RequestMethod.POST)
	public void deleteNews(String ids) throws Exception {
		Json json = new Json();
		try {
			int count = newsService.deleteNews(ids);
			if (count != 0 ) {
				json.setSuccess(true);
				json.setMsg("删除成功");
				super.writeJson(json);
			} else if (count == -1) {
				json.setMsg("新闻已被其他信息关联，不能删除");
				super.writeJson(json);
			} else {
				logger.error(super.getLoginIP() + "删除新闻失败");
				json.setMsg("服务器繁忙，删除失败");
				super.writeJson(json);
			}
		} catch (Exception e) {
			logger.error(super.getLoginIP() + "删除新闻失败", e);
			json.setMsg("服务器繁忙，删除失败");
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：saveNews </p>
	 * <p> 方法描述：保存新闻 </p>
	 * <p> 返回值：void </p>
	 * @param news
	 * @param bindingResult
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "saveNews", method = RequestMethod.POST)
	public void saveNews(@RequestBody @Validated News news, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			try {
				Serializable id = newsService.saveNews(news);
				if (id != null) {
					json.setSuccess(true);
					json.setMsg("保存成功");
					logger.info(super.getLoginIP() + ":保存新闻成功");
					super.writeJson(json);
				} else {
					json.setMsg("服务器繁忙，保存失败");
					logger.error(super.getLoginIP() + "保存新闻失败");
					super.writeJson(json);
				}
			} catch (Exception e) {
				json.setMsg("服务器繁忙，保存失败");
				logger.error(super.getLoginIP() + "保存新闻失败", e);
				super.writeJson(json);
			}
		} else {
			json.setMsg("修改失败," + errorInfo);
			logger.info(super.getLoginIP() + ":保存简历失败:" + errorInfo);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：editNews </p>
	 * <p> 方法描述：编辑新闻 </p>
	 * <p> 返回值：void </p>
	 * @param news
	 * @param bindingResult
	 * @throws Exception
	 */
	@RequiresRoles(value = Constants.ADMIN)
	@RequestMapping(value = "editNews", method = RequestMethod.POST)
	public void editNews(@RequestBody @Validated News news, BindingResult bindingResult) throws Exception {
		Json json = new Json();
		String errorInfo = super.paramErrorInfo(bindingResult);
		if (errorInfo == null || "".equals(errorInfo)) {
			try {
				newsService.updateNews(news);
			} catch (Exception e) {
				json.setMsg("服务器繁忙，修改失败");
				logger.error(super.getLoginIP() + "修改新闻失败", e);
				super.writeJson(json);
			}
			json.setSuccess(true);
			json.setMsg("修改成功");
			logger.info(super.getLoginIP() + ":修改新闻成功");
			super.writeJson(json);
		} else {
			json.setMsg("修改失败," + errorInfo);
			super.writeJson(json);
		}
	}
	
	
}