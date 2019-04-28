package com.nagarro.nagpmanagementapplication.repository;

import java.util.List;


import com.nagarro.nagpmanagementapplication.entity.Batch;
import com.nagarro.nagpmanagementapplication.entity.Levels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nagarro.nagpmanagementapplication.entity.NagpActivities;



public interface ActivityRepository extends JpaRepository<NagpActivities, String> {
	
	//@Query("select a  from nagp_activities a where a.levelid:=id")
	//public List<NagpActivities> findByLevel(@Param("id") int id);


	@Query(value = "select * from nagp_activities where batch_id=:batchId and level_id=:levelId",nativeQuery = true)
	public List<NagpActivities> findAllByBatchIdAndLevelId(@Param("batchId") Integer batchId, @Param("levelId") Integer levelId);

	@Query(value = "select * from nagp_activities where batch_id=:batchId",nativeQuery = true)
	public List<NagpActivities> findAllByBatchId(@Param("batchId") Integer batchId);

	@Query(value = "select * from nagp_activities where level_id=:levelId",nativeQuery = true)
	public List<NagpActivities> findAllByLevelId( @Param("levelId") Integer levelId);
	@Query(value="select * from nagp_activities where activity_name=:name ",nativeQuery = true)
	public NagpActivities findByName(@Param("name")  String name);


}
