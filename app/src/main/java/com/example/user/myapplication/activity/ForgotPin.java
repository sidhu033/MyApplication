package com.example.user.myapplication.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class ForgotPin extends AppCompatActivity
{
    TextView txt1,txt2;
    Button btnforget,btngoback;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpin);


        ButterKnife.bind(ForgotPin.this);
        //intitalize the variables
       /* txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);*/


        btnforget  = findViewById(R.id.btnforget);
        btngoback = findViewById(R.id.btngoback);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.glogo);
        setTitle("FORGOT PIN");

        btnforget.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Toast.makeText(getApplicationContext(),"PIN SENT SUCESSFULLY", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ForgotPin.this, Pin.class);
                intent.putExtra("isForgot",true);
                startActivity(intent);

                /*builder = new AlertDialog.Builder(ForgotPin.this,R.style.MyDialogTheme);
                builder.setMessage("Do YOU WANT TO SEND NEW PIN ON YOUR REGISTRED MOBILE NUMBER & EMAIL ID");
                builder.setCancelable(false);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        Toast.makeText(getApplicationContext(),"PIN SENT", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ForgotPin.this, Pin.class);
                        startActivity(intent);
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        dialogInterface.cancel();
                        Toast.makeText(getApplicationContext(),"WELCOME TO TREATMENT", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ForgotPin.this, ScrollingActivity.class);
                        startActivity(intent);
                    }
                });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("FORGOT PASSWORD ?");
                alert.show();*/




            }
        });
        btngoback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"WELCOME TO TREATMENT", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ForgotPin.this, ScrollingActivity.class);
                startActivity(intent);
            }
        });
    }
}
