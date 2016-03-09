package com.qzw.service;

import java.io.Serializable;
import java.util.List;

import com.qzw.bean.PublishPosition;
import com.qzw.bean.User;
import com.qzw.common.Table;
import com.qzw.common.TableParams;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service </p>
 * <p> 类名称：PublishPositionServiceI.java  </p>
 * <p> 类描述：发布职位的Service实现接口 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年12月13日  下午2:34:20
 * @version 1.0
 */
public interface PublishPositionServiceI {
	
	/**
	 * <p> 方法名：savePublishPosition </p>
	 * <p> 方法描述：保存发布的职位 </p>
	 * <p> 返回值：Serializable </p>
	 * @param publishPosition
	 * @return
	 * @throws Exception
	 */
	Serializable savePublishPosition(PublishPosition publishPosition) throws Exception;
	
	/**
	 * <p> 方法名：editPublishPosition </p>
	 * <p> 方法描述：修改发布的职位 </p>
	 * <p> 返回值：void </p>
	 * @param publishPosition
	 * @throws Exception
	 */
	void editPublishPosition(PublishPosition publishPosition) throws Exception;
	
	/**
	 * <p> 方法名：selectPublishPosition </p>
	 * <p> 方法描述：查询发布的职位 </p>
	 * <p> 返回值：Table<PublishPosition> </p>
	 * @param tableParams
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Table<PublishPosition> selectPublishPosition(TableParams tableParams, User user) throws Exception;
	
	/**
	 * <p> 方法名：deletePublishPosition </p>
	 * <p> 方法描述：删除发布的职位 </p>
	 * <p> 返回值：int </p>
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	int deletePublishPosition(String ids) throws Exception;
	
	/**
	 * <p> 方法名：selectPublishPosition </p>
	 * <p> 方法描述：查询所有正在招聘的职位 </p>
	 * <p> 返回值：Table<PublishPosition> </p>
	 * @param tableParams
	 * @return
	 * @throws Exception
	 */
	Table<PublishPosition> selectPublishPosition(TableParams tableParams) throws Exception;
	
	List<PublishPosition> selectPublishPosition() throws Exception;
	
}