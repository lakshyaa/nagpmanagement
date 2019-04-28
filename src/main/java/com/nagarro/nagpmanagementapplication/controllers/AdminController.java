package com.nagarro.nagpmanagementapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nagarro.nagpmanagementapplication.entity.Admin;
import com.nagarro.nagpmanagementapplication.entity.Batch;
import com.nagarro.nagpmanagementapplication.entity.Levels;
import com.nagarro.nagpmanagementapplication.entity.NagpActivities;
import com.nagarro.nagpmanagementapplication.repository.AdminRepository;
import com.nagarro.nagpmanagementapplication.service.AdminService;
import com.nagarro.nagpmanagementapplication.impl.ActivityServiceImpl;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private AdminService adminService;
	@Autowired
	private ActivityServiceImpl activityService;
	


	
	@GetMapping
	public Admin adminLogin()
	{
	Admin a =new Admin();
	System.out.println("reached in controller");
	a.setId(1);
	a.setName("Lakshay");
	a.setPassword("1234567");
	adminRepository.save(a);
	return a;
	

	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)

	public void create(@RequestBody Admin admin)
	{
		System.out.println("reached in controller");
		adminRepository.save(admin);
		
	}
	@GetMapping(value="/addBatch")
	@ResponseStatus(HttpStatus.OK)
   public void createBatch(@RequestBody Batch batch)
	{
		
		System.out.println("adding batch");
		adminService.addBatch(batch);
	}


	
	//@PostMapping(value="/addApplicant",consumes=MediaType.APPLICATION_JSON_VALUE)


	
	
	
	
	
}