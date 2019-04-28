package com.nagarro.nagpmanagementapplication.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.repository.cdi.Eager;

@Entity
public class Levels implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private int qualificationPoints;
	
	//@OneToMany(mappedBy= "level")
	
	//private List<Batch> list=new ArrayList<>();
//	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="level",cascade=CascadeType.ALL)

//	@JsonIgnore
	private List<NagpActivities> nagpActivities=new ArrayList<>();
	 
	// @JsonIgnoreProperties("applicantList")
//	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "level",cascade=CascadeType.ALL)
//	 @JsonManagedReference(value="levelno")
	private List<Applicant> applicantList=new ArrayList<>();

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="level",cascade=CascadeType.ALL)
	@JsonManagedReference(value="levelno")
	private List<ApplicantActivityRecord> applicantActivityRecord=new ArrayList<>();
	
	
	
	public List<ApplicantActivityRecord> getApplicantActivityRecord() {
		return applicantActivityRecord;
	}
	public void setApplicantActivityRecord(List<ApplicantActivityRecord> applicantActivityRecord) {
		this.applicantActivityRecord = applicantActivityRecord;
	}
	public List<NagpActivities> getNagpActivities() {
		return nagpActivities;
	}
	public void setNagpActivities(List<NagpActivities> nagpActivities) {
		this.nagpActivities = nagpActivities;
	}
	public List<Applicant> getApplicantList() {
		return applicantList;
	}
	public void setApplicantList(List<Applicant> applicantList) {
		this.applicantList = applicantList;
	}
	public int getLevelNo() {
		return levelNo;
	}
	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}
	
	private int levelNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQualificationPoints() {
		return qualificationPoints;
	}
	public void setQualificationPoints(int qualificationPoints) {
		this.qualificationPoints = qualificationPoints;
	}


}
