package com.example.user.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.R;
public class MainTreatmentScreen extends AppCompatActivity
{
    TextView txtlogs;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_treatment_screen);

        getSupportActionBar().setLogo(R.drawable.glogo);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setTitle("REDOXER TREATMENT");

        txtlogs = findViewById(R.id.txtlogs);

        txtlogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainTreatmentScreen.this, TreatmentResult.class));
                Toast.makeText(MainTreatmentScreen.this,"Treatment result",Toast.LENGTH_LONG).show();
            }
        });

    }
}
