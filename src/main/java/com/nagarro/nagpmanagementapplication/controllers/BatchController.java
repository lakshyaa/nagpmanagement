package com.nagarro.nagpmanagementapplication.controllers;

import com.nagarro.nagpmanagementapplication.entity.Batch;
import com.nagarro.nagpmanagementapplication.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class BatchController {

@Autowired
private BatchService batchService;


    @PostMapping (value="/addBatch")
    @ResponseStatus(HttpStatus.OK)
    public void createBatch(@RequestBody Batch batch)
    {

        System.out.println("adding batch");
        batchService.addBatch(batch);
    }

}
