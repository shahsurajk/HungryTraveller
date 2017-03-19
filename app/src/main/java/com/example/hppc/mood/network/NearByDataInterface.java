package com.example.hppc.mood.network;

import com.example.hppc.mood.model.NearByDataRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by madscientist on 19/3/17.
 */

public interface NearByDataInterface {

    @GET("search?ll=19.1107643,72.8456398&categoryId={catID}&client_id=LBG00343EKHRRU4OC3TD45M1PBTYL11DP4OUML1PXX5OP3YK&client_secret=IAIU0OTNIXBAKBUVF2LWZ1NOD5QIK5QBUVGHDBAKYMH1MHJS&v=20170319")
    Call<NearByDataRoot>getNearByDataRootCall(@Path("catID") String catID);
}
