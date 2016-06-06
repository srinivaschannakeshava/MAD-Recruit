package com.mad.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mad.bean.CandidateInterviewDetails;
import com.mad.dao.CandidateInterviewInfo;
import com.mad.jdbc.conn.DBconnection;

public class CandidateInterviewInfoDao implements CandidateInterviewInfo {

	@Override
	public boolean updateCandidateInterviewDetails(CandidateInterviewDetails cid) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		try {
			String SQL = "UPDATE candidateinfo SET panelistnames=?,availpref=?,"
					+ "gradepref=?,subjectpref=?,subjTaught=?,contentKnow=? ,consbreakdown=?,presentation=?,"
					+ "teachcomments=?,causeabvslf=?,emotmature=?,sensoffamily=?,leadership=?,finalcomments=?,result=?,groupactivity=?,"
					+ "candidatename=?,mobno=?,city=?,profile=?,profession=?,organization=?,vernacular=?"
					+ " WHERE email=?";
			pstmt = DBconnection.getDBConnection().prepareStatement(SQL);
			if (cid.getPanelistName() == null) {
				pstmt.setNull(1, java.sql.Types.VARCHAR);
			} else {
				pstmt.setString(1, cid.getPanelistName());
			}
			if (cid.getAvailabilityPref() == null) {
				pstmt.setNull(2, java.sql.Types.VARCHAR);
			} else {
				pstmt.setString(2, cid.getAvailabilityPref());
			}
			if (cid.getGradePref() == null) {
				pstmt.setNull(3, java.sql.Types.VARCHAR);
			} else {
				pstmt.setString(3, cid.getGradePref());
			}
			if (cid.getSubjectPref() == null) {
				pstmt.setNull(4, java.sql.Types.VARCHAR);
			} else {
				pstmt.setString(4, cid.getSubjectPref());
			}
			if (cid.getSubjectTaught() == null) {
				pstmt.setNull(5, java.sql.Types.VARCHAR);
			} else {
				pstmt.setString(5, cid.getSubjectTaught());
			}
			if (cid.getContentKnowledge() == 0) {
				pstmt.setNull(6, java.sql.Types.INTEGER);
			} else {
				pstmt.setInt(6, cid.getContentKnowledge());
			}
			if (cid.getBreakDownConcept() == 0) {
				pstmt.setNull(7, java.sql.Types.INTEGER);
			} else {
				pstmt.setInt(7, cid.getBreakDownConcept());
			}
			if (cid.getPresentation() == 0) {
				pstmt.setNull(8, java.sql.Types.INTEGER);
			} else {
				pstmt.setInt(8, cid.getPresentation());
			}
			if (cid.getTeachComments() == null) {
				pstmt.setNull(9, java.sql.Types.VARCHAR);
			} else {
				pstmt.setString(9, cid.getTeachComments());
			}
			if (cid.getCauseAboveSelf() == 0) {
				pstmt.setNull(10, java.sql.Types.INTEGER);
			} else {
				pstmt.setInt(10, cid.getCauseAboveSelf());
			}
			if (cid.getEmotionalMaturity() == 0) {
				pstmt.setNull(11, java.sql.Types.INTEGER);
			} else {
				pstmt.setInt(11, cid.getEmotionalMaturity());
			}
			if (cid.getSenseOfFamily() == 0) {
				pstmt.setNull(12, java.sql.Types.INTEGER);
			} else {
				pstmt.setInt(12, cid.getSenseOfFamily());
			}
			if (cid.getLeaderShip() == 0) {
				pstmt.setNull(13, java.sql.Types.INTEGER);
			} else {
				pstmt.setInt(13, cid.getLeaderShip());
			}

			if (cid.getFinalComments() == null) {
				pstmt.setNull(14, java.sql.Types.VARCHAR);
			} else {
				pstmt.setString(14, cid.getFinalComments());
			}
			if (cid.getResult() == null) {
				pstmt.setNull(15, java.sql.Types.VARCHAR);
			} else {
				pstmt.setString(15, cid.getResult());
			}
			if (cid.getGroupActivity() == null) {
				pstmt.setNull(16, java.sql.Types.VARCHAR);
			} else {
				pstmt.setString(16, cid.getGroupActivity());
			}

			if (cid.getName() == null) {
				pstmt.setNull(17, java.sql.Types.VARCHAR);
			} else {
				pstmt.setString(17, cid.getName());
			}
			if (cid.getMobNumber() == 0) {
				pstmt.setNull(18, java.sql.Types.INTEGER);
			} else {
				pstmt.setLong(18, cid.getMobNumber());
			}
			if (cid.getCity() == null) {
				pstmt.setNull(19, java.sql.Types.VARCHAR);
			} else {
				pstmt.setString(19, cid.getCity());
			}
			if (cid.getProfile() == null) {
				pstmt.setNull(20, java.sql.Types.VARCHAR);
			} else {
				pstmt.setString(20, cid.getProfile());
			}
			if (cid.getProfession() == null) {
				pstmt.setNull(21, java.sql.Types.VARCHAR);
			} else {
				pstmt.setString(21, cid.getProfession());
			}
			if (cid.getOrganization() == null) {
				pstmt.setNull(22, java.sql.Types.VARCHAR);
			} else {
				pstmt.setString(22, cid.getOrganization());
			}
			if (cid.getVernacular() == null) {
				pstmt.setNull(23, java.sql.Types.VARCHAR);
			} else {
				pstmt.setString(23, cid.getVernacular());
			}

			pstmt.setString(24, cid.getEmail());

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
	public List<CandidateInterviewDetails> getAllSelectedList() {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		List<CandidateInterviewDetails> result = new ArrayList<CandidateInterviewDetails>();
		try {
			String SQL = "SELECT * FROM candidateinfo where result='Yes' || result='May Be'";
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

}
