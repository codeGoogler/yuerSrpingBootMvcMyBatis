package com.yuer.ssmc.pojo;

import java.io.Serializable;

/**
 * 类功能描述：</br>
 * 用户信息类
 * @author 于亚豪
 * @version 1.0 </p> 修改时间：</br> 修改备注：</br>
 */
public class User implements Serializable {
	
	private int id;
	private String name;
	private Integer age;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public User() {
		super();
	}

}
