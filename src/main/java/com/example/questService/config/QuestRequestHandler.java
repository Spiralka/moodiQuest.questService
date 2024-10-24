//package com.example.questService.config;
//import com.example.questModel.Quest;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class QuestRequestHandler {
//
//    public Quest handleQuestRequest(Long id) {
//        // Логика получения квеста по ID
//        Quest quest = findQuestById(id); // Метод для поиска квеста
//        return quest;
//    }
//
//    private Quest findQuestById(Long id) {
//        // Поиск квеста в базе данных или другом источнике
//        System.out.println("Получение квеста по ID: " + id);
//        // Возвращаем заглушку для примера
//        return new Quest(id, "Название квеста", "Описание квеста", 4);
//    }
//}
