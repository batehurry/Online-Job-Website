package com.qzw.contrllor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

import com.qzw.bean.VitaeRecord;
import com.qzw.common.Json;
import com.qzw.common.TableParams;
import com.qzw.service.VitaeRecordServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.contrllor </p>
 * <p> 类名称：VitaeRecordController.java  </p>
 * <p> 类描述：简历投递记录的控制器 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月2日  下午11:28:31
 * @version 1.0
 */
@Controller
@RequestMapping(value = "vitaeRecord")
public class VitaeRecordController extends BaseContrllor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private VitaeRecordServiceI vitaeRecordService;
	
	/**
	 * <p> 方法名：vitaeRecordManager </p>
	 * <p> 方法描述：转跳投递记录管理页面 </p>
	 * <p> 返回值：String </p>
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "vitaeRecordManager1")
	public String vitaeRecordManager1() throws Exception {
		return "vitaeRecord/vitaeRecordManager1";
	}
	
	/**
	 * <p> 方法名：vitaeRecordManager2 </p>
	 * <p> 方法描述： </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "vitaeRecordManager2")
	public String vitaeRecordManager2() throws Exception {
		return "vitaeRecord/vitaeRecordManager2";
	}
	
	/**
	 * <p> 方法名：chooseInterviewDate </p>
	 * <p> 方法描述：选择面试时间页面 </p>
	 * <p> 返回值：String </p>
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "chooseInterviewDate")
	public String chooseInterviewDate() throws Exception {
		return "vitaeRecord/chooseInterviewDate";
	}
	
	/**
	 * <p> 方法名：saveVitaeRecord </p>
	 * <p> 方法描述：保存投递记录 </p>
	 * <p> 返回值：void </p>
	 * @param vitaeRecord
	 * @param ids
	 * @throws Exception
	 */
	@RequestMapping(value = "saveVitaeRecord", method = RequestMethod.POST)
	public void saveVitaeRecord(VitaeRecord vitaeRecord, String ids) throws Exception {
		Json json = new Json();
		try {
			vitaeRecordService.saveVitaeRecord(vitaeRecord, ids);
			json.setSuccess(true);
			json.setMsg("发送成功");
			logger.info(super.getLoginIP() + ":发送简历成功");
			super.writeJson(json);
		} catch (Exception e) {
			json.setMsg("服务器繁忙，发送失败");
			logger.error(super.getLoginIP() + "发送简历失败", e);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：vitaeRecordTable1 </p>
	 * <p> 方法描述： </p>
	 * <p> 返回值：void </p>
	 * @param tableParams
	 * @throws Exception
	 */
	@RequestMapping(value = "vitaeRecordTable1", method = RequestMethod.POST)
	public void vitaeRecordTable1(@RequestBody TableParams tableParams) throws Exception {
		super.writeJson(vitaeRecordService.selectVitaeRecord1(tableParams, getLoginUser()));
	}
	
	/**
	 * <p> 方法名：vitaeRecordTable2 </p>
	 * <p> 方法描述： </p>
	 * <p> 返回值：void </p>
	 * @param tableParams
	 * @throws Exception
	 */
	@RequestMapping(value = "vitaeRecordTable2", method = RequestMethod.POST)
	public void vitaeRecordTable2(@RequestBody TableParams tableParams) throws Exception {
		super.writeJson(vitaeRecordService.selectVitaeRecord2(tableParams, getLoginUser()));
	}
	
	/**
	 * <p> 方法名：deleteVitaeRecord </p>
	 * <p> 方法描述：取消投递记录 </p>
	 * <p> 返回值：void </p>
	 * @param ids
	 * @throws Exception
	 */
	@RequestMapping(value = "deleteVitaeRecord")
	public void deleteVitaeRecord(String ids) throws Exception {
		Json json = new Json();
		try {
			int falg = vitaeRecordService.deleteVitaeRecord(ids);
			if(falg > 0) {
				json.setSuccess(true);
				json.setMsg("删除成功");
				logger.info(super.getLoginIP() + ":删除投递记录成功");
				super.writeJson(json);
			} else if (falg == -1) {
				json.setMsg("投递记录已被其他信息关联，不能删除");
				super.writeJson(json);
			} else {
				json.setMsg("服务器繁忙，删除失败");
				logger.info(super.getLoginIP() + ":删除投递记录失败");
				super.writeJson(json);
			}
		} catch (Exception e) {
			json.setMsg("服务器繁忙，删除失败");
			logger.error(super.getLoginIP() + ":删除投递记录失败", e);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：updateVitaeRecordPass </p>
	 * <p> 方法描述：简历通过 </p>
	 * <p> 返回值：void </p>
	 * @param vitaeRecord
	 * @param ids
	 * @throws Exception
	 */
	@RequestMapping(value = "updateVitaeRecordPass")
	public void updateVitaeRecordPass(VitaeRecord vitaeRecord, String ids) throws Exception {
		Json json = new Json();
		try {
			vitaeRecordService.updateVitaeRecordPass(vitaeRecord, ids);
			json.setSuccess(true);
			json.setMsg("成功");
			logger.info(super.getLoginIP() + ":简历通过成功");
			super.writeJson(json);
		} catch (Exception e) {
			json.setMsg("服务器繁忙，失败");
			logger.error(super.getLoginIP() + ":简历通过失败", e);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：updateVitaeRecordRefuse </p>
	 * <p> 方法描述：简历拒绝 </p>
	 * <p> 返回值：void </p>
	 * @param vitaeRecord
	 * @param ids
	 * @throws Exception
	 */
	@RequestMapping(value = "updateVitaeRecordRefuse")
	public void updateVitaeRecordRefuse(VitaeRecord vitaeRecord, String ids) throws Exception {
		Json json = new Json();
		try {
			vitaeRecordService.updateVitaeRecordRefuse(vitaeRecord, ids);
			json.setSuccess(true);
			json.setMsg("成功");
			logger.info(super.getLoginIP() + ":简历拒绝成功");
			super.writeJson(json);
		} catch (Exception e) {
			json.setMsg("服务器繁忙，失败");
			logger.error(super.getLoginIP() + ":简历拒绝失败", e);
			super.writeJson(json);
		}
	}
	
	/**
	 * <p> 方法名：updateVitaeReadStatus </p>
	 * <p> 方法描述：修改简历阅读状态 </p>
	 * <p> 返回值：void </p>
	 * @param id
	 * @throws Exception
	 */
	@RequestMapping(value = "updateVitaeReadStatus")
	public void updateVitaeReadStatus(String id) throws Exception {
		Json json = new Json();
		try {
			vitaeRecordService.updateVitaeRecordReadStatus(id);
			json.setSuccess(true);
			json.setMsg("成功");
			logger.info(super.getLoginIP() + ":修改简历阅读状态成功");
			super.writeJson(json);
		} catch (Exception e) {
			json.setMsg("服务器繁忙，失败");
			logger.error(super.getLoginIP() + ":修改简历阅读状态失败", e);
			super.writeJson(json);
		}
	}

}