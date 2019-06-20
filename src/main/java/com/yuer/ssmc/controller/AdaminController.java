package com.yuer.ssmc.controller;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.IgnoreJava6Requirement;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuer.ssmc.pojo.Admin;

@Controller
@RequestMapping("/showAdmin")
public class AdaminController {
	
	
	/**
	 * 向页面传值的时候：可以在跳转页面的方法中注入一个 Adamin 对象。 由于 springmvc 会将该对象放入到 Model 中传递。 
	 * 默认：key 的名称会使用 该对象的驼峰式的命名规则来作为 key。参数的变量名需要与对象的名称相同。将首字母小写。
	 * @param admin
	 * @return
	 */
	@RequestMapping("/addAdmin")
	public String showPage(@ModelAttribute("kklt") Admin admin){
		return "addAdmin";
	}
	
	/**
	 * 完成添加的操作
	 * @Valid：开启了多admin参数对象的数据校验
	 * @param admin
	 * 如果想为传递的对象更改名称，可以使用@ModelAttribute("kklt")这表示当 前传递的对象的 key 为 kklt。
	 * 那么我们在页面中获取该对象的 key 也需要修改为 kklt * @param admin 
	 * 
	 */
	@RequestMapping("/saveAdminOk")
	public String saveAdminFinish(@ModelAttribute("kklt") @Valid Admin admin,BindingResult bindingResult){
		System.out.println("来吧，我过来了~~"+bindingResult);
		if(bindingResult.hasErrors()){
			return "addAdmin";	
		}
		return "success";
	}
}
