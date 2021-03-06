package qsheng.wang.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ModelDriven;

import qsheng.wang.pageModel.User;
import qsheng.wang.service.UserServiceI;
import qsheng.wang.utils.Json;

@Action("userAction")
public class UserAction extends BaseAction implements ModelDriven<User> {

	private User user = new User();
	
	private UserServiceI userService;

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		return user;
	}
	
	public void register() {
		Json json = new Json();
		try {
			this.userService.saveAUser(user);
			json.setSuccess(true);
			json.setMsg("注册成功！！！");
		} catch (Exception e) {
			json.setMsg("注册失败！！！");
		}
		super.writeJson(json);
	}

	public void login(){
		Json json = new Json();
		boolean result = this.userService.findAUser(user);
		if(result){
			json.setSuccess(result);
			json.setMsg("登陆成功！！！");
		}else{
			json.setMsg("登录失败！！！");
		}
		super.writeJson(json);
	}

}
