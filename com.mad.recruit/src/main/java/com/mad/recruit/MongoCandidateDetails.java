package com.mad.recruit;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_DEFAULT)
public class MongoCandidateDetails {
	// ObjectId id;
	String name;
	long mobNumber;
	String city;
	String email;
	String profile;
	String profession;
	String organization;
	String vernacular;
	int tokenNo;
	String pref1;
	String pref2;
	String prInterest;

	String groupActivity;

	int causeAboveSelf;
	int emotionalMaturity;
	int senseOfFamily;
	int leaderShip;
	String finalComments;

	String edPanelistName;
	String edAvailabilityPref;
	String edGradePref;
	String edSubjectPref;
	String edSubjectTaught;
	String edCenterPref;
	int edContentKnowledge;
	int edBreakDownConcept;
	int edPresentation;
	String edTeachComments;
	String edResult;

	String pPanelistName;
	String pAvailabilityPref;
	String propelSubjectPref;
	String propelSubjectTaught;
	String propelCenterPref;
	int pContentKnowledge;
	int pBreakDownConcept;
	int pPresentation;
	String pTeachComments;
	String pResult;

	String frPanelistName;
	String frAvailabilityPref;
	String frPreference;
	String frResult;
	int frProActiveness;

	public int getFrProActiveness() {
		return frProActiveness;
	}

	public void setFrProActiveness(int frProActiveness) {
		this.frProActiveness = frProActiveness;
	}

	public String getFrAvailabilityPref() {
		return frAvailabilityPref;
	}

	public void setFrAvailabilityPref(String frAvailabilityPref) {
		this.frAvailabilityPref = frAvailabilityPref;
	}

	public String getEdCenterPref() {
		return edCenterPref;
	}

	public void setEdCenterPref(String edCenterPref) {
		this.edCenterPref = edCenterPref;
	}

	public String getPref1() {
		return pref1;
	}

	public void setPref1(String pref1) {
		this.pref1 = pref1;
	}

	public String getPref2() {
		return pref2;
	}

	public void setPref2(String pref2) {
		this.pref2 = pref2;
	}

	public String getPrInterest() {
		return prInterest;
	}

	public void setPrInterest(String prInterest) {
		this.prInterest = prInterest;
	}

	public String getFrPanelistName() {
		return frPanelistName;
	}

	public void setFrPanelistName(String frPanelistName) {
		this.frPanelistName = frPanelistName;
	}

	public String getFrPreference() {
		return frPreference;
	}

	public void setFrPreference(String frPreference) {
		this.frPreference = frPreference;
	}

	public String getFrResult() {
		return frResult;
	}

	public void setFrResult(String frResult) {
		this.frResult = frResult;
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

	public String getEdPanelistName() {
		return edPanelistName;
	}

	public void setEdPanelistName(String edPanelistName) {
		this.edPanelistName = edPanelistName;
	}

	public String getEdAvailabilityPref() {
		return edAvailabilityPref;
	}

	public void setEdAvailabilityPref(String edAvailabilityPref) {
		this.edAvailabilityPref = edAvailabilityPref;
	}

	public String getEdGradePref() {
		return edGradePref;
	}

	public void setEdGradePref(String edGradePref) {
		this.edGradePref = edGradePref;
	}

	public String getEdSubjectPref() {
		return edSubjectPref;
	}

	public void setEdSubjectPref(String edSubjectPref) {
		this.edSubjectPref = edSubjectPref;
	}

	public String getEdSubjectTaught() {
		return edSubjectTaught;
	}

	public void setEdSubjectTaught(String edSubjectTaught) {
		this.edSubjectTaught = edSubjectTaught;
	}

	public int getEdContentKnowledge() {
		return edContentKnowledge;
	}

	public void setEdContentKnowledge(int edContentKnowledge) {
		this.edContentKnowledge = edContentKnowledge;
	}

	public int getEdBreakDownConcept() {
		return edBreakDownConcept;
	}

	public void setEdBreakDownConcept(int edBreakDownConcept) {
		this.edBreakDownConcept = edBreakDownConcept;
	}

	public int getEdPresentation() {
		return edPresentation;
	}

	public void setEdPresentation(int edPresentation) {
		this.edPresentation = edPresentation;
	}

	public String getEdTeachComments() {
		return edTeachComments;
	}

	public void setEdTeachComments(String edTeachComments) {
		this.edTeachComments = edTeachComments;
	}

	public String getEdResult() {
		return edResult;
	}

	public void setEdResult(String edResult) {
		this.edResult = edResult;
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

	public String getpPanelistName() {
		return pPanelistName;
	}

	public void setpPanelistName(String pPanelistName) {
		this.pPanelistName = pPanelistName;
	}

	public String getpAvailabilityPref() {
		return pAvailabilityPref;
	}

	public void setpAvailabilityPref(String pAvailabilityPref) {
		this.pAvailabilityPref = pAvailabilityPref;
	}

	public String getPropelSubjectPref() {
		return propelSubjectPref;
	}

	public void setPropelSubjectPref(String propelSubjectPref) {
		this.propelSubjectPref = propelSubjectPref;
	}

	public String getPropelCenterPref() {
		return propelCenterPref;
	}

	public void setPropelCenterPref(String propelCenterPref) {
		this.propelCenterPref = propelCenterPref;
	}

	public int getpContentKnowledge() {
		return pContentKnowledge;
	}

	public void setpContentKnowledge(int pContentKnowledge) {
		this.pContentKnowledge = pContentKnowledge;
	}

	public int getpBreakDownConcept() {
		return pBreakDownConcept;
	}

	public void setpBreakDownConcept(int pBreakDownConcept) {
		this.pBreakDownConcept = pBreakDownConcept;
	}

	public int getpPresentation() {
		return pPresentation;
	}

	public void setpPresentation(int pPresentation) {
		this.pPresentation = pPresentation;
	}

	public String getpTeachComments() {
		return pTeachComments;
	}

	public void setpTeachComments(String pTeachComments) {
		this.pTeachComments = pTeachComments;
	}

	public String getpResult() {
		return pResult;
	}

	public void setpResult(String pResult) {
		this.pResult = pResult;
	}

	public String getPropelSubjectTaught() {
		return propelSubjectTaught;
	}

	public void setPropelSubjectTaught(String propelSubjectTaught) {
		this.propelSubjectTaught = propelSubjectTaught;
	}

}
