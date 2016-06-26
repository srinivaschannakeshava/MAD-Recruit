package com.mad.recruit.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_DEFAULT)
public class MongoCandidateDetails {
	public String id;
	public String name;
	public long mobNumber;
	public String city;
	public String email;
	public String profile;
	public String profession;
	public String organization;
	public String vernacular;
	public int tokenNo;
	public String panelistName;
	public String availabilityPref;
	public String gradePref;
	public String subjectPref;
	public String subjectTaught;
	public int contentKnowledge;
	public int breakDownConcept;
	public int presentation;
	public String teachComments;
	public int causeAboveSelf;
	public int emotionalMaturity;
	public int senseOfFamily;
	public int leaderShip;
	public String finalComments;
	public String groupActivity;
	public String Result;

	@JsonProperty("_id")
	public String getId() {
		return id;
	}

	@JsonProperty("_id")
	public void setId(String id) {
		this.id = id;
	}

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

	public String getPanelistName() {
		return panelistName;
	}

	public void setPanelistName(String panelistName) {
		this.panelistName = panelistName;
	}

	public String getAvailabilityPref() {
		return availabilityPref;
	}

	public void setAvailabilityPref(String availabilityPref) {
		this.availabilityPref = availabilityPref;
	}

	public String getGradePref() {
		return gradePref;
	}

	public void setGradePref(String gradePref) {
		this.gradePref = gradePref;
	}

	public String getSubjectPref() {
		return subjectPref;
	}

	public void setSubjectPref(String subjectPref) {
		this.subjectPref = subjectPref;
	}

	public String getSubjectTaught() {
		return subjectTaught;
	}

	public void setSubjectTaught(String subjectTaught) {
		this.subjectTaught = subjectTaught;
	}

	public int getContentKnowledge() {
		return contentKnowledge;
	}

	public void setContentKnowledge(int contentKnowledge) {
		this.contentKnowledge = contentKnowledge;
	}

	public int getBreakDownConcept() {
		return breakDownConcept;
	}

	public void setBreakDownConcept(int breakDownConcept) {
		this.breakDownConcept = breakDownConcept;
	}

	public int getPresentation() {
		return presentation;
	}

	public void setPresentation(int presentation) {
		this.presentation = presentation;
	}

	public String getTeachComments() {
		return teachComments;
	}

	public void setTeachComments(String teachComments) {
		this.teachComments = teachComments;
	}

	public int getCauseAboveSelf() {
		return causeAboveSelf;
	}

	public void setCauseAboveSelf(int causeAboveSelf) {
		this.causeAboveSelf = causeAboveSelf;
	}

	public int getEmotionalMaturity() {
		return emotionalMaturity;
	}

	public void setEmotionalMaturity(int emotionalMaturity) {
		this.emotionalMaturity = emotionalMaturity;
	}

	public int getSenseOfFamily() {
		return senseOfFamily;
	}

	public void setSenseOfFamily(int senseOfFamily) {
		this.senseOfFamily = senseOfFamily;
	}

	public int getLeaderShip() {
		return leaderShip;
	}

	public void setLeaderShip(int leaderShip) {
		this.leaderShip = leaderShip;
	}

	public String getFinalComments() {
		return finalComments;
	}

	public void setFinalComments(String finalComments) {
		this.finalComments = finalComments;
	}

	public String getGroupActivity() {
		return groupActivity;
	}

	public void setGroupActivity(String groupActivity) {
		this.groupActivity = groupActivity;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

}
