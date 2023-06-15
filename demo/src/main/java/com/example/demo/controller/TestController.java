package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
 
//테스트 페이지
	@RequestMapping("/test")
	public ModelAndView Register() {
		ModelAndView m = new ModelAndView();
		m.setViewName("test");
		
		return m;
	}
}
