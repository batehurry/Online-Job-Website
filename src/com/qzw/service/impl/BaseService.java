package com.qzw.service.impl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.qzw.common.AllJO;
import com.qzw.common.Table;
import com.qzw.common.TableParams;
import com.qzw.dao.BaseDaoI;

/**
 * <p> 项目名称：qzw </p>
 * <p> 包名：com.qzw.util </p>
 * <p> 类名称：BeanUtil.java  </p>
 * <p> 类描述： </p>
 * <p> 备注： </p>
 * @author 魏胜泽
 * @date  2015年11月21日  下午1:07:55
 * @version 1.0
 */
public abstract class BaseService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BaseDaoI<Object> dao;
	
	/**
	 * <p> 方法名：getObj </p>
	 * <p> 方法描述：获取对象 </p>
	 * <p> 返回值：T </p>
	 * @param clazz
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	protected <T> T getObj(Class<T> clazz) throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}
	
	/**
	 * <p> 方法名：getParamsMap </p>
	 * <p> 方法描述：获取指定键值对的Map（用于hql/sql的参数） </p>
	 * <p> 返回值：Map<String,Object> </p>
	 * @param paramNames 参数名称(多个参数用','隔开)
	 * @param paramValue 参数值(可多个，要和参数名称对应)
	 * @return 参数的Map对象
	 * @throws Exception
	 */
	protected Map<String, Object> getParamsMap(String paramNames, Object... paramValue) {
		Map<String, Object> params = new HashMap<String, Object>();
		String[] paramName = paramNames.split(",");
		if(paramName.length != paramValue.length) {
			logger.error("获取参数Map错误", new Exception("paramsMap中的名称和值个数不对应！"));
		} else {
			for(int i = 0; i < paramName.length; i++) {
				params.put(paramName[i], paramValue[i]);
			}
		}
		return params;
	}
	
	/**
	 * <p> 方法名：copyProperties </p>
	 * <p> 方法描述：复制对象的属性 </p>
	 * <p> 返回值：T </p>
	 * @param source
	 * @param clazz
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	protected <S, T> T copyProperties(S source, Class<T> clazz) throws InstantiationException, IllegalAccessException  {
		if (source != null) {
			T target = clazz.newInstance();
			BeanUtils.copyProperties(source, target);
			return target;
		} else {
			return null;
		}
	}
	
	/**
	 * <p> 方法名：copyPropertiesList </p>
	 * <p> 方法描述： </p>
	 * <p> 返回值：List<T> </p>
	 * @param sourceList
	 * @param clazz
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	protected <S, T> List<T> copyPropertiesList(List<S> sourceList, Class<T> clazz) throws InstantiationException, IllegalAccessException {
		List<T> targetList = new ArrayList<T>();
		if (sourceList != null && sourceList.size() > 0) {
			for (S source : sourceList) {
				targetList.add(copyProperties(source, clazz));
			}
		}
		return targetList;
	}
	
	/**
	 * <p> 方法名：copyProperties </p>
	 * <p> 方法描述：模型转换（使用了Spring的BeanUtils和apache的PropertyUtils） </p>
	 * <p> 返回值：T </p>
	 * @param source 原对象
	 * @param clazz 需要转换的对象的类型
	 * @return 转换完成的对象
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 */
	protected <S, T> T changeModal(S source, Class<T> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		T target = copyProperties(source, clazz);
		if (source != null && target != null) {
			for(PropertyDescriptor pd : PropertyUtils.getPropertyDescriptors(clazz)) {
				// 后台转前台
				for(Class<?> temp : AllJO.VO_CLASS) {
					if (temp.equals(pd.getPropertyType())) {
						if (PropertyUtils.getProperty(source, pd.getName()) != null) {
							PropertyUtils.setProperty(target, pd.getName(), changeModal((PropertyUtils.getProperty(source, pd.getName())), PropertyUtils.getPropertyType(target, pd.getName())));
						}
					}
				}
				// 前台转后台
				for(Class<?> temp : AllJO.PO_CLASS) {
					if (temp.equals(pd.getPropertyType())) {
						Object soucePropertyObj = PropertyUtils.getProperty(source, pd.getName());
						Object soucePropertyObjId = null;
						if (soucePropertyObj != null) {
							soucePropertyObjId =  PropertyUtils.getProperty(soucePropertyObj, "id");
						}
						if (soucePropertyObj != null && soucePropertyObjId !=null && !"".equals(soucePropertyObjId.toString().trim())) {
							PropertyUtils.setProperty(target, pd.getName(), dao.getByHql("from " + pd.getPropertyType().getSimpleName() + " where id = :id", getParamsMap("id", soucePropertyObjId.toString())));
						} else {
							PropertyUtils.setProperty(target, pd.getName(), null);
						}
					}
				}
			}
		}
		return target;
	}
	
	/**
	 * <p> 方法名：copyListProperties </p>
	 * <p> 方法描述：批量模型转换 </p>
	 * <p> 返回值：List<T> </p>
	 * @param sourceList 原对象的List集合
	 * @param clazz 需要转换的对象的类型
	 * @return 转换完成的对象的List集合
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 */
	protected <S, T> List<T> changeModalList(List<S> sourceList, Class<T> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		List<T> targetList = new ArrayList<T>();
		if (sourceList != null && sourceList.size() > 0) {
			for (S source : sourceList) {
				targetList.add(changeModal(source, clazz));
			}
		}
		return targetList;
	}
	
	/**
	 * <p> 方法名：getTableData </p>
	 * <p> 方法描述：获取前台的数据表格的数据(有排序功能)，hql无参 </p>
	 * <p> 返回值：Table<V> </p>
	 * @param tableParams 数据表格参数
	 * @param dao 相应的Dao层对象
	 * @param clazz 前台页面Bean的类型
	 * @param hql hql语句
	 * @return 设置完成的数据表格Table对象
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	protected <T, V> Table<V> getTableData(TableParams tableParams, Class<V> clazz, String hql) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Table<V> table = new Table<V>();
		if (hql.indexOf("from") == 0) {
			table.setTotal(dao.count("select count(*) " + hql));
		} else {
			table.setTotal(dao.count("select count(*) " + hql.substring(hql.indexOf("from"))));
		}
		if (tableParams.getSort() != null) {
			hql += " order by " + tableParams.getSort() + " " + tableParams.getOrder();
		}
		table.setRows(changeModalList(dao.find(hql, tableParams.getOffset(), tableParams.getLimit()), clazz));
		return table;
	}
	
	/**
	 * <p> 方法名：getTableData </p>
	 * <p> 方法描述：获取前台的数据表格的数据(有排序、模糊查询功能)，hql无参 </p>
	 * <p> 返回值：Table<V> </p>
	 * @param tableParams 数据表格参数
	 * @param dao 相应的Dao层对象
	 * @param clazz 前台页面Bean的类型
	 * @param hql hql语句
	 * @param searchColumnName hql中查找条件的字段
	 * @return 设置完成的数据表格Table对象
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	protected <T, V> Table<V> getTableData(TableParams tableParams, Class<V> clazz, String hql, String searchColumnName) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Table<V> table = new Table<V>();
		Map<String, Object> params = new HashMap<String, Object>();
		if (tableParams.getSearch() != null && !tableParams.getSearch().trim().equals("")) {
			hql += " where " + searchColumnName + " like :searchColumnName";
			params.put("searchColumnName", "%%" + tableParams.getSearch().trim() + "%%");
		}
		if (hql.indexOf("from") == 0) {
			table.setTotal(dao.count("select count(*) " + hql, params));
		} else {
			table.setTotal(dao.count("select count(*) " + hql.substring(hql.indexOf("from")), params));
		}
		if (tableParams.getSort() != null) {
			hql += " order by " + tableParams.getSort() + " " + tableParams.getOrder();
		}
		table.setRows(changeModalList(dao.find(hql, params, tableParams.getOffset(), tableParams.getLimit()), clazz));
		return table;
	}
	
	/**
	 * <p> 方法名：getTableData </p>
	 * <p> 方法描述：获取前台的数据表格的数据(有排序功能)，hql有参 </p>
	 * <p> 返回值：Table<V> </p>
	 * @param tableParams 数据表格参数
	 * @param dao 相应的Dao层对象
	 * @param clazz 前台页面Bean的类型
	 * @param hql hql语句
	 * @param params hql语句的参数Map对象
	 * @return 设置完成的数据表格Table对象
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	protected <T, V> Table<V> getTableData(TableParams tableParams, Class<V> clazz, String hql, Map<String, Object> params) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Table<V> table = new Table<V>();
		if (hql.indexOf("from") == 0) {
			table.setTotal(dao.count("select count(*) " + hql, params));
		} else {
			table.setTotal(dao.count("select count(*) " + hql.substring(hql.indexOf("from")), params));
		}
		if (tableParams.getSort() != null) {
			hql += " order by " + tableParams.getSort() + " " + tableParams.getOrder();
		}
		table.setRows(changeModalList(dao.find(hql, params, tableParams.getOffset(), tableParams.getLimit()), clazz));
		return table;
	}
	
	/**
	 * <p> 方法名：getTableData </p>
	 * <p> 方法描述：获取前台的数据表格的数据(有排序、模糊查询功能)，hql有参 </p>
	 * <p> 返回值：Table<V> </p>
	 * @param tableParams 数据表格参数
	 * @param dao 相应的Dao层对象
	 * @param clazz 前台页面Bean的类型
	 * @param hql hql语句
	 * @param params hql语句的参数Map对象
	 * @param searchColumnName hql语句中查找条件的字段名
	 * @return 设置完成的数据表格Table对象
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	protected <T, V> Table<V> getTableData(TableParams tableParams, Class<V> clazz, String hql, Map<String, Object> params, String searchColumnName) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Table<V> table = new Table<V>();
		if (tableParams.getSearch() != null && !tableParams.getSearch().trim().equals("")) {
			hql += " and " + searchColumnName + " like :searchColumnName";
			params.put("searchColumnName", "%%" + tableParams.getSearch().trim() + "%%");
		}
		if (hql.indexOf("from") == 0) {
			table.setTotal(dao.count("select count(*) " + hql, params));
		} else {
			table.setTotal(dao.count("select count(*) " + hql.substring(hql.indexOf("from")), params));
		}
		if (tableParams.getSort() != null) {
			hql += " order by " + tableParams.getSort() + " " + tableParams.getOrder();
		}
		table.setRows(changeModalList(dao.find(hql, params, tableParams.getOffset(), tableParams.getLimit()), clazz));
		return table;
	}
	
	/**
	 * <p> 方法名：batchDelete </p>
	 * <p> 方法描述：批量删除数据 </p>
	 * <p> 返回值：int </p>
	 * @param ids
	 * @param dao
	 * @param clazz
	 * @return
	 */
	protected <T> int batchDelete(String ids, Class<T> clazz) throws Exception {
		if (ids != null) {
			String[] nids = ids.split(",");
			for (String id : nids) {
				@SuppressWarnings("unchecked")
				T obj = (T) dao.getByHql("from " + clazz.getSimpleName() + " where id = :id", getParamsMap("id", id));
				for(PropertyDescriptor pd : PropertyUtils.getPropertyDescriptors(clazz)) {
					if (pd.getPropertyType().equals(Set.class)) {
						if (PropertyUtils.getProperty(obj, pd.getName()) != null) {
							if (((Set<?>) PropertyUtils.getProperty(obj, pd.getName())).size() != 0) {
								return -1;
							}
						}
					}
				}

			}
			for(String id : nids) {
				StringBuffer hql = new StringBuffer();
				hql.append("delete " + clazz.getSimpleName() + " where id in (");
				for (int i = 0; i < nids.length; i++) {
					if (i > 0) {
						hql.append(",");
					}
					hql.append("'" + nids[i] + "'");
				}
				hql.append(")");
				return dao.executeHql(hql.toString());
			}
		}
		return 0;
	}
	
}