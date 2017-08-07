package qsheng.wang.dao;

import java.io.Serializable;

import qsheng.wang.model.TUser;

public interface UserDaoI{
	
	public Serializable saveAUser(TUser user);
	
}
