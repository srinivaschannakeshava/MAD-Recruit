package com.mad.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mad.bean.CandidateDetails;
import com.mad.bean.CandidateInterviewDetails;
import com.mad.dao.CandidateInfoDao;
import com.mad.jdbc.conn.DBconnection;

public class CandidateDaoImpl implements CandidateInfoDao {

	@Override
	public List<CandidateDetails> getAllCandidates() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		List<CandidateDetails> result = new ArrayList<CandidateDetails>();
		try {
			String SQL = "SELECT * FROM candidateinfo;";
			pstmt = DBconnection.getDBConnection().prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CandidateDetails cd = new CandidateDetails(rs.getString("candidatename"), rs.getLong("mobno"),
						rs.getString("city"), rs.getString("email"), rs.getString("profile"),
						rs.getString("profession"), rs.getString("organization"), rs.getString("vernacular"));
				cd.setTokenNo(rs.getInt("tokenno"));
				result.add(cd);
				// System.out.println("[Debug] "+cd.toString());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} /*
			 * finally { DBconnection.closeConnection(); }
			 */
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
		PreparedStatement pstmt = null;
		try {
			String SQL = "UPDATE candidateinfo SET tokenno=? WHERE email=?";
			pstmt = DBconnection.getDBConnection().prepareStatement(SQL);
			if (token == 0) {
				pstmt.setNull(1, java.sql.Types.INTEGER);
			} else {
				pstmt.setInt(1, token);
			}
			pstmt.setString(2, emailId);

			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public CandidateDetails getCandidateDetail(String emaiId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String rowMapper(List<CandidateDetails> cdl) {

		return null;

	}

	@Override
	public List<CandidateInterviewDetails> getInterviewCandidates() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		List<CandidateInterviewDetails> result = new ArrayList<CandidateInterviewDetails>();
		try {
			String SQL = "SELECT * FROM candidateinfo where tokenno>0";
			pstmt = DBconnection.getDBConnection().prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
			
				CandidateInterviewDetails cd = new CandidateInterviewDetails();
				cd.setName(rs.getString("candidatename"));
				cd.setMobNumber(rs.getLong("mobno"));
				cd.setCity(rs.getString("city"));
				cd.setEmail(rs.getString("email"));
				cd.setProfile(rs.getString("profile"));
				cd.setProfession(rs.getString("profession"));
				cd.setOrganization(rs.getString("organization"));
				cd.setVernacular(rs.getString("vernacular"));
				cd.setTokenNo(rs.getInt("tokenno"));
				cd.setPanelistName(rs.getString("panelistnames"));
				cd.setAvailabilityPref(rs.getString("availpref"));
				cd.setGradePref(rs.getString("gradepref"));
				cd.setSubjectPref(rs.getString("subjectpref"));
				cd.setSubjectTaught(rs.getString("subjTaught"));
				cd.setContentKnowledge(rs.getInt("contentKnow"));
				cd.setBreakDownConcept(rs.getInt("consbreakdown"));
				cd.setPresentation(rs.getInt("presentation"));
				cd.setTeachComments(rs.getString("teachcomments"));
				cd.setCauseAboveSelf(rs.getInt("causeabvslf"));
				cd.setEmotionalMaturity(rs.getInt("emotmature"));
				cd.setSenseOfFamily(rs.getInt("sensoffamily"));
				cd.setLeaderShip(rs.getInt("leadership"));
				cd.setResult(rs.getString("result"));
				cd.setFinalComments(rs.getString("finalcomments"));
				cd.setGroupActivity(rs.getString("groupactivity"));

				result.add(cd);
				// System.out.println("[Debug] "+cd.toString());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} /*
			 * finally { DBconnection.closeConnection(); }
			 */
		return result;

	}

	@Override
	public boolean addNewCandidate(CandidateDetails ncd) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		try {
			String query="INSERT into candidateinfo(candidatename,mobno,city,email,profile,profession,organization,vernacular,tokenno) VALUES(?,?,?,?,?,?,?,?,?)";
			pstmt = DBconnection.getDBConnection().prepareStatement(query);
			pstmt.setString(1, ncd.getName());
			pstmt.setLong(2, ncd.getMobNumber());
			pstmt.setString(3, ncd.getCity());
			pstmt.setString(4, ncd.getEmail());
			pstmt.setString(5, ncd.getProfile());
			pstmt.setString(6, ncd.getProfession());
			pstmt.setString(7, ncd.getOrganization());
			pstmt.setString(8, ncd.getVernacular());
			pstmt.setInt(9, ncd.getTokenNo());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
