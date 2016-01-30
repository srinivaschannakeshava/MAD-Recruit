package com.mad.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CandidateInterviewDetails {
	String email;
	String panelistName;
	String availabilityPref;
	String gradePref;
	String subjectPref;
	String subjectTaught;
	int contentKnowledge;
	int breakDownConcept;
	int presentation;
	String comments;
	int causeAboveSelf;
	int emotionalMaturity;
	int senseOfFamily;
	int leaderShip;
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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	@Override
	public String toString() {
		return "CandidateInterviewDetails [email=" + email + ", panelistName=" + panelistName + ", availabilityPref="
				+ availabilityPref + ", gradePref=" + gradePref + ", subjectPref=" + subjectPref + ", subjectTaught="
				+ subjectTaught + ", contentKnowledge=" + contentKnowledge + ", breakDownConcept=" + breakDownConcept
				+ ", presentation=" + presentation + ", comments=" + comments + ", causeAboveSelf=" + causeAboveSelf
				+ ", emotionalMaturity=" + emotionalMaturity + ", senseOfFamily=" + senseOfFamily + ", leaderShip="
				+ leaderShip + ", Result=" + Result + "]";
	}

}
