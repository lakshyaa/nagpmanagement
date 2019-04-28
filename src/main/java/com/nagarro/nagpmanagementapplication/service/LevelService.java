package com.nagarro.nagpmanagementapplication.service;

import com.nagarro.nagpmanagementapplication.entity.Levels;

import java.util.List;

public interface LevelService {


    public void createLevel(Levels levels);

    public List<Levels> getLevels();

}
