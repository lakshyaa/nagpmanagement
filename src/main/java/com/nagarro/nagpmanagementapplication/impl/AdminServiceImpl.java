package com.nagarro.nagpmanagementapplication.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagpmanagementapplication.entity.Batch;
import com.nagarro.nagpmanagementapplication.entity.Levels;
import com.nagarro.nagpmanagementapplication.repository.BatchRepository;
import com.nagarro.nagpmanagementapplication.repository.LevelRepository;
import com.nagarro.nagpmanagementapplication.service.AdminService;


@Service("adminservice")
public class AdminServiceImpl  implements AdminService {

	@Autowired	
	private BatchRepository batchRepository;
	@Autowired
	private LevelRepository levelRepository;
	@Override
	public void addBatch(Batch batch) {
		
		
		batchRepository.save(batch);
	}
	@Override
	public void addLevel(Levels level) {
		
		levelRepository.save(level);
	}
	
	public List<Levels> getLevels()
	{
		List<Levels> levelsList = levelRepository.findAll();
		levelsList.forEach(System.out::println);
		return levelsList;
	}

}
