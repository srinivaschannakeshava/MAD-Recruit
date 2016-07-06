package com.mad.recruit.app;

import java.io.IOException;

import com.mad.recruit.DB.DBconnection;
import com.mad.recruit.bean.CandidateDetails;
import com.mad.recruit.bean.MongoCandidateDetails;
import com.mad.recruit.service.DBService;
import com.mad.recruit.service.MongoCandidateDaoImpl;

public class Main {
	public static void main(String[] args) throws IOException{
//		CandidateDetails cd= new CandidateDetails("Srinivas",8971773538L,"bengaluru","Srinivas@gmail.com","ED support","engineer","Bosch","kannada,English");
//		DBService.addCandidateToServer(cd);
	//	DBService.getCandidateList();
		 for (MongoCandidateDetails candidateDetails : ExcelParser.parseExcel()) {
		      //	DBService.addCandidateToDataBase(candidateDetails);	
			 
			 try {
				MongoCandidateDaoImpl.getMongoCandidateDaoImpl().addTODBtest(candidateDetails);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("DUPLICATES");
				//e.printStackTrace();
			}
			}
			//	DBService.getCandidateList();
			//	DBconnection.closeConnection();
		
		}

}
