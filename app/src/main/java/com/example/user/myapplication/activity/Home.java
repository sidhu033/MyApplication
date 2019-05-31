package com.example.user.myapplication.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.myapplication.R;

import butterknife.ButterKnife;

public class Home extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    private ImageView img;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dashboard);

        ButterKnife.bind(Home.this);

       // click();

        dl = (DrawerLayout)findViewById(R.id.drawer_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
                        Toast.makeText(Home.this, "My Account",Toast.LENGTH_SHORT).show();
                    case R.id.settings:
                        Toast.makeText(Home.this, "Settings",Toast.LENGTH_SHORT).show();
                    case R.id.mycart:
                        Toast.makeText(Home.this, "My Cart",Toast.LENGTH_SHORT).show();
                    default:
                        return true;
                }




            }
        });

        t.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.yellow));



    }
    @SuppressLint("ResourceType")
 //   @Override
   /* public  boolean onCreateOptionsMenu(Menu menu) {
        try {
            MenuInflater inflater = getMenuInflater();
          //  LayoutInflater layoutInflater = getLayoutInflater();
          // layoutInflater.inflate(R.layout.activity_card,false);
           // inflater.inflate(R.layout.activity_card,menu);
            return super.onCreateOptionsMenu(menu);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return false;
    }*/
    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.image,menu);
        return super.onCreateOptionsMenu(menu);
    }
   /*  @Override
   public boolean onOptionsItemSelected(MenuItem item) {

       if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
*/

    public void click ()
    {
        img = (ImageView)findViewById(R.id.imageView2);
        //cv =  (CardView)findViewById(R.id.card_view);
        img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Home.this,Card.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if(t.onOptionsItemSelected(item))
        {
            return true;
        }
        else {
            Intent intent = new Intent(Home.this,Card.class);
            startActivity(intent);
            return super.onOptionsItemSelected(item);
        }
    }


}
