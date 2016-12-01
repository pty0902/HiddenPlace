package com.phoenix.hiddenplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {

   @RequestMapping(value="/homepage/homeView")
   public String test1() {
      System.out.println("html 파일 호출");
      return "/views/homepage/homeView";	
   }
   
//   @RequestMapping(value="/homepage/homeJspTest")
//   public void test2(){
//      System.out.println("jsp 파일 호출");
//   }

}
