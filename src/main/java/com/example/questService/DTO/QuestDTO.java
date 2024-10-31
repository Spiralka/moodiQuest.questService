package com.example.questService.DTO;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestDTO implements Serializable {

    private long id;
    private String shortName;
    private String description;
    private int progressNumber;
}
