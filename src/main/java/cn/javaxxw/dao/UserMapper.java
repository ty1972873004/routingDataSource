package cn.javaxxw.dao;


import java.util.List;

import org.springframework.stereotype.Component;

import cn.javaxxw.common.dao.BaseMapper;
import cn.javaxxw.model.User;

@Component
public class UserMapper extends BaseMapper<User>{
	
	
	public List<User> selectAllUser(){
		return this.getSqlSession().selectList("selectAllUser");
	}
	

}
