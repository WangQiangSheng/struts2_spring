package qsheng.wang.service.impl;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qsheng.wang.dao.UserDaoI;
import qsheng.wang.model.TUser;
import qsheng.wang.pageModel.User;
import qsheng.wang.service.UserServiceI;


@Service("userService")
public class UserServiceImpl implements UserServiceI {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	private UserDaoI userDao;
	public UserDaoI getUserDao() {
		return userDao;
	}
@Autowired
	public void setUserDao(UserDaoI userDao) {
		this.userDao = userDao;
	}

	@Override
	public Serializable saveAUser(User user) {
		TUser u = new TUser();
		u.setCreatedatetime(new Timestamp(new Date().getTime()));
		u.setId(UUID.randomUUID().toString());
		u.setName(user.getName());
		u.setPwd(user.getPwd1());
		logger.info(user);
		return this.userDao.saveAUser(u);
	}

}
