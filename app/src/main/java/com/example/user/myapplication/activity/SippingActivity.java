package com.example.user.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.user.myapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SippingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);


        ButterKnife.bind(SippingActivity.this);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.glogo);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.glogo);
        setTitle("DELIVERY DETAILS");

    }
    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.right_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       /* if(t.onOptionsItemSelected(item))
            return true;*/

        return super.onOptionsItemSelected(item);
    }
    @OnClick({R.id.btnnext})
    public void btnPurchase(View view) {
        switch (view.getId()) {

            case R.id.btnnext:
                Intent i = new Intent(SippingActivity.this, SippingActivity2.class);
                startActivity(i);
                break;

           /* case R.id.btncash:
                Intent intent = new Intent(SippingActivity.this, OrderActivity.class);
                startActivity(intent);
                break;*/
        }
    }
}