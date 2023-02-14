package com.example.PretestShinhanDS.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TutorialDto {
    private long id;
    private String title;
    private String description;
    private boolean published;
}
