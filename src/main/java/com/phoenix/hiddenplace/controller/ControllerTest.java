package com.phoenix.hiddenplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {

   @RequestMapping(value="/user/userInsertView")
   public String test1() {
      System.out.println("html 파일 호출");
      return "/views/user/userInsertView";
   }
   
}