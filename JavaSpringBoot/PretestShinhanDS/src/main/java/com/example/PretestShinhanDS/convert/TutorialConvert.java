package com.example.PretestShinhanDS.convert;

import com.example.PretestShinhanDS.dto.TutorialDto;
import com.example.PretestShinhanDS.entity.Tutorial;
import org.springframework.stereotype.Component;

@Component
public class TutorialConvert {
    public Tutorial dtoToEntity(TutorialDto tutorialDto){
        Tutorial tutorial = new Tutorial();
        if(tutorialDto.getId()!= 0){
            tutorial.setId(tutorial.getId());
        }
        tutorial.setTitle(tutorialDto.getTitle());
        tutorial.setDescription(tutorialDto.getDescription());
        tutorial.setPublished(tutorialDto.isPublished());
        return tutorial;
    }

    public TutorialDto entityToDto(Tutorial tutorial){
        TutorialDto tutorialDto = new TutorialDto();
        if (tutorial.getId() != 0){
            tutorialDto.setId(tutorial.getId());
        }
        tutorialDto.setTitle(tutorial.getTitle());
        tutorialDto.setDescription(tutorial.getDescription());
        tutorialDto.setPublished(tutorial.isPublished());
        return tutorialDto;
    }


}
