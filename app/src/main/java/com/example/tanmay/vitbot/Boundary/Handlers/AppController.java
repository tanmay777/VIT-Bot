package com.example.tanmay.vitbot.Boundary.Handlers;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by tanmay on 22/07/17.
 */

public class AppController extends Application {
    public static final String TAG=AppController.class.getSimpleName();
    private RequestQueue mRequestQueue;

    private static AppController mInstance;

    @Override
    public void onCreate()
    {
        super.onCreate();
        mInstance=this;
    }

    public static synchronized AppController getInstance(){
        return mInstance;
    }

    /*
    If thread A tries to enter synchronized(foo) {...} while
    thread B already has foo locked (either in the same synchronized block,
    or in a different one), then thread A will be forced to wait until
    thread B releases the lock.
    */

    public RequestQueue getRequestQueue(){
        if(mRequestQueue==null)
        {
            mRequestQueue= Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req,String tag){
        req.setTag(TextUtils.isEmpty(tag)?TAG:tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req){
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag){
        if(mRequestQueue!=null){
            mRequestQueue.cancelAll(tag);
        }
    }
}
