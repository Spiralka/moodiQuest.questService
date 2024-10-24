package com.example.questService.controller;

import com.example.questModel.Quest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "main-methods")
@RestController
@RequestMapping("/quests")
public class QuestController {

    private final AmqpTemplate rabbitTemplate;

    @Autowired
    public QuestController(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Operation(
            summary = "Возвращает три случайных квеста из БД",
            description = "Этот метод возвращает три случайных квеста, которые были выбраны из базы данных. " +
                    "Эти квесты обновляются ежедневно и могут быть использованы для выполнения в течение дня." +
                    "Ответ кэшируется в Redis на 1 минуту "
    )
    @GetMapping("/daily")
    @Cacheable(value = "dailyQuests")
    public List<Quest> getDailyQuests() {
        System.out.println("Получение ежедневных квестов из RabbitMQ");
        return (List<Quest>) rabbitTemplate.convertSendAndReceive("questExchange", "dailyQuests", "");
    }


    @Operation(
            summary = "Попытка сделать кофе",
            description = "Эндпоинт возвращает HTTP статус 418 (I'm a teapot) с сообщением о том, что сервер — это чайник и не может приготовить кофе."
    )
    @GetMapping("/makeCoffee")
    public ResponseEntity<String> makeCoffee() {
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("I'm a teapot, I cannot make coffee");
    }


    @Operation(
            summary = "Получить квест по ID",
            description = "Возвращает квест из базы данных по указанному идентификатору. ID передается в запросе как путь параметра."
    )
    @GetMapping("{id}")
    public Quest getQuestById(@PathVariable Long id) {
        System.out.println("Requesting quest by id: " + id);
        Quest quest = (Quest) rabbitTemplate.convertSendAndReceive("questExchange", "questById", id);
        return quest;
    }

    @Operation(
            summary = "Получить случайный квест",
            description = "Возвращает случайный квест из базы данных."
    )
    @GetMapping("random")
    public Quest getRandomQuest() {
        System.out.println("Requesting random quest");
        Quest randomQuest = (Quest) rabbitTemplate.convertSendAndReceive("questExchange", "randomQuest", "");
        return randomQuest;
    }
}
