package com.nagarro.nagpmanagementapplication.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.nagpmanagementapplication.entity.Applicant;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface ApplicantRepository extends PagingAndSortingRepository<Applicant, Integer>
{

    @Query(value = "select * from applicant where batch_id=:batchId and level_id=:levelId",nativeQuery = true)
    public List<Applicant> findAllByBatchIdAndLevelId(@Param("batchId") Integer batchId, @Param("levelId") Integer levelId);


    @Query(value="select * from applicant where name=:name",nativeQuery = true)
	public List<Applicant> findByName(@Param("name") String name);



    Page<Applicant> findAll(Pageable pageable);
    public  Applicant findFirstByEmail(String email);

    @Modifying(clearAutomatically = true)
    @Query(value="update applicant set name=:name,password=:password,set nagp_status=:nagpstatus,set email=:email,set contact_no=:contactno where applicant_id=:id",nativeQuery = true)
   public int updateApplicant(String name,String password,String nagpstatus,String email,long contactno,int id);


}


