package com.example.demoSpringDataJPA;

import java.util.List;

public interface TutorialService {
    List<Tutorial> findAll();
    List<Tutorial> findByTitleContaining(String title);
    Tutorial findById(long id);
    void deleteById(long id);
    void deleteAll();
    List<Tutorial> findByPublished(boolean b);
    Tutorial saveTutorial(Tutorial tutorial);
}
