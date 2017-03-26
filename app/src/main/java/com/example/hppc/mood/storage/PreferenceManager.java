package com.example.hppc.mood.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * Created by madscientist on 26/3/17.
 */

public class PreferenceManager {

    public static final String PREF_NAME ="com.mood.prefs";

    public static final String KEY_CITY_SELECTED = "city_selected";
    public static final String KEY_LOCATION_LAT = "location_lat";
    public static final String KEY_LOCATION_LONG = "location_long";

    private SharedPreferences prefs ;
    private PreferenceManager(Context context){
        prefs = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
    }
    private static PreferenceManager instance;

    public synchronized static void initiaileInstance(Context context){
        if (instance == null) {
            instance = new PreferenceManager(context);
        }
    }
    public void setLatLong (String latValue,String longValue ){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_LOCATION_LAT,latValue);
        editor.putString(KEY_LOCATION_LONG,longValue);
        editor.apply();
    }
    public String getCityName(){
        return prefs.getString(KEY_CITY_SELECTED,"");
    }
    public void setCityName(String cityName){
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_CITY_SELECTED,cityName);
        editor.apply();
    }
    public String[]getLatLong (){
        if (!TextUtils.isEmpty(prefs.getString(KEY_LOCATION_LAT,"")))
            return new String[]{prefs.getString(KEY_LOCATION_LAT,""),prefs.getString(KEY_LOCATION_LONG,"")};
        else
            return new String[]{};
    }
    public static PreferenceManager getInstance(){
        if (instance==null){
            throw new IllegalStateException(PreferenceManager.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return instance;
    }
}
