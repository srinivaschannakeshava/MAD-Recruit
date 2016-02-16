package com.mad.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CandidateDetails {
	public CandidateDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public CandidateDetails(String name, long mobNumber, String city, String email, String profile, String profession,
			String organization, String vernacular) {
		super();
		this.name = name;
		this.mobNumber = mobNumber;
		this.city = city;
		this.email = email;
		this.profile = profile;
		this.profession = profession;
		this.organization = organization;
		this.vernacular = vernacular;
	}

	String name;
	long mobNumber;
	String city;
	String email;
	String profile;
	String profession;
	String organization;
	String vernacular;
	int tokenNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(long mobNumber) {
		this.mobNumber = mobNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getVernacular() {
		return vernacular;
	}

	public void setVernacular(String vernacular) {
		this.vernacular = vernacular;
	}

	public int getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(int tokenNo) {
		this.tokenNo = tokenNo;
	}

	@Override
	public String toString() {
		return "CandidateDetails [name=" + name + ", mobNumber=" + mobNumber + ", city=" + city + ", email=" + email
				+ ", profile=" + profile + ", profession=" + profession + ", organization=" + organization
				+ ", vernacular=" + vernacular + ", tokenNo=" + tokenNo + "]";
	}

}
