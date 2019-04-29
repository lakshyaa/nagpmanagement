package com.nagarro.nagpmanagementapplication.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class ApplicantActivityRecord {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JsonBackReference(value="levelno")
	private Levels level;
	@ManyToOne
	@JsonBackReference(value="activityno")
	private NagpActivities activity;
	
	private String status;
	@ManyToOne
	@JsonBackReference(value="applicantno")
	private Applicant applicant;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Levels getLevel() {
		return level;
	}
	public void setLevel(Levels level) {
		this.level = level;
	}
	public NagpActivities getActivity() {
		return activity;
	}
	public void setActivity(NagpActivities activity) {
		this.activity = activity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Applicant getApplicant() {
		return applicant;
	}
	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}
	public int getPercentageScore() {
		return percentageScore;
	}
	public void setPercentageScore(int percentageScore) {
		this.percentageScore = percentageScore;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Applicant getAssignee() {
		return assignee;
	}
	public void setAssignee(Applicant assignee) {
		this.assignee = assignee;
	}
	public List<Comments> getListOfComments() {
		return listOfComments;
	}
	public void setListOfComments(List<Comments> listOfComments) {
		this.listOfComments = listOfComments;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getDoneDate() {
		return doneDate;
	}
	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;
	}
	public Date getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}
	private int  percentageScore;
	
	private int points;
	
	@ManyToOne
	@JsonBackReference(value="assigneeno")
	private Applicant assignee;
	@OneToMany(mappedBy="apprecord",cascade=CascadeType.ALL)
	@JsonManagedReference(value="apprecordno")
	private List<Comments> listOfComments=new ArrayList<>();
	
	private String description;
	
	private Date startDate;
	private Date doneDate;
	private Date completionDate;
	
	
	
	
	

}
