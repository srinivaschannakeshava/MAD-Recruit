package com.mad.recruit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PagesController {

	
	   @RequestMapping(value = "/index", method = RequestMethod.GET)
	   public String index() {
		   System.out.println("I am here");
		   return "index";
	   }
	   
	  
}
