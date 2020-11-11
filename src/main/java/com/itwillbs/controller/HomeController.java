package com.itwillbs.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "JSONtest";
	}
	
	//@RestController사용하지 않고 일반컨트롤러에서도 @ResponseBody을 통해서 ResponseEntity를 통한 리턴이 가능하다(rest로 처리가능하다)
	@RequestMapping(value = "/res1")
	@ResponseBody
	public Map<String, Object> res1(){
		System.out.println("res1 메서드 호출");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "uesr1");
		map.put("name", "사용자");
		
		return map;
	}
	
}
