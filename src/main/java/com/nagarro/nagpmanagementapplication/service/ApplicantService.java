package com.nagarro.nagpmanagementapplication.service;

import java.util.List;

import com.nagarro.nagpmanagementapplication.entity.Applicant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApplicantService {
	
	public void addApplicant(Applicant applicant);
	
	public List<Applicant> getApplicants();
	public List<Applicant> findAllByBatchIdAndLevelId(@Param("batchId") Integer batchId, @Param("levelId") Integer levelId );

	public List<Applicant> findByName(@Param("name") String name);


}
