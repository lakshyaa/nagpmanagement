package com.nagarro.nagpmanagementapplication.service;

import com.nagarro.nagpmanagementapplication.entity.Batch;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BatchService {



    public void addBatch(Batch batch);

    public  void updateBatch(Batch batch);
    public List<Batch> getBatches();
    public Batch getBatchById(@PathVariable("id") int  id);
    public void updateBatch(int id, Batch newBatch);



    }
