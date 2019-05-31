package com.example.user.myapplication.activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.myapplication.R;

public class AuthenticationLogin extends AppCompatActivity
{

    EditText authmobileno,authpass;
    Button btnauthsign;
    Typeface regular ,bold,medium;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication_login);

        authlogininit();
        authloginonclick();
    }

    private void authloginonclick()
    {
        btnauthsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AuthenticationLogin.this,OTP.class));
            }
        });
    }

    public void authlogininit()
    {
        btnauthsign = findViewById(R.id.btnauthsign);
        authmobileno = findViewById(R.id.authmobileno);
        authpass = findViewById(R.id.authpass);


        regular = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.regular));
        bold = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.bold));
        medium = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.medium));

        authmobileno.setTypeface(medium);
        authpass.setTypeface(medium);
        btnauthsign.setTypeface(medium);

    }
}
