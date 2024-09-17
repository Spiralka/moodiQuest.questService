package com.example.questService.controller;

import com.example.questModel.Quest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quests")
public class QuestController {

    @GetMapping("random")
    public Quest getRandomQuest() {
        System.out.println("Get random quest");
        return null;
    }

}
