package com.nagarro.nagpmanagementapplication.entity;

import java.util.ArrayList;
import java.util.Date;
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

@Entity
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int year;
	private String technology;
	private String description;
	private int qualificationPoints;

	private Date startDate;
	// @ManyToOne
	// private Levels level;
//@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "batch", cascade = CascadeType.ALL)
//	@JsonManagedReference(value = "batchno")
	@JsonIgnore
	private List<NagpActivities> nagpActivities = new ArrayList<>();
//	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "batch", cascade = CascadeType.ALL)
	@JsonManagedReference(value = "batchno")
	private List<Applicant> applicantList = new ArrayList<>();

	public List<Applicant> getApplicantList() {
		return applicantList;
	}

	public void setApplicantList(List<Applicant> applicantList) {
		this.applicantList = applicantList;
	}

	public List<NagpActivities> getNagpActivities() {
		return nagpActivities;
	}

	public void setNagpActivities(List<NagpActivities> nagpActivities) {
		this.nagpActivities = nagpActivities;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "Batch{" +
				"id=" + id +
				", year=" + year +
				", technology='" + technology + '\'' +
				", description='" + description + '\'' +
				", qualificationPoints=" + qualificationPoints +
				", startDate=" + startDate +
				", nagpActivities=" + nagpActivities +
				", applicantList=" + applicantList +
				'}';
	}
}
