package qsheng.wang.dao.impl;

import org.apache.log4j.Logger;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import qsheng.wang.dao.BaseDaoI;


@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDaoI<T> {
	public static final Logger logger = Logger.getLogger(BaseDaoImpl.class);
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private SessionFactory sessionFactory;
	
	
	
	

	@Override
	public Serializable save(T o) {
		logger.info("调用 hibernate Save 方法");
		logger.info(o.getClass().toString());
		return sessionFactory.getCurrentSession().save(o);
	}

}
