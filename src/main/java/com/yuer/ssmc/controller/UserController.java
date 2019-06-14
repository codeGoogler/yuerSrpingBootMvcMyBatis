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
	 * 
	 * 如果想为传递的对象更改名称，可以使用@ModelAttribute("aa")这表示当前传递的对象的key为aa。
	 * 那么我们在页面中获取该对象的key也需要修改为aa
	 * @param users
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String  page){

		return page;
	}

	/**
	 * 完成用户添加
	 *@Valid 开启对Users对象的数据校验
	 *BindingResult:封装了校验的结果
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
	/**
	 * 注意这里面的方法名和requestMapping可以任意，为了规范，可以和mapper接口里面的值保持一致
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryUserAllList2")
	public String  findAllList2() {
		List<User> list = null;
		list = this.service.queryUserAllList();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", 0);
		jsonObject.put("boolean", true);
		JSONArray jsonArray = new JSONArray();
		if(list != null && list.size()>0){
			for (User user:list) {
				JSONObject jsonObject2 = new JSONObject();
				jsonObject2.put("id", user.getId());
				jsonObject2.put("name", user.getName());
				jsonObject2.put("age", user.getAge());
				jsonArray.add(jsonObject2);
			}
		}
		jsonObject.put("info", jsonArray);
		return jsonObject.toString();
	}
	
	/**
	 * 注意这里面的方法名和requestMapping可以任意，为了规范，可以和mapper接口里面的值保持一致
	 * @return
	 */
	@RequestMapping("/queryUserAllList")
	public String  findAllList(Model model) {
		List<User> list = null;
		list = this.service.queryUserAllList();
		model.addAttribute("list", list);
		return "queryAllList" ;
	}
	
	@RequestMapping("/selectOneUserById")
	public String findUserById(int id ,Model model){
		User user = this.service.selectOneUserById(id);
		model.addAttribute("user", user);
		return "modifyUserInfo";
	}
	
	
	
	@RequestMapping("/editUserInfo")
	public String updateUserInfo(User user){
		 this.service.updateUserInfo(user);
		return "success";
	}
	
	
	@RequestMapping("/deleteUserInfoById")
	public String updateUserInfo(int id){
		 this.service.deleteUserInfoById(id);
		return "success";
	}
	
	/**
	 * 请求用户个人主页
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryUserInfo")
	public String queryUserInfo(Model model){
		return "userHomePage";
	}
}
