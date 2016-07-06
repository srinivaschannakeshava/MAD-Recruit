package com.mad.recruit.service;

import java.util.List;

import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import com.mad.recruit.DB.MongoDBConnection;
import com.mad.recruit.bean.MongoCandidateDetails;
import com.mongodb.DBCollection;

public class MongoCandidateDaoImpl  {
	private static MongoCandidateDaoImpl MCDI;

	public static MongoCandidateDaoImpl getMongoCandidateDaoImpl() {
		if (MCDI != null) {
			return MCDI;
		} else {
			MCDI = new MongoCandidateDaoImpl();
			return MCDI;
		}
	}

	public MongoCandidateDetails addTODBtest(MongoCandidateDetails MCD) {
		// TODO Auto-generated method stub
		DBCollection collection = MongoDBConnection.getCollection("madrecruit", "kolkattacandidates");
		JacksonDBCollection<MongoCandidateDetails, String> coll = JacksonDBCollection.wrap(collection,
				MongoCandidateDetails.class, String.class);
		WriteResult<MongoCandidateDetails, String> result = coll.insert(MCD);
		System.out.println(result);
		return null;
	}

	public List<MongoCandidateDetails> getCandidateMongo(){
		
		return null;
	}
	
}
