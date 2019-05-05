package com.nagarro.nagpmanagementapplication.impl;

import com.nagarro.nagpmanagementapplication.entity.Batch;
import com.nagarro.nagpmanagementapplication.repository.BatchRepository;
import com.nagarro.nagpmanagementapplication.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.ServiceMode;
import java.util.List;
import java.util.logging.Logger;

@Service("batchService")
public class BatchServiceImpl implements BatchService {
    @Autowired
    private BatchRepository batchRepository;
    Logger logger = Logger.getLogger(Batch.class.getName());


    public void addBatch(Batch batch) {

        batchRepository.save(batch);
    }

    public List<Batch> getBatches() {
        logger.info("GETTING Batches");
        System.out.println(batchRepository.findAll().get(0).getNagpActivities().get(0).getActivityName());
        return batchRepository.findAll();
    }

    public void updateBatch(Batch batch) {
        logger.info(" " + batch.getDescription() + " " + batch.getQualificationPoints() + " " + batch.getStartDate() + " " + batch.getTechnology() + " " + batch.getYear() + " ");
        batchRepository.save(batch);

        //batchRepository.updateBatch();


    }

    public Batch getBatchById(@PathVariable("id") int id) {


       return batchRepository.findById(id).get();
}

    public void updateBatch(int id, Batch newBatch) {
        // TODO Auto-generated method stub

        logger.info("updating batch in batch service");
        System.out.println("in update batch");
        Batch old=batchRepository.getOne(id);
        if(old!=null)
        {
            newBatch.setId(old.getId());
            newBatch.setStartDate(old.getStartDate());
            batchRepository.save(newBatch);
        }
        else {
            System.out.println("Error ");
        }

    }




}
