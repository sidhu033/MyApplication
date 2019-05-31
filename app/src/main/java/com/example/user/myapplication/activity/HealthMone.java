package com.example.user.myapplication.activity;

import android.graphics.Typeface;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.user.myapplication.R;
import com.example.user.myapplication.adapter.HMeterAdapter;
import com.example.user.myapplication.pojo.HMeterDataObject;

import java.util.ArrayList;
import java.util.List;

public class HealthMone extends AppCompatActivity
{
    /* TextView Quetions,subquetions;
         HMeterDataObject hMeterDataObject;
     CheckBox qcheck1 ,qcheck2;*/
    RecyclerView recyclerView;                                   //recycleview
    private HMeterAdapter hMeterAdapter;                        //adapter for health meter
    private List<HMeterDataObject> hmeterList;                  //modelclass list



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_mone);

        recyclerView =  (RecyclerView) findViewById(R.id.rechm);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        hmeterList= new ArrayList<>();                  //list in arraylist intialization


        hmeterList.add(new HMeterDataObject
                (
                        1,
                        "CARDIO VASCULLER  DISEASE ",
                        "Does Your Mother Have Cardio Vasculler Diesease ?"


                ));
        hmeterList.add(new HMeterDataObject
                (
                        2,
                        "",
                        "Does your father Have Cardio Vasculler Diesease ? "


                ));
        hmeterList.add(new HMeterDataObject
                (
                        3,
                        "",
                        " Does your sibilings Have Cardio Vasculler Diesease ? "


                ));
        hmeterList.add(new HMeterDataObject
                (
                        4,
                        "DIABETES",
                        "Parents / sibilings have diabaties ? "


                ));
        hmeterList.add(new HMeterDataObject
                (
                        5,
                        "",
                        "Parents / sibilings have high BP  ? "


                ));

        hMeterAdapter = new HMeterAdapter(this, hmeterList);
        recyclerView.setAdapter(hMeterAdapter);

    }
}
