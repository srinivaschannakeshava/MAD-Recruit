package com.mad.recruit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/*@RequestMapping("/pages")*/
public class PagesController {

	 /*@RequestMapping(value="/login",method =RequestMethod.GET)
	   public String getLoginPage(){
		   return "login";
	   }*/
	
	   @RequestMapping(value = "/index", method = RequestMethod.GET)
	   public String index() {
//		   System.out.println("I am here");
		   return "index";
	   }
	  
	   @RequestMapping(value="/home",method =RequestMethod.GET)
	   public String getCandidatePage(){
		   return "home";
	   }
	   
	   @RequestMapping(value="/interview",method =RequestMethod.GET)
	   public String getInterviewPage(){
		   return "interview";
	   }
	   
	   @RequestMapping(value="/selected",method =RequestMethod.GET)
	   public String getSelectedPage(){
		   return "selected";
	   }
	  
}
