package com.example.user.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.user.myapplication.R;

import java.text.DateFormat;
import java.util.Date;

public class TreatmentResult extends AppCompatActivity
{
    TextView txtloghdate,txtlogs;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment_result);

        getSupportActionBar().setLogo(R.drawable.glogo);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setTitle("REDOXER TREATMENT RESULT");

        /*Initialization*/


        txtloghdate = findViewById(R.id.txtloghdate);
        txtlogs = findViewById(R.id.txtlogs);


        String Date = DateFormat.getDateTimeInstance().format(new Date());
        txtloghdate.setText(Date);

        txtlogs.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                startActivity(new Intent(TreatmentResult.this,LogFinal.class));
            }
        });
    }
}
