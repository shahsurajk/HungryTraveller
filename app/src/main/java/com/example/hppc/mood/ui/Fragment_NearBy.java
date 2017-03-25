package com.example.hppc.mood.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.example.hppc.mood.R;
import com.example.hppc.mood.adapter.NearByAdapter;
import com.example.hppc.mood.model.NearByData;
import com.example.hppc.mood.model.NearByDataRoot;
import com.example.hppc.mood.network.ApiClient;
import com.example.hppc.mood.network.JacksonRequest;
import com.example.hppc.mood.network.Mapper;
import com.example.hppc.mood.network.NearByDataInterface;
import com.example.hppc.mood.network.Validator;
import com.example.hppc.mood.network.VolleyManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.hppc.mood.ui.Fragment_NearBy.ChildFragments.*;



public class Fragment_NearBy extends Fragment {

    private static final String KEY_CHILD_TYPE = "type";
    private RecyclerView recyclerView;
    private NearByAdapter nearByAdapter;
    private ProgressBar progressBar;

    private NearByDataRoot nearByDataRoot;
    private List<NearByData>nearByDataList=new ArrayList<>();
    public static Fragment_NearBy getInstance(int childType) {
        Fragment_NearBy fragment= new Fragment_NearBy();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_CHILD_TYPE, childType);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nearByAdapter = new NearByAdapter(getContext(),nearByDataList);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        recyclerView.setAdapter(nearByAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        int type  = getArguments().getInt(KEY_CHILD_TYPE,1);
        if (Validator.isOnline(getActivity())) {
            loadDataBaseOnType(type);
        }
    }
    public static final String TAG= Fragment_NearBy.class.getCanonicalName().toString();
    private void loadDataBaseOnType(int type){
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
        nearByDataList.clear();
//        todo
//   if -> lat long-> ll
//        else -> near=mumbai
        String city = "byculla";
        String near = "near="+city+",+IN";
        String latlong = "ll=19.1107643,72.8456398";
        String latlong1 = "ll=18.9697,72.8072";
        final String url ="https://api.foursquare.com/v2/venues/search?%s&radius=1500&categoryId=%s&client_id=LBG00343EKHRRU4OC3TD45M1PBTYL11DP4OUML1PXX5OP3YK&client_secret=IAIU0OTNIXBAKBUVF2LWZ1NOD5QIK5QBUVGHDBAKYMH1MHJS&v=20170319";
        Log.i(TAG, "loadDataBaseOnType: "+type);
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
        JacksonRequest jacksonRequest = new JacksonRequest(Request.Method.GET, String.format(url, latlong1,categoryID), null, NearByDataRoot.class, new com.android.volley.Response.Listener() {
            @Override
            public void onResponse(Object o) {

                nearByDataRoot = (NearByDataRoot) o;
                nearByDataList.addAll(nearByDataRoot.getResponse().getVenues());
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                nearByAdapter.notifyDataSetChanged();
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "Error Occured!", Toast.LENGTH_SHORT).show();
            }
        });
        VolleyManager.getInstance().addToRequestQueue(jacksonRequest);
        /*
        NearByDataInterface dataInterface = ApiClient.getClient().create(NearByDataInterface.class);

        Log.i(TAG, "loadDataBaseOnType: before");
        Call<NearByDataRoot>nearByDataRootCall  = dataInterface.getNearByDataRootCall("19.1107643,72.8456398",categoryID,
                "LBG00343EKHRRU4OC3TD45M1PBTYL11DP4OUML1PXX5OP3YK","IAIU0OTNIXBAKBUVF2LWZ1NOD5QIK5QBUVGHDBAKYMH1MHJS","20170319");

        nearByDataRootCall.enqueue(new Callback<NearByDataRoot>() {
            @Override
            public void onResponse(Call<NearByDataRoot> call, Response<NearByDataRoot> response) {

                Log.i("tag", "onResponse: "+response.toString());
                if (response.isSuccessful() && response.body()!=null)
                {
                    nearByDataRoot = response.body();
                    nearByDataList.addAll(nearByDataRoot.getResponse().getVenues());
                    Log.i("check", "onResponse: "+nearByDataRoot.getResponse().getVenues().size());
                    nearByAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NearByDataRoot> call, Throwable t) {

            }
        });*/
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
