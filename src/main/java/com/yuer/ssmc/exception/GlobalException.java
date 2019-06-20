package com.yuer.ssmc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalException {
	
	/**
	 * java.lang.ArithmeticException 
	 * 该方法需要返回一个 ModelAndView：目的是可以让我们封装异常信息以及视图的指定
	 * 参数 Exception e:会将产生异常对象注入到方法中 
	 * 
	 */ 
	@ExceptionHandler(value={java.lang.ArithmeticException.class})
	public ModelAndView arithmeticException(Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("myException", exception.toString());
		modelAndView.setViewName("error1"); 
		return modelAndView;
	}
	
	/**
	 * java.lang.NullPointerException 
	 * 该方法需要返回一个 ModelAndView：目的是可以让我们封装异常信息以及视图的指定
	 * 参数 Exception e:会将产生异常对象注入到方法中 
	 * 
	 */ 
	@ExceptionHandler(value={java.lang.NullPointerException.class})
	public ModelAndView nullPointerException(Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("myException", exception.toString());
		modelAndView.setViewName("error2"); 
		return modelAndView;
	}
}
