package com.qzw.service;

import java.io.Serializable;
import java.util.List;

import com.qzw.bean.EducationExp;
import com.qzw.bean.User;
import com.qzw.bean.Vitae;
import com.qzw.bean.WorkExp;
import com.qzw.common.Table;
import com.qzw.common.TableParams;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service </p>
 * <p> 类名称：VitaeServiceI.java  </p>
 * <p> 类描述：简历的Service接口 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月1日  下午8:02:36
 * @version 1.0
 */
public interface VitaeServiceI {
	
	/**
	 * <p> 方法名：selectVitae </p>
	 * <p> 方法描述：查询用户的简历 </p>
	 * <p> 返回值：List<Vitae> </p>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	List<Vitae> selectVitae(User user) throws Exception;
	
	/**
	 * <p> 方法名：selectEducationExp </p>
	 * <p> 方法描述：查询用户的教育经历 </p>
	 * <p> 返回值：List<EducationExp> </p>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	List<EducationExp> selectEducationExp(User user) throws Exception;
	
	/**
	 * <p> 方法名：selectWorkExp </p>
	 * <p> 方法描述：查询用户的工作经验 </p>
	 * <p> 返回值：List<WorkExp> </p>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	List<WorkExp> selectWorkExp(User user) throws Exception;
	
	/**
	 * <p> 方法名：selectVitae </p>
	 * <p> 方法描述：查询指定用户的简历 </p>
	 * <p> 返回值：List<Vitae> </p>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Table<Vitae> selectVitae(TableParams tableParams, User user) throws Exception;
	
	/**
	 * <p> 方法名：selectEducationExp </p>
	 * <p> 方法描述：查询指定用户的教育经历 </p>
	 * <p> 返回值：List<EducationExp> </p>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Table<EducationExp> selectEducationExp(TableParams tableParams, User user) throws Exception;
	
	/**
	 * <p> 方法名：selectWorkExp </p>
	 * <p> 方法描述：查询指定用户的工作经验 </p>
	 * <p> 返回值：List<WorkExp> </p>
	 * @param user
	 * @return
	 * @throws Exception
	 */
	Table<WorkExp> selectWorkExp(TableParams tableParams, User user) throws Exception;
	
	/**
	 * <p> 方法名：saveVitae </p>
	 * <p> 方法描述：保存简历 </p>
	 * <p> 返回值：Serializable </p>
	 * @param vitae
	 * @return
	 * @throws Exception
	 */
	Serializable saveVitae(Vitae vitae) throws Exception;

	/**
	 * <p> 方法名：saveEducationExp </p>
	 * <p> 方法描述：保存教育经历 </p>
	 * <p> 返回值：Serializable </p>
	 * @param educationExp
	 * @return
	 * @throws Exception
	 */
	Serializable saveEducationExp(EducationExp educationExp) throws Exception;
	
	/**
	 * <p> 方法名：saveWorkExp </p>
	 * <p> 方法描述：保存工作经验 </p>
	 * <p> 返回值：Serializable </p>
	 * @param workExp
	 * @return
	 * @throws Exception
	 */
	Serializable saveWorkExp(WorkExp workExp) throws Exception;
	
	/**
	 * <p> 方法名：editVitae </p>
	 * <p> 方法描述：修改简历 </p>
	 * <p> 返回值：void </p>
	 * @param vitae
	 * @throws Exception
	 */
	void editVitae(Vitae vitae) throws Exception;
	
	/**
	 * <p> 方法名：editEducationExp </p>
	 * <p> 方法描述：修改教育经历 </p>
	 * <p> 返回值：void </p>
	 * @param educationExp
	 * @throws Exception
	 */
	void editEducationExp(EducationExp educationExp) throws Exception;
	
	/**
	 * <p> 方法名：editWorkExp </p>
	 * <p> 方法描述：修改工作经验 </p>
	 * <p> 返回值：void </p>
	 * @param workExp
	 * @throws Exception
	 */
	void editWorkExp(WorkExp workExp) throws Exception;
	
	/**
	 * <p> 方法名：deleteVitae </p>
	 * <p> 方法描述：根据ids删除简历 </p>
	 * <p> 返回值：int </p>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int deleteVitae(String ids) throws Exception;
	
	/**
	 * <p> 方法名：deleteEducationExp </p>
	 * <p> 方法描述：根据ids教育经历 </p>
	 * <p> 返回值：int </p>
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	int deleteEducationExp(String ids) throws Exception;
	
	/**
	 * <p> 方法名：deleteWorkExp </p>
	 * <p> 方法描述：根据ids工作经验 </p>
	 * <p> 返回值：int </p>
	 * @param ids
	 * @return
	 * @throws Exception
	 */
	int deleteWorkExp(String ids) throws Exception;
}