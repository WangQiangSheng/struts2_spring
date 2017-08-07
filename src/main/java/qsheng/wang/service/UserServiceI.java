package qsheng.wang.service;

import java.io.Serializable;

import qsheng.wang.model.TUser;
import qsheng.wang.pageModel.User;

public interface UserServiceI {

	public Serializable saveAUser(User user);

}
