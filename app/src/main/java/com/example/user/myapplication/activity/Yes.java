package com.example.user.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.user.myapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Yes extends AppCompatActivity
{

    Button button1, button2;
    ImageView imageView2;
    NavigationView nv;
    TextView textViewName, textViewName1;
    Typeface regular, bold, medium;
    android.support.v7.widget.Toolbar toolbar;

    String TAG = "YEs activity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes);
        ButterKnife.bind(Yes.this);




        //setting up of custom fonts
        regular = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.regular));
        bold = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.bold));
        medium = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.medium));


        //intilization
        textViewName = findViewById(R.id.textViewName);
        textViewName1 = findViewById(R.id.textViewName1);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        imageView2 = findViewById(R.id.imageView2);

        textViewName.setTypeface(medium);                   //medium condense
        textViewName1.setTypeface(medium);

        button1.setTypeface(medium);
        button2.setTypeface(medium);

        ActionBar actionBar = getSupportActionBar();
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.purtoolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("What type of user are you?");

       button1.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View view)
           {
              Intent myIntent = new Intent(Yes.this, NewOrExistingUser.class);
              startActivity(myIntent);
               finish();
           }
       });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });


       /* actionBar.setDisplayShowCustomEnabled(true);*
        /*LayoutInflater layoutInflater =  (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.activity_yes,null);
        actionBar.setCustomView(v);*/




         /*      getSupportActionBar().setHomeAsUpIndicator(R.drawable.glogo);
                 getSupportActionBar().setHomeButtonEnabled(true);
                 getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                 getSupportActionBar().setTitle("");*/

    }


    //on create end


    //initilizaiton of components

    public void onclicklistner()
    {

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

    /*
    @OnClick({R.id.button1})
    public void btnClick(View view)
   {
        switch (view.getId())
        {
            case R.id.button1:
                startActivity(new Intent(Yes.this, Category.class));
                break;

        }
    }


    @OnClick({R.id.button2})
    public void btnClick1(View view) {
        switch (view.getId()) {
            case R.id.button2:
                startActivity(new Intent(Yes.this, LoginActivity.class));
                break;

        }
    }*/
}
