package com.phoenix.hiddenplace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {
   
   @RequestMapping(value="/homepage/homepageView")
   public String homeView() {
      
<<<<<<< HEAD
      return "/views/homepage/homeView";
      
   }
   
   @RequestMapping(value="/myhiddenplace/myHiddenPlaceInsert")
   public String InsertMHP() {
      
      return "/views/myhiddenplace/myHiddenPlaceInsert";
=======
      return "/views/homepage/homepageView";
>>>>>>> refs/remotes/dongjin1204/master
      
   }

}
