package com.nagarro.nagpmanagementapplication.repository;

import com.nagarro.nagpmanagementapplication.entity.ApplicantActivityRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

public interface ApplicantActivityRecordRepository extends JpaRepository<ApplicantActivityRecord,Integer> {

        @Query(value=" select *  from applicant_activity_record where assignee_applicant_id=:id",nativeQuery=true)
        public List<ApplicantActivityRecord> findAllById(@PathVariable("id")int id);


        @Query(value = "Select * FROM applicant_activity_record  WHERE assignee_applicant_id =:applicant_id and activity_id=:activity_id", nativeQuery = true)
        public List<ApplicantActivityRecord> checkActivity(@RequestParam("activity_id") String activity_id,
                                                           @RequestParam("applicant_id") int applicant_id);
        @Query(value = "Select * FROM applicant_activity_record  WHERE assignee_applicant_id =:id",nativeQuery = true)
        public List<ApplicantActivityRecord> getHistoryofActivitiesOfApplicant(@RequestParam("id") int id);

        @Modifying
        @Transactional
        @Query(value = "update  applicant_activity_record set status=:status where id =:recordid ",nativeQuery = true)
        public void updateActivityRecord(@RequestParam("status") String status,@RequestParam("recordid") int recordid);


        @Query(value = "SELECT sum(points) FROM applicant_activity_record where assignee_applicant_id =:applicant_id",nativeQuery = true)
        public double getTotalScore(@RequestParam("applicant_id") int applicant_id);


        @Modifying
        @Transactional
        @Query(value = "update  applicant_activity_record set status=:status , percentage_score=:percentage_score, points=:points_earned where  id =:record_id ",nativeQuery = true)
        public void updateActivityStatus(@RequestParam("percentage_score") double percentage_score, @RequestParam("points_earned") double points_earned,
                                         @RequestParam("status") String status,@RequestParam("record_id") int record_id);





}
