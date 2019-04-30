package com.nagarro.nagpmanagementapplication.repository;

import com.nagarro.nagpmanagementapplication.entity.ApplicantActivityRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ApplicantActivityRecordRepository extends JpaRepository<ApplicantActivityRecord,Integer> {

        @Query(value=" select *  from applicant_activity_record where assignee_applicant_id=:id",nativeQuery=true)
        public List<ApplicantActivityRecord> findAllById(@PathVariable("id")int id);

        }
