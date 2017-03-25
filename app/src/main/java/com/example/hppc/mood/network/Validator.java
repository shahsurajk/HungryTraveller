package com.example.hppc.mood.network;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by frapp on 25/3/17.
 */

public class Validator {
    public static boolean isOnline (Context context) {
        boolean result = false;
        try {
            if (context != null) {
                ConnectivityManager cm = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo netInfo = cm.getActiveNetworkInfo();
                result = netInfo != null && netInfo.isConnectedOrConnecting();
                if (!result) {
                    Toast.makeText(context,"No internet connection found! Try again!",Toast.LENGTH_LONG).show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
}
