package com.example.myapplication;

import java.util.ArrayList;

public class item {

    public  String description;
    public  String id;
    public  String name;
    public  String punishment;
    public  String reward;


    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPunishment() {
        return punishment;
    }

    public String getReward() {
        return reward;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

}
