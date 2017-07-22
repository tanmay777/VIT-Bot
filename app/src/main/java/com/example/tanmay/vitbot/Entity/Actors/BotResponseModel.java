package com.example.tanmay.vitbot.Entity.Actors;

/**
 * Created by tanmay on 22/07/17.
 */

public class BotResponseModel {
    String response;
    String time;

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {

        return time;
    }

    public BotResponseModel(String response, String time) {
        this.response = response;
        this.time = time;
    }

    public BotResponseModel(String response) {
        this.response = response;
    }

    public void setResponse(String response) {

        this.response = response;
    }

    public String getResponse() {

        return response;
    }
}
