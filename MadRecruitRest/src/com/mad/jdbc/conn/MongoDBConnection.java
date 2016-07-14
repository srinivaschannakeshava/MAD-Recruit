package com.mad.jdbc.conn;

import java.net.InetSocketAddress;
import java.util.Arrays;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.Mongo;

public class MongoDBConnection {

	public static String dbAddress = "52.77.248.90"; // "localhost";
	public static int dbPort = 27017;
	public static MongoClient mongoClient = null;
	public static String dbName = "madrecruit";
//	public static String collectionName = "kolkattacandidates";

	public static void getConnection() {
		try {

			// To connect to mongodb server
			ServerAddress mongoServer = new ServerAddress(new InetSocketAddress(dbAddress, dbPort));
			mongoClient = new MongoClient(mongoServer);
			// return mongoClient;
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		// return null;
	}

	public static DBCollection getCollection(String dbName, String collectionName) {
		if (mongoClient != null) {
			DB db = mongoClient.getDB(dbName);
			DBCollection coll = db.getCollection(collectionName);
			return coll;
		} else {
			getConnection();
			return getCollection(dbName, collectionName);
		}

	}

	public static DBCollection getCollection(String collection) {
		if (mongoClient != null) {
			DB db = mongoClient.getDB(dbName);
			DBCollection coll = db.getCollection(collection);
			return coll;
		} else {
			getConnection();
			return getCollection(dbName, collection);
		}
	}

}
