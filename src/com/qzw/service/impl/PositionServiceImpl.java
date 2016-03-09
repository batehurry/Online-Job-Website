package com.qzw.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzw.bean.Position;
import com.qzw.common.Table;
import com.qzw.common.TableParams;
import com.qzw.dao.BaseDaoI;
import com.qzw.entity.TPosition;
import com.qzw.service.PositionServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service.impl </p>
 * <p> 类名称：PositionServiceImpl.java  </p>
 * <p> 类描述：职位的Service实现类 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月1日  下午8:01:42
 * @version 1.0
 */
@Service
public class PositionServiceImpl extends BaseService implements PositionServiceI {

	@Autowired
	private BaseDaoI<TPosition> positionDao;

	/* (non-Javadoc)
	 * @see com.qzw.service.PostServiceI#selectPostByIndustryId(java.lang.String)
	 */
	@Override
	public List<Position> selectPositionByIndustryId(String id) throws Exception {
		String hql = "from TPosition where industryId = :industryId";
		return super.changeModalList(positionDao.find(hql, super.getParamsMap("industryId", id)), Position.class);
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.PositionServiceI#savePosition(com.qzw.bean.Position)
	 */
	@Override
	public Serializable savePosition(Position position) throws Exception {
		position.setCreateDate(new Date());
		return positionDao.save(changeModal(position, TPosition.class));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.PositionServiceI#updaetePosition(com.qzw.bean.Position)
	 */
	@Override
	public void updaetePosition(Position position) throws Exception {
		position.setUpdateDate(new Date());
		positionDao.update(changeModal(position, TPosition.class));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.PositionServiceI#selectPosition(com.qzw.common.TableParams)
	 */
	@Override
	public Table<Position> selectPosition(TableParams tableParams) throws Exception {
		return getTableData(tableParams, Position.class, "from TPosition", "name");
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.PositionServiceI#deletePosition(java.lang.String)
	 */
	@Override
	public int deletePosition(String ids) throws Exception {
		return batchDelete(ids, TPosition.class);
	}

}