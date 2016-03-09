package com.qzw.service;

import java.io.Serializable;
import java.util.List;

import com.qzw.bean.Position;
import com.qzw.common.Table;
import com.qzw.common.TableParams;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service </p>
 * <p> 类名称：PositionServiceI.java  </p>
 * <p> 类描述：职位的Service接口 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月1日  下午7:56:14
 * @version 1.0
 */
public interface PositionServiceI {
	
	/**
	 * <p> 方法名：selectPostByIndustryId </p>
	 * <p> 方法描述：通过行业id查询职位 </p>
	 * <p> 返回值：List<Position> </p>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<Position> selectPositionByIndustryId(String id) throws Exception;
	
	/**
	 * <p> 方法名：savePosition </p>
	 * <p> 方法描述：保存职位 </p>
	 * <p> 返回值：Serializable </p>
	 * @param position
	 * @return
	 * @throws Exception
	 */
	Serializable savePosition(Position position) throws	 Exception;
	
	/**
	 * <p> 方法名：updaetePosition </p>
	 * <p> 方法描述：更新职位 </p>
	 * <p> 返回值：void </p>
	 * @param position
	 * @throws Exception
	 */
	void updaetePosition(Position position) throws Exception;
	
	/**
	 * <p> 方法名：selectPosition </p>
	 * <p> 方法描述：查询数据表格的职位 </p>
	 * <p> 返回值：Table<Position> </p>
	 * @param tableParams
	 * @return
	 * @throws Exception
	 */
	Table<Position> selectPosition(TableParams tableParams) throws Exception;
	
	/**
	 * <p> 方法名：deletePosition </p>
	 * <p> 方法描述：通过id批量删除职位 </p>
	 * <p> 返回值：int </p>
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	int deletePosition(String ids) throws Exception;
	
}