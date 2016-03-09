package com.qzw.service;

import java.io.Serializable;
import java.util.List;

import com.qzw.bean.News;
import com.qzw.common.Table;
import com.qzw.common.TableParams;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.service </p>
 * <p> 类名称：NewsServiceI.java  </p>
 * <p> 类描述：新闻的Service接口 </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2016年1月1日  下午8:02:10
 * @version 1.0
 */
public interface NewsServiceI {
	
	/**
	 * <p> 方法名：saveNews </p>
	 * <p> 方法描述：保存新闻 </p>
	 * <p> 返回值：Serializable </p>
	 * @param news
	 * @return
	 * @throws Exception
	 */
	Serializable saveNews(News news) throws Exception;
	
	/**
	 * <p> 方法名：updateNews </p>
	 * <p> 方法描述：更新新闻 </p>
	 * <p> 返回值：void </p>
	 * @param news
	 * @throws Exception
	 */
	void updateNews(News news) throws Exception;
	
	/**
	 * <p> 方法名：selectNews </p>
	 * <p> 方法描述：给数据表格查询新闻 </p>
	 * <p> 返回值：Table<News> </p>
	 * @param tableParams
	 * @return
	 * @throws Exception
	 */
	Table<News> selectNews(TableParams tableParams) throws Exception;
	
	/**
	 * <p> 方法名：selectNews </p>
	 * <p> 方法描述：查询前10条新闻 </p>
	 * <p> 返回值：List<News> </p>
	 * @return
	 * @throws Exception
	 */
	List<News> selectNews() throws Exception;
	
	/**
	 * <p> 方法名：selectNewsById </p>
	 * <p> 方法描述：通过id查询新闻 </p>
	 * <p> 返回值：News </p>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	News selectNewsById(String id) throws Exception;
	
	/**
	 * <p> 方法名：deleteNews </p>
	 * <p> 方法描述：通过多个id批量删除新闻 </p>
	 * <p> 返回值：void </p>
	 * @param ids
	 * @throws Exception
	 */
	int deleteNews(String ids) throws Exception;
	
}