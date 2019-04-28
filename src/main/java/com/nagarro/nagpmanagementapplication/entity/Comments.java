package com.nagarro.nagpmanagementapplication.entity;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Comments {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ApplicantActivityRecord getApprecord() {
		return apprecord;
	}

	public void setApprecord(ApplicantActivityRecord apprecord) {
		this.apprecord = apprecord;
	}

	
	private String comment;
	
	private Time timeOfComment;
	@ManyToOne
	@JsonBackReference(value="apprecordno")
	private ApplicantActivityRecord  apprecord;
@ManyToOne
@JsonBackReference(value="applicantno")
	private Applicant applicant;
	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Time getTimeOfComment() {
		return timeOfComment;
	}

	public void setTimeOfComment(Time timeOfComment) {
		this.timeOfComment = timeOfComment;
	}
	
	
	

}
