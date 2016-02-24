package com.mad.recruit;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mad.recruit.service.HttpServices;

@Controller
@RequestMapping("/rest")
public class ServiceController {

	@RequestMapping(value = "/ping", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String pingRequest() {
		return "{\"success\":\"true\"}";
	}

	@RequestMapping(value = "/getcandidatelist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getCandidateList() {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendGet("candidateslist");
	}

	@RequestMapping(value = "/addtoken", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addTokenNumber(@RequestBody String tokenNo) {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendPut("addtoken", tokenNo);
	}

	@RequestMapping(value = "/getinterviewlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getInterviewCandidateList() {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendGet("interviewlist");
	}

	@RequestMapping(value = "/updateinterviewdetails", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateInterviewDetails(@RequestBody String interviewDetails) {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendPut("updateinterviewdetails", interviewDetails);
	}

	@RequestMapping(value = "/getselectedlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getSelectedCandidateList() {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendGet("selectedlist");
	}
	
	@RequestMapping(value="/addnewcandidate",method=RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addNewCandidate(@RequestBody String newCandidate){
		HttpServices httpGet = new HttpServices();
		return httpGet.sendPut("addnewcandidate", newCandidate);
	}

}
