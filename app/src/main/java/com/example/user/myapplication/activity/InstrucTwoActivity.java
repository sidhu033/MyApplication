package com.example.user.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.user.myapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InstrucTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruc_two);
        ButterKnife.bind(InstrucTwoActivity.this);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher_logo);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_logo);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
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

    @OnClick({R.id.btnNextTwo})
    public void btnNextTwo(View view) {
        switch (view.getId()) {
            case R.id.btnNextTwo:
                Intent intent = new Intent(InstrucTwoActivity.this, ScanActivity.class);
                startActivity(intent);
                break;
        }
    }



}
