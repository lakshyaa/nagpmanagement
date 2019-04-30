package com.nagarro.nagpmanagementapplication.controllers;

import com.nagarro.nagpmanagementapplication.entity.Levels;
import com.nagarro.nagpmanagementapplication.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class LevelController {

@Autowired
private LevelService levelService;
    @PostMapping(value= "/level")
    @ResponseStatus(HttpStatus.OK)
    public void createLevel(@RequestBody Levels level)
    {
        System.out.println("adding level");
        levelService.createLevel(level);

    }

    @GetMapping(value= "/level")
    public List<Levels> getLevel(){

      //  System.out.println("activity name is"+levelService.getLevels().get(0).getNagpActivities());

        return levelService.getLevels();

    }




}
