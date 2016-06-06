package com.mad.dao.impl;

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
		System.out.println(result);
		return null;
	}

}
