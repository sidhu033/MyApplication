package com.example.user.myapplication.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.myapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PurchaseActivity extends AppCompatActivity
{
    Button btnYes, btnNo;
    TextView purchasetooltitle;
     Typeface regular ,bold,medium;
    private boolean isDevice;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        ButterKnife.bind(PurchaseActivity.this);

        //setting up of custom fonts
        regular = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.regular));
        bold = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.bold));
        medium = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.medium));

        //intiallization
        btnYes  = findViewById(R.id.btnYes);
        btnNo  = findViewById(R.id.btnYes);
        purchasetooltitle=findViewById(R.id.purchasetooltitle);

        //setting up of fontstyle
        purchasetooltitle.setTypeface(medium);
        btnYes.setTypeface(medium);
        btnNo.setTypeface(medium);

        //change the textview of activity Main activity for previous for already registered user screen
        Intent intent = getIntent();
         if (getIntent().getExtras()!=null)
        {
            isDevice = getIntent().getExtras().getBoolean("isDevice");
            Log.e("isDevice","");
        }
         if(isDevice)
        {
            btnNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    Intent in = new Intent(PurchaseActivity.this, ScrollingActivity.class);
                    startActivity(in);
                }
            });

        }

        //setTitle("     Do You Want To Purchase? ");
        //getSupportActionBar().setLogo(R.drawable.web);
       // getSupportActionBar().setIcon(R.drawable.web);
       // getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(false);
       // getSupportActionBar().setHomeButtonEnabled(false);
        //getActionBar().setIcon(R.drawable.gg);



    }

    @OnClick({R.id.btnYes, R.id.btnNo})
    public void btnPurchase(View view)
    {
        switch (view.getId()) {

            case R.id.btnYes:
                Intent i = new Intent(PurchaseActivity.this, PurchaseActivity1.class);
                startActivity(i);
                break;

            case R.id.btnNo:
                Intent intent = new Intent(PurchaseActivity.this, Register.class);
                startActivity(intent);
                break;
        }
    }


}
