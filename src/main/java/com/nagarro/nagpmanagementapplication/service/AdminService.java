package com.nagarro.nagpmanagementapplication.service;

import java.util.List;

import com.nagarro.nagpmanagementapplication.entity.Batch;
import com.nagarro.nagpmanagementapplication.entity.Levels;

public interface AdminService  {
	
	
	public void addBatch(Batch batch);
	public void addLevel(Levels level);
	public List<Levels> getLevels();
	

}
