package com.example.user.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.user.myapplication.R;
import com.kevalpatel.passcodeview.PinView;


/*
import com.goodiebag.pinview.Pinview;
*/

import java.net.PasswordAuthentication;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Pin extends AppCompatActivity
{
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private  EditText inputUser;
    public boolean isForgot;
    TextView pinmsgset ,pinmsg,tvsubmit,txt,txtforget;
    Typeface regular ,bold,medium;
    private static final String ARG_CURRENT_PIN = "current_pin";

    private PinView mPinView;

    //pinview
 /*   Pinview pinview;*/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pin);
        ButterKnife.bind(Pin.this);


        EditText inputUser = findViewById(R.id.inputUser);

        //intitialization of textview

        tvsubmit = findViewById(R.id.txtforget);                                      //for forgot pin
        txt = findViewById(R.id.tvsubmit);                                            //for reset pin
        pinmsg =findViewById(R.id.pinmsg);
        pinmsgset =findViewById(R.id.pinmsgset);

        //for setting pinview
       /* pinview = findViewById(R.id.pinview1);
*/
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

      /*  //pinview envent
        pinview.setPinViewEventListener(new Pinview.PinViewEventListener()
        {
            @Override
            public void onDataEntered(Pinview pinview, boolean b)
            {
                Toast.makeText(getApplicationContext(),pinview.getValue(),Toast.LENGTH_SHORT).show();
            }
        });*/

        txt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Pin.this, SetPin.class);
                startActivity(intent);
            }
        });

        tvsubmit.setOnClickListener(new View.OnClickListener()                                   //for forgot pin
        {
            @Override
            public void onClick(View view)
            {
               Intent intent = new Intent(Pin.this, ForgotPin.class);
                startActivity(intent);

            }
        });


        dl = (DrawerLayout)findViewById(R.id.drawer_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.glogo);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.glogo);
        setTitle("TREATMENT PIN");

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.account:
                        Toast.makeText(Pin.this, "My Account",Toast.LENGTH_SHORT).show();
                    case R.id.settings:
                        Toast.makeText(Pin.this, "Settings",Toast.LENGTH_SHORT).show();
                    case R.id.mycart:
                        Toast.makeText(Pin.this, "My Cart",Toast.LENGTH_SHORT).show();
                    default:
                        return true;
                }
            }
        });
        t.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.yellow));

        //setting up of custom fonts
        regular = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.regular));
        bold = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.bold));
        medium = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.medium));

        pinmsg.setTypeface(medium);

        tvsubmit.setTypeface(medium);
        txt.setTypeface(medium);

        //get intent from activity forgotPin
        Intent intent = getIntent();
        if(getIntent().getExtras()!=null)
        {
            isForgot =  getIntent().getExtras().getBoolean("isForgot");

        }
        if(isForgot)
        {

            pinmsg.setText("PLEASE ENTER NEW PIN WHICH SENT \n ON REIGISTERED MOBILE NO AND EMAIL ID");
            pinmsg.setTypeface(medium);
            pinmsg.setTextColor(Color.RED);
            tvsubmit.setText("");
            txt.setText("");
        }
    //pinview




    }

    //on create closed


    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.image,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if(t.onOptionsItemSelected(item))
        {

            return true;
        }
        else
        {
            Intent intent = new Intent(Pin.this,Card.class);
            startActivity(intent);
            return super.onOptionsItemSelected(item);
        }
    }


    @OnClick({R.id.btnpin})
    public void pinSubmit(View view)
    {
        switch (view.getId())
        {
            case R.id.btnpin:
                startActivity(new Intent(Pin.this, StartTretment.class));
                break;

        }
    }
}
