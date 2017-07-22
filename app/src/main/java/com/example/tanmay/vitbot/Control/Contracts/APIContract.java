package com.example.tanmay.vitbot.Control.Contracts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tanmay on 22/07/17.
 */

public class APIContract {
    //TODO: TO BE UPDATED.
    public static String BOT_PREVIOUS_REQUEST_URL="";
    public static String BOT_REQUEST_URL="";

    public static String getBotPreviousRequestUrl() {
        return BOT_PREVIOUS_REQUEST_URL;
    }

    public static String getBotRequestUrl() {
        return BOT_REQUEST_URL;
    }
}
/*
This wouldn't be required I guess.
    public static Map<String,String> getBotParams(String request){
        Map<String,String> map=new HashMap<>();
        map.put("request",request);
        return map;
    }
    */
