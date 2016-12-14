package com.phoenix.hiddenplace.controller;

import java.util.List;

import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.phoenix.hiddenplace.domain.Login;
import com.phoenix.hiddenplace.domain.MyHiddenPlace;
import com.phoenix.hiddenplace.domain.PageMaker;
import com.phoenix.hiddenplace.domain.Reply;
import com.phoenix.hiddenplace.domain.User;
import com.phoenix.hiddenplace.service.ReplyService;

@RestController
@RequestMapping(value = "/reply/*")
public class ReplyControllerRest {

	
	@Inject
	private ReplyService service;
	
	// 내알못 댓글 등록 
	   @RequestMapping(value = "/insertReplyMHP", method = RequestMethod.POST)
	   public ResponseEntity<String> insert(Reply reply) {
		   System.out.println(reply);
	      ResponseEntity<String> entity = null;

	      try {
	    	  service.insert(reply);
	         entity = new ResponseEntity<String>("success", HttpStatus.OK);
	      } catch (Exception e) {
	         e.printStackTrace();
	         entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	      }

	      return entity;
	   }
	

	//내알못 댓글 목록
	@RequestMapping(value = "/selectAllReplyMHP", method = RequestMethod.GET)
	public ResponseEntity<List<Reply>> hiddenplaceSelectAll(int num) throws Exception {
		
		ResponseEntity<List<Reply>> entity = null;
		
		try {
			entity = new ResponseEntity<List<Reply>>(service.listMHP(num), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("목록보기에서 오류");
			entity = new ResponseEntity<List<Reply>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}	
	
	
	// 댓글 삭제
		@RequestMapping(value = "/deleteReplyMHP", method = RequestMethod.POST)
		public ResponseEntity<String> deleteReply(Reply reply) {

			ResponseEntity<String> entity = null;
			try {
					service.romeveReply(reply);
					entity = new ResponseEntity<String>("success", HttpStatus.OK);

			} catch (Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			return entity;
		}
		
		
		// 댓글 수정
		@RequestMapping(value = "/updateReplyMHP", method = RequestMethod.POST)
		public ResponseEntity<String> updateReply(Reply reply) throws Exception {

			ResponseEntity<String> entity = null;
			try {

					service.modifyReply(reply);
					entity = new ResponseEntity<String>("success", HttpStatus.OK);
					
			} catch (Exception e) {
				e.printStackTrace();
				entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			return entity;
		}
	

	

}
