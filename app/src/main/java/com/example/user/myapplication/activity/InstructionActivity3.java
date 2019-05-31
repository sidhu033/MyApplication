package com.example.user.myapplication.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.user.myapplication.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.ButterKnife;


public class InstructionActivity3 extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    TextView textView1;
    Button btnNext;
    ImageView img;
   // private PreferenceHelper preferenceHelper;
    private Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction3);
        //android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        ButterKnife.bind(InstructionActivity3.this);

        btnNext = findViewById(R.id.tv2);
        //imgBtn = findViewById(R.id.btn_img);
        //imgBtn.setColorFilter(getResources().getColor(R.color.white));
       // setTitle("Welcome to Redoxer Treatment ");
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //preferenceHelper.putIsLogin(false);
                startActivity(new Intent(InstructionActivity3.this, MainTreatmentScreen.class));
            }
        });



       // click();
        //preferenceHelper = new PreferenceHelper(this);

       /* if(preferenceHelper.getIsLogin()) {
            Intent intent = new Intent(InstructionActivity.this, SettingsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
            startActivity(intent);
            this.finish();
        }*/

      /*  try {
            getSupportActionBar().hide();
        }catch (Exception e){

        }*/
       //getSupportActionBar().getCustomView();
        dl = (DrawerLayout)findViewById(R.id.drawer_main);
        ActionBar actionBar =getSupportActionBar();
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        //actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_logo);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_logo);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.account:
                        Toast.makeText(InstructionActivity3.this, "My Account",Toast.LENGTH_SHORT).show();
                    case R.id.settings:
                        Toast.makeText(InstructionActivity3.this, "Settings",Toast.LENGTH_SHORT).show();
                    case R.id.mycart:
                        Toast.makeText(InstructionActivity3.this, "My Cart",Toast.LENGTH_SHORT).show();
                    default:
                        return true;
                }




            }
        });
        //textView1 = findViewById(R.id.tv1);


        t.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.yellow));
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.image,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item)){

            return true;


        }
        else {
            Intent intent = new Intent(InstructionActivity3.this,Card.class);
            startActivity(intent);
            return super.onOptionsItemSelected(item);
        }
    }


   /* public void click (){
        img = (ImageView)findViewById(R.id.imageView2);
        //cv =  (CardView)findViewById(R.id.card_view);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InstructionActivity3.this,Card.class);
                startActivity(intent);
            }
        });



    }*/
    /*@Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(InstructionActivity3.this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Logout?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                //preferenceHelper.putIsLogin(false);
              //  Intent intent = new Intent(InstructionActivity.this,LoginActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
               // startActivity(intent);
                InstructionActivity3.this.finish();
            }
        });

        builder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                InstructionActivity3.super.onBackPressed();
                dialog.cancel();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }
    @Override
    protected void onPause() {
        super.onPause();

        timer = new Timer();
        Log.i("Main", "Invoking logout timer");
        LogOutTimerTask logoutTimeTask = new LogOutTimerTask();
        timer.schedule(logoutTimeTask, 1800000); //auto logout in 5 minutes
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (timer != null) {
            timer.cancel();
            Log.i("Main", "cancel timer");
            timer = null;
        }

    }

    private class LogOutTimerTask extends TimerTask {

        @Override
        public void run() {

            //redirect user to login screen
           // preferenceHelper.putIsLogin(false);
            /*Intent intent = new Intent(InstructionActivity.this,LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);*/
          //  InstructionActivity3.this.finish();
      //  }
   // }


}
