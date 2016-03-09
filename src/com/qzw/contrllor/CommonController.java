package com.qzw.contrllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qzw.service.AreaServiceI;
import com.qzw.service.NewsServiceI;
import com.qzw.service.PublishPositionServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.contrllor </p>
 * <p> 类名称：CommonController.java  </p>
 * <p> 类描述：公共的控制器 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月2日  下午11:27:10
 * @version 1.0
 */
@Controller
public class CommonController extends BaseContrllor {

	@Autowired
	private AreaServiceI areaService;
	
	@Autowired
	private PublishPositionServiceI publishPositionService;
	
	@Autowired
	private NewsServiceI newsService;
	
	/**
	 * <p> 方法名：area </p>
	 * <p> 方法描述：跳转区域树页面 </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "area")
	public String area() throws Exception {
		return "common/area";
	}
	
	/**
	 * <p> 方法名：areaTree </p>
	 * <p> 方法描述：加载区域树的Json数据 </p>
	 * <p> 返回值：void </p>
	 * @param pid
	 * @throws Exception
	 */
	@RequestMapping(value = "areaTree")
	public void areaTree(String pid) throws Exception {
		super.writeJson(areaService.selectAreasByPid(pid));
	}
	
	/**
	 * 跳转404页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "404")
	public String page404() throws Exception {
		return "common/404";
	}

	/**
	 * 跳转500页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "500")
	public String page500() throws Exception {
		return "common/500";
	}
	
	/**
	 * 跳转error页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "error")
	public String error() throws Exception {
		return "common/error";
	}
	
	/**
	 * <p> 方法名：refuse </p>
	 * <p> 方法描述：转跳无权限页面 </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "refuse")
	public String refuse() throws Exception {
		return "common/refuse";
	}
	
	/**
	 * <p> 方法名：index </p>
	 * <p> 方法描述：转跳到主页 </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "index")
	public ModelAndView index() throws Exception {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("publishPositionList", publishPositionService.selectPublishPosition());
		mv.addObject("newsList", newsService.selectNews());
		return mv;
	}
	
}