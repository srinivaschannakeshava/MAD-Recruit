package com.mad.recruit;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class CandidateListExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> arg0, HSSFWorkbook arg1, HttpServletRequest arg2,
			HttpServletResponse arg3) throws Exception {
		arg3.setHeader("Content-Disposition","attachment; filename=interviewedlist.xls");
		List<MongoCandidateDetails> interviewCandidateList = (List<MongoCandidateDetails>) arg0.get("candidateList");
		// HSSFWorkbook workbook = new HSSFWorkbook();
		// Create a blank spreadsheet
		HSSFSheet spreadsheet = arg1.createSheet("InterviewedList");
		createExcelHeader(arg1,spreadsheet);
		// TODO Auto-generated method stub
		int rownum = 1;
		for (MongoCandidateDetails candidate : interviewCandidateList) {
			Row row = spreadsheet.createRow(rownum++);
			createList(candidate, row);

		}

	}

	public void createList(MongoCandidateDetails candidate, Row row) {
		int cellCount = 0;
		Field[] fields = candidate.getClass().getDeclaredFields();
		for (Field f : fields) {
			
			Cell cell = row.createCell(cellCount);
			try {
				if (f.get(candidate) != null) {
					System.out.println(f.getGenericType());
					if (f.getGenericType().equals(String.class)) {
						cell.setCellValue((String) f.get(candidate));
					} else if (f.getGenericType().equals(long.class)) {
						cell.setCellValue((Long) f.get(candidate));
					} else if (f.getGenericType().equals(int.class)) {
						cell.setCellValue((int) f.get(candidate));
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cellCount++;
		}

	}

	public void createExcelHeader(HSSFWorkbook arg1,HSSFSheet sheet) {
		// create style for header cells
		CellStyle style = arg1.createCellStyle();
		Font font = arg1.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		
		HSSFRow header = sheet.createRow(0);
		
		String[] headers = {"Name","Mobile Number","City","Email","Profile"
				,"Profession","Organization","Vernacular","Token No", "Pref1","Pref 2", "PR Interest", 
				"GroupActivity" ,"Cause Above Self","Emotional Maturity","Sense of Family","Leadership","HC Comments",
				"Ed Panelsit Name", "Availability Pref","Grade Pref","Sub Pref","Sub Taught","Center Pref","Content Knowledge",
				"Concept Breakdown","Presentation","Ed Comments", "Ed Result" ,
				"Propel Panelist","Availability" ,"SubPref","SubTaught","propelCenterPref","Content Knowledge",
				"Concept Breakdown","Presentation","Propel Comments", "Propel Result",
				"FrPanelistName","Availability Pref","frPreference","frProActiveness","frResult"};

//		header.createCell(0).setCellValue("Name");
//		header.getCell(0).setCellStyle(style);
//
//		header.createCell(1).setCellValue("Mobile Number");
//		header.getCell(1).setCellStyle(style);
//
//		header.createCell(2).setCellValue("City");
//		header.getCell(2).setCellStyle(style);
//
//		header.createCell(3).setCellValue("Email");
//		header.getCell(3).setCellStyle(style);
//
//		header.createCell(4).setCellValue("Profile");
//		header.getCell(4).setCellStyle(style);
//		
//		header.createCell(5).setCellValue("Profession");
//		header.getCell(5).setCellStyle(style);
//
//		header.createCell(6).setCellValue("Organization");
//		header.getCell(6).setCellStyle(style);
//
//		header.createCell(7).setCellValue("Vernacular");
//		header.getCell(7).setCellStyle(style);
//
//		header.createCell(8).setCellValue("Token No");
//		header.getCell(8).setCellStyle(style);
//
//		header.createCell(9).setCellValue("Pref1");
//		header.getCell(9).setCellStyle(style);
//		
//		header.createCell(10).setCellValue("Pref 2");
//		header.getCell(10).setCellStyle(style);
//
//		header.createCell(11).setCellValue("Cause Above Self");
//		header.getCell(11).setCellStyle(style);
//
//		header.createCell(12).setCellValue("Emotional Maturity");
//		header.getCell(12).setCellStyle(style);
//
//		header.createCell(13).setCellValue("Sense of Family");
//		header.getCell(13).setCellStyle(style);
//
//		header.createCell(14).setCellValue("Leadership");
//		header.getCell(14).setCellStyle(style);
//		
//		header.createCell(15).setCellValue("Ed Panelsit Name");
//		header.getCell(15).setCellStyle(style);
//
//		header.createCell(16).setCellValue("Availability Pref");
//		header.getCell(16).setCellStyle(style);
//
//		header.createCell(17).setCellValue("Grade Pref");
//		header.getCell(17).setCellStyle(style);
//
//		header.createCell(18).setCellValue("Sub Pref");
//		header.getCell(18).setCellStyle(style);
//
//		header.createCell(19).setCellValue("Sub Taught");
//		header.getCell(19).setCellStyle(style);
//		
//		header.createCell(19).setCellValue("Center Pref");
//		header.getCell(19).setCellStyle(style);
//		
//		header.createCell(21).setCellValue("Content Knowledge");
//		header.getCell(21).setCellStyle(style);
//		
//		header.createCell(22).setCellValue("Concept Breakdown");
//		header.getCell(22).setCellStyle(style);
//
//		header.createCell(23).setCellValue("Presentation");
//		header.getCell(23).setCellStyle(style);
//
//		header.createCell(24).setCellValue("Ed Comments");
//		header.getCell(24).setCellStyle(style);
//
//		header.createCell(25).setCellValue("Ed Result");
//		header.getCell(25).setCellStyle(style);
//		
//		header.createCell(26).setCellValue("Propel Panelist");
//		header.getCell(26).setCellStyle(style);
		
		int i = 0;
		for (String string : headers) {
			header.createCell(i).setCellValue(string);
			header.getCell(i).setCellStyle(style);
			i++;
		}
;

		
	}

}
