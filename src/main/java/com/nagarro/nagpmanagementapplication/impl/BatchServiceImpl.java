package com.nagarro.nagpmanagementapplication.impl;

import com.nagarro.nagpmanagementapplication.entity.Batch;
import com.nagarro.nagpmanagementapplication.repository.BatchRepository;
import com.nagarro.nagpmanagementapplication.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

@Service("batchService")
public class BatchServiceImpl implements BatchService {
    @Autowired
    private BatchRepository batchRepository;

    public void addBatch(Batch batch)
    {

        batchRepository.save(batch);
    }




}
