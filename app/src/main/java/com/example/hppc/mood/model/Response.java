package com.example.hppc.mood.model;

import java.util.List;

/**
 * Created by madscientist on 19/3/17.
 */

class Response {

   private List<NearByData>nearByDataList;

    public List<NearByData> getNearByDataList() {
        return nearByDataList;
    }

    public void setNearByDataList(List<NearByData> nearByDataList) {
        this.nearByDataList = nearByDataList;
    }
}
