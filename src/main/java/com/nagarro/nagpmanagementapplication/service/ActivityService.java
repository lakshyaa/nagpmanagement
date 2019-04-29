package com.nagarro.nagpmanagementapplication.service;

import java.util.List;

import com.nagarro.nagpmanagementapplication.entity.Levels;
import com.nagarro.nagpmanagementapplication.entity.NagpActivities;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActivityService {

	
	public void addActivity(NagpActivities activities);
	
	public Iterable<NagpActivities> getActivities();
	
	//public List<NagpActivities> findByLevel(int id);
	public List<NagpActivities> findAllByBatchIdAndLevelId(@Param("batchId") Integer batchId, @Param("levelId") Integer levelId);

	public List<NagpActivities> findAllByBatchId(@Param("batchId") Integer batchId);

	public List<NagpActivities> findAllByLevelId( @Param("levelId") Integer levelId);
	public NagpActivities findByName(@Param("name")  String name);

	public Page<NagpActivities> getActivities(int pageno);


}
