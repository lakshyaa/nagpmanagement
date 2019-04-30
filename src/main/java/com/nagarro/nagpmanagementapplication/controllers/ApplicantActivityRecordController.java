package com.nagarro.nagpmanagementapplication.controllers;

import com.nagarro.nagpmanagementapplication.entity.Admin;
import com.nagarro.nagpmanagementapplication.entity.ApplicantActivityRecord;
import com.nagarro.nagpmanagementapplication.service.ApplicantActivityRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class ApplicantActivityRecordController {
@Autowired
private ApplicantActivityRecordService applicantActivityRecordService;


Logger logger=Logger.getLogger(ApplicantActivityRecordController.class.getName());
    @GetMapping(value="/appactivityrecord/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ApplicantActivityRecord> getApplicantActivityRecord(@PathVariable("id")int id){

        logger.info("get appllicant activity record"+id);
      return   applicantActivityRecordService.findAll(id);





    }
    @PostMapping(value="/appactivityrecord")
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody ApplicantActivityRecord applicantActivityRecord)
    {
        System.out.println("reached in controller");
        applicantActivityRecordService.addApplicantActivityRecord(applicantActivityRecord);

    }

    @GetMapping(value="/appactivityrecords")
@ResponseStatus(HttpStatus.OK)
    public List<ApplicantActivityRecord> getApplicantActivityRecord()
    {
        logger.info("getting all applicant activity record");
      return   applicantActivityRecordService.findAll();
    }

}
