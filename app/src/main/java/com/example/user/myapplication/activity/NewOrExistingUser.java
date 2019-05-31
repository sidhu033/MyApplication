package com.example.user.myapplication.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.myapplication.R;
public class NewOrExistingUser extends AppCompatActivity
{
    Button btnpurchasenew, btnsomeelse;
    TextView cattxtName1, cattxtName2;
    android.support.v7.widget.Toolbar toolbar;
    Typeface regular, bold, medium;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_or_existing_user);

        //intilization
        cattxtName1 = findViewById(R.id.cattxtName1);
        cattxtName2 = findViewById(R.id.cattxtName2);
        btnpurchasenew = findViewById(R.id.btnpurchasenew);
        btnsomeelse = findViewById(R.id.btnsomeelse);

        //setting up of custom fonts
        regular = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.regular));
        bold = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.bold));
        medium = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.medium));


        cattxtName1.setTypeface(medium);                   //medium condense
        cattxtName2.setTypeface(medium);

        btnpurchasenew.setTypeface(medium);
        btnsomeelse.setTypeface(medium);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


     btnpurchasenew.setOnClickListener(new View.OnClickListener()
     {
        @Override
        public void onClick(View view)
        {
            startActivity(new Intent(NewOrExistingUser.this, PaymentAsk.class));
        }
     });



        btnsomeelse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewOrExistingUser.this, LoginActivity.class);
                intent.putExtra("isNew", true);
                startActivity(intent);
            }
        });



    }
    //end of on create

    @Override
    protected void onPause() {
        super.onPause();
        try {
            Thread.sleep(501); // Don't do this!!! Only for testing purposes!!!
        }catch (Exception e) {
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
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






