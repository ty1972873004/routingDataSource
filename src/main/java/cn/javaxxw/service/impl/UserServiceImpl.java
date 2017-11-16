package cn.javaxxw.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import cn.javaxxw.common.service.BaseServiceImpl;
import cn.javaxxw.model.User;
import cn.javaxxw.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{


	@Transactional
	@Override
	public  User addUser(String userName, String nickName, String sex, Integer old) {
		User user = new User();
		user.setNickName(nickName);
		user.setUserName(userName);
		user.setOld(old);
		user.setSex(sex);
		this.insertOrUpdate(user);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		return this.getAll();
	}

}
