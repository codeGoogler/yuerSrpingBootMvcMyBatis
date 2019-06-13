package com.yuer.ssmc.mapper;

import java.util.List;

import com.yuer.ssmc.pojo.User;

/**
 * 类功能描述：</br>
 * 创建Mapping接口
 * @author 于亚豪
 * @version 1.0 </p> 修改时间：</br> 修改备注：</br>
 */
public interface UserMapper {
	//向表中插入数据
	void insertUserData(User users);
	//查询所有的用户
	List<User> queryUserAllList();
	//根据id查用户
	User selectOneUserById(int id);
	//修改用户信息
	void updateUserInfo(User user);
	//删除用户
	void deleteUserInfoById(int id);
}
