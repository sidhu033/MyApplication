package com.example.user.myapplication.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.myapplication.R;
public class TretmentuserConfirm extends AppCompatActivity
{
    Button btnmyself,btnother;
    TextView tretconfirname ,txtretmyself,txtretother;
    Typeface regular ,bold,medium;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tretmentuser_confirm);

        Initilization();
        onclicklistener();

    }
    /*oncreate closed*/



    public void Initilization()
    {
        btnmyself = findViewById(R.id.btnmyself);
        btnother = findViewById(R.id.btnother);
        tretconfirname = findViewById(R.id.tretconfirname);
        txtretother = findViewById(R.id.txtretother);
        txtretmyself = findViewById(R.id.txtretmyself);

        regular = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.regular));
        bold = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.bold));
        medium = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.medium));

        txtretmyself.setTypeface(medium);
        tretconfirname.setTypeface(medium);
        txtretother.setTypeface(medium);

    }
    public void onclicklistener()
    {
        //when purchasing for myself autofill all details
        btnmyself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               String s = null;
                Intent intent = new Intent(TretmentuserConfirm.this, Register.class);

                intent.putExtra("treatmentconfirm",s);
                startActivity(intent);
            }
        });

        btnother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(TretmentuserConfirm.this, Register.class);
                startActivity(intent);
            }
        });
    }

}
