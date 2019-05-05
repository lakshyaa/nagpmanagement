package com.nagarro.nagpmanagementapplication.service;

import java.util.List;

import com.nagarro.nagpmanagementapplication.entity.Applicant;
import com.nagarro.nagpmanagementapplication.entity.ApplicantIds;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApplicantService {
	
	public void addApplicant(Applicant applicant);
	
	public List getApplicants();
	public List<Applicant> findAllByBatchIdAndLevelId(@Param("batchId") Integer batchId, @Param("levelId") Integer levelId );

	public List<Applicant> findByName(@Param("name") String name);
	public ApplicantIds authenticate(Applicant user);


public Applicant getApplicantById(int id);


	Page<Applicant> findAll(int pageno);

	public void updateApplicant(Applicant applicant,int id);



}
