package com.nagarro.nagpmanagementapplication.controllers;

import com.nagarro.nagpmanagementapplication.entity.NagpActivities;
import com.nagarro.nagpmanagementapplication.repository.ActivityRepository;
import com.nagarro.nagpmanagementapplication.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActivityController {

    @Autowired
 private  ActivityService activityService;

    @GetMapping("/activities")
    public List<NagpActivities> getActivities(@RequestParam("batchId") Integer batchId, @RequestParam("levelId") Integer levelId){
        List<NagpActivities> nagpActivities =	activityService.findAllByBatchIdAndLevelId(batchId, levelId);
        return nagpActivities;
    }
@GetMapping("/activitybyname")
public NagpActivities findByName(@RequestParam("name") String name)
{
    System.out.println("reached here");
    System.out.println(activityService.findByName(name));

    return activityService.findByName(name);
}

    @PostMapping(value= "/addActivity")
    @ResponseStatus(HttpStatus.OK)
    public void createActivity(@RequestBody NagpActivities activities)
    {
        activityService.addActivity(activities);




    }
    @GetMapping("/activities/{pageno}")
    public Page<NagpActivities>   getActivities(@PathVariable("pageno") int pageno )
    {
        return activityService.getActivities(pageno);
    }

    }
