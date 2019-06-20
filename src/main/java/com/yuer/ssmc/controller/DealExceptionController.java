package com.yuer.ssmc.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dealException")
public class DealExceptionController {
	
	@RequestMapping("/dealException1")
	public String dealException1() {
		int i=0;
		int ss = i / 0;
		System.out.println("啦啦啦啦");
		return "success";
	}
	
	@RequestMapping("/dealException2")
	public String dealException2() {
		String message = null;
		int ss = message.length();
		System.out.println("dealException2");
		return "success";
	}
	
//	/**java.lang.ArithmeticException 
//	 * 该方法需要返回一个 ModelAndView：目的是可以让我们封装异常信息以及视图的指定
//	 * 参数 Exception e:会将产生异常对象注入到方法中 
//	 * 
//	 */ 
//	@ExceptionHandler(value={java.lang.ArithmeticException.class})
//	public ModelAndView arithmeticException(Exception exception) {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("myException", exception.toString());
//		modelAndView.setViewName("error1"); 
//		return modelAndView;
//	}
//	
//	/**java.lang.NullPointerException 
//	 * 该方法需要返回一个 ModelAndView：目的是可以让我们封装异常信息以及视图的指定
//	 * 参数 Exception e:会将产生异常对象注入到方法中 
//	 * 
//	 */ 
//	@ExceptionHandler(value={java.lang.NullPointerException.class})
//	public ModelAndView nullPointerException(Exception exception) {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("myException", exception.toString());
//		modelAndView.setViewName("error2"); 
//		return modelAndView;
//	}
}	
