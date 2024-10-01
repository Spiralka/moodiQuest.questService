package com.example.questService.controller;

import com.example.questModel.Quest;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quests")
public class QuestController {

    private final AmqpTemplate rabbitTemplate;

    @Autowired
    public QuestController(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    @GetMapping("daily")
    public List<Quest> getDailyQuests() {
        System.out.println("Requesting daily quests");
        // Отправляем запрос на очередь и ожидаем ответ
        List<Quest> dailyQuests = (List<Quest>) rabbitTemplate.convertSendAndReceive("questExchange", "questRequestQueue", "");
        return dailyQuests;
    }

    @GetMapping("{id}")
    public Quest getQuestById(@PathVariable Long id) {
        System.out.println("Requesting quest by id: " + id);
        // Отправляем запрос с идентификатором и ожидаем ответ
        Quest quest = (Quest) rabbitTemplate.convertSendAndReceive("questExchange", "questByIdQueue", id);
        return quest;
    }

    @GetMapping("random")
    public Quest getRandomQuest() {
        System.out.println("Requesting random quest");
        // Отправляем запрос на случайное задание и ожидаем ответ
        Quest randomQuest = (Quest) rabbitTemplate.convertSendAndReceive("questExchange", "questRandomQueue", "");
        return randomQuest;
    }
}
