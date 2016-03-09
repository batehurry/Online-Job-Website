package com.qzw.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qzw.dao.BaseDaoI;

/**
 * 基础数据库操作实现类
 * 
 * @author 胜泽
 * 
 * @param <T>
 */
@Repository
public class BaseDaoImpl<T> implements BaseDaoI<T> {
	
	private static Logger log = LoggerFactory.getLogger(BaseDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 创建Criteria对象带属性
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param criterions
	 * @return
	 */
	/*private Criteria createCriteria(Class<T> entityClass, Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}*/

	/**
	 * 创建Criteria对象，有排序功能。
	 * 
	 * @param entityClass
	 * @param orderBy
	 * @param isAsc
	 * @param criterions
	 * @return
	 */
	/*private Criteria createCriteria(Class<T> entityClass, boolean isAsc, Criterion... criterions) {
		Criteria criteria = createCriteria(entityClass, criterions);
		if (isAsc) {
			criteria.addOrder(Order.asc("asc"));
		} else {
			criteria.addOrder(Order.desc("desc"));
		}
		return criteria;
	}*/

	/**
	 * 创建单一Criteria对象
	 * 
	 * @param entityClass
	 * @param criterions
	 * @return
	 */
	/*private Criteria createCriteria(Class<T> entityClass) {
		Criteria criteria = getSession().createCriteria(entityClass);
		return criteria;
	}*/

	@Override
	public Serializable save(T entity) {
		try {
			if (entity != null) {
				Serializable id = getSession().save(entity);
				getSession().flush();
				if (log.isDebugEnabled()) {
					log.debug("保存实体成功," + entity.getClass().getName());
				}
				return id;
			} else
				return null;
		} catch (RuntimeException e) {
			log.error("保存实体异常", e);
			throw e;
		}
	}

	@Override
	public List<Serializable> saveBatch(List<T> entitys) {
		if (entitys != null && entitys.size() > 0) {
			List<Serializable> listId = new ArrayList<Serializable>();
			for (int i = 0; i < entitys.size(); i++) {
				Serializable id = getSession().save(entitys.get(i));
				listId.add(id);
				if (i % 20 == 0) {
					// 20个对象后才清理缓存，写入数据库
					getSession().flush();
					getSession().clear();
				}
			}
			// 最后清理一下----防止大于20小于40的不保存
			getSession().flush();
			getSession().clear();
			return listId;
		} else
			return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Class<T> c, Serializable id) {
		if (id == null || id.equals("")) {
			return null;
		}
		T t = (T) getSession().get(c, id);
		if (t != null) {
			getSession().flush();
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getByHql(String hql) {
		Query q = getSession().createQuery(hql);
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getByHql(String hql, Map<String, Object> params) {
		Query q = getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public void delete(T entity) {
		if (entity != null) {
			try {
				getSession().delete(entity);
				getSession().flush();
				if (log.isDebugEnabled()) {
					log.debug("删除成功," + entity.getClass().getName());
				}
			} catch (RuntimeException e) {
				log.error("删除异常", e);
				throw e;
			}
		}
	}

	@Override
	public void update(T entity) {
		if (entity != null) {
			getSession().update(entity);
		}
	}

	@Override
	public void saveOrUpdate(T entity) {
		if (entity != null) {
			try {
				getSession().saveOrUpdate(entity);
				getSession().flush();
				if (log.isDebugEnabled()) {
					log.debug("添加或更新成功," + entity.getClass().getName());
				}
			} catch (RuntimeException e) {
				log.error("添加或更新异常", e);
				throw e;
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql) {
		Query q = getSession().createQuery(hql);
		return q.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		Query q = getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, Map<String, Object> params, int page,
			int rows) {
		Query q = getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult(page).setMaxResults(rows).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(String hql, int page, int rows) {
		Query q = getSession().createQuery(hql);
		return q.setFirstResult(page).setMaxResults(rows).list();
	}

	@Override
	public Long count(String hql) {
		Query q = getSession().createQuery(hql);
		return (Long) q.uniqueResult();
	}

	@Override
	public Long count(String hql, Map<String, Object> params) {
		Query q = getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (Long) q.uniqueResult();
	}

	@Override
	public int executeHql(String hql) {
		Query q = getSession().createQuery(hql);
		return q.executeUpdate();
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		Query q = getSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> findBySql(String sql) {
		SQLQuery q = getSession().createSQLQuery(sql);
		return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> findBySql(String sql, int page, int rows) {
		SQLQuery q = getSession().createSQLQuery(sql);
		return q.setFirstResult(page).setMaxResults(rows)
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> findBySql(String sql, Map<String, Object> params) {
		SQLQuery q = getSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> findBySql(String sql, Map<String, Object> params,
			int page, int rows) {
		SQLQuery q = getSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.setFirstResult(page).setMaxResults(rows)
				.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@Override
	public int executeSql(String sql) {
		SQLQuery q = getSession().createSQLQuery(sql);
		return q.executeUpdate();
	}

	@Override
	public int executeSql(String sql, Map<String, Object> params) {
		SQLQuery q = getSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}

	@Override
	public BigInteger countBySql(String sql) {
		SQLQuery q = getSession().createSQLQuery(sql);
		return (BigInteger) q.uniqueResult();
	}

	@Override
	public BigInteger countBySql(String sql, Map<String, Object> params) {
		SQLQuery q = getSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (BigInteger) q.uniqueResult();
	}

}
