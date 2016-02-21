package com.mad.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CandidateInterviewDetails extends CandidateDetails {
	String panelistName;
	String availabilityPref;
	String gradePref;
	String subjectPref;
	String subjectTaught;
	int contentKnowledge;
	int breakDownConcept;
	int presentation;
	String teachComments;
	int causeAboveSelf;
	int emotionalMaturity;
	int senseOfFamily;
	int leaderShip;
	String finalComments;
	String Result;

	public String getSubjectPref() {
		return subjectPref;
	}

	public void setSubjectPref(String subjectPref) {
		this.subjectPref = subjectPref;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getFinalComments() {
		return finalComments;
	}

	public void setFinalComments(String finalComments) {
		this.finalComments = finalComments;
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

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public String getSubjectTaught() {
		return subjectTaught;
	}

	public void setSubjectTaught(String subjectTaught) {
		this.subjectTaught = subjectTaught;
	}

	

}
