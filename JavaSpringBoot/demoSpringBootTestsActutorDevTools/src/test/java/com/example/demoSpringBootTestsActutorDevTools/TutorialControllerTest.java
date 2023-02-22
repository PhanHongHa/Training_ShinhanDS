package com.example.demoSpringBootTestsActutorDevTools;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
        this.mockMvc.perform(get("/tutorials")).andDo(print()).andExpect(status().isOk());
    }
}