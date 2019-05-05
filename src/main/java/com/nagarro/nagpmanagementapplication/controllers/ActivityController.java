package com.nagarro.nagpmanagementapplication.controllers;

import com.nagarro.nagpmanagementapplication.entity.Batch;
import com.nagarro.nagpmanagementapplication.entity.NagpActivities;
import com.nagarro.nagpmanagementapplication.repository.ActivityRepository;
import com.nagarro.nagpmanagementapplication.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class ActivityController {

    Logger logger = Logger.getLogger(ActivityController.class.getName());
    @Autowired
    private ActivityService activityService;

    /**
     *
     * @param batchId batchId for batch
     * @param levelId  level Id for batch
     * @return activities which match batchid and levelid
     */
    @GetMapping("/activities")
    public List<NagpActivities> getActivities(@RequestParam("batchId") Integer batchId, @RequestParam("levelId") Integer levelId) {
logger.info("batch id is="+batchId+" "+levelId);
        List<NagpActivities> nagpActivities = activityService.findAllByBatchIdAndLevelId(batchId, levelId);
        return nagpActivities;
    }

    /**
     *
     * @param name of the activity we want to get
     * @return activity object or null if does not match
     */
    @GetMapping("/activitybyname")
    public NagpActivities findByName(@RequestParam("name") String name) {
        System.out.println("reached here");
        System.out.println(activityService.findByName(name));

        return activityService.findByName(name);
    }

    /**
     *
     * @param activities add activity
     */
    @PostMapping(value = "/addActivity")
    @ResponseStatus(HttpStatus.OK)
    public void createActivity(@RequestBody NagpActivities activities) {



        logger.info("batch id is="+activities.getBatch().getId());

        activityService.addActivity(activities);


    }

    /**
     *
     * @param pageno a integer for getting a list of paginated results
     * @return a paginated result.
     */

    @GetMapping("/activities/{pageno}")
    public Page<NagpActivities> getActivities(@PathVariable("pageno") int pageno) {
        return activityService.getActivities(pageno);
    }
@PostMapping("/activities")
@ResponseStatus(HttpStatus.OK)
public Iterable<NagpActivities> getActivities() {
logger.info("getting activities");
return this.activityService.getActivities();

    }

}
