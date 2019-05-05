package com.nagarro.nagpmanagementapplication.controllers;

//import com.fasterxml.jackson.databind.util.JSONPObject;
import com.nagarro.nagpmanagementapplication.entity.Admin;
import com.nagarro.nagpmanagementapplication.entity.ApplicantActivityRecord;
import com.nagarro.nagpmanagementapplication.entity.ApplicantActivityRecordStatus;
import com.nagarro.nagpmanagementapplication.service.ApplicantActivityRecordService;
import org.json.JSONException;
import org.json.JSONObject;
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

    @RequestMapping(value = "/activitycheck")
    public String activityCheck(@RequestParam("activity_id") String activity_id,
                                @RequestParam("applicant_id") int applicant_id) {
        logger.info("getting status of applicant_id and activity_id");
        logger.info("status is="+applicantActivityRecordService.activityCheck(activity_id, applicant_id));

        return applicantActivityRecordService.activityCheck(activity_id, applicant_id);

    }


    @GetMapping(value="/appactivityrecord/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<ApplicantActivityRecord> getApplicantActivityRecord(@PathVariable("id")int id){

        logger.info("get appllicant activity record"+id);
      return   applicantActivityRecordService.findAll(id);

    }
    @RequestMapping(value = "/history/{id}")
    public List<ApplicantActivityRecord> getHistoryofActivitiesOfApplicant(@PathVariable int id){
        logger.info("IN APPLICANT ACTIVITY RECORD CONTROLLER AND ID IS"+id);
        return applicantActivityRecordService.getHistoryofActivitiesOfApplicant(id);
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

    /**
     *
     * @param applicant updating a applicant activity record for a particular applicant.
     * @param id of the applicant
     */

    @PostMapping(value = "/updaterecord/{id}" , consumes = "application/json")
    public void updateActivityRecord(@RequestBody ApplicantActivityRecordStatus applicant, @PathVariable int id ) {

        logger.info("status is="+applicant.getStatus());

        if(applicant.getStatus().equals("DONE"))
        {
            applicant.setStatus("REVIEW_PENDING");
        }
       applicantActivityRecordService.updateActivityRecord(applicant.getStatus(),id);

    }

    /**
     *
     * @param object update applicantactivityrecord  for a applicant consist of percentage score given by admin and status either complete or review_failed.
     * @param id of the applicant
     */
    @PutMapping(value="/updateactivity/{id}", consumes = "application/json")
        public void updateActivityStatus(@RequestBody ApplicantActivityRecord object,@PathVariable int id ) {
        logger.info("***************32143141");
        logger.info("PErcentage score is "+object.getPercentageScore()+">>>>>>>>>>>>>>>>>");
        applicantActivityRecordService.updateActivityStatus(object.getPercentageScore(),object.getStatus().toString(),id);
        System.out.println("***************");
    }






    @GetMapping(value = "/applicantscore/{id}")
    public double getApplicantScoreById(@PathVariable int id) {
        logger.info("id is="+id);

        return applicantActivityRecordService.getApplicantScoreById(id);
    }




}



