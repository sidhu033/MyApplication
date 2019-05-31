package com.example.user.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.myapplication.R;
import com.example.user.myapplication.customactivity.MovableFloatingActionButton;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PurchaseActivity1 extends AppCompatActivity
{
    int count = 1 ;
     Button itemadd, itemremove;
     MovableFloatingActionButton btnfloatingcart;
     TextView txtitems, txtprice,txtnoticount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase1);


        ButterKnife.bind(PurchaseActivity1.this);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.glogo);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.glogo);
        setTitle("BUY REDOXER");


        /*Intilization*/
        itemadd = findViewById(R.id.itemadd);
        itemremove = findViewById(R.id.itemremove);
        txtitems = findViewById(R.id.txtitems);
        txtprice = findViewById(R.id.txtprice);
        txtnoticount = findViewById(R.id.txtnoticount);

        btnfloatingcart =  findViewById(R.id.btnfloatingcart);
    }
    @OnClick({R.id.btnPlace, R.id.itemadd,R.id.itemremove,R.id.btnfloatingcart})
    public void btnNext(View view)
    {
        String stxtprice = String.valueOf(txtprice);

        switch (view.getId())
        {
            case R.id.btnPlace:
                startActivity(new Intent(PurchaseActivity1.this, SippingActivity.class));
                Intent intent = new Intent();
                intent.putExtra("isname",true);
                //startActivity(new Intent(PurchaseActivity1.this, PurchaseCart.class));

                break;
            case R.id.itemadd :
                count++;

                if(count>0)
                {
                    txtitems.setText(String.valueOf(count));
                    txtnoticount.setText(String.valueOf(count));
                }


                break;
            case R.id.itemremove :
                count--;
                if(count>0)
                {
                    txtitems.setText(String.valueOf(count));
                    txtnoticount.setText(String.valueOf(count));
                }
                break;

            case R.id.btnfloatingcart :
                startActivity(new Intent(PurchaseActivity1.this,PurchaseCart.class));
        }
    }
}
