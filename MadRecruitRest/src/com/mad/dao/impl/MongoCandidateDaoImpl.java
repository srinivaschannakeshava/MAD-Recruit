package com.mad.dao.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.DBUpdate;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import com.mad.bean.AdminBean;
import com.mad.bean.MongoCandidateDetails;
import com.mad.dao.MongoCandidateDao;
import com.mad.jdbc.conn.DBconnection;
import com.mad.jdbc.conn.MongoDBConnection;
import com.mongodb.DBCollection;
import com.mongodb.DuplicateKeyException;

public class MongoCandidateDaoImpl implements MongoCandidateDao {
	private static MongoCandidateDaoImpl MCDI;

	public static MongoCandidateDaoImpl getMongoCandidateDaoImpl() {
		if (MCDI != null) {
			return MCDI;
		} else {
			MCDI = new MongoCandidateDaoImpl();
			return MCDI;
		}
	}

	@Override
	public MongoCandidateDetails addTODBtest(MongoCandidateDetails MCD, String collection) {
		// TODO Auto-generated method stub
		DBCollection dbcol = MongoDBConnection.getCollection("madrecruit", "candidates");
		JacksonDBCollection<MongoCandidateDetails, String> coll = JacksonDBCollection.wrap(dbcol,
				MongoCandidateDetails.class, String.class);
		WriteResult<MongoCandidateDetails, String> result = coll.insert(MCD);
		// System.out.println(result);
		return null;
	}

	@Override
	public boolean addCandidateToDB(MongoCandidateDetails MCD, String collection) {
		// TODO Auto-generated method stub
		JacksonDBCollection<MongoCandidateDetails, String> coll = JacksonDBCollection
				.wrap(MongoDBConnection.getCollection(collection), MongoCandidateDetails.class, String.class);
		try {
			WriteResult<MongoCandidateDetails, String> result = coll.insert(MCD);
			if (result.getSavedId() != null) {
				return false;
			}
		} catch (DuplicateKeyException e) {
			return true;
		}
		// System.out.println(result);
		// System.out.println(result.getWriteResult());
		return true;
	}

	@Override
	public boolean updateCandidateMongoDB(MongoCandidateDetails MCD, String collection) {
		// TODO Auto-generated method stub
		JacksonDBCollection<MongoCandidateDetails, String> coll = JacksonDBCollection
				.wrap(MongoDBConnection.getCollection(collection), MongoCandidateDetails.class, String.class);
		// DBUpdate.Builder builder = new DBUpdate.Builder();
		// WriteResult<MongoCandidateDetails, String> result =
		// coll.findAndModify(DBQuery.is("email", MCD.getEmail()), MCD));
		try {
			WriteResult<MongoCandidateDetails, String> result = coll.update(DBQuery.is("email", MCD.getEmail()), MCD);
			return result.isUpdateOfExisting();

		} catch (DuplicateKeyException e) {
			return false;
		}

	}

	@Override
	public List<MongoCandidateDetails> getCandidateList(String collection) {
		// TODO Auto-generated method stub
		JacksonDBCollection<MongoCandidateDetails, String> coll = JacksonDBCollection
				.wrap(MongoDBConnection.getCollection(collection), MongoCandidateDetails.class, String.class);
		DBCursor<MongoCandidateDetails> cursor = coll.find();
		List<MongoCandidateDetails> candList = new ArrayList<MongoCandidateDetails>();
		while (cursor.hasNext()) {
			MongoCandidateDetails candidateData = cursor.next();
			candList.add(candidateData);
		}
		return candList;
	}

	@Override
	public MongoCandidateDetails getCandidateDetails(String emailId, String collection) {
		// TODO Auto-generated method stub
		JacksonDBCollection<MongoCandidateDetails, String> coll = JacksonDBCollection
				.wrap(MongoDBConnection.getCollection(collection), MongoCandidateDetails.class, String.class);
		MongoCandidateDetails candidate = coll.findOne((DBQuery.is("email", emailId)));
		return candidate;
	}

	public List<MongoCandidateDetails> getCandiadatesForInterview(String collection) {
		List<MongoCandidateDetails> list = new ArrayList<MongoCandidateDetails>();
		JacksonDBCollection<MongoCandidateDetails, String> coll = JacksonDBCollection
				.wrap(MongoDBConnection.getCollection(collection), MongoCandidateDetails.class, String.class);
		DBCursor<MongoCandidateDetails> cursor = coll.find(DBQuery.greaterThan("tokenNo", 0));
		while (cursor.hasNext()) {
			MongoCandidateDetails candidateData = cursor.next();
			list.add(candidateData);
		}
		return list;

	}

	@Override
	public List<MongoCandidateDetails> getInterviewedCandidateList(String collection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminBean getLogin(AdminBean login) {
		// TODO Auto-generated method stub
		JacksonDBCollection<AdminBean, String> coll = JacksonDBCollection
				.wrap(MongoDBConnection.getCollection("adminusers"), AdminBean.class, String.class);
		AdminBean loginUser = coll.findOne(
				DBQuery.and(DBQuery.is("username", login.getUsername()), DBQuery.is("password", login.getPassword())));
		return loginUser;
	}

}
