package com.yuer.ssmc.mapper;

import java.util.List;

import com.yuer.ssmc.pojo.User;

public interface UserMapper {
	
	void insertUserData(User users);
	List<User> queryUserAllList();
	//根据id查用户
	User selectOneUserById(int id);
	//修改用户信息
	void updateUserInfo(User user);
	//删除用户
	void deleteUserInfoById(int id);
}
