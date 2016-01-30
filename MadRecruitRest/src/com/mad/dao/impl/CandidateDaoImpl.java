package com.mad.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mad.bean.CandidateDetails;
import com.mad.dao.CandidateInfoDao;
import com.mad.jdbc.conn.DBconnection;

public class CandidateDaoImpl implements CandidateInfoDao{

	@Override
	public List<CandidateDetails> getAllCandidates() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		List<CandidateDetails> result=new ArrayList<CandidateDetails>();
		try {
			String SQL = "SELECT * FROM candidateinfo;";
			pstmt = DBconnection.getDBConnection().prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CandidateDetails cd = new CandidateDetails(rs.getString("candidatename"), rs.getLong("mobno"),
						rs.getString("city"), rs.getString("email"), rs.getString("profile"),
						rs.getString("profession"), rs.getString("organization"), rs.getString("vernacular"));
				
				result.add(cd);
	//			System.out.println("[Debug] "+cd.toString());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}/*finally {
			DBconnection.closeConnection();
		}*/
		return result;
	}

	@Override
	public boolean updateCandidateDetails(String emailId, String data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTokenToCandidate(String emailId, int token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CandidateDetails getCandidateDetail(String emaiId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String rowMapper(List<CandidateDetails> cdl){
		
		
		return null;
		
	}

}
