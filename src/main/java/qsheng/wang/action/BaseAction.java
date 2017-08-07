package qsheng.wang.action;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.alibaba.fastjson.JSON;

@ParentPackage("basePackage")
@Namespace("/")
public class BaseAction {
	
	public static final Logger logger = Logger.getLogger(UserAction.class);
	
	public void writeJson(Object object) {
		try {
			ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
			ServletActionContext.getResponse().setContentType("text/html;");
			String jsonStr = JSON.toJSONString(object);
			ServletActionContext.getResponse().getWriter().write(jsonStr);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
