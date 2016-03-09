package com.qzw.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzw.bean.PublishPosition;
import com.qzw.bean.User;
import com.qzw.common.Table;
import com.qzw.common.TableParams;
import com.qzw.dao.BaseDaoI;
import com.qzw.entity.TPublishPosition;
import com.qzw.service.PublishPositionServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service.impl </p>
 * <p> 类名称：PublishPositionServiceImpl.java  </p>
 * <p> 类描述：发布职位的Service实现 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年12月13日  下午2:36:39
 * @version 1.0
 */
@Service
public class PublishPositionServiceImpl extends BaseService implements PublishPositionServiceI {

	@Autowired
	private BaseDaoI<TPublishPosition> publishPositionDao;

	/* (non-Javadoc)
	 * @see com.qzw.service.PublishPositionServiceI#savePublishPosition(com.qzw.bean.PublishPosition)
	 */
	@Override
	public Serializable savePublishPosition(PublishPosition publishPosition) throws Exception {
		publishPosition.setCreateDate(new Date());
		return publishPositionDao.save(changeModal(publishPosition, TPublishPosition.class));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.PublishPositionServiceI#editPublishPosition(com.qzw.bean.PublishPosition)
	 */
	@Override
	public void editPublishPosition(PublishPosition publishPosition) throws Exception {
		publishPosition.setUpdateDate(new Date());
		publishPositionDao.update(changeModal(publishPosition, TPublishPosition.class));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.PublishPositionServiceI#selectPublishPosition(com.qzw.common.TableParams, com.qzw.bean.User)
	 */
	@Override
	public Table<PublishPosition> selectPublishPosition(TableParams tableParams, User user) throws Exception {
		String hql = "from TPublishPosition where userId = :userId";
		return getTableData(tableParams, PublishPosition.class, hql, getParamsMap("userId", user.getId()));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.PublishPositionServiceI#deletePublishPosition(java.lang.String)
	 */
	@Override
	public int deletePublishPosition(String ids) throws Exception {
		return batchDelete(ids, TPublishPosition.class);
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.PublishPositionServiceI#selectPublishPosition(com.qzw.common.TableParams)
	 */
	@Override
	public Table<PublishPosition> selectPublishPosition(TableParams tableParams) throws Exception {
		String hql = "from TPublishPosition";
		return getTableData(tableParams, PublishPosition.class, hql, "workAdd");
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.PublishPositionServiceI#selectPublishPosition()
	 */
	@Override
	public List<PublishPosition> selectPublishPosition() throws Exception {
		String hql = "from TPublishPosition order by createDate";
		return changeModalList(publishPositionDao.find(hql, 0, 5), PublishPosition.class);
	}
	
}