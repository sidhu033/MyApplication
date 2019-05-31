package com.example.user.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.myapplication.R;

public class StartTretment extends AppCompatActivity {

    Button btnstartt,btnknwt,btnviewt;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_tretment);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.glogo);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("WANT TO TAKE TREATMENT ?");


        Button btnstartt = findViewById(R.id.btnstartt);
        Button btnknwt = findViewById(R.id.btnknwt);
        Button btnviewt = findViewById(R.id.btnviewt);


        btnstartt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                startActivity(new Intent(StartTretment.this, InstructionAVI.class));
            }
        });

        btnviewt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartTretment.this, LogFinal.class));
            }
        });
    }
}
