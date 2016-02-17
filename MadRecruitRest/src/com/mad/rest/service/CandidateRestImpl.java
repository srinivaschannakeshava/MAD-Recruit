package com.mad.rest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mad.bean.CandidateDetails;
import com.mad.bean.CandidateInterviewDetails;
import com.mad.dao.impl.CandidateDaoImpl;

@Path("/")
public class CandidateRestImpl {
	
@Path("/ping")	
@GET
@Produces(MediaType.APPLICATION_JSON)
public String helloMad(){
	return "Ping Sucessfull";
}

@Path("/candidateslist")
@GET
@Produces(MediaType.APPLICATION_JSON)
public List<CandidateDetails> getCandidateList(){
	CandidateDaoImpl cd=new CandidateDaoImpl();
	return cd.getAllCandidates();
}

@Path("/interviewlist")
@GET
@Produces(MediaType.APPLICATION_JSON)
public List<CandidateDetails> getInterviewList(){
	CandidateDaoImpl cd=new CandidateDaoImpl();
	return cd.getInterviewCandidates();
}
	
@Path("/selectedlist")
@GET
@Produces(MediaType.APPLICATION_JSON)
public String getSelectionList(){
	return "SelectedList";
}

@Path("/addtoken")
@PUT
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public String addToken(CandidateDetails candDetail){
//	System.out.println("Data : "+data);
	CandidateDaoImpl cd=new CandidateDaoImpl();
	boolean isError=cd.addTokenToCandidate(candDetail.getEmail(), candDetail.getTokenNo());
	return "{\"isError\":\""+!isError+"\"}";
}

}
