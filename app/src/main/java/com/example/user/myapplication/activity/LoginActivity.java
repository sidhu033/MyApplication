package com.example.user.myapplication.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.ApiClient;
import com.example.user.myapplication.ApiInterface;
import com.example.user.myapplication.FeedReaderDbHelper;
import com.example.user.myapplication.R;
import com.example.user.myapplication.pojo.Datum;
import com.example.user.myapplication.pojo.LoginEntity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */

public class LoginActivity extends AppCompatActivity
{
    // UI references.
    private EditText inputUser,inputPass;
    private View mProgressView;
    private View mLoginFormView;
    private Button btnSignIn;
    private  TextView txtloginhdmsg;
    AlertDialog.Builder dialogBuilder;
    Typeface regular ,bold,medium;
    public boolean isNew;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /*Initilization*/
        inputUser =  findViewById(R.id.inputUser);
        inputPass = findViewById(R.id.inputPass);
        btnSignIn =  findViewById(R.id.btnSignIn);
        mLoginFormView = findViewById(R.id.login_form);                 //scrollview of login form
        mProgressView = findViewById(R.id.login_progress);              //progress bar1

        //setting up of custom fonts
        regular = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.regular));
        bold = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.bold));
        medium = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.medium));

        /*Setting Typeface with custom fonts*/
        btnSignIn.setTypeface(medium);

        inputPass.setOnEditorActionListener(new TextView.OnEditorActionListener()
        {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent)
            {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL)
                {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        //on click of login button
        btnSignIn.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                attemptLogin();
            }
        });


        dialogBuilder = new AlertDialog.Builder(this);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.glogo);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Login");


        //change the textview of activity Login activity for previous user mobile number
        Intent intent = getIntent();
        if(getIntent().getExtras()!= null)
        {
            isNew = getIntent().getExtras().getBoolean("isNew");

        }
        Log.e("isNew","hello");

        // Added condition here
        if(isNew)
        {
            /*mEmailView.setHint(" Registered Mobile Number");
            mPasswordView.setHint("Registered User's PIN ");*/
            btnSignIn.setText("Authenticate");
            getSupportActionBar().setTitle("AUTHENTICATION");
            txtloginhdmsg = findViewById(R.id.txtloginhdmsg);
            txtloginhdmsg.setTypeface(medium);
            txtloginhdmsg.setText("Please Authenticate Yourself By Entering Previous User's Mobile Number and PIN");
            txtloginhdmsg.setTextSize(20);
            btnSignIn.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    callregistred();
                }
            });

        }
        else
        {
            inputUser.setHint("  Mobile Number");
            inputPass.setHint("Pin ");
        }

    }
    //on create end
    private void callregistred()
    {
        Intent intent = new Intent(LoginActivity.this, OTP.class);
        startActivity(intent);
    }



    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin()
    {

        // Store values at the time of the login attempt.
        String Mobile = inputUser.getText().toString();
        String Pin = inputPass.getText().toString();

        if(isValidPhoneNumber(Mobile))
        {
                inputUser.setError("enter valid number");
        }
        else
        {
            inputUser.setError("not valid number");
        }
    }
    private boolean isValidPhoneNumber(CharSequence phoneNumber)
    {
        if (!TextUtils.isEmpty(phoneNumber))
        {
            return Patterns.PHONE.matcher(phoneNumber).matches();
        }
        return false;
    }
    //asychronous task in android
    private void userLoginTask(String email, String password)
    {

    }


    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.right_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        return super.onOptionsItemSelected(item);
    }

}

