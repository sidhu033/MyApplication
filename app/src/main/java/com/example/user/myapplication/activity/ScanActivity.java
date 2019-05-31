package com.example.user.myapplication.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Camera;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.R;
import com.google.gson.JsonObject;
import com.google.zxing.Result;

import org.json.JSONObject;

import butterknife.ButterKnife;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private Typeface regular ,bold,medium;
    private TextView textView9,textView10,txtprodctid;
    private Button btnscannow,btnscanlogin;
    private EditText editprodctid;
    private ZXingScannerView scannerView;
    private Context context;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scan);



        getSupportActionBar().setHomeAsUpIndicator(R.drawable.glogo);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SCAN YOUR CODE");

        scannerView = new ZXingScannerView(this);

        //intializing scan object
        btnscanlogin =findViewById(R.id.btnscanlogin);
        btnscannow = findViewById(R.id.btnscannow);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        txtprodctid = findViewById(R.id.txtprodctid);
        editprodctid = findViewById(R.id.editprodctid);

        //setting up of custom fonts
        regular = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.regular));
        bold = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.bold));
        medium = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.medium));

        textView9.setTypeface(medium);                   //medium condense
        textView10.setTypeface(medium);
        btnscannow.setTypeface(medium);
        txtprodctid.setTypeface(medium);


        //if scan now button click
        btnscannow.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {

               // setContentView(scannerView);  // set camera scanner by own library

                Intent intent = new Intent(ScanActivity.this, RegisteredDeviceSrc.class);
                startActivity(intent);

            }
        });
        btnscanlogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ScanActivity.this, ScrollingActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Product Id :"+editprodctid.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
    /*on create closed*/

    // when open the activity or project this method will call
    @Override
    public void onResume()
    {

        super.onResume();
        scannerView.setResultHandler(this);                 // Register ourselves as a handler for scan results.
        scannerView.startCamera();                          // Start camera on resume
        scannerView.setAutoFocus(true);

    }

    // after scaning the code this method will call
    @Override
    public void onPause()
    {
        super.onPause();
        scannerView.stopCamera();                            // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult)
    {
        scannerView.resumeCameraPreview(this);
        scannerView.removeAllViews();
        scannerView.stopCamera();

        setContentView(R.layout.activity_scan);
    }
    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.right_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
       /* if(t.onOptionsItemSelected(item))
            return true;*/
        return super.onOptionsItemSelected(item);
    }




   /* public void onPress()
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(ScanActivity.this, R.style.MyDialogTheme);
        builder.setCancelable(false);
        builder.setMessage("Your Devices is configured Sucessfully Please register");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                //if user pressed "yes", then he is allowed to exit from application
                Intent intent = new Intent(ScanActivity.this, Register.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                //ScanActivity.this.finish();
            }
        });

       *//* builder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                ScanActivity.super.onBackPressed();
                dialog.cancel();
            }
        });*//*
        AlertDialog alert=builder.create();
        alert.show();
    }*/
}
