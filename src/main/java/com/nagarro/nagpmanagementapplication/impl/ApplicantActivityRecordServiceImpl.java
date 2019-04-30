package com.nagarro.nagpmanagementapplication.impl;

import com.nagarro.nagpmanagementapplication.entity.ApplicantActivityRecord;
import com.nagarro.nagpmanagementapplication.repository.ApplicantActivityRecordRepository;
import com.nagarro.nagpmanagementapplication.service.ApplicantActivityRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.logging.Logger;

@Service("applicantActivityRecordService")
public class ApplicantActivityRecordServiceImpl implements ApplicantActivityRecordService {
    @Autowired
    private ApplicantActivityRecordRepository applicantActivityRecordRepository;

    Logger logger=Logger.getLogger(ApplicantActivityRecordServiceImpl.class.getName());

    public void addApplicantActivityRecord(ApplicantActivityRecord applicantActivityRecord)
    {

        applicantActivityRecordRepository.save(applicantActivityRecord);

    }

    public List<ApplicantActivityRecord> findAll(@PathVariable("id")int id){

        logger.info("get activity record for id="+1);
       System.out.println("here is the size"+applicantActivityRecordRepository.findAllById(id).size());
return applicantActivityRecordRepository.findAllById(id);
    }

    public List<ApplicantActivityRecord> findAll()
    {
        //System.out.println(applicantActivityRecordRepository.findAll().get(0).getDescription());

        return applicantActivityRecordRepository.findAll();
    }
}
