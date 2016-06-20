package com.mad.dao;

import java.util.List;

import com.mad.bean.MongoCandidateDetails;

public interface MongoCandidateDao {

	public MongoCandidateDetails addTODBtest(MongoCandidateDetails MCD);

	public boolean addCandidateToDB(MongoCandidateDetails MCD);

	public boolean updateCandidateMongoDB(MongoCandidateDetails MCD);

	public List<MongoCandidateDetails> getCandidateList();

	public MongoCandidateDetails getCandidateDetails(String emailId);
	
	public  List<MongoCandidateDetails> getInterviewedCandidateList();

}
