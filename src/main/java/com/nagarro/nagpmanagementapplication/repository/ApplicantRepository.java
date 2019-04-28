package com.nagarro.nagpmanagementapplication.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.nagpmanagementapplication.entity.Applicant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicantRepository extends PagingAndSortingRepository<Applicant, Integer>
{

    @Query(value = "select * from applicant where batch_id=:batchId and level_id=:levelId",nativeQuery = true)
    public List<Applicant> findAllByBatchIdAndLevelId(@Param("batchId") Integer batchId, @Param("levelId") Integer levelId);


    @Query(value="select * from applicant where name=:name",nativeQuery = true)
	public List<Applicant> findByName(@Param("name") String name);


    @Override
    Page<Applicant> findAll(Pageable pageable);

}


