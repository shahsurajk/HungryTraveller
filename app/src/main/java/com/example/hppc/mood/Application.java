package com.example.hppc.mood;

import com.example.hppc.mood.network.VolleyManager;

/**
 * Created by madscientist on 19/3/17.
 */

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        VolleyManager.initializeInstance(this);
    }
}
