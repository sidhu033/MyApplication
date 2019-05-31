package com.example.user.myapplication.adapter;
/*
 * Recycleview.adapter
 *Recycleview.viewholder
 * */

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.myapplication.R;
import com.example.user.myapplication.activity.HealthMone;
import com.example.user.myapplication.activity.Pin;
import com.example.user.myapplication.activity.ScrollingActivity;
import com.example.user.myapplication.pojo.HMeterDataObject;

import java.util.List;

public class HMeterAdapter extends RecyclerView.Adapter<HMeterAdapter.HMeterDataObjectViewHolder>
{

    private Context context;
    private List<HMeterDataObject> HmeterList;

    public HMeterAdapter(Context context, List<HMeterDataObject> hmeterList)
    {
        this.context = context;
        HmeterList = hmeterList;
    }

    @Override
    public HMeterDataObjectViewHolder onCreateViewHolder( ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclehealthmone,null);
        return new HMeterDataObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final HMeterDataObjectViewHolder holder, int position)
    {
        HMeterDataObject hMeterDataObjectViewHolder = HmeterList.get(position);
        holder.Quetions.setText(hMeterDataObjectViewHolder.getmText1());
        holder.subquetions.setText(hMeterDataObjectViewHolder.getmText2());

    }

    @Override
    public int getItemCount()
    {
        return HmeterList.size();
    }

    class HMeterDataObjectViewHolder extends RecyclerView.ViewHolder
    {
        TextView Quetions,subquetions;
        Typeface regular ,bold,medium;
        public HMeterDataObjectViewHolder( View itemView)
        {

            super(itemView);

            Quetions =itemView.findViewById(R.id.Quetions);
            subquetions =itemView.findViewById(R.id.subquetions);


            regular = Typeface.createFromAsset(itemView.getContext().getAssets(), "HelveticaNeueLight.ttf");
            bold = Typeface.createFromAsset(itemView.getContext().getAssets(), "HelveticaNeueBlackCond.ttf");
            medium = Typeface.createFromAsset(itemView.getContext().getAssets(), "HelveticaNeue-MediumCond.otf");

            Quetions.setTypeface(medium);
            subquetions.setTypeface(medium);


        }
    }


}
