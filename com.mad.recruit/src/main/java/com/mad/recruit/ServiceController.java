package com.mad.recruit;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.net.URLConnection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.mad.recruit.bean.MongoCandidateDetails;
import com.mad.recruit.service.HttpServices;

@Controller
@RequestMapping("/rest")
public class ServiceController {

	@RequestMapping(value = "/ping", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String pingRequest() {
		return "{\"success\":\"true\"}";
	}

	@RequestMapping(value = "/getcandidatelist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getCandidateList() {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendGet("candidateslist");
	}

	@RequestMapping(value = "/addtoken", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addTokenNumber(@RequestBody String tokenNo) {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendPut("addtoken", tokenNo);
		// mupdateinterviewdetails
	}

	@RequestMapping(value = "/getinterviewlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getInterviewCandidateList() {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendGet("interviewlist");
		// mcandidatelist
	}

	@RequestMapping(value = "/updateinterviewdetails", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateInterviewDetails(@RequestBody String interviewDetails) {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendPut("updateinterviewdetails", interviewDetails);
		// mupdateinterviewdetails
	}

	@RequestMapping(value = "/getselectedlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getSelectedCandidateList() {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendGet("selectedlist");
	}

	@RequestMapping(value = "/addnewcandidate", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addNewCandidate(@RequestBody String newCandidate) {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendPut("addnewcandidate", newCandidate);
		// maddnewcandidate
	}

	@RequestMapping(value = "/downloadList", method = RequestMethod.GET)
	public ModelAndView downloadExcel() {
		// String mimeType = "application/octet-stream";
		/*String mimeType = "application/vnd.ms-excel";
		response.reset();
//		String mimeType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		response.setHeader("Content-Disposition","attachment; filename=sampleName.xls");
		response.setContentType(mimeType);*/
		ModelAndView MaV = null;
		HttpServices httpGet = new HttpServices();
		String data = httpGet.sendGet("downloadexcel");
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<MongoCandidateDetails> listOfInterviewedCandidates = mapper.readValue(data,
					TypeFactory.defaultInstance().constructCollectionType(List.class, MongoCandidateDetails.class));

			System.out.println(listOfInterviewedCandidates);
			
			MaV= new ModelAndView("excelView", "candidateList", listOfInterviewedCandidates);
			/*response.setContentLength((int) data.length());
			// Create Blank workbook
			XSSFWorkbook workbook = new XSSFWorkbook();
			// Create a blank spreadsheet
			XSSFSheet spreadsheet = workbook.createSheet("InterviewedList");
			int rownum = 0;
			for (MongoCandidateDetails candidate : listOfInterviewedCandidates) {
				Row row = spreadsheet.createRow(rownum++);
				createList(candidate, row);

			}
			// InputStream inputStream = new BufferedInputStream(new
			// ByteArrayInputStream(data.getBytes()));
			FileOutputStream out = new FileOutputStream(new File("D:\\NewFile.xlsx"));
//			 workbook.write(response.getOutputStream());
			workbook.write(out);
			out.close();
//			FileCopyUtils.copy(new FileInputStream("D:\\NewFile.xlsx"), response.getOutputStream());
			IOUtils.copyLarge(new FileInputStream("D:\\NewFile.xlsx"), response.getOutputStream());
		 	System.out.println("File deleted : " + new File("D:\\NewFile.xlsx").delete());*/

			/*
			 * try { FileCopyUtils.copy(inputStream,
			 * response.getOutputStream()); } catch (IOException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return MaV;

	}

	public void createList(MongoCandidateDetails candidate, Row row) {
		int cellCount = 0;
		Field[] fields = candidate.getClass().getDeclaredFields();
		for (Field f : fields) {
			cellCount++;
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
		}

	}

}
