package com.example.demoSpringBootTestsActutorDevTools;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TutorialServiceImplTest {
    @Mock
    private TutorialRepository tutorialRepository;
    @InjectMocks
    private TutorialServiceImpl tutorialService;


    @Test
    void findAll() {
        tutorialService.findAll();
        verify(tutorialRepository).findAll();
    }

    @Test
    void findById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void saveTutorial() {
        Tutorial tutorial = new Tutorial(2,"blo","clo",true);
        tutorialService.saveTutorial(tutorial);
        ArgumentCaptor<Tutorial> tutorialArgumentCaptor = ArgumentCaptor.forClass(Tutorial.class);
        verify(tutorialRepository).save(tutorialArgumentCaptor.capture());
        Tutorial tutorialCapture = tutorialArgumentCaptor.getValue();
        assertThat(tutorialCapture).isEqualTo(tutorial);
    }
}