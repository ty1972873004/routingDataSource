package cn.javaxxw.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class TestController {
	
	@RequestMapping("/index")
	public String list(HttpServletRequest request){
		return "index";
	}
	

}
