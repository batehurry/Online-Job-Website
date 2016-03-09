package com.qzw.service;

import com.qzw.bean.User;
import com.qzw.bean.VitaeRecord;
import com.qzw.common.Table;
import com.qzw.common.TableParams;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service </p>
 * <p> 类名称：VitaeRecordServiceI.java  </p>
 * <p> 类描述：简历投递记录的Service接口 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月1日  下午8:02:51
 * @version 1.0
 */
public interface VitaeRecordServiceI {
	
	/**
	 * <p> 方法名：saveVitaeRecord </p>
	 * <p> 方法描述：保存简历投递记录 </p>
	 * <p> 返回值：Serializable </p>
	 * @param vitaeRecord
	 * @return
	 * @throws Exception
	 */
	void saveVitaeRecord(VitaeRecord vitaeRecord, String ids) throws Exception;
	
	/**
	 * <p> 方法名：deleteVitaeRecord </p>
	 * <p> 方法描述：删除投递记录 </p>
	 * <p> 返回值：int </p>
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	int deleteVitaeRecord(String ids) throws Exception;
	
	/**
	 * <p> 方法名：selectVitaeRecord1 </p>
	 * <p> 方法描述：查询投递记录 </p>
	 * <p> 返回值：Table<VitaeRecord> </p>
	 * @param tableParams
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Table<VitaeRecord> selectVitaeRecord1(TableParams tableParams, User user) throws Exception;
	
	/**
	 * <p> 方法名：selectVitaeRecord2 </p>
	 * <p> 方法描述： </p>
	 * <p> 返回值：Table<VitaeRecord> </p>
	 * @param tableParams
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Table<VitaeRecord> selectVitaeRecord2(TableParams tableParams, User user) throws Exception;
	
	/**
	 * <p> 方法名：updateVitaeRecordPass </p>
	 * <p> 方法描述：更新简历通过状态  </p>
	 * <p> 返回值：void </p>
	 * @param vitaeRecord
	 * @param ids
	 * @throws Exception
	 */
	void updateVitaeRecordPass(VitaeRecord vitaeRecord, String ids) throws Exception;
	
	/**
	 * <p> 方法名：updateVitaeRecordRefuse </p>
	 * <p> 方法描述：更新简历拒绝状态 </p>
	 * <p> 返回值：void </p>
	 * @param vitaeRecord
	 * @param ids
	 * @throws Exception
	 */
	void updateVitaeRecordRefuse(VitaeRecord vitaeRecord, String ids) throws Exception;
	
	/**
	 * <p> 方法名：updateVitaeRecordReadStatus </p>
	 * <p> 方法描述：更新简历阅读状态 </p>
	 * <p> 返回值：void </p>
	 * @param id
	 * @throws Exception
	 */
	void updateVitaeRecordReadStatus(String id) throws Exception;
	
}