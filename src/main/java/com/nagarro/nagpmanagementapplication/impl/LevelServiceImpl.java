package com.nagarro.nagpmanagementapplication.impl;

import com.nagarro.nagpmanagementapplication.entity.Levels;
import com.nagarro.nagpmanagementapplication.repository.LevelRepository;
import com.nagarro.nagpmanagementapplication.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("levelService")
public class LevelServiceImpl implements  LevelService {
    @Autowired
    private LevelRepository levelRepository;


    public void createLevel(Levels level)
    {

        levelRepository.save(level);
    }

    public List<Levels> getLevels()
    {

       return levelRepository.findAll();
    }


}
