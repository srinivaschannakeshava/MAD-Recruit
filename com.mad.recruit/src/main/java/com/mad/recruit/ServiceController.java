package com.mad.recruit;

import java.lang.reflect.Field;
import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.mad.recruit.bean.AdminBean;
import com.mad.recruit.bean.MongoCandidateDetails;
import com.mad.recruit.service.HttpServices;

@Controller
@RequestMapping("/rest")
public class ServiceController {

	@RequestMapping(value = "/ping", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String pingRequest() {
		return "{\"success\":\"true\"}";
	}

	@RequestMapping(value = "/adminuser", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getAdminUser(@RequestBody String login) {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendPut("mgetlogin", login);
	}

	@RequestMapping(value = "/{collection}/getcandidatelist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getCandidateList(@PathVariable(value = "collection") String collection) {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendGet(collection + "/mcandidatelist");
	}

	@RequestMapping(value = "/{collection}/addtoken", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addTokenNumber(@RequestBody String tokenNo,
			@PathVariable(value = "collection") String collection) {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendPut(collection + "/maddtoken", tokenNo);
	}

	@RequestMapping(value = "/{collection}/getinterviewlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getInterviewCandidateList(@PathVariable(value = "collection") String collection) {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendGet(collection + "/minterviewlist");
	}

	@RequestMapping(value = "/{collection}/updateinterviewdetails", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String updateInterviewDetails(@RequestBody String interviewDetails,
			@PathVariable(value = "collection") String collection) {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendPut(collection + "/mupdateinterviewdetails", interviewDetails);
	}

	@RequestMapping(value = "/{collection}/getselectedlist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String getSelectedCandidateList(@PathVariable(value = "collection") String collection) {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendGet(collection + "/selectedlist");
	}

	@RequestMapping(value = "/{collection}/addnewcandidate", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String addNewCandidate(@RequestBody String newCandidate,
			@PathVariable(value = "collection") String collection) {
		HttpServices httpGet = new HttpServices();
		return httpGet.sendPut(collection + "/maddnewcandidate", newCandidate);
	}

	@RequestMapping(value = "/{collection}/downloadList", method = RequestMethod.GET)
	public ModelAndView downloadExcel(@PathVariable(value = "collection") String collection) {
		// String mimeType = "application/octet-stream";
		/*
		 * String mimeType = "application/vnd.ms-excel"; response.reset(); //
		 * String mimeType =
		 * "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		 * response.setHeader("Content-Disposition",
		 * "attachment; filename=sampleName.xls");
		 * response.setContentType(mimeType);
		 */
		ModelAndView MaV = null;
		HttpServices httpGet = new HttpServices();
		String data = httpGet.sendGet(collection + "/downloadexcel");
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<MongoCandidateDetails> listOfInterviewedCandidates = mapper.readValue(data,
					TypeFactory.defaultInstance().constructCollectionType(List.class, MongoCandidateDetails.class));

			System.out.println(listOfInterviewedCandidates);

			MaV = new ModelAndView("excelView", "candidateList", listOfInterviewedCandidates);
			/*
			 * response.setContentLength((int) data.length()); // Create Blank
			 * workbook XSSFWorkbook workbook = new XSSFWorkbook(); // Create a
			 * blank spreadsheet XSSFSheet spreadsheet =
			 * workbook.createSheet("InterviewedList"); int rownum = 0; for
			 * (MongoCandidateDetails candidate : listOfInterviewedCandidates) {
			 * Row row = spreadsheet.createRow(rownum++); createList(candidate,
			 * row);
			 * 
			 * } // InputStream inputStream = new BufferedInputStream(new //
			 * ByteArrayInputStream(data.getBytes())); FileOutputStream out =
			 * new FileOutputStream(new File("D:\\NewFile.xlsx")); //
			 * workbook.write(response.getOutputStream()); workbook.write(out);
			 * out.close(); // FileCopyUtils.copy(new
			 * FileInputStream("D:\\NewFile.xlsx"), response.getOutputStream());
			 * IOUtils.copyLarge(new FileInputStream("D:\\NewFile.xlsx"),
			 * response.getOutputStream()); System.out.println("File deleted : "
			 * + new File("D:\\NewFile.xlsx").delete());
			 */

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
