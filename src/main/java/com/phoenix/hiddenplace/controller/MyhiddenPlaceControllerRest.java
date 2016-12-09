//1
package com.phoenix.hiddenplace.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.phoenix.hiddenplace.domain.MyHiddenPlace;
import com.phoenix.hiddenplace.domain.PageMaker;
import com.phoenix.hiddenplace.service.MyHiddenPlaceService;

@RestController
@RequestMapping(value = "/myhiddenplace")
public class MyhiddenPlaceControllerRest {

	@Inject
	private MyHiddenPlaceService service;

	//페이지 전환
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<PageMaker> listPage(PageMaker pageMaker) throws Exception {
		
		ResponseEntity<PageMaker> entity = null;
		
		try {
			
			pageMaker.setTotalCount(service.listCount(pageMaker));
			System.out.println(pageMaker.getEndPage());
			entity = new ResponseEntity<PageMaker>(pageMaker, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<PageMaker>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}	
	
	//내알못 목록
	@RequestMapping(value = "/myhiddenplaceSelectAll", method = RequestMethod.GET)
	public ResponseEntity<List<MyHiddenPlace>> hiddenplaceSelectAll(PageMaker pageMaker) throws Exception {
		
		ResponseEntity<List<MyHiddenPlace>> entity = null;
		
		try {
			entity = new ResponseEntity<List<MyHiddenPlace>>(service.list(pageMaker), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("목록보기에서 오류");
			entity = new ResponseEntity<List<MyHiddenPlace>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}	
	
	
	//내알못 베스트 3
	@RequestMapping(value = "/bestMHP", method = RequestMethod.GET)
	public ResponseEntity<List<MyHiddenPlace>> bestMHP() throws Exception {
		
		ResponseEntity<List<MyHiddenPlace>> entity = null;
		
		try {
			entity = new ResponseEntity<List<MyHiddenPlace>>(service.bestMHP(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("목록보기에서 오류");
			entity = new ResponseEntity<List<MyHiddenPlace>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}	
	
//	// 회원가입
//	@RequestMapping(value = "/userInsertView", method = RequestMethod.POST)
//	public ResponseEntity<String> insert(User user) {
//
//		System.out.println("회원가입 컨트롤러RESTFUL");
//		System.out.println(user.toString());
//		ResponseEntity<String> entity = null;
//
//		try {
//			service.create(user);
//			entity = new ResponseEntity<String>("success", HttpStatus.OK);
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//
//		return entity;
//	}
//
//	// 닉네임 중복확인
//	@RequestMapping(value = "/nicknameCheck")
//	public ResponseEntity<String> nicknameCheck(String nickname) {
//
//		System.out.println("닉네임 중복확인 컨트롤러RESTFUL");
//		ResponseEntity<String> entity = null;
//		String checkNickname = null;
//		try {
//			checkNickname = service.nicknameCheck(nickname); // 사용가능한 닉네임, 불가능하다면 null
//			System.out.println(checkNickname);
//			if (checkNickname == null) {
//				entity = new ResponseEntity<String>("success", HttpStatus.OK);
//			} else {
//				entity = new ResponseEntity<String>("fail", HttpStatus.OK);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//		return entity;
//
//	}
	
	
	
	
	

	/*태금테스트*/
	@RequestMapping(value = "/imageUpload", headers = "content-type=multipart/*", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
		System.out.println("1");
		try {
			System.out.println("2");
            //UploadFile uploadedFile = imageService.store(file);
//            return ResponseEntity.ok().body("/image/" + uploadedFile.getId());
            return ResponseEntity.ok().body("/image/11");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
	
	
	// 내알못 등록 
	   @RequestMapping(value = "/insertMHP", method = RequestMethod.POST)
	   public ResponseEntity<String> insert(MyHiddenPlace myHiddenPlace) {
		   System.out.println("왔니");
		   System.out.println(myHiddenPlace.getContent());
	      ResponseEntity<String> entity = null;

	      try {
	    	  service.insert(myHiddenPlace);
	         entity = new ResponseEntity<String>("success", HttpStatus.OK);
	      } catch (Exception e) {
	         e.printStackTrace();
	         entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	      }

	      return entity;
	   }
	   
	}   
