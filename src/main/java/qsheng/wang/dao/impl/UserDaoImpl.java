package qsheng.wang.dao.impl;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import qsheng.wang.dao.UserDaoI;
import qsheng.wang.model.TUser;




@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<TUser> implements UserDaoI{

	@Override
	public Serializable saveAUser(TUser user) {
		logger.info("UserDaoImpl  saveAUser ^^^^^^");
		return save(user);
	}
	
	
	
	
}
