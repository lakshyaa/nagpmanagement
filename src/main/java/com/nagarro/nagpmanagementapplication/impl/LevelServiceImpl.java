package com.nagarro.nagpmanagementapplication.impl;

import com.nagarro.nagpmanagementapplication.entity.Batch;
import com.nagarro.nagpmanagementapplication.entity.Levels;
import com.nagarro.nagpmanagementapplication.repository.LevelRepository;
import com.nagarro.nagpmanagementapplication.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service("levelService")
public class LevelServiceImpl implements  LevelService {
    @Autowired
    private LevelRepository levelRepository;
    private Logger logger= Logger.getLogger(LevelServiceImpl.class.getName());



    public void createLevel(Levels level)
    {

        levelRepository.save(level);
    }

    public List<Levels> getLevels()
    {

       return levelRepository.findAll();
    }

    public Levels getLevelById(int id)
    {
        logger.info("inside levelservice implementaion id of level is="+id);

        return levelRepository.findById(id).get();
    }

    public void updateLevel(int id, Levels newlevel) {
        // TODO Auto-generated method stub

        logger.info("updating batch in batch service");
        System.out.println("in update batch");
        Levels old=levelRepository.getOne(id);
        if(old!=null)
        {
            newlevel.setId(old.getId());
            old.setDescription(newlevel.getDescription());
            old.setName(newlevel.getName());
            old.setQualificationPoints(newlevel.getQualificationPoints());

            levelRepository.save(newlevel);
        }
        else {
            System.out.println("Error ");
        }

    }


}
