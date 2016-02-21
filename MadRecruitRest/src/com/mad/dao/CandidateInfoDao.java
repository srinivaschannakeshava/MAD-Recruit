package com.mad.dao;

import java.util.List;

import com.mad.bean.CandidateDetails;
import com.mad.bean.CandidateInterviewDetails;

public interface CandidateInfoDao {
	
	public List<CandidateDetails> getAllCandidates();

	public boolean updateCandidateDetails(String emailId,String data);

	public boolean addTokenToCandidate(String emailId,int token);
	
	public List<CandidateInterviewDetails> getInterviewCandidates();
	
	public CandidateDetails getCandidateDetail(String emaiId);

}
