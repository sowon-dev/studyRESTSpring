package com.itwillbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	@RequestMapping(value = "sendList")
	public List<SampleVO> sendList(){
		List<SampleVO> voList = new ArrayList<SampleVO>();
		
		for(int i=0;i<10;i++) {
			SampleVO vo = new SampleVO(i, "나혜석", "0"+i+"0-123-4567" );
			voList.add(vo);
		}
		return voList;
	}
	
	//컬렉션객체활용 2.Map
	//http://localhost:8088/test/sendMap
	@RequestMapping(value = "sendMap")
	public Map<Integer, SampleVO> sendMap(){
		Map<Integer, SampleVO> voMap = new HashMap<Integer, SampleVO>();
		for(int i=0;i<10;i++) {
			SampleVO vo = new SampleVO(i, "나혜석", "0"+i+"0-123-4567" );
			
			voMap.put(i, vo);
		}
		return voMap;
	}
 	
	//파라미터들을 json데이터로 꺼내올 수 있음
	//http://localhost:8088/test/board2/1234
	//@RequestMapping(value = "board/{num}")
	public int board(@PathVariable("num") int num) {
		return num; //숫자리턴은 json형태가 된다.
	}
	
	//String타입 매개변수도 사용가능하다 
	@RequestMapping(value = "board/{num}")
	public int board(@PathVariable("num") String num) {
		System.out.println(num);
		return 0; //숫자리턴은 json형태가 된다.
	}
	
	//String타입 매개변수도 사용가능하다 
	@RequestMapping(value = "board2/{num}")
	public SampleVO board2(@PathVariable("num") int num) {
		SampleVO vo = new SampleVO(num, "나혜석", "0"+num+"0-123-4567" );
		return vo; //숫자리턴은 json형태가 된다.
	}
	
	//ajax로 데이터전달받기
	@RequestMapping(value = "info", method = RequestMethod.POST)
	public void checkVO(@RequestBody SampleVO vo) {
		//@RequestBody : JSON형태로 전달된 데이터를 해당타입(여기서는 SampleVO)에 자동으로 저장하겠다는 의미
		System.out.println("REST컨트롤러 checkVO메서드 호출"+vo);
	}
	
	//ResponseEntity 테스트
	//http://localhost:8088/test/sendListError
	@RequestMapping(value = "sendListError")
	public ResponseEntity<List<SampleVO>> sendListAuth() {
		//System.out.println("HTTP상태리턴: " + HttpStatus.FORBIDDEN);
		List<SampleVO> voList = new ArrayList<SampleVO>();
		
		for(int i=0;i<10;i++) {
			SampleVO vo = new SampleVO(i, "나혜석", "0"+i+"0-123-4567" );
			voList.add(vo);
		}
		
		System.out.println("HTTP상태리턴: " + voList);
		return new ResponseEntity<List<SampleVO>>(voList, HttpStatus.NOT_FOUND);
	}
	
	//ResponseEntity를 사용하면 단순한 객체 정보도 JSON형태로 전달가능하지만,
	//HTML 정보와 JS정보까지 전달할 수 있다.(예를 들어 Header정보)
	//이를 통해 결과확인 및 오류메세지 체크가 가능해진다.
	@RequestMapping(value = "res2")
	public ResponseEntity res2() {
		System.out.println("res2 메서드 호출");
		
		//응답정보 중에 header에 데이터를 add해서 보낸다.
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-type", "text/html; charset=UTF-8");
		String msg = "<script>";
		msg += "alert('얼럿창테스트');";
		msg += "location.href='/res1';";
		msg += "</script>";
		
		return new ResponseEntity(msg,responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
