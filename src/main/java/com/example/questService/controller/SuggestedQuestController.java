package com.example.questService.controller;

import com.example.questModel.UserSuggestedQuest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "suggestion-methods")
@RestController
@RequestMapping("/suggestMe")
public class SuggestedQuestController {

    private final AmqpTemplate rabbitTemplate;
    private static final Logger logger = LoggerFactory.getLogger(SuggestedQuestController.class);
    @Autowired
    public SuggestedQuestController(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Operation(summary = "Получение всех предложенных квестов", description = "Возвращает список всех предложенных квестов, сохраненных в базе данных через RabbitMQ.")
    @GetMapping("/all")
    public List<UserSuggestedQuest> getAllSuggestedQuests() {
        logger.info("Getting all suggested quests MongoDB");
        return (List<UserSuggestedQuest>) rabbitTemplate.convertSendAndReceive("questQueueNoSql", "getAllQuestNoSqlQueue", "");
    }

    @Operation(summary = "Загрузка предложенного квеста", description = "Сохраняет новый предложенный квест в базе данных через RabbitMQ и возвращает его.")
    @PostMapping(value = "/load")
    public UserSuggestedQuest loadSuggestedQuests(@RequestBody UserSuggestedQuest userSuggestedQuest) {
        logger.info("Load suggested quests MongoDB : {}", userSuggestedQuest);
        rabbitTemplate.convertAndSend("questQueueNoSql", "saveQuestNoSqlQueue", userSuggestedQuest);
        return userSuggestedQuest;
    }

}
