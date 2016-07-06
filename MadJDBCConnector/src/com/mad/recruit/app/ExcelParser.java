package com.mad.recruit.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mad.recruit.bean.CandidateDetails;
import com.mad.recruit.bean.MongoCandidateDetails;
 
/**
 * A dirty simple program that reads an Excel file.
 * @author www.codejava.net
 *
 */
public class ExcelParser {
     
    public static void main(String[] args) throws IOException {
       System.out.println(parseExcel()); 
        
    }

	public static List<MongoCandidateDetails> parseExcel() throws FileNotFoundException, IOException {
		String excelFilePath = "D:\\Projects\\Web Projects\\MAD project\\workspace\\MadJDBCConnector\\resources\\Upload Sheet.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
         Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
        List<MongoCandidateDetails> listOfObjects= new ArrayList<MongoCandidateDetails>();
        int count =0;
        iterator.next();
        iterator.next();
        while (iterator.hasNext()) {
            Row row = iterator.next();
            // For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();
            MongoCandidateDetails customFormObject = new MongoCandidateDetails();
            while (cellIterator.hasNext()) {
              Cell cell = cellIterator.next();
              switch (cell.getColumnIndex()) {
              case 1:
                  customFormObject.setName(cell.getStringCellValue());
                  count++;
                  System.out.println(count);
                  break;  
              
              case 2:
                  if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    customFormObject.setMobNumber((long)cell.getNumericCellValue());
                  }
                  else {
                    customFormObject.setEmail(cell.getStringCellValue());
                  }
                  break;

                case 3:
                  if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    customFormObject.setMobNumber((long)cell.getNumericCellValue());
                  }
                  else {
                    customFormObject.setEmail(cell.getStringCellValue());
                  }
                  break;
                  
                case 9:
                	customFormObject.setOrganization(cell.getStringCellValue());
                	break;
                case 8:
                	customFormObject.setProfession(cell.getStringCellValue());
                	break;
                case 10:
                	customFormObject.setVernacular(cell.getStringCellValue());
                	System.out.println(cell.getStringCellValue());
                	break;
                	
                case 7:
                	customFormObject.setProfile(cell.getStringCellValue());
              }
            }
            customFormObject.setCity("Bengaluru");
            listOfObjects.add(customFormObject);
            
        }
        workbook.close();
        inputStream.close();
		return listOfObjects;
	}
    
 
}