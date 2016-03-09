package com.qzw.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzw.bean.EducationExp;
import com.qzw.bean.User;
import com.qzw.bean.Vitae;
import com.qzw.bean.WorkExp;
import com.qzw.common.Table;
import com.qzw.common.TableParams;
import com.qzw.dao.BaseDaoI;
import com.qzw.entity.TEducationExp;
import com.qzw.entity.TVitae;
import com.qzw.entity.TWorkExp;
import com.qzw.service.VitaeServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service.impl </p>
 * <p> 类名称：VitaeServiceImpl.java  </p>
 * <p> 类描述：建立的Service实现类 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月1日  下午8:08:31
 * @version 1.0
 */
@Service
public class VitaeServiceImpl extends BaseService implements VitaeServiceI {

	@Autowired
	private BaseDaoI<TVitae> vitaeDao;

	@Autowired
	private BaseDaoI<TEducationExp> educationExpDao;

	@Autowired
	private BaseDaoI<TWorkExp> workExpDao;
	
	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeServiceI#selectVitae(com.qzw.bean.User)
	 */
	@Override
	public List<Vitae> selectVitae(User user) throws Exception {
		String hql = "from TVitae where userId = :userId";
		return changeModalList(vitaeDao.find(hql, getParamsMap("userId", user.getId())), Vitae.class);
	}
	
	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeServiceI#selectEducationExp(com.qzw.bean.User)
	 */
	@Override
	public List<EducationExp> selectEducationExp(User user) throws Exception {
		String hql = "from TEducationExp where userId = :userId";
		return super.changeModalList(educationExpDao.find(hql, super.getParamsMap("userId", user.getId())), EducationExp.class);
	}
	
	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeServiceI#selectWorkExp(com.qzw.bean.User)
	 */
	@Override
	public List<WorkExp> selectWorkExp(User user) throws Exception {
		String hql = "from TWorkExp where userId = :userId";
		return super.changeModalList(workExpDao.find(hql, super.getParamsMap("userId", user.getId())), WorkExp.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qzw.service.VitaeServiceI#saveVitae(com.qzw.entity.TVitae)
	 */
	@Override
	public Serializable saveVitae(Vitae vitae) throws Exception {
		vitae.setCreateDate(new Date());
		return vitaeDao.save(super.changeModal(vitae, TVitae.class));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qzw.service.VitaeServiceI#saveEducationExp(com.qzw.bean.EducationExp)
	 */
	@Override
	public Serializable saveEducationExp(EducationExp educationExp) throws Exception {
		educationExp.setCreateDate(new Date());
		return educationExpDao.save(super.changeModal(educationExp, TEducationExp.class));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qzw.service.VitaeServiceI#saveWorkExp(com.qzw.bean.WorkExp)
	 */
	@Override
	public Serializable saveWorkExp(WorkExp workExp) throws Exception {
		workExp.setCreateDate(new Date());
		return workExpDao.save(super.changeModal(workExp, TWorkExp.class));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeServiceI#selectVitae(com.qzw.bean.User)
	 */
	@Override
	public Table<Vitae> selectVitae(TableParams tableParams, User user) throws Exception {
		String hql = "from TVitae where userId = :userId";
		return super.getTableData(tableParams, Vitae.class, hql, super.getParamsMap("userId", user.getId()), "title");
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeServiceI#selectEducationExp(com.qzw.common.TableParams, com.qzw.bean.User)
	 */
	@Override
	public Table<EducationExp> selectEducationExp(TableParams tableParams, User user) throws Exception {
		String hql = "from TEducationExp where userId = :userId";
		return super.getTableData(tableParams, EducationExp.class, hql, super.getParamsMap("userId", user.getId()), "schoolName");
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeServiceI#selectWorkExp(com.qzw.common.TableParams, com.qzw.bean.User)
	 */
	@Override
	public Table<WorkExp> selectWorkExp(TableParams tableParams, User user) throws Exception {
		String hql = "from TWorkExp where userId = :userId";
		return super.getTableData(tableParams, WorkExp.class, hql, super.getParamsMap("userId", user.getId()), "etpName");
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeServiceI#editVitae(com.qzw.bean.Vitae)
	 */
	@Override
	public void editVitae(Vitae vitae) throws Exception {
		vitae.setUpdateDate(new Date());
		vitaeDao.update(super.changeModal(vitae, TVitae.class));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeServiceI#editEducationExp(com.qzw.bean.EducationExp)
	 */
	@Override
	public void editEducationExp(EducationExp educationExp) throws Exception {
		educationExp.setUpdateDate(new Date());
		educationExpDao.update(super.changeModal(educationExp, TEducationExp.class));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeServiceI#editWorkExp(com.qzw.bean.WorkExp)
	 */
	@Override
	public void editWorkExp(WorkExp workExp) throws Exception {
		workExp.setUpdateDate(new Date());
		workExpDao.update(super.changeModal(workExp, TWorkExp.class));
	}
	
	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeServiceI#deleteVitae(java.lang.String)
	 */
	@Override
	public int deleteVitae(String ids) throws Exception {
		return super.batchDelete(ids, TVitae.class);
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeServiceI#deleteEducationExp(java.lang.String)
	 */
	@Override
	public int deleteEducationExp(String ids) throws Exception {
		return super.batchDelete(ids, TEducationExp.class);
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeServiceI#deleteWorkExp(java.lang.String)
	 */
	@Override
	public int deleteWorkExp(String ids) throws Exception {
		return super.batchDelete(ids, TWorkExp.class);
	}

}