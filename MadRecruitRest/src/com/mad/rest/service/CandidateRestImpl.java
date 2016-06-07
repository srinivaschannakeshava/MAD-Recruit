package com.mad.rest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mad.bean.CandidateDetails;
import com.mad.bean.CandidateInterviewDetails;
import com.mad.bean.MongoCandidateDetails;
import com.mad.dao.CandidateInfoDao;
import com.mad.dao.impl.CandidateDaoImpl;
import com.mad.dao.impl.CandidateInterviewInfoDao;
import com.mad.dao.impl.MongoCandidateDaoImpl;

@Path("/")
public class CandidateRestImpl {

	@Path("/ping")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String helloMad() {
		return "{\"Test\":\"Ping Sucessfull\"}";
	}

	@Path("/candidateslist")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CandidateDetails> getCandidateList() {
		CandidateDaoImpl cd = new CandidateDaoImpl();
		return cd.getAllCandidates();
	}

	@Path("/interviewlist")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CandidateInterviewDetails> getInterviewList() {
		CandidateDaoImpl cd = new CandidateDaoImpl();
		return cd.getInterviewCandidates();
	}

	@Path("/selectedlist")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CandidateInterviewDetails> getSelectionList() {
		CandidateInterviewInfoDao cd = new CandidateInterviewInfoDao();
		return cd.getAllSelectedList();
	}

	@Path("/addtoken")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addToken(CandidateDetails candDetail) {
		// System.out.println("Data : "+data);
		CandidateDaoImpl cd = new CandidateDaoImpl();
		boolean isError = cd.addTokenToCandidate(candDetail.getEmail(), candDetail.getTokenNo());
		return "{\"isError\":\"" + !isError + "\"}";
	}

	@Path("/updateinterviewdetails")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateInterviewDetails(CandidateInterviewDetails cid) {
		CandidateInterviewInfoDao ciid = new CandidateInterviewInfoDao();
		boolean isError = ciid.updateCandidateInterviewDetails(cid);
		return "{\"isError\":\"" + !isError + "\"}";
	}

	@Path("/addnewcandidate")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addNewCandidate(CandidateDetails ncd) {
		CandidateDaoImpl cid = new CandidateDaoImpl();
		boolean isError = cid.addNewCandidate(ncd);
		return "{\"isError\":\"" + !isError + "\"}";
	}

	@Path("/maddnewcandidate")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addToMongoDBTest(MongoCandidateDetails MCD) {
		boolean result = MongoCandidateDaoImpl.getMongoCandidateDaoImpl().addCandidateToDB(MCD);
		return "{\"isError\":\"" + result + "\"}";
	}

	@Path("/mgetcandidate/{emailId}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MongoCandidateDetails getCandidateDetails(@PathParam(value = "emailId") String emailId) {
		return MongoCandidateDaoImpl.getMongoCandidateDaoImpl().getCandidateDetails(emailId);
	}

	@Path("/mcandidatelist")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<MongoCandidateDetails> getCandidateListMongo() {
		return MongoCandidateDaoImpl.getMongoCandidateDaoImpl().getCandidateList();
	}

	@Path("/mupdateinterviewdetails")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateInterviewDetailsMongo(MongoCandidateDetails MCD) {
		boolean isError = MongoCandidateDaoImpl.getMongoCandidateDaoImpl().updateCandidateMongoDB(MCD);
		return "{\"isError\":\"" + !isError + "\"}";
	}

}
