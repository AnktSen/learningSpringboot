package com.springboot.project.learningspringboot.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
        
	@RequestMapping("/ankit")
	@ResponseBody
	public String heyAnkit() {
		return "Hey Ankit How Are You?";
	}
	
	@RequestMapping("/html")
	@ResponseBody
	public String heyHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My first HTML page - Changed</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html page with body- Changed");
		sb.append("</bpdy>");
		sb.append("</html>");
		
		return sb.toString();
	}
}

