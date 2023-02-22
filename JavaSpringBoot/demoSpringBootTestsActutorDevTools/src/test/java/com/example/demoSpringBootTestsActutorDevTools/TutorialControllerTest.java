package com.example.demoSpringBootTestsActutorDevTools;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TutorialController.class)
class TutorialControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TutorialService tutorialService;
    @Test
    void getAllTutorials() throws Exception {
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1l, "title 1", "description 1", true));

        when(tutorialService.findAll()).thenReturn(tutorials);

        mockMvc.perform(get("/api/tutorials"))
                .andExpect(status().isOk());
    }

    @Test
    void getTutorialsById() throws Exception {
        Tutorial tutorial = new Tutorial(1l, "title 1", "description 1", true);
        when(tutorialService.findById(1l)).thenReturn(tutorial);

        mockMvc.perform(get("/api/tutorials/1"))
                .andExpect(status().isOk());
               }

    @Test
    void createTutorial() throws Exception {
        Tutorial tutorial = new Tutorial(2l, "Title 1", "Description 1", true);
        Tutorial savedTutorial = new Tutorial(1L, "Title 1", "Description 1", true);
        when(tutorialService.saveTutorial(tutorial)).thenReturn(savedTutorial);

        mockMvc.perform(post("/api/tutorials")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\":\"Title 1\",\"description\":\"Description 1\",\"published\":true}"))
                .andExpect(status().isCreated());
    }

    @Test
    void updateTutorial() throws Exception {
        Tutorial tutorial = new Tutorial(1l, "Title 1", "Description 1", true);
        Tutorial updatedTutorial = new Tutorial(1l, "Updated Title", "Updated Description", false);
        when(tutorialService.findById(1l)).thenReturn(tutorial);
        when(tutorialService.saveTutorial(updatedTutorial)).thenReturn(updatedTutorial);

        mockMvc.perform(put("/api/tutorials/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"Updated Title\",\"description\":\"Updated Description\",\"published\":false}"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTutorial() throws Exception {
        doNothing().when(tutorialService).deleteById(1L);

        mockMvc.perform(delete("/api/tutorials/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteAllTutorials() throws Exception {
        doNothing().when(tutorialService).deleteAll();

        mockMvc.perform(delete("/api/tutorials"))
                .andExpect(status().isNoContent());
    }

    @Test
    void findByPublished() throws Exception {
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1L, "Title 1", "Description 1", true));
        when(tutorialService.findByPublished(true)).thenReturn(tutorials);

        mockMvc.perform(get("/api/tutorials/published"))
                .andExpect(status().isOk());
    }
}