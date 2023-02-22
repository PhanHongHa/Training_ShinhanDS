package com.example.demoSpringBootTestsActutorDevTools;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.function.Supplier;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TutorialRepositoryTest {

    @Mock
    private Tutorial tutorial;
    @Autowired
    private TutorialRepository tutorialRepository;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByPublished() {
        List<Tutorial> findByPublished = tutorialRepository.findByPublished(true);
        assertFalse(tutorial.isPublished(), findByPublished.toString());
    }

    @Test
    void findByTitleContaining() {
        List<Tutorial> findByTitleContaining = tutorialRepository.findByTitleContaining("alo");
        findByTitleContaining.forEach(t ->
                Assertions.assertThat(t.getTitle()).containsIgnoringCase("alo")
        );
    }
}