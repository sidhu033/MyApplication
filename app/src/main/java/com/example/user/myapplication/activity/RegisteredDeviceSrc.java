package com.example.user.myapplication.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.myapplication.R;

import org.w3c.dom.Text;

public class RegisteredDeviceSrc extends AppCompatActivity
{
    private TextView txtdevicedec1,txtprodctdec2,txtdevicehead;
    private Typeface regular ,bold,medium;
    Button btnregdevicelog,btnregdevice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_device_src);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.glogo);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("REGISTERED DEVICE?");
        //intialization
        txtdevicedec1 = findViewById(R.id.txtdevicedec1);
        txtprodctdec2 = findViewById(R.id.txtprodctdec2);
        txtdevicehead = findViewById(R.id.txtdevicehead);
        btnregdevicelog =findViewById(R.id.btnregdevicelog);
        btnregdevice = findViewById(R.id.btnregdevice);


        //setting up of custom fonts
        regular = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.regular));
        bold = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.bold));
        medium = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.medium));
        //setting typface
        txtdevicedec1.setTypeface(medium);
        txtprodctdec2.setTypeface(medium);
        txtdevicehead.setTypeface(medium);
        btnregdevice.setTypeface(medium);

        btnregdevice.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisteredDeviceSrc.this,LoginActivity.class);
                intent.putExtra("isNew",true);
                startActivity(intent);
            }
        });
        btnregdevicelog.setOnClickListener(new View.OnClickListener()            //on button
        {
            @Override
            public void onClick(View view)
            {

                Intent intent = new Intent(RegisteredDeviceSrc.this, LoginActivity.class);

                startActivity(intent);
            }
        });


    }
}
