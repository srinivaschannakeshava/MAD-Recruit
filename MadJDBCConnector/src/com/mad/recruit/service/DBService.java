package com.mad.recruit.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mad.recruit.DB.DBconnection;
import com.mad.recruit.bean.CandidateDetails;

public class DBService {

	public static void addCandidateToDataBase(CandidateDetails cd) {
		PreparedStatement pstmt = null;
		try {
			String SQL = "insert into candidateinfo (candidatename,mobno,city,email,profile,profession,organization,vernacular) values(?,?,?,?,?,?,?,?)";
			pstmt = DBconnection.getDBConnection().prepareStatement(SQL);
			pstmt.setString(1, cd.getName());
			pstmt.setLong(2, cd.getMobNumber());
			pstmt.setString(3, cd.getCity());
			pstmt.setString(4, cd.getEmail());
			pstmt.setString(5, cd.getProfile());
			pstmt.setString(6, cd.getProfession());
			pstmt.setString(7, cd.getOrganization());
			pstmt.setString(8, cd.getVernacular());
			int value = pstmt.executeUpdate();
			System.out.println("Value : " + value);//value is 1 success else failure
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBconnection.closeConnection();
		}
	}

	public static List<String> getCandidateList() {
		PreparedStatement pstmt = null;
		List<String> result=new ArrayList<String>();
		try {
			String SQL = "SELECT * FROM candidateinfo;";
			pstmt = DBconnection.getDBConnection().prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CandidateDetails cd = new CandidateDetails(rs.getString("candidatename"), rs.getLong("mobno"),
						rs.getString("city"), rs.getString("email"), rs.getString("profile"),
						rs.getString("profession"), rs.getString("organization"), rs.getString("vernacular"));
				
				result.add(cd.toString());
				System.out.println("[Debug] "+cd.toString());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			DBconnection.closeConnection();
		}
		return result;
	}

}
