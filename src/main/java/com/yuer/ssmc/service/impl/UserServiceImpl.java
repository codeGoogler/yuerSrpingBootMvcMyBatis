package com.yuer.ssmc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.attoparser.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.TextUtils;

import com.mysql.jdbc.StringUtils;
import com.yuer.ssmc.mapper.UserMapper;
import com.yuer.ssmc.pojo.User;
import com.yuer.ssmc.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	//这里需要注入UserMapper的代理对象
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int addUser(User user) {
		if(user == null){
			return -1;
		}else if(StringUtils.isNullOrEmpty(user.getName())){
			return -1;
		}
		// TODO Auto-generated method stub
		this.userMapper.insertUserData(user);
		return 0;
	}

	@Override
	public List<User> queryUserAllList() {
		List<User> list = this.userMapper.queryUserAllList();
		return list;
	}

	@Override
	public User selectOneUserById(int id) {
		// TODO Auto-generated method stub
		return this.userMapper.selectOneUserById(id);
	}

	@Override
	public void updateUserInfo(User user) {
		 
		this.userMapper.updateUserInfo(user);
	}

	@Override
	public void deleteUserInfoById(int id) {
		 this.userMapper.deleteUserInfoById(id);
	}

}
