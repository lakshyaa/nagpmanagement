package com.nagarro.nagpmanagementapplication.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.repository.cdi.Eager;

@Entity

public class Applicant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int applicantId;
	
	private String name;
	
	private String email;
	private long contactNo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference(value="batchno")
	 @JoinColumn(name = "batch_id")
	private Batch batch;
	public List<Comments> getComments() {
		return comments;
	}
	public Applicant()
	{
		
	}
	///@OneToMany(mappedBy="assignee")
	//private List<ApplicantActivityRecord> applicantActivityRecord;
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference(value="levelno")
	 @JoinColumn(name = "level_id")
	private Levels level;
	//@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="assignee",cascade=CascadeType.ALL)
	@JsonManagedReference(value="assigneeno")
	
	private List<ApplicantActivityRecord> applicantActivityRecord=new ArrayList<>();
	private String NagpStatus;
	//@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="applicant",cascade=CascadeType.ALL)
	@JsonManagedReference(value="applicantno")
	private List<Comments> comments=new ArrayList<>();
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	
	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	public Levels getLevel() {
		return level;
	}
	public void setLevel(Levels level) {
		this.level = level;
	}
	public List<ApplicantActivityRecord> getApplicantActivityRecord() {
		return applicantActivityRecord;
	}
	public void setApplicantActivityRecord(List<ApplicantActivityRecord> applicantActivityRecord) {
		this.applicantActivityRecord = applicantActivityRecord;
	}
	public String getNagpStatus() {
		return NagpStatus;
	}
	public void setNagpStatus(String nagpStatus) {
		NagpStatus = nagpStatus;
	}

	}
