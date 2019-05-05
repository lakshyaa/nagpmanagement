package com.nagarro.nagpmanagementapplication.service;

import com.nagarro.nagpmanagementapplication.entity.ApplicantActivityRecord;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ApplicantActivityRecordService  {

    public void addApplicantActivityRecord(ApplicantActivityRecord applicantActivityRecord);

    public List<ApplicantActivityRecord> findAll(@PathVariable("id")int id);

    public List<ApplicantActivityRecord> findAll();
    public String activityCheck(String activity_id, int applicant_id);
    public  void NextAttemptForActivity(ApplicantActivityRecord applicantActivityRecord);

    public List<ApplicantActivityRecord> getHistoryofActivitiesOfApplicant(int id);
    public void updateActivityRecord(String status, int recordid);
    public double getApplicantScoreById(int applicant_id);

    public void updateActivityStatus(double percentage_score, String status, int record_id);
}
