package com.yuer.ssmc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@MapperScan("com.yuer.ssmc.mapper")  //用于spring扫描MyBatids的mapping接口,根据扫描的接口来生成代理对象
@SpringBootApplication
public class UserApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(UserApp.class, args);	
	}

}
 