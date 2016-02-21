package com.mad.dao;

import java.util.List;

import com.mad.bean.CandidateInterviewDetails;

public interface CandidateInterviewInfo {
	
	public boolean updateCandidateInterviewDetails(CandidateInterviewDetails cid);
	
	public List<CandidateInterviewDetails> getAllSelectedList();
	
}
