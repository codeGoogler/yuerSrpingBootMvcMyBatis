package com.yuer.ssmc.service;

import java.util.List;

import com.yuer.ssmc.pojo.User;

public interface UserService {
	int addUser(User user);
	List<User> queryUserAllList();
	User selectOneUserById(int id);
	void updateUserInfo(User user);
	void deleteUserInfoById(int id);
}
