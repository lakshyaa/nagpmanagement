package com.nagarro.nagpmanagementapplication.impl;

import com.nagarro.nagpmanagementapplication.entity.ApplicantActivityRecord;
import com.nagarro.nagpmanagementapplication.repository.ApplicantActivityRecordRepository;
import com.nagarro.nagpmanagementapplication.service.ApplicantActivityRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("applicantActivityRecordService")
public class ApplicantActivityRecordServiceImpl implements ApplicantActivityRecordService {
    @Autowired
    private ApplicantActivityRecordRepository applicantActivityRecordRepository;

    public void addApplicantActivityRecord(ApplicantActivityRecord applicantActivityRecord)
    {

        applicantActivityRecordRepository.save(applicantActivityRecord);

    }
}
