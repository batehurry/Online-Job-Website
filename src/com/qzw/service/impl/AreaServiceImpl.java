package com.qzw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzw.bean.Area;
import com.qzw.dao.BaseDaoI;
import com.qzw.entity.TArea;
import com.qzw.service.AreaServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service.impl </p>
 * <p> 类名称：AreaServiceImpl.java  </p>
 * <p> 类描述：区域的Service实现类 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月1日  下午8:09:51
 * @version 1.0
 */
@Service
public class AreaServiceImpl extends BaseService implements AreaServiceI {

	@Autowired
	private BaseDaoI<TArea> areaDao;

	/* (non-Javadoc)
	 * @see com.qzw.service.AreaServiceI#selectAreasByPid(java.lang.String)
	 */
	@Override
	public List<Area> selectAreasByPid(String pid) throws Exception {
		// 做父id的转换
		if (pid == null || "".equals(pid)) {
			pid = "0";
		}
		String hql = "from TArea where pid = :pid";
		String hqlCount = "select count(*) " + hql;
		List<Area> areaList = super.changeModalList(areaDao.find(hql, super.getParamsMap("pid", pid)), Area.class);
		if(areaList != null && areaList.size() > 0){
			for(Area area : areaList) {
				if (areaDao.count(hqlCount, super.getParamsMap("pid", area.getId())) > 0L) {
					area.setIsParent(true);
				}
			}
		}
		return areaList;
	}

}