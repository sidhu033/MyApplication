package com.example.user.myapplication.activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.nfc.Tag;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.user.myapplication.R;

public class OTP extends AppCompatActivity
{
    private static final String TAG = "FullScreenPinActivity";
    EditText enter_mpin;
    ImageView i1, i2, i3, i4;
    Typeface regular ,bold,medium;
    TextView txtotphead,txtplzotp;
    private boolean isDevice;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        i1 = (ImageView) findViewById(R.id.imageview_circle1);
        i2 = (ImageView) findViewById(R.id.imageview_circle2);
        i3 = (ImageView) findViewById(R.id.imageview_circle3);
        i4 = (ImageView) findViewById(R.id.imageview_circle4);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.glogo);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("AUTHENTICATION");

        enter_mpin = (EditText) findViewById(R.id.editText_enter_mpin);
        enter_mpin.requestFocus();
       // enter_mpin.setInputType(InputType.TYPE_CLASS_NUMBER);
        enter_mpin.setInputType(InputType.TYPE_CLASS_NUMBER|InputType.TYPE_CLASS_PHONE);
        enter_mpin.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        enter_mpin.setFocusableInTouchMode(true);


        //setting up of custom fonts
        regular = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.regular));
        bold = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.bold));
        medium = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.medium));

        txtotphead = findViewById(R.id.txtotphead);
        txtplzotp = findViewById(R.id.txtplzotp);

        txtotphead.setTypeface(medium);
        txtplzotp.setTypeface(medium);


        enter_mpin.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }


            @Override
            public void afterTextChanged(Editable s)
            {
                Log.d(TAG, "onKey: screen key pressed");

                switch (s.length())
                {

                    case 4:

                        //change the textview of activity Main activity for previous for already registered user screen
                        /*Intent intent2 = getIntent();
                        if (getIntent().getExtras()!= null)
                        {
                            isDevice = getIntent().getExtras().getBoolean("isDevice");
                        }
                        if(isDevice)
                        {
                            new Intent(OTP.this,ScrollingActivity.class);
                            startActivity(intent2);
                        }
                        else
                         {}*/
                      //  Intent intent = new Intent(OTP.this, Register.class);
                        startActivity(new Intent(OTP.this,Register.class));
                        i4.setImageResource(R.drawable.circle2);
                        break;

                    case 3:
                        i4.setImageResource(R.drawable.circle);
                        i3.setImageResource(R.drawable.circle2);
                        break;
                    case 2:
                        i3.setImageResource(R.drawable.circle);
                        i2.setImageResource(R.drawable.circle2);
                        break;
                    case 1:
                        i2.setImageResource(R.drawable.circle);
                        i1.setImageResource(R.drawable.circle2);
                        break;
                    default:
                        i1.setImageResource(R.drawable.circle);

                }

            }

        });


    }
}
