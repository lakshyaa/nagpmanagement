package com.nagarro.nagpmanagementapplication.controllers;

import java.util.List;
import java.util.logging.Logger;

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
	


	Logger logger = Logger.getLogger(AdminController.class.getName());

	/**
	 *
	 * @param admin object of admin get from angular
	 * @return object of admin if found or return null if not found.
	 */
	@PostMapping(value="/admincheck")
	public Admin adminLogin(@RequestBody Admin admin)
	{
		logger.info("inside admin login");
		logger.info("ADMIN PASSWORD IS"+admin.getPassword());



	return adminRepository.checkAdmin(admin.getName(),admin.getPassword());
	

	}

	/**
	 *
	 * @param admin for creating a admin object
	 */
	@PostMapping(value="/admin")
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