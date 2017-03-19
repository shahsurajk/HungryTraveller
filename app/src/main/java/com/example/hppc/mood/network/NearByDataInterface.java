package com.example.hppc.mood.network;

import com.example.hppc.mood.model.NearByDataRoot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by madscientist on 19/3/17.
 */

public interface NearByDataInterface {

    @GET("search")
    Call<NearByDataRoot>getNearByDataRootCall(@Query("ll")String latLong,@Query("categoryId") String catID, @Query("client_id")
            String client_id, @Query("client_secret")String client_secret , @Query("v")String v);
}
