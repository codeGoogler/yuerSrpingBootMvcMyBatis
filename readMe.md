### 前沿


###   第一步，创建项目

![ ](https://upload-images.jianshu.io/upload_images/14371339-cbe667e53bcac71e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


### 第二步 ，配置pom.xml文件

在pom文件中添加相应的依赖

```
<dependencies>
		<!-- springBoot的启动器 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<scope>provided</scope>
		</dependency>
		<!-- web 启动器 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<!-- Mybatis 启动器 -->
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>1.1.1</version>
		</dependency>
		<!-- mysql 数据库驱动 -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>
      <!-- druid 数据库连接池 -->
		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>druid</artifactId>
			<version>1.0.9</version>
		</dependency>
	</dependencies>
```


#### 创建表

```
CREATE TABLE users( id int(11) NOT NULL AUTO_INCREMENT, name varchar(255)DEFAULT NULL,  age int(11)DEFAULT NULL, PRIMARY KEY(id) )ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

### 建立实体类Model

这一步没什么可说的。

```
/**
 * 类功能描述：</br>
 * 用户信息类
 * @author 于亚豪
 * @version 1.0 </p> 修改时间：</br> 修改备注：</br>
 */
public class User implements Serializable {
	
	private int id;
	private String name;
	private int age;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
```

### 创建UserMapper接口以及映射配置文件

**首先创建用户Mapping接口**

```
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

```

**首先创建Mapping接口**

```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.yuer.ssmc.mapper.UserMapper">
    ...
</mapper>

```

#### **说明：**

1、在 StudentMapper.xml 映射器配置文件中，其名空间 namespace 应该跟 StudentMapper 接口的完全限定名保持一

致。另外， StudentMapper.xml 中语句 id， parameterType， returnType 应该分别和 StudentMapper 接口中的方法名，参数类型，返回值相对应。

2、即使映射器 Mapper 接口可以以类型安全的方式调用映射语句，但是我们也应该负责书写正确的，匹配方法名、参数类型、 和返回值的映射器 Mapper 接口。

如果映射器 Mapper 接口中的方法和XML中的映射语句不能匹配，会在运行期抛出一个异常。

实际上，指定 parameterType 是可选的；MyBatis 可以使用反射机制来决定 parameterType。

但是，从配置可读性的角度来看，最好指定parameterType 属性。

3、如果 parameterType 没有被提及，开发者必须查看Mapper XML 配置和 Java 代码了解传递给语句的输入参数的数据类型。



###   创建业务层

在业务层里面实现你的数据库处理的操作操作，注意，这里不是和数据库直接打交道，eg:


```

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
```

### 创建Controller层 

Controller层就是一个控制器，通过导入Service层里面的方法，我们可以对前端传递过来的参数，返回指定的路径或者是页面

```
package com.yuer.ssmc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuer.ssmc.pojo.User;
import com.yuer.ssmc.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 类功能描述：</br>
 * 控制器
 * @author 于亚豪
 * @version 1.0 </p> 修改时间：</br> 修改备注：</br>
 */
@Controller
@RequestMapping("/showUser")
public class UserController {

	@Autowired
	private UserService service;

	/**
	 * 页面的跳转
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String  page){

		return page;
	}
	/**
	 * 向表中添加用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addUser")
	public String addUser(User user){
		int status = this.service.addUser(user);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", 0);
		if(status == 0){
			jsonObject.put("boolean", true);
			jsonObject.put("info", "插入成功！");
		}else{
			jsonObject.put("boolean", false);
			jsonObject.put("info", "数据不完整！");
		}
		return jsonObject.toString();
	}

	 
	......
 
}

```

### 实现增删改查

**比如我们来实现一个数据插入的操作，我们在Dao层进行修改，增加一个插入:**

```
<insert id="insertUserData" parameterType="user">
		insert into users(name,age) values(#{name},#{age})
</insert>
	
```

**修改业务层：**

```
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

```

**修改controller层**

```
/**
	 * 向表中添加用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addUser")
	public String addUser(User user){
		int status = this.service.addUser(user);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", 0);
		if(status == 0){
			jsonObject.put("boolean", true);
			jsonObject.put("info", "插入成功！");
		}else{
			jsonObject.put("boolean", false);
			jsonObject.put("info", "数据不完整！");
		}
		return jsonObject.toString();
	}
```

**运行结果：**

![ ](https://upload-images.jianshu.io/upload_images/14371339-a86bb3572117c594.gif?imageMogr2/auto-orient/strip)

**然后查看数据库：**

![ ](https://upload-images.jianshu.io/upload_images/14371339-504406200ee564b6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


### 对SSM即sping+springMVC+mybatis框架的理解

参考：http://www.luyixian.cn/news_show_15698.aspx



**Spring MVC**是Spring提供的一个强大而灵活的模块式web框架。通过Dispatcher Servlet, ModelAndView 和 View Resolver，开发web应用变得很容易


**Model层：**存放我们的实体类，与数据库中的属性值基本保持一致。

**Service层：** 业务逻辑处理层，也是一些关于数据库处理的操作，但不是直接和数据库打交道，一般是通过Service的实现类来，他有接口还有接口的实现方法，在接口的实现方法中需要导入mapper层，mapper层是直接跟数据库打交道的，他也是个接口，只有方法名字，具体实现在mapper.xml文件里，service是供我们使用的方法，在方法中进行业务逻辑的操作。

**DAO层：** 数据访问层，属于一种比较底层，比较基础的操作，具体到对于某个表的增删改查，也就是说某个DAO一定是和数据库的某一张表一一对应的，其中封装了增删改查基本操作。现在用mybatis逆向工程生成的mapper层，其实就是dao层。对数据库进行数据持久化操作，他的方法语句是直接针对数据库操作的，而service层是针对我们controller，也就是针对我们使用者。service的impl是把mapper和service进行整合的文件。

 

**controller层：** 控制器，通过导入Service层里面的方法，我们可以对前端传递过来的参数，返回指定的路径或者是页面。



这下是不是清晰多了，其实他的业务逻辑是：

UserController-->service接口-->UserserviceImpl-->dao接口-->UserdaoImpl-->mapper-->db  

这样有助有我们对SpringMVC的理解！


### 更多参考

[Spring Boot 《一》开发一个“HelloWorld”的 web 应用](https://blog.csdn.net/androidstarjack/article/details/90904067)

[SpringMVC， SpringBoot、 Spring Cloud及Maven的理解](https://blog.csdn.net/androidstarjack/article/details/90901366)

### 相信自己，没有做不到的，只有想不到的
 如果你觉得此文对您有所帮助， 欢迎关注微信公众号：终端研发部 这里不仅仅学到的是技术

 
![技术+职场](http://upload-images.jianshu.io/upload_images/4614633-977d06f49c7ba7be.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

（欢迎关注学习和交流） 
 