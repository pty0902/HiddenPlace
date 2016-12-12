package com.phoenix.hiddenplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {
   
   @RequestMapping(value="/homepage/homepageView")
   public String homeView() {
      
      return "/views/homepage/homeView";
      
   }
   
/*  @RequestMapping(value="/myhiddenplace/myHiddenPlaceInsert")
   public String InsertMHP() {
      
      return "/views/myhiddenplace/myHiddenPlaceInsert";
      
   }*/

}
