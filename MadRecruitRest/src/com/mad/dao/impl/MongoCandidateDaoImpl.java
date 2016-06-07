package com.mad.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.DBUpdate;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import com.mad.bean.MongoCandidateDetails;
import com.mad.dao.MongoCandidateDao;
import com.mad.jdbc.conn.MongoDBConnection;
import com.mongodb.DBCollection;

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
	public MongoCandidateDetails addTODBtest(MongoCandidateDetails MCD) {
		// TODO Auto-generated method stub
		DBCollection collection = MongoDBConnection.getCollection("madrecruit", "candidates");
		JacksonDBCollection<MongoCandidateDetails, String> coll = JacksonDBCollection.wrap(collection,
				MongoCandidateDetails.class, String.class);
		WriteResult<MongoCandidateDetails, String> result = coll.insert(MCD);
		// System.out.println(result);
		return null;
	}

	@Override
	public boolean addCandidateToDB(MongoCandidateDetails MCD) {
		// TODO Auto-generated method stub
		JacksonDBCollection<MongoCandidateDetails, String> coll = JacksonDBCollection
				.wrap(MongoDBConnection.getCollection(), MongoCandidateDetails.class, String.class);
		WriteResult<MongoCandidateDetails, String> result = coll.insert(MCD);
		if (result.getSavedId() != null) {
			return false;
		}
		// System.out.println(result);
		// System.out.println(result.getWriteResult());
		return true;
	}

	@Override
	public boolean updateCandidateMongoDB(MongoCandidateDetails MCD) {
		// TODO Auto-generated method stub
		JacksonDBCollection<MongoCandidateDetails, String> coll = JacksonDBCollection
				.wrap(MongoDBConnection.getCollection(), MongoCandidateDetails.class, String.class);
		// DBUpdate.Builder builder = new DBUpdate.Builder();
		// WriteResult<MongoCandidateDetails, String> result =
		// coll.findAndModify(DBQuery.is("email", MCD.getEmail()), MCD));
		WriteResult<MongoCandidateDetails, String> result = coll.update(DBQuery.is("email", MCD.getEmail()), MCD);
		return result.isUpdateOfExisting();
	}

	@Override
	public List<MongoCandidateDetails> getCandidateList() {
		// TODO Auto-generated method stub
		JacksonDBCollection<MongoCandidateDetails, String> coll = JacksonDBCollection
				.wrap(MongoDBConnection.getCollection(), MongoCandidateDetails.class, String.class);
		DBCursor<MongoCandidateDetails> cursor = coll.find();
		List<MongoCandidateDetails> candList = new ArrayList<MongoCandidateDetails>();
		while (cursor.hasNext()) {
			MongoCandidateDetails candidateData = cursor.next();
			candList.add(candidateData);
		}
		return candList;
	}

	@Override
	public MongoCandidateDetails getCandidateDetails(String emailId) {
		// TODO Auto-generated method stub
		JacksonDBCollection<MongoCandidateDetails, String> coll = JacksonDBCollection
				.wrap(MongoDBConnection.getCollection(), MongoCandidateDetails.class, String.class);
		MongoCandidateDetails candidate = coll.findOne((DBQuery.is("email", emailId)));
		return candidate;
	}

}
