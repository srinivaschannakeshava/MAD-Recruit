package com.mad.dao;

import java.util.List;

import com.mad.bean.AdminBean;
import com.mad.bean.MongoCandidateDetails;

public interface MongoCandidateDao {
	public AdminBean getLogin(AdminBean login);

	public MongoCandidateDetails addTODBtest(MongoCandidateDetails MCD, String collection);

	public boolean addCandidateToDB(MongoCandidateDetails MCD, String collection);

	public boolean updateCandidateMongoDB(MongoCandidateDetails MCD, String collection);

	public List<MongoCandidateDetails> getCandidateList(String collection);

	public MongoCandidateDetails getCandidateDetails(String emailId, String collection);

	public List<MongoCandidateDetails> getInterviewedCandidateList(String collection);

}
