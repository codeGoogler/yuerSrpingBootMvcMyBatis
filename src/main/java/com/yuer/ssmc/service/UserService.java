package com.yuer.ssmc.service;

import java.util.List;

import com.yuer.ssmc.pojo.User;

/**
 * 类功能描述：</br>
 * 用户信息类
 * @author 于亚豪
 * @version 1.0 </p> 修改时间：</br> 修改备注：</br>
 */
public interface UserService {
	int addUser(User user);
	List<User> queryUserAllList();
	User selectOneUserById(int id);
	void updateUserInfo(User user);
	void deleteUserInfoById(int id);
}
