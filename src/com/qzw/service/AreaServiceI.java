package com.qzw.service;

import java.util.List;

import com.qzw.bean.Area;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service </p>
 * <p> 类名称：AreaServiceI.java  </p>
 * <p> 类描述：区域的Service接口 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月1日  下午8:05:53
 * @version 1.0
 */
public interface AreaServiceI {
	
	/**
	 * <p> 方法名：selectAreasByPid </p>
	 * <p> 方法描述：根据父id查询区域 </p>
	 * <p> 返回值：List<Area> </p>
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	List<Area> selectAreasByPid(String pid) throws Exception;
	
}
