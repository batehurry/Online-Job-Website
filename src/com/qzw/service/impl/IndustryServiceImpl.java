package com.qzw.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzw.bean.Industry;
import com.qzw.common.Table;
import com.qzw.common.TableParams;
import com.qzw.dao.BaseDaoI;
import com.qzw.entity.TIndustry;
import com.qzw.service.IndustryServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service.impl </p>
 * <p> 类名称：IndustryServiceImpl.java  </p>
 * <p> 类描述： </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年12月13日  下午2:39:45
 * @version 1.0
 */
@Service
public class IndustryServiceImpl extends BaseService implements IndustryServiceI {
	
	@Autowired
	private BaseDaoI<TIndustry> industryDao;

	/* (non-Javadoc)
	 * @see com.qzw.service.IndustryServiceI#selectIndustry()
	 */
	@Override
	public List<Industry> selectIndustry() throws Exception {
		String hql = "from TIndustry";
		return changeModalList(industryDao.find(hql), Industry.class);
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.IndustryServiceI#saveIndustry(com.qzw.bean.Industry)
	 */
	@Override
	public Serializable saveIndustry(Industry industry) throws Exception {
		industry.setCreateDate(new Date());
		return industryDao.save(changeModal(industry, TIndustry.class));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.IndustryServiceI#selectIndustry(com.qzw.common.TableParams)
	 */
	@Override
	public Table<Industry> selectIndustry(TableParams tableParams) throws Exception {
		return getTableData(tableParams, Industry.class, "from TIndustry", "name");
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.IndustryServiceI#updateIndustry(com.qzw.bean.Industry)
	 */
	@Override
	public void updateIndustry(Industry industry) throws Exception {
		industry.setUpdateDate(new Date());
		industryDao.update(changeModal(industry, TIndustry.class));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.IndustryServiceI#deleteIndustry(java.lang.String)
	 */
	@Override
	public int deleteIndustry(String ids) throws Exception {
		return batchDelete(ids, TIndustry.class);
	}

}