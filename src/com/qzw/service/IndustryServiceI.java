package com.qzw.service;

import java.io.Serializable;
import java.util.List;

import com.qzw.bean.Industry;
import com.qzw.common.Table;
import com.qzw.common.TableParams;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service </p>
 * <p> 类名称：IndustryServiceI.java  </p>
 * <p> 类描述： </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年12月13日  下午2:39:36
 * @version 1.0
 */
public interface IndustryServiceI {
	
	/**
	 * <p> 方法名：saveIndustry </p>
	 * <p> 方法描述：保存行业 </p>
	 * <p> 返回值：Serializable </p>
	 * @param industry
	 * @return
	 * @throws Exception
	 */
	Serializable saveIndustry(Industry industry) throws Exception;
	
	/**
	 * <p> 方法名：selectIndustry </p>
	 * <p> 方法描述：查询所有的行业 </p>
	 * <p> 返回值：List<Industry> </p>
	 * @return
	 * @throws Exception
	 */
	List<Industry> selectIndustry() throws Exception;
	
	/**
	 * <p> 方法名：selectIndustry </p>
	 * <p> 方法描述：查询数据表格的行业 </p>
	 * <p> 返回值：Table<Industry> </p>
	 * @param tableParams
	 * @return
	 * @throws Exception
	 */
	Table<Industry> selectIndustry(TableParams tableParams) throws Exception;
	
	/**
	 * <p> 方法名：updateIndustry </p>
	 * <p> 方法描述：修改行业 </p>
	 * <p> 返回值：void </p>
	 * @param industry
	 * @throws Exception
	 */
	void updateIndustry(Industry industry) throws Exception;
	
	/**
	 * <p> 方法名：deleteIndustry </p>
	 * <p> 方法描述：通过id批量删除行业 </p>
	 * <p> 返回值：int </p>
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	int deleteIndustry(String ids) throws	Exception;
	
}