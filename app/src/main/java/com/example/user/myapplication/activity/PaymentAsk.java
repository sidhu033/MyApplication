package com.example.user.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.example.user.myapplication.R;

import butterknife.OnClick;

public class PaymentAsk extends AppCompatActivity
{
    Button payaskbutton1 ,payaskbutton2;
    Context payaskcontext;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_ask);

        Intilization();
        createobject();
        onclicklistner();
        
    }



    private void createobject()
    {
        payaskcontext =getApplicationContext();
    }

    private void Intilization()
    {
        payaskbutton1 = findViewById(R.id.payaskbutton1);
        payaskbutton2 = findViewById(R.id.payaskbutton2);

    }
    private void onclicklistner()
    {
        payaskbutton1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                startActivity(new Intent(payaskcontext, TretmentuserConfirm.class));

            }
        });
        payaskbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(payaskcontext, ScanActivity.class));
            }
        });

    }
    


    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.right_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        return super.onOptionsItemSelected(item);
    }



}
