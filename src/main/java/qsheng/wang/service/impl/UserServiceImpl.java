package qsheng.wang.service.impl;

import java.io.Serializable;
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
import qsheng.wang.utils.Encrypt;

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
		u.setPwd(Encrypt.e(user.getPwd1()));
		logger.info(user);
		return this.userDao.save(u);
	}

	@Override
	public boolean findAUser(User user) {
		boolean result = false;
		String hql = "from TUser t where t.name = '" + user.getName() + "' and t.pwd='" + Encrypt.e(user.getPwd1()) + "'";
		logger.info("HQL : " + hql);
		try {
			logger.info("userDao.find(hql).size() = "+userDao.find(hql));
			if(userDao.find(hql) != null){
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

}
