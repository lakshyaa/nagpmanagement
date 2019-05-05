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

    Logger logger = Logger.getLogger(BatchController.class.getName());

    /**
     *
     * @param batch info of new batch.
     */
    @PostMapping(value = "/batch")
    @ResponseStatus(HttpStatus.OK)
    public void createBatch(@RequestBody Batch batch) {

        System.out.println("adding batch");
        batchService.addBatch(batch);
    }

    /**
     *
     * @return get all batches .
     */
    @RequestMapping(value = "/batch")
    @ResponseStatus(HttpStatus.OK)
    public List<Batch> getBatch() {
        return batchService.getBatches();
    }

    /**
     * updated batch information.
     */
    @PostMapping(value = "/updatebatch")
    @ResponseStatus(HttpStatus.OK)
    public void updateBatch(@RequestBody Batch batch) {
        logger.info("id is=" + batch.getId());

        logger.info(" " + batch.getDescription() + " " + batch.getQualificationPoints() + " " + batch.getStartDate() + " " + batch.getTechnology() + " " + batch.getYear() + " ");


//logger.info(startDate.toString());
        batchService.updateBatch(batch);
    }

    /**
     *
     * @param id of the batch
     * @return if batch found with that id return that batch or returns null.
     */
    @GetMapping(value = "batch/{id}")
    public Batch getBatchById(@PathVariable("id") int id) {
        return batchService.getBatchById(id);
    }

    /**
     *
     * @param newBatch updated batch info.
     * @param id of the batch.
     */
    @PutMapping(value = "/batch/{id}")
    public void updateBatch(@RequestBody Batch newBatch, @PathVariable("id") int id) {
        System.out.println("In update of batch called ");

        logger.info(newBatch.getDescription()+" "+newBatch.getTechnology()+""+newBatch.getQualificationPoints());
        batchService.updateBatch(id, newBatch);


    }
}