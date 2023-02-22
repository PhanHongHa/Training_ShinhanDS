package com.example.demoSpringBootTestsActutorDevTools;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TutorialServiceImplTest {
    @Mock
    private TutorialRepository tutorialRepository;
    @InjectMocks
    private TutorialServiceImpl tutorialService;

    @BeforeEach
    void setUp() {    }

    @AfterEach
    void tearDown() {   }
    @Test
    void findAll() {
        tutorialService.findAll();
        verify(tutorialRepository).findAll();
    }

    @Test
    void findByTitleContaining() {
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1l, "test", "test", true));

        when(tutorialRepository.findByTitleContaining("this")).thenReturn(tutorials);

        assertThat(tutorialService.findByTitleContaining("this")).isNotNull();
    }
    @Test
    void findById() {
        when(tutorialRepository.findById(1l))
                .thenReturn(Optional.of(new Tutorial(1l, "title", "description", true)));
        assertThat(tutorialService.findById(1l).getId()).isEqualTo(1l);
    }

    @Test
    void deleteById() {
        tutorialService.deleteById(1l);
        verify(tutorialRepository).deleteById(1l);
    }

    @Test
    void deleteAll() {
        tutorialService.deleteAll();
        verify(tutorialRepository).deleteAll();
    }

    @Test
    void findByPublished() {
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1l, "test2", "test2", true));

        when(tutorialRepository.findByPublished(true)).thenReturn(tutorials);
        List<Tutorial> returnedTutorials = tutorialService.findByPublished(true);

        assertThat(returnedTutorials.get(0).getId()).isEqualTo(1l);
    }

    @Test
    void saveTutorial() {
        Tutorial tutorial = new Tutorial(2,"title2","description2",true);
        tutorialService.saveTutorial(tutorial);
        ArgumentCaptor<Tutorial> tutorialArgumentCaptor = ArgumentCaptor.forClass(Tutorial.class);
        verify(tutorialRepository).save(tutorialArgumentCaptor.capture());
        Tutorial tutorialCapture = tutorialArgumentCaptor.getValue();
        assertThat(tutorialCapture).isEqualTo(tutorial);
    }
}