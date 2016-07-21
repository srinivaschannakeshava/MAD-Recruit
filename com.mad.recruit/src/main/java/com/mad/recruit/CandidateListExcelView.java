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
		arg3.setHeader("Content-Disposition", "attachment; filename=interviewedlist.xls");
		List<MongoCandidateDetails> interviewCandidateList = (List<MongoCandidateDetails>) arg0.get("candidateList");
		// HSSFWorkbook workbook = new HSSFWorkbook();
		// Create a blank spreadsheet
		HSSFSheet spreadsheet = arg1.createSheet("InterviewedList");
		createExcelHeader(arg1, spreadsheet);
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
			f.setAccessible(true);
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

	public void createExcelHeader(HSSFWorkbook arg1, HSSFSheet sheet) {
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

		String[] headers = { "Name", "Mobile Number", "City", "Email", "Profile", "Profession", "Organization",
				"Vernacular", "Token No", "Pref1", "Pref 2", "PR Interest", "GAteamPlayer", "GAleadership",
				"GAemotionalMaturity", "GAcreativeThinking", "GAenergy", "GAComments", "Cause Above Self",
				"Emotional Maturity", "Sense of Family", "Leadership", "HC Comments", "Ed Panelsit Name",
				"Availability Pref", "Grade Pref", "Sub Pref", "Sub Taught", "Center Pref", "Content Knowledge",
				"Concept Breakdown", "Presentation", "Ed Comments", "Ed Result", "Propel Panelist", "Availability",
				"SubPref", "SubTaught", "propelCenterPref", "Content Knowledge", "Concept Breakdown", "Presentation",
				"Propel Comments", "Propel Result", "FrPanelistName", "frAvailabilityPref", "frPreference",
				"frProActiveness", "CFRObservableTraits", "CRObservableTraits", "Thought Process", "Remarkability",
				"Confidence", "Content", "Comments", "frResult" };

		int i = 0;
		for (String string : headers) {
			header.createCell(i).setCellValue(string);
			header.getCell(i).setCellStyle(style);
			i++;
		}
		;

	}

}
