package com.qzw.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzw.bean.User;
import com.qzw.bean.VitaeRecord;
import com.qzw.common.Constants;
import com.qzw.common.Table;
import com.qzw.common.TableParams;
import com.qzw.dao.BaseDaoI;
import com.qzw.entity.TDict;
import com.qzw.entity.TPublishPosition;
import com.qzw.entity.TVitaeRecord;
import com.qzw.service.VitaeRecordServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service.impl </p>
 * <p> 类名称：VitaeRecordServiceImpl.java  </p>
 * <p> 类描述：简历的投递记录Service实现类 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月1日  下午8:08:01
 * @version 1.0
 */
@Service
public class VitaeRecordServiceImpl extends BaseService implements VitaeRecordServiceI {

	@Autowired
	private BaseDaoI<TVitaeRecord> vitaeRecordDao;
	
	@Autowired
	private BaseDaoI<TPublishPosition> publishPositionDao;
	
	@Autowired
	private BaseDaoI<TDict> dictDao;
	
	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeRecordServiceI#saveVitaeRecord(com.qzw.bean.VitaeRecord)
	 */
	@Override
	public void saveVitaeRecord(VitaeRecord vitaeRecord, String ids) throws Exception {
		String[] idArray = ids.split(",");
		for(String id : idArray) {
			TVitaeRecord tVitaeRecord = changeModal(vitaeRecord, TVitaeRecord.class);
			tVitaeRecord.setCreateDate(new Date());
			tVitaeRecord.setPublishPosition(publishPositionDao.getByHql("from TPublishPosition where id = :id", getParamsMap("id", id)));
			tVitaeRecord.setReadStatus(dictDao.getByHql("from TDict where id = :id", getParamsMap("id", Constants.NOREAD)));
			tVitaeRecord.setRecordResult(dictDao.getByHql("from TDict where id = :id", getParamsMap("id", Constants.RESULT_NOREAD)));
			vitaeRecordDao.save(tVitaeRecord);
		}
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeRecordServiceI#deleteVitaeRecord(java.lang.String)
	 */
	@Override
	public int deleteVitaeRecord(String ids) throws Exception {
		return batchDelete(ids, TVitaeRecord.class);
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeRecordServiceI#selectVitaeRecord(com.qzw.common.TableParams)
	 */
	@Override
	public Table<VitaeRecord> selectVitaeRecord1(TableParams tableParams, User user) throws Exception {
		String hql = "from TVitaeRecord where vitae.user.id = :userId";
		return getTableData(tableParams, VitaeRecord.class, hql, getParamsMap("userId", user.getId()));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeRecordServiceI#selectVitaeRecord2(com.qzw.common.TableParams, com.qzw.bean.User)
	 */
	@Override
	public Table<VitaeRecord> selectVitaeRecord2(TableParams tableParams, User user) throws Exception {
		String hql = "from TVitaeRecord where publishPosition.user.id = :userId";
		return getTableData(tableParams, VitaeRecord.class, hql, getParamsMap("userId", user.getId()));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeRecordServiceI#updateVitaeRecord(com.qzw.bean.VitaeRecord, java.lang.String)
	 */
	@Override
	public void updateVitaeRecordPass(VitaeRecord vitaeRecord, String ids) throws Exception {
		String[] idArray = ids.split(",");
		for(String id : idArray) {
			TVitaeRecord tVitaeRecord = vitaeRecordDao.getByHql("from TVitaeRecord where id = :id", getParamsMap("id", id));
			tVitaeRecord.setInterviewDate(vitaeRecord.getInterviewDate());
			tVitaeRecord.setReadDate(new Date());
			tVitaeRecord.setReadStatus(dictDao.getByHql("from TDict where id = :id", getParamsMap("id", Constants.READ)));
			tVitaeRecord.setRecordResult(dictDao.getByHql("from TDict where id = :id", getParamsMap("id", Constants.PASS)));
			tVitaeRecord.setUpdateDate(new Date());
			vitaeRecordDao.update(tVitaeRecord);
		}
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeRecordServiceI#updateVitaeRecordRefuse(com.qzw.bean.VitaeRecord, java.lang.String)
	 */
	@Override
	public void updateVitaeRecordRefuse(VitaeRecord vitaeRecord, String ids) throws Exception {
		String[] idArray = ids.split(",");
		for(String id : idArray) {
			TVitaeRecord tVitaeRecord = vitaeRecordDao.getByHql("from TVitaeRecord where id = :id", getParamsMap("id", id));
			tVitaeRecord.setReadDate(new Date());
			tVitaeRecord.setInterviewDate(null);
			tVitaeRecord.setReadStatus(dictDao.getByHql("from TDict where id = :id", getParamsMap("id", Constants.READ)));
			tVitaeRecord.setRecordResult(dictDao.getByHql("from TDict where id = :id", getParamsMap("id", Constants.REFUSE)));
			tVitaeRecord.setUpdateDate(new Date());
			vitaeRecordDao.update(tVitaeRecord);
		}
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.VitaeRecordServiceI#updateVitaeRecordReadStatus(java.lang.String)
	 */
	@Override
	public void updateVitaeRecordReadStatus(String id) throws Exception {
		TVitaeRecord tVitaeRecord = vitaeRecordDao.getByHql("from TVitaeRecord where id = :id", getParamsMap("id", id));
		tVitaeRecord.setReadDate(new Date());
		tVitaeRecord.setReadStatus(dictDao.getByHql("from TDict where id = :id", getParamsMap("id", Constants.READ)));
		vitaeRecordDao.update(tVitaeRecord);
	}

}