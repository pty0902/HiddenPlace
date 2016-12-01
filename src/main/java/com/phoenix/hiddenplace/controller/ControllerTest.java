package com.phoenix.hiddenplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {

<<<<<<< HEAD
   @RequestMapping(value="/user/userInsertView")
=======

   @RequestMapping(value="/homepage/homeView")
>>>>>>> refs/remotes/dongjin1204/master
   public String test1() {
      System.out.println("html 파일 호출");
      return "/views/user/userInsertView";
   }
   
   @RequestMapping(value="/bookmark/userBookMarkView")
   public String test3() {
      System.out.println("html 파일 호출");
      return "/views/bookmark/userBookMarkView";
   }

}
