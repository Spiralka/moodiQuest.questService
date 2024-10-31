package com.example.questService.DTO;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuggestedQuestDTO implements Serializable {

    private String userName;
    private String quest;
}
