package com.example.hppc.mood.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hppc.mood.R;
import com.example.hppc.mood.model.NearByData;

import java.util.List;
import java.util.Locale;

/**
 * Created by madscientist on 19/3/17.
 */

public class NearByAdapter extends RecyclerView.Adapter<NearByAdapter.ViewHolder> {

    private Context context;
    private List<NearByData>nearByDataList;

    public NearByAdapter(Context context, List<NearByData> nearByDataList) {
        this.context = context;
        this.nearByDataList = nearByDataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_nearby_data,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final NearByData nearByData = nearByDataList.get(position);
        holder.title.setText(nearByData.getName());
        holder.location.setText(nearByData.getLocation().getAddress() +
                (!TextUtils.isEmpty(nearByData.getLocation().getCrossStreet())?nearByData.getLocation().getCrossStreet():""));
        if (nearByData.getStats()!=null && !TextUtils.isEmpty(nearByData.getStats().getUsersCount()))
        {
            holder.peopleCount.setText(nearByData.getStats().getUsersCount()+" users have been here.");
        }
        if (!TextUtils.isEmpty(nearByData.getLocation().getDistance())) {
            float distanceInKM = Float.parseFloat(nearByData.getLocation().getDistance()) / 1000;
            holder.distance.setText(String.format("%2.1f Kms\naway",distanceInKM));
            holder.distance.setVisibility(View.VISIBLE);
        }else{
            holder.distance.setVisibility(View.GONE);
        }


        holder.rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double latitude= Double.parseDouble(nearByData.getLocation().getLat());
                Double longitude = Double.parseDouble(nearByData.getLocation().getLng());
                String uri =String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
                String uri_other = "geo:<lat>,<long>?q="+String.valueOf(latitude)+","+String.valueOf(longitude)+"("+nearByData.getName()+")";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri_other));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nearByDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title ;
        private TextView location;
        private TextView peopleCount;
        private TextView distance;
        private ImageView imageView;
        private LinearLayout rootLayout;
        public ViewHolder(View itemView) {
            super(itemView);

            rootLayout = (LinearLayout) itemView.findViewById(R.id.rootLayout);
            title = (TextView) itemView.findViewById(R.id.rnd_title);
            location = (TextView) itemView.findViewById(R.id.location );
            peopleCount = (TextView) itemView.findViewById(R.id.checking);
            distance = (TextView) itemView.findViewById(R.id.distnace);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
