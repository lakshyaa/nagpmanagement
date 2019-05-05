package com.nagarro.nagpmanagementapplication.impl;

import com.nagarro.nagpmanagementapplication.Enums.Status;
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
    public String activityCheck(String activity_id, int applicant_id) {
        // TODO Auto-generated method stub
        List<ApplicantActivityRecord> fetchallRecords=applicantActivityRecordRepository.checkActivity(activity_id, applicant_id);
        System.out.println(fetchallRecords);
        System.out.println("current status is "+fetchallRecords.get(0).getStatus());
        System.out.println("max attempts is "+fetchallRecords.get(0).getActivity().getMaxQualification());
        System.out.println("curent count is "+fetchallRecords.get(0).getCount());

        if(fetchallRecords.size()==0) {
            logger.info("no record found");

            return "true";
        }
        else {
            System.out.println("in else");
            //check if status is complete,we have to disable button
            if(fetchallRecords.get(0).getStatus().toString().equals("COMPLETED")) {
                logger.info("status is completed");
                return "COMPLETED";
            }
            else if(fetchallRecords.get(0).getStatus().toString().equals("REVIEW_FAILED")) {
                logger.info("review match failed hit ");
                logger.info("status is failed");
                logger.info("count is ="+fetchallRecords.get(0).getCount());
                int count=fetchallRecords.get(0).getCount();
                logger.info("max attempt is "+fetchallRecords.get(0).getActivity().getMaxQualification());
                int maxAttempts=fetchallRecords.get(0).getActivity().getMaxQualification();
                if(count<maxAttempts) {
                    //we can reAttempt the activity
                    NextAttemptForActivity(fetchallRecords.get(0));
                    return "ADDMORE";
                }

                else {
                    return "false";
                }
            }
            else {
                return "PENDING";
            }


        }
    }

    public  void NextAttemptForActivity(ApplicantActivityRecord applicantActivityRecord) {
        // TODO Auto-generated method stub
        logger.info("information==>"+applicantActivityRecord);
        logger.info("new count is="+applicantActivityRecord.getCount()+1);

        applicantActivityRecord.setCount(applicantActivityRecord.getCount()+1);
        applicantActivityRecord.setStatus(Status.Planned);

        applicantActivityRecordRepository.save(applicantActivityRecord);
    }

    public List<ApplicantActivityRecord> getHistoryofActivitiesOfApplicant(int id) {
        // TODO Auto-generated method stub
        logger.info("IN ACTTIVITYRECORD SERVICE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return applicantActivityRecordRepository.getHistoryofActivitiesOfApplicant(id);
    }
    public void updateActivityRecord(String status, int recordid) {
        // TODO Auto-generated method stub
        logger.info("inside update activity record service>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        ApplicantActivityRecord fetched=applicantActivityRecordRepository.findById(recordid).get();
        logger.info("GET APPLICANT ACTIVITY RECORD THAT IS"+fetched);
        applicantActivityRecordRepository.updateActivityRecord(status,recordid);
    }

    public double getApplicantScoreById(int applicant_id) {
        if(applicantActivityRecordRepository.getHistoryofActivitiesOfApplicant(applicant_id).size()==0) {
            return 0;
        }
        logger.info("inside service="+applicant_id);
        return applicantActivityRecordRepository.getTotalScore(applicant_id);
    }


    public void updateActivityStatus(double percentage_score, String status, int record_id) {
        ApplicantActivityRecord fetched=applicantActivityRecordRepository.findById(record_id).get();
        double points_earned = 0;
        if(status.equals("COMPLETED")) {
            points_earned = (fetched).getActivity().getPoints()*percentage_score/100;
        }
        applicantActivityRecordRepository.updateActivityStatus(percentage_score,points_earned,status, record_id);

    }









}
