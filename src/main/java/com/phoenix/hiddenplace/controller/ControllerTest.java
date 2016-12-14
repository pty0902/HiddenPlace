package com.phoenix.hiddenplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {
   
   @RequestMapping(value="/homepage/homepageView")
   public String homeView() {
      
      return "/views/homepage/homeView";
      
   }

   //즐겨찾기 목록 호출
  @RequestMapping(value="/bookmark/userBookmarkView")
   public String InsertMHP() {
      
      return "/views/bookmark/userBookmarkView";
      
   }

}
