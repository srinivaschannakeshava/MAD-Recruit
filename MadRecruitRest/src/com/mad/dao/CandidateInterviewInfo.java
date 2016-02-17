package com.mad.dao;

import java.util.ArrayList;

import com.mad.bean.CandidateInterviewDetails;

public interface CandidateInterviewInfo {
	
	public ArrayList<CandidateInterviewDetails> getAllCandidateInterviewDetails();
	
	public boolean updateCandidateInterviewDetails(CandidateInterviewDetails cid);
	
}
