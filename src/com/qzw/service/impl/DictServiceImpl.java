package com.qzw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzw.bean.Dict;
import com.qzw.dao.BaseDaoI;
import com.qzw.entity.TDict;
import com.qzw.service.DictServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service.impl </p>
 * <p> 类名称：DictServiceImpl.java  </p>
 * <p> 类描述：数据字典的Service实现类 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月1日  下午8:09:10
 * @version 1.0
 */
@Service
public class DictServiceImpl extends BaseService implements DictServiceI  {

	@Autowired
	private BaseDaoI<TDict> dictDao;

	/* (non-Javadoc)
	 * @see com.qzw.service.DictServiceI#selectDictByType(java.lang.String)
	 */
	@Override
	public List<Dict> selectDictByType(String typeId) throws Exception {
		String hql = "from TDict where type = :type";
		return super.changeModalList(dictDao.find(hql, super.getParamsMap("type", typeId)), Dict.class);
	}

}