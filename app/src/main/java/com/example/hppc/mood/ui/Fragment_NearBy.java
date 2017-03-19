package com.example.hppc.mood.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hppc.mood.R;
import com.example.hppc.mood.model.NearByDataRoot;
import com.example.hppc.mood.network.ApiClient;
import com.example.hppc.mood.network.NearByDataInterface;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

import static com.example.hppc.mood.ui.Fragment_NearBy.ChildFragments.*;

/**
 * Created by madscientist on 19/3/17.
 */

public class Fragment_NearBy extends Fragment {

    private static final String KEY_CHILD_TYPE = "type";

    private List<NearByDataRoot>  nearByDataRootList = new ArrayList<>();
    public static Fragment_NearBy getInstance(int childType) {
        Fragment_NearBy fragment= new Fragment_NearBy();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_CHILD_TYPE, childType);
        return fragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int type  = getArguments().getInt(KEY_CHILD_TYPE,1);
        loadDataBaseOnType(type);
    }
    private void loadDataBaseOnType(int type){
//        todo
//   if -> lat long-> ll
//        else -> near=mumbai
       final String url ="";
        String categoryID = "";
        switch (type){
            case RESTAURENTS:
               categoryID="4d4b7105d754a06374d81259";
                break;
            case ARTS_ENTERTAINMENT:
                categoryID="4d4b7104d754a06370d81259";
                break;
            case EVENTS:
                categoryID ="4d4b7105d754a06373d81259";
                break;
            case PLACES:
                categoryID ="4d4b7105d754a06379d81259";
                break;
            case SHOPS:
                categoryID = "4d4b7105d754a06378d81259";
                break;
        }
        NearByDataInterface dataInterface = ApiClient.getClient().create(NearByDataInterface.class);

        Call<NearByDataRoot>nearByDataRootCall  = dataInterface.getNearByDataRootCall(categoryID);
        nearByDataRootCall.enqueue(new Callback<NearByDataRoot>() {
            @Override
            public void onResponse(Call<NearByDataRoot> call, Response<NearByDataRoot> response) {
                nearByDataRootList.addAll((Collection<? extends NearByDataRoot>) response.body ());
            }

            @Override
            public void onFailure(Call<NearByDataRoot> call, Throwable t) {

            }
        });
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nearby,container,false);
    }

    public static final class ChildFragments{
        public static final int ALL=0;
        public static final int RESTAURENTS= 1;
        public static final int SHOPS=2;
        public static final int ARTS_ENTERTAINMENT =3;
        public static final int EVENTS=4;
        public static final int PLACES=5;
    }
}
