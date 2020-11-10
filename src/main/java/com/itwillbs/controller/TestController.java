package com.itwillbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.SampleVO;

@RestController
@RequestMapping(value = "/test/*")
public class TestController {
	//@ResponseBody : 객체를 json으로 만들어주는 어노테이션
	//@RestController : 스프링4부터, 하위의 메서드는 @ResponseBody가 없어도 동일하게 처리된다(@ResponseBody생략됨)

	//http://localhost:8088/test/hello
	@RequestMapping(value= "hello", method= RequestMethod.GET)
	public String hello() {
		//문자열리턴의 목적은 : jsp페이지로 가는 것이 아니라 문자열타입의 데이터를 리턴하거나 생성하는 목적으로 사용된다.
		return "Hello ITWILL!"; //text형태로 보여짐
	}
	
	//http://localhost:8088/test/sendVO
	@RequestMapping(value= "sendVO")
	public @ResponseBody SampleVO sendVO() {
		SampleVO svo = new SampleVO(1, "나혜석", "010-123-4567" );
		return svo;
	}
	
	//컬렉션객체활용 1.List(리스트)
	//http://localhost:8088/test/sendList
	@RequestMapping(value= "sendList")
	public List<SampleVO> sendList(){
		List<SampleVO> voList = new ArrayList<SampleVO>();
		
		for(int i=0;i<10;i++) {
			SampleVO vo = new SampleVO(i, "나혜석", "0"+i+"0-123-4567" );
			voList.add(vo);
		}
		return voList;
	}
	
	//http://localhost:8088/test/sendMap
	@RequestMapping(value="sendMap")
	public Map<Integer, SampleVO> sendMap(){
		Map<Integer, SampleVO> voMap = new HashMap<Integer, SampleVO>();
		for(int i=0;i<10;i++) {
			SampleVO vo = new SampleVO(i, "나혜석", "0"+i+"0-123-4567" );
			
			voMap.put(i, vo);
		}
		return voMap;
	}
 	
}
