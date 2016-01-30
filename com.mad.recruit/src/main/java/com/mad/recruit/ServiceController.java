package com.mad.recruit;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mad.recruit.service.HttpServices;

@Controller
@RequestMapping("/rest")
public class ServiceController {
	
	@RequestMapping(value="/ping",method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String pingRequest(){
		return "success";
	}
	
	@RequestMapping(value="/getcandidatelist" , method=RequestMethod.GET , produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getCandidateList(){
		HttpServices httpGet=new HttpServices();
		return httpGet.sendGet("candidateslist");
	}

}
