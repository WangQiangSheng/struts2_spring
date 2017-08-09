package qsheng.wang.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDaoI <T>{
	
	public Serializable save(T o);
	
	public T find(String hql);

}
