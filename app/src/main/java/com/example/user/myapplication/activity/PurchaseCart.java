package com.example.user.myapplication.activity;

import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.user.myapplication.R;

import static com.example.user.myapplication.R.layout.cart_bottom_sheet;

public class PurchaseCart extends AppCompatActivity
{
    Button btnPlace;
    LinearLayout layoutBottomSheet;
    BottomSheetBehavior sheetBehavior;
    Boolean isname;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_cart);


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.drawable.glogo);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.glogo);
        setTitle("Cart");

        /*intilization*/
        btnPlace = findViewById(R.id.btnPlace);

        layoutBottomSheet = findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        Intent intent = getIntent();


       sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState)
            {
                switch(newState)
                {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                    {

                    }
                    break;

                    case BottomSheetBehavior.STATE_COLLAPSED:
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }


            }

            @Override
            public void onSlide(@NonNull View view, float v)
            {

            }
        });

        btnPlace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                    if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                        sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                    } else {
                        sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                    }
                }

        });
    }
    /*On create closed*/


}
