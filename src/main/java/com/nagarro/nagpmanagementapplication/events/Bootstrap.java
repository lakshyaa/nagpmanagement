package com.nagarro.nagpmanagementapplication.events;

import com.nagarro.nagpmanagementapplication.entity.*;
import com.nagarro.nagpmanagementapplication.repository.ActivityRepository;
import com.nagarro.nagpmanagementapplication.repository.AdminRepository;
import com.nagarro.nagpmanagementapplication.repository.ApplicantActivityRecordRepository;
import com.nagarro.nagpmanagementapplication.repository.ApplicantRepository;
import com.nagarro.nagpmanagementapplication.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Bootstrap {
    @Autowired
    private ApplicantActivityRecordRepository applicantActivityRecordRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private AdminService adminService;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {
        System.out.println("initialize..............");
        Levels level = new Levels();

        level.setName("conquer your fears");
        level.setDescription("see your fears");
        level.setLevelNo(1);
        level.setQualificationPoints(120);
        adminService.addLevel(level);
        Batch batch = new Batch();
        batch.setDescription("iot batch 2019");
        batch.setQualificationPoints(150);
        batch.setStartDate(new Date(2019, 01, 01));
        batch.setTechnology("IOT");
        batch.setYear(2019);
        adminService.addBatch(batch);


        NagpActivities nagpActivities = new NagpActivities();
        nagpActivities.setActivityName("workshop session");
        nagpActivities.setDescription("workshop iot");
        nagpActivities.setBatch(batch);
        nagpActivities.setLevel(level);
        nagpActivities.setMaxQualification(2);
        nagpActivities.setPoints(10);
        activityRepository.save(nagpActivities);
        NagpActivities nagpActivities1 = new NagpActivities();
        nagpActivities1.setActivityName("level up");
        nagpActivities1.setDescription("clearing the level up");
        nagpActivities1.setBatch(batch);
        nagpActivities1.setLevel(level);
        nagpActivities1.setMaxQualification(2);
        nagpActivities1.setPoints(10);
        activityRepository.save(nagpActivities1);



        Applicant applicant = new Applicant();
        applicant.setBatch(batch);
        applicant.setLevel(level);
        applicant.setName("Lakshay");
        applicant.setPassword("1234");
        applicant.setContactNo(98120);
        applicant.setEmail("lakshay01@nagarro.com");
        applicant.setNagpStatus("In progresss");
        applicantRepository.save(applicant);

        Applicant applicant1 = new Applicant();
        applicant1.setBatch(batch);
        applicant1.setLevel(level);
        applicant1.setName("shivam");
        applicant1.setPassword("1234567");
        applicant1.setContactNo(90340);
        applicant1.setEmail("shivam@nagarro.com");
        applicant1.setNagpStatus("In progresss");
        applicantRepository.save(applicant1);

        Applicant applicant2 = new Applicant();
        applicant2.setBatch(batch);
        applicant2.setLevel(level);
        applicant2.setName("shaantanu");
        applicant2.setPassword("afae");
        applicant2.setContactNo(70158);
        applicant2.setEmail("shaantanu@nagarro.com");
        applicant2.setNagpStatus("In progresss");
        applicantRepository.save(applicant2);
        Applicant applicant3 = new Applicant();
        applicant3.setBatch(batch);
        applicant3.setLevel(level);
        applicant3.setName("shaantanu");
        applicant3.setPassword("afae");
        applicant3.setContactNo(70158);
        applicant3.setEmail("shaantanu@nagarro.com");
        applicant3.setNagpStatus("In progresss");
        applicantRepository.save(applicant3);




        ApplicantActivityRecord applicantActivityRecord = new ApplicantActivityRecord();

        applicantActivityRecord.setActivity(nagpActivities);
        applicantActivityRecord.setLevel(applicant.getLevel());
        applicantActivityRecord.setStatus("PLANNED");
        applicantActivityRecord.setPercentageScore(80);
        applicantActivityRecord.setPoints((80  * nagpActivities.getPoints())/100);
        applicantActivityRecord.setAssignee(applicant);
        applicantActivityRecord.setDescription("workshop");
        applicantActivityRecord.setStartDate(new Date(2019, 01, 01));
        applicantActivityRecord.setDoneDate(null);
        applicantActivityRecord.setCompletionDate(null);

        applicantActivityRecordRepository.save(applicantActivityRecord);


    }

}
