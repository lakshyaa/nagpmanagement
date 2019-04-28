package com.nagarro.nagpmanagementapplication.controllers;

import com.nagarro.nagpmanagementapplication.entity.Applicant;
import com.nagarro.nagpmanagementapplication.entity.NagpActivities;
import com.nagarro.nagpmanagementapplication.service.ActivityService;
import com.nagarro.nagpmanagementapplication.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;


    @PostConstruct
    public void init(){
        System.out.println(applicantService+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @PostMapping(value="/addApplicant",consumes= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Applicant applicant)
    {
        System.out.println("reached in controller");
        applicantService.addApplicant(applicant);
        System.out.println(applicant.getContactNo()+" "+applicant.getNagpStatus()+" "+applicant.getPassword()+" "+applicant.getLevel());

    }


    @GetMapping(value="/getAllApplicants")
    public Iterable<Applicant> getApplicants()
    {
        System.out.println("not at the right placereached in activity controller");


        System.out.println(applicantService.getApplicants());
        return  applicantService.getApplicants();

    }
    @GetMapping(value="/getAllApplicants/{pageno}")
    public Page<Applicant> getApplicants(@PathVariable("pageno") int pageno)
    {
        System.out.println("reached in activity controller");

      //  System.out.println(applicantService.getApplicants());

        return  applicantService.findAll(pageno);

    }


    @GetMapping("/applicants")
    public List<Applicant> getApplicants(@RequestParam("batchId") Integer batchId, @RequestParam("levelId") Integer levelId){
        List<Applicant> nagpActivities =	applicantService.findAllByBatchIdAndLevelId(batchId, levelId);
        return nagpActivities;
    }

    @GetMapping("/applicantsbyname")
    public List<Applicant>  getApplicantsByName(@RequestParam("name") String name)
    {

        return applicantService.findByName(name);
    }






}
