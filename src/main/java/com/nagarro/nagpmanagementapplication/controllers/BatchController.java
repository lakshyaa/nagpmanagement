package com.nagarro.nagpmanagementapplication.controllers;

import com.nagarro.nagpmanagementapplication.entity.Batch;
import com.nagarro.nagpmanagementapplication.service.BatchService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class BatchController {

@Autowired
private BatchService batchService;

Logger logger= Logger.getLogger(BatchController.class.getName());

    @PostMapping (value="/addbatch")
    @ResponseStatus(HttpStatus.OK)
    public void createBatch(@RequestBody Batch batch)
    {

        System.out.println("adding batch");
        batchService.addBatch(batch);
    }
    @RequestMapping(value="/batches")
    @ResponseStatus(HttpStatus.OK)
    public List<Batch> getBatch()
    {
return batchService.getBatches();
    }

@PostMapping(value="/batches")
@ResponseStatus(HttpStatus.OK)
public  void updateBatch(@RequestBody Batch batch)
{logger.info("id is="+batch.getId());

logger.info(" "+batch.getDescription()+" "+batch.getQualificationPoints()+" "+batch.getStartDate()+" "+batch.getTechnology()+" "+batch.getYear()+" ");



//logger.info(startDate.toString());
    batchService.updateBatch(batch);
}
}
