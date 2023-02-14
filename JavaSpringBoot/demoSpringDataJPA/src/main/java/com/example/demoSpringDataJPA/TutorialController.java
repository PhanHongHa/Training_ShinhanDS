package com.example.demoSpringDataJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TutorialController {
    @Autowired
    private TutorialService tutorialService;

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title){

        List<Tutorial> tutorials =new ArrayList<Tutorial>();
        if (title == null)
            tutorials = tutorialService.findAll();
        else
            tutorials = tutorialService.findByTitleContaining(title);
        if(tutorials.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }

    @GetMapping("tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id){
        Tutorial tutorial = tutorialService.findById(id);
        if(tutorial !=null){
            return new ResponseEntity<>(tutorial, HttpStatus.OK);

        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/tutorials")
    public  ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
       try {
           Tutorial tutorial1 = new Tutorial();
           tutorial1.setTitle(tutorial.getTitle());
           tutorial1.setDescription(tutorial.getDescription());
           tutorial1.setPublished(tutorial.isPublished());

           Tutorial _tuTutorial = tutorialService.saveTutorial(tutorial1);
           return new ResponseEntity<>(_tuTutorial, HttpStatus.CREATED);
       }catch (Exception e) {
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @PutMapping("/tutorial/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial){
        Tutorial _tuTutorial = tutorialService.findById(id);
        if(_tuTutorial != null){
            _tuTutorial.setTitle(tutorial.getTitle());
            _tuTutorial.setPublished(tutorial.isPublished());
            _tuTutorial.setDescription(tutorial.getDescription());
            return new ResponseEntity<>(tutorialService.saveTutorial(_tuTutorial), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("tutorials/{id}")
    public ResponseEntity<Tutorial> deleteTutorial(@PathVariable("id") long id){
        try{
            tutorialService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/tutorial")
    public ResponseEntity<HttpStatus> deleteAllTutorials(){
        try{
            tutorialService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished(){
        try{
            List<Tutorial> tutorials = tutorialService.findByPublished(true);
            if(tutorials.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
