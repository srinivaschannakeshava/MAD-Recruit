package com.mad.recruit.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpServices {
	// HTTP GET request
	String url = "http://localhost:8080/MadRecruitRest/";

	public String sendGet(String urlParameter) {
		try {
			URL obj = new URL(url + urlParameter);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			// int responseCode = con.getResponseCode();
			/*
			 * System.out.println("\nSending 'GET' request to URL : " + url);
			 * System.out.println("Response Code : " + responseCode);
			 */

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			// System.out.println(response.toString());
			return response.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// HTTP POST request
	public String sendPut(String urlParameter, String data) {

		try {
			URL obj = new URL(url + urlParameter);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// add reuqest header
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json");

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(data);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'PUT' request to URL : " + url);
			System.out.println("PUT parameters : " + urlParameter);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			return response.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
