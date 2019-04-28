package com.nagarro.nagpmanagementapplication.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nagarro.nagpmanagementapplication.entity.Applicant;
import com.nagarro.nagpmanagementapplication.repository.ApplicantRepository;
import com.nagarro.nagpmanagementapplication.service.ApplicantService;
@Service("applicantService")
public class ApplicantServiceImpl implements ApplicantService {


	@Autowired
	private ApplicantRepository applicantRepository;

	@Override
	public void addApplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		
		applicantRepository.save(applicant);
	}

	@Override
	public Iterable<Applicant> getApplicants() {
		// TODO Auto-generated method stub
		 return applicantRepository.findAll();
	}


	public List<Applicant> findAllByBatchIdAndLevelId( Integer batchId,  Integer levelId ){


		return applicantRepository.findAllByBatchIdAndLevelId(batchId,levelId);
	}

public List<Applicant>  findByName(String name)
{
	return applicantRepository.findByName(name);
}

	 public Page<Applicant> findAll(int pageno) {


		 System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		 System.out.println(pageno);
		 Pageable pageable = PageRequest.of(pageno, 2);
		 Page<Applicant> pages = applicantRepository.findAll(pageable);
		 return pages;
	 }







}

			

	

