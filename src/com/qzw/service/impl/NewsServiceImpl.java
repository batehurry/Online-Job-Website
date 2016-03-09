package com.qzw.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qzw.bean.News;
import com.qzw.common.Table;
import com.qzw.common.TableParams;
import com.qzw.dao.BaseDaoI;
import com.qzw.entity.TNews;
import com.qzw.service.NewsServiceI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service.impl </p>
 * <p> 类名称：NewsServiceImpl.java  </p>
 * <p> 类描述：新闻的Service实现 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月1日  下午6:28:47
 * @version 1.0
 */
@Service
public class NewsServiceImpl extends BaseService implements NewsServiceI {

	@Autowired
	private BaseDaoI<TNews> newsDao;

	/* (non-Javadoc)
	 * @see com.qzw.service.NewsServiceI#selectNews()
	 */
	@Override
	public List<News> selectNews() throws Exception {
		return changeModalList(newsDao.find("from TNews", 0, 10), News.class);
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.NewsServiceI#selectNewsById(java.lang.String)
	 */
	@Override
	public News selectNewsById(String id) throws Exception {
		return changeModal(newsDao.getByHql("from TNews where id = :id", getParamsMap("id", id)), News.class);
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.NewsServiceI#saveNews(com.qzw.bean.News)
	 */
	@Override
	public Serializable saveNews(News news) throws Exception {
		news.setCreateDate(new Date());
		return newsDao.save(changeModal(news, TNews.class));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.NewsServiceI#updateNews(com.qzw.bean.News)
	 */
	@Override
	public void updateNews(News news) throws Exception {
		news.setUpdateDate(new Date());
		newsDao.update(changeModal(news, TNews.class));
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.NewsServiceI#selectNews(com.qzw.common.TableParams)
	 */
	@Override
	public Table<News> selectNews(TableParams tableParams) throws Exception {
		return getTableData(tableParams, News.class, "from TNews", "title");
	}

	/* (non-Javadoc)
	 * @see com.qzw.service.NewsServiceI#deleteNews(java.lang.String)
	 */
	@Override
	public int deleteNews(String ids) throws Exception {
		return batchDelete(ids, TNews.class);
	}
}