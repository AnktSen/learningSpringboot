package com.springboot.project.learningspringboot.hello;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamController {

	@RequestMapping("param")
	public String requestParam(@RequestParam String hello, ModelMap model) {
		model.put("hello", hello);
		return "param";
		
	}
}
