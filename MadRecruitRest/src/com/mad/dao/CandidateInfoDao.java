package com.mad.dao;

import java.util.List;

import com.mad.bean.CandidateDetails;

public interface CandidateInfoDao {
	
	public List<CandidateDetails> getAllCandidates();

	public boolean updateCandidateDetails(String emailId,String data);

	public boolean addTokenToCandidate(String emailId,int token);
	
	public List<CandidateDetails> getInterviewCandidates();
	
	public CandidateDetails getCandidateDetail(String emaiId);

}
