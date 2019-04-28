package com.nagarro.nagpmanagementapplication.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.nagarro.nagpmanagementapplication.entity.NagpActivities;
import com.nagarro.nagpmanagementapplication.repository.ActivityRepository;
import com.nagarro.nagpmanagementapplication.service.ActivityService;

import javax.annotation.PostConstruct;

@Service("activityService")
public class ActivityServiceImpl  implements ActivityService{


	@PostConstruct
	public void init(){
		System.out.println(".......................................");
	}

	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public void addActivity(NagpActivities activities) {
		activityRepository.save(activities);
	}

	@Override
	public Iterable<NagpActivities> getActivities() {

		
		return activityRepository.findAll();
	}

	

	public List<NagpActivities> findAllByBatchIdAndLevelId(@Param("batchId") Integer batchId, @Param("levelId") Integer levelId)
	{
return activityRepository.findAllByBatchIdAndLevelId(batchId,levelId);
	}
	public List<NagpActivities> findAllByBatchId( Integer batchId){
		return activityRepository.findAllByBatchId(batchId);

	}

	public List<NagpActivities> findAllByLevelId( Integer levelId){
		return activityRepository.findAllByLevelId(levelId);

	}

	public NagpActivities findByName(  String name){

		return activityRepository.findByName(name);
	}

	@Override
	public Page<NagpActivities> getActivities(int pageno) {


		Pageable pageable= PageRequest.of(pageno,1);
		Page<NagpActivities> nagpActivities=activityRepository.findAll(pageable);
		return nagpActivities;


	}



}
