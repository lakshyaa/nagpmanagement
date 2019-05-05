package com.nagarro.nagpmanagementapplication.controllers;

import com.nagarro.nagpmanagementapplication.entity.Batch;
import com.nagarro.nagpmanagementapplication.entity.Levels;
import com.nagarro.nagpmanagementapplication.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class LevelController {

@Autowired
private LevelService levelService;

    private Logger logger=Logger.getLogger(LevelController.class.getName());

    /**
     *
     * @param level info of new level to create a new level. .
     */
    @PostMapping(value= "/level")
    @ResponseStatus(HttpStatus.OK)
    public void createLevel(@RequestBody Levels level)
    {
        System.out.println("adding level");
        levelService.createLevel(level);

    }

    /**
     *
     * @return get all levels
     */

    @GetMapping(value= "/level")
    public List<Levels> getLevel(){

      //  System.out.println("activity name is"+levelService.getLevels().get(0).getNagpActivities());

        return levelService.getLevels();

    }

    /**
     *
     * @param id of the level.
     * @return level belong to the id.
     */
    @GetMapping(value="/levelbyid/{id}")
    public Levels getLevel(@PathVariable("id") int id)
    {
logger.info("inside level Controller getting level id is="+id);

        return levelService.getLevelById(id);

    }

    /**
     *
     * @param newLevel updated new level info.
     * @param id of the existing level.
     */
    @PutMapping(value = "/levelupdate/{id}")
    public void updateLevel(@RequestBody Levels newLevel, @PathVariable("id") int id) {
        System.out.println("In update of level called ");

        logger.info(newLevel.getDescription() + " " + newLevel.getName() + "" + newLevel.getQualificationPoints());
        levelService.updateLevel(id, newLevel);


    }




    }
