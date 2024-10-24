package com.example.questModel;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserSuggestedQuest implements Serializable {


    @JsonProperty("userName")
    private String userName;
    @JsonProperty("quest")
    private String quest;

    public UserSuggestedQuest() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

}
