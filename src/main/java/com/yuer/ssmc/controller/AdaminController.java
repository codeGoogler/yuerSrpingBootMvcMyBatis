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
	
	@RequestMapping("/addAdmin")
	public String showPage(@ModelAttribute("kklt") Admin admin){
		return "addAdmin";
	}
	
	/**
	 * 完成添加的操作
	 * @Valid：开启了多admin参数对象的数据校验
	 * @param admin
	 * @return
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
