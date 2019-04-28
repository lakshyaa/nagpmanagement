package com.nagarro.nagpmanagementapplication.repository;

import java.util.List;


import com.nagarro.nagpmanagementapplication.entity.Applicant;
import com.nagarro.nagpmanagementapplication.entity.Batch;
import com.nagarro.nagpmanagementapplication.entity.Levels;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.nagarro.nagpmanagementapplication.entity.NagpActivities;



public interface ActivityRepository extends PagingAndSortingRepository<NagpActivities, String> {
	
	//@Query("select a  from nagp_activities a where a.levelid:=id")
	//public List<NagpActivities> findByLevel(@Param("id") int id);


	@Query(value = "select * from nagp_activities where batchid=:batchId and levelid=:levelId",nativeQuery = true)
	public List<NagpActivities> findAllByBatchIdAndLevelId(@Param("batchId") Integer batchId, @Param("levelId") Integer levelId);

	@Query(value = "select * from nagp_activities where batchid=:batchId",nativeQuery = true)
	public List<NagpActivities> findAllByBatchId(@Param("batchId") Integer batchId);

	@Query(value = "select * from nagp_activities where levelid=:levelId",nativeQuery = true)
	public List<NagpActivities> findAllByLevelId( @Param("levelId") Integer levelId);
	@Query(value="select * from nagp_activities where activity_name=:name ",nativeQuery = true)
	public NagpActivities findByName(@Param("name")  String name);

	public Page<NagpActivities>  findAll(Pageable pageable);


}
