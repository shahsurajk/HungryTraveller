package com.example.hppc.mood.model;

import java.util.List;

/**
 * Created by madscientist on 19/3/17.
 */

public class Response {

   private List<NearByData> venues;

    public List<NearByData> getVenues() {
        return venues;
    }

    public void setVenues(List<NearByData> venues) {
        this.venues = venues;
    }
}
