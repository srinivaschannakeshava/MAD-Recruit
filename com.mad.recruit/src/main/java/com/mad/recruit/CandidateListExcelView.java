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

import com.mad.recruit.bean.MongoCandidateDetails;

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

		header.createCell(0).setCellValue("ID");
		header.getCell(0).setCellStyle(style);

		header.createCell(1).setCellValue("Name");
		header.getCell(1).setCellStyle(style);

		header.createCell(2).setCellValue("Mobile Number");
		header.getCell(2).setCellStyle(style);

		header.createCell(3).setCellValue("City");
		header.getCell(3).setCellStyle(style);

		header.createCell(4).setCellValue("Email");
		header.getCell(4).setCellStyle(style);
		
		header.createCell(5).setCellValue("Profile");
		header.getCell(5).setCellStyle(style);

		header.createCell(6).setCellValue("Profession");
		header.getCell(6).setCellStyle(style);

		header.createCell(7).setCellValue("Organization");
		header.getCell(7).setCellStyle(style);

		header.createCell(8).setCellValue("Vernacular");
		header.getCell(8).setCellStyle(style);

		header.createCell(9).setCellValue("Token No");
		header.getCell(9).setCellStyle(style);
		
		header.createCell(10).setCellValue("Panelist Name");
		header.getCell(10).setCellStyle(style);

		header.createCell(11).setCellValue("Availability Pref");
		header.getCell(11).setCellStyle(style);

		header.createCell(12).setCellValue("Grade Pref");
		header.getCell(12).setCellStyle(style);

		header.createCell(13).setCellValue("Subject Pref");
		header.getCell(13).setCellStyle(style);

		header.createCell(14).setCellValue("Subject Taught");
		header.getCell(14).setCellStyle(style);
		
		header.createCell(15).setCellValue("Content Knowledge");
		header.getCell(15).setCellStyle(style);

		header.createCell(16).setCellValue("BreakDown Concept");
		header.getCell(16).setCellStyle(style);

		header.createCell(17).setCellValue("Presentation");
		header.getCell(17).setCellStyle(style);

		header.createCell(18).setCellValue("Teach Comments");
		header.getCell(18).setCellStyle(style);

		header.createCell(19).setCellValue("Cause Above Self");
		header.getCell(19).setCellStyle(style);
		
		header.createCell(20).setCellValue("Emotional Maturity");
		header.getCell(20).setCellStyle(style);
		
		header.createCell(21).setCellValue("Sense Of Family");
		header.getCell(21).setCellStyle(style);

		header.createCell(22).setCellValue("LeaderShip");
		header.getCell(22).setCellStyle(style);

		header.createCell(23).setCellValue("Final Comments");
		header.getCell(23).setCellStyle(style);

		header.createCell(24).setCellValue("Group Activity");
		header.getCell(24).setCellStyle(style);
		
		header.createCell(25).setCellValue("Result");
		header.getCell(25).setCellStyle(style);
;

		
	}

}
