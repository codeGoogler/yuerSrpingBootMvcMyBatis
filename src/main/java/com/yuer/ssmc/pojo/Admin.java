package com.yuer.ssmc.pojo;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Admin implements Serializable{
	@NotBlank(message="姓名不能为空") //姓名的非空校验
	private String name;
	
	@NotBlank(message="密码不能为空") //姓名的非空校验
	private String password;
//	
//	@NotNull(message="年龄不能为空")  
	@Min(value=15)
	private int  age;
	
	@NotBlank(message="email不能为空")  
	@Email(message="email 输入的不是一个合格的字符串，请检车看卡")
	private String  email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Admin() {
		super();
	}
	
	
	 
}
