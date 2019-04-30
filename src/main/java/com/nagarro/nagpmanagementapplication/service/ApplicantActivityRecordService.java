package com.nagarro.nagpmanagementapplication.service;

import com.nagarro.nagpmanagementapplication.entity.ApplicantActivityRecord;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ApplicantActivityRecordService  {

    public void addApplicantActivityRecord(ApplicantActivityRecord applicantActivityRecord);

    public List<ApplicantActivityRecord> findAll(@PathVariable("id")int id);

    public List<ApplicantActivityRecord> findAll();

}
