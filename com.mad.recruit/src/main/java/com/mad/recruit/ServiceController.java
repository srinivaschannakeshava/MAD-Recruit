package com.mad.recruit;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
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
		//mupdateinterviewdetails
	}

	@RequestMapping(value = "/getinterviewlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getInterviewCandidateList() {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendGet("interviewlist");
		//mcandidatelist
	}

	@RequestMapping(value = "/updateinterviewdetails", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateInterviewDetails(@RequestBody String interviewDetails) {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendPut("updateinterviewdetails", interviewDetails);
		//mupdateinterviewdetails
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
		//maddnewcandidate
	}
	
	@RequestMapping(value="/downloadList",method=RequestMethod.GET)
	public void downloadExcel(HttpServletResponse response){
		 String mimeType= "application/octet-stream";
		 response.setHeader("Content-Disposition", String.format("inline; filename=\"testDoc.json\""));
		response.setContentType(mimeType);
		HttpServices httpGet = new HttpServices();
		String data=httpGet.sendGet("downloadexcel");
		 response.setContentLength((int)data.length());
		 InputStream inputStream = new BufferedInputStream(new ByteArrayInputStream(data.getBytes()));
		 try {
			FileCopyUtils.copy(inputStream, response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
