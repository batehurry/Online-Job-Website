package com.qzw.service;

import java.util.List;

import com.qzw.bean.Dict;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service </p>
 * <p> 类名称：DictServiceI.java  </p>
 * <p> 类描述：数据字典的Service接口 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月1日  下午8:05:08
 * @version 1.0
 */
public interface DictServiceI {
	
	/**
	 * <p> 方法名：selectDictByType </p>
	 * <p> 方法描述：通过类型查询数据字典信息 </p>
	 * <p> 返回值：List<Dict> </p>
	 * @param typeId
	 * @return
	 * @throws Exception
	 */
	List<Dict> selectDictByType(String typeId) throws Exception;
	
}
