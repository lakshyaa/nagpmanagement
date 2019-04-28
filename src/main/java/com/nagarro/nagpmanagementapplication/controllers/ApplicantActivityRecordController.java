package com.nagarro.nagpmanagementapplication.controllers;

import com.nagarro.nagpmanagementapplication.entity.Admin;
import com.nagarro.nagpmanagementapplication.entity.ApplicantActivityRecord;
import com.nagarro.nagpmanagementapplication.service.ApplicantActivityRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicantActivityRecordController {
@Autowired
private ApplicantActivityRecordService applicantActivityRecordService;




    public void create(@RequestBody ApplicantActivityRecord applicantActivityRecord)
    {
        System.out.println("reached in controller");
        applicantActivityRecordService.addApplicantActivityRecord(applicantActivityRecord);

    }


}
