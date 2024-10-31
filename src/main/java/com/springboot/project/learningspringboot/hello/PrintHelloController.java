package com.springboot.project.learningspringboot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PrintHelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public String printHello() {
		return "Hello! What are you doing today?";
	}
}

