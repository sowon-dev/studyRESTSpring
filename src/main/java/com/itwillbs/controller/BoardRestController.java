package com.itwillbs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itwillbs.domain.BoardVO;

@RestController
@RequestMapping(value = "/boards")
public class BoardRestController {
	// 특정 정보 조회(GET)
	// http://localhost:8088/boards/2
	@RequestMapping(value = "/{bno}", method = RequestMethod.GET)
	public ResponseEntity<BoardVO> findBoard(@PathVariable("bno") int bno){
		System.out.println("findBoard메서드의 bno는 "+bno);
		BoardVO vo = new BoardVO(bno, "admind_"+bno, "테스트제목_"+bno, "테스트내용_"+bno);
		
		return new ResponseEntity<BoardVO>(vo, HttpStatus.OK); 
	}

	//신규 글쓰기
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> addBoard(@RequestBody BoardVO vo){
		//@RequestBody는 model객체처럼 json타입을 받아서 BoardVO로 받아서 사용가능
		System.out.println("addBoard메서드"+ vo);
		
		ResponseEntity<String> resEntity = null;
		
		try {
			System.out.println("정보 전달 받아서 처리 -> 서비스");
			resEntity = new ResponseEntity<String>("글쓰기 성공", HttpStatus.OK);
		} catch (Exception e) {
			resEntity = new ResponseEntity<String>("글쓰기 실패", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return resEntity;
	}
	
	//글정보수정 (put)
	@RequestMapping(value = "/{bno}", method = RequestMethod.PUT)
	public ResponseEntity<String> modBoard(@PathVariable("bno") int bno, @RequestBody BoardVO updateVO){
		ResponseEntity<String> resEntity = null;

		try {
			System.out.println("modBoard메서드의 bno는 "+bno+ " , updateVO: "+updateVO);
			resEntity = new ResponseEntity<String>("글수정 성공", HttpStatus.OK);
		} catch (Exception e) {
			resEntity = new ResponseEntity<String>("글수정 실패", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return resEntity;
	}
	
	//글정보삭제 (delete)
	@RequestMapping(value = "/{bno}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delBoard(@PathVariable("bno") int bno, @RequestBody BoardVO deleteVO){
		ResponseEntity<String> resEntity = null;
		
		try {
			System.out.println("deleteVO 메서드의 bno는 "+bno+ " , updateVO: "+deleteVO);
			resEntity = new ResponseEntity<String>("글삭제 성공", HttpStatus.OK);
		} catch (Exception e) {
			resEntity = new ResponseEntity<String>("글삭제 실패", HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		
		return resEntity;
	}
	
}
