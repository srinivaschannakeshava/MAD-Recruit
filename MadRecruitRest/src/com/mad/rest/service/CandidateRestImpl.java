package com.mad.rest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mad.bean.AdminBean;
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

	@Path("/{collection}/selectedlist")
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

	// -------------------------------------------------Mongo-------------------------------------------------------------------------------//

	@Path("/mgetlogin")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public AdminBean getCandidateDetails(AdminBean login) {
		AdminBean admin = MongoCandidateDaoImpl.getMongoCandidateDaoImpl().getLogin(login);
		admin.setPassword(null);
		return admin;
	}

	@Path("/{collection}/maddtoken")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String maddToken(MongoCandidateDetails candDetail, @PathParam(value = "collection") String collection) {
		// System.out.println("Data : "+data);
		MongoCandidateDaoImpl cd = new MongoCandidateDaoImpl();
		boolean isError = cd.updateCandidateMongoDB(candDetail, collection);
		return "{\"isError\":\"" + !isError + "\"}";
	}

	@Path("/{collection}/maddnewcandidate")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addToMongoDBTest(MongoCandidateDetails MCD, @PathParam(value = "collection") String collection) {
		boolean result = MongoCandidateDaoImpl.getMongoCandidateDaoImpl().addCandidateToDB(MCD, collection);
		return "{\"isError\":\"" + result + "\"}";
	}

	@Path("/{collection}/mgetcandidate/{emailId}")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public MongoCandidateDetails getCandidateDetails(@PathParam(value = "emailId") String emailId,
			@PathParam(value = "collection") String collection) {
		return MongoCandidateDaoImpl.getMongoCandidateDaoImpl().getCandidateDetails(emailId, collection);
	}

	@Path("/{collection}/mcandidatelist")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<MongoCandidateDetails> getCandidateListMongo(@PathParam(value = "collection") String collection) {
		return MongoCandidateDaoImpl.getMongoCandidateDaoImpl().getCandidateList(collection);
	}

	@Path("/{collection}/mupdateinterviewdetails")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String updateInterviewDetailsMongo(MongoCandidateDetails MCD,
			@PathParam(value = "collection") String collection) {
		boolean isError = MongoCandidateDaoImpl.getMongoCandidateDaoImpl().updateCandidateMongoDB(MCD, collection);
		return "{\"isError\":\"" + !isError + "\"}";
	}

	@Path("/{collection}/downloadexcel")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MongoCandidateDetails> downloadCandidateList(@PathParam(value = "collection") String collection) {
		return MongoCandidateDaoImpl.getMongoCandidateDaoImpl().getCandiadatesForInterview(collection);
	}

	@Path("/{collection}/minterviewlist")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MongoCandidateDetails> getMongoInterviewList(@PathParam(value = "collection") String collection) {
		return MongoCandidateDaoImpl.getMongoCandidateDaoImpl().getCandiadatesForInterview(collection);
	}
}
