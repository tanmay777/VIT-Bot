package com.example.tanmay.vitbot.Boundary.API;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.tanmay.vitbot.Boundary.Handlers.AppController;
import com.example.tanmay.vitbot.Control.Contracts.APIContract;
import com.example.tanmay.vitbot.Entity.Actors.BotResponseModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tanmay on 22/07/17.
 */

public class ConnectAPI {

    //Constants
    public static final String TAG=ConnectAPI.class.getSimpleName();

    private AppController appController;
    Context context;

    List<BotResponseModel> botResponseList;
    String botResponse;

    /**
     * Constructor for ConnectAPI
     * Inititalize all class attributes here.
     */

    public ConnectAPI(Context context){
        appController=AppController.getInstance();
        this.context=context;
    }

    public List botRequestInitial(){
        String url= APIContract.getBotPreviousRequestUrl();
        StringRequest getRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v(TAG, "Bot Response list: " + response);
                try {
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();
                    List<BotResponseModel> botResponseList = new ArrayList<BotResponseModel>();
                    botResponseList = Arrays.asList(gson.fromJson(response, BotResponseModel.class));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        return botResponseList;
    }

    public String botRequest(String request){
        String url= APIContract.getBotRequestUrl();
        StringRequest getRequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.v(TAG, "Bot Response: " + response);
                botResponse=response;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
    return botResponse;
    }

}
