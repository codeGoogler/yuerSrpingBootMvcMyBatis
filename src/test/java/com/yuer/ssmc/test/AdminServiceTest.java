package com.yuer.ssmc.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yuer.ssmc.UserApp;
import com.yuer.ssmc.pojo.User;
import com.yuer.ssmc.service.UserService;
import com.yuer.ssmc.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={UserApp.class})
public class AdminServiceTest {

	@Autowired
	UserService userServiceImpl;

	@Test
	public void questTest(){
		List<User> list = userServiceImpl.queryUserAllList();
		for (User user : list) {
			System.out.println("姓名:"+user.getName()+"    年龄:" +user.getAge());
		}
	}

	@Test
	public void insertTest(){
		try {
			User user = new User();
			user.setName("yuer");
			user.setAge(29);
			user.setId(10);
			userServiceImpl.addUser(user);
			System.out.println("插入成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("插入失败");
		}

	}
}
