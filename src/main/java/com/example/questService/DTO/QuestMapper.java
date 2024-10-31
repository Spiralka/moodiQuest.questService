package com.example.questService.DTO;

import com.example.questModel.Quest;
import com.example.questModel.UserSuggestedQuest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface QuestMapper {

    QuestMapper INSTANCE = Mappers.getMapper(QuestMapper.class);

    QuestDTO questToQuestDTO(Quest quest);

    Quest questDTOToQuest(QuestDTO questDTO);

    SuggestedQuestDTO userSuggestedQuestToSuggestedQuestDTO(UserSuggestedQuest userSuggestedQuest);

    UserSuggestedQuest suggestedQuestDTOToUserSuggestedQuest(SuggestedQuestDTO suggestedQuestDTO);
}