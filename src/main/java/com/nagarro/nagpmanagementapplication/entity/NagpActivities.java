package com.nagarro.nagpmanagementapplication.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class NagpActivities {
	@Id
	 @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String  id;
	
	

	@JsonIgnore
	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)
	 @JoinColumn(name = "batchid")
	private Batch  batch;
	
	private String activityName;
	private String description;
	private int points;


//	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToOne
	@JoinColumn(name = "levelid")
//	@JsonBackReference(value="levelno")
	@JsonIgnore
	private Levels level;
	
	
	private int maxQualification;
	///@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="activity",cascade=CascadeType.ALL)
	@JsonManagedReference(value="activityno")
	private List<ApplicantActivityRecord> applicantActivityRecord=new ArrayList<>();
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Levels getLevel() {
		return level;
	}

	public void setLevel(Levels level) {
		this.level = level;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getMaxQualification() {
		return maxQualification;
	}

	public void setMaxQualification(int maxQualification) {
		this.maxQualification = maxQualification;
	}


}
