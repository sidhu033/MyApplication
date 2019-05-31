
package com.example.user.myapplication.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myapplication.R;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register extends AppCompatActivity implements  View.OnClickListener
{
   // Toolbar maintoolbar1;

    private static  final String TAG = "RegisterActivity";

    //intialization of variables
    EditText eduname, edemail, edumobile, eduusername, edupassword, edurepassword;
    CheckBox check;
    TextView txttermsncond,textDOB,regtooltitle;
    RadioButton radioMale, radioFemale;
    Button btnLogin ,btnAlertDailog,tvLogin;
    Typeface regular ,bold,medium;
    private  Boolean is1stchild ,treatmentconfirm;

    //Date picker for calender
    DatePickerDialog.OnDateSetListener dobdateSetListener;
    Calendar cal = Calendar.getInstance();

    int year = cal.get(Calendar.YEAR);
    int month = cal.get(Calendar.MONTH);
    int day = cal.get(Calendar.DATE);
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
       ButterKnife.bind(Register.this);


      /*  setTitle("REGISTRATION");
        getSupportActionBar().setLogo(R.drawable.web);
        getSupportActionBar().setIcon(R.drawable.web);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
*/

        //defination of variables

       // maintoolbar1 = findViewById(R.id.maintoolbar1);



        eduname = (EditText) findViewById(R.id.eduname);
        edemail = (EditText) findViewById(R.id.edemail);

        textDOB =  (TextView) findViewById(R.id.textDOB);
        textDOB.setOnClickListener(this);

        edumobile = (EditText) findViewById(R.id.edumobile);
        eduusername = (EditText) findViewById(R.id.eduusername);
        edupassword = (EditText) findViewById(R.id.edupassword);
        edurepassword = (EditText) findViewById(R.id.edurepassword);
        txttermsncond = findViewById(R.id.txttermsncond);

        regtooltitle = findViewById(R.id.regtooltitle);

        radioMale = (RadioButton) findViewById(R.id.radioMale);
        radioFemale = (RadioButton) findViewById(R.id.radioFemale);

        check = (CheckBox) findViewById(R.id.check);

        //button defination of register button
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvLogin =(Button) findViewById(R.id.tvLogin);
        btnAlertDailog = (Button) findViewById(R.id.btnAlertDailog);


        //setting up of custom fonts
        regular = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.regular));
        bold = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.bold));
        medium = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.medium));


        regtooltitle.setTypeface(medium);
        txttermsncond.setTypeface(regular);
        btnLogin.setTypeface(medium);
        tvLogin.setTypeface(medium);
        eduname.setTypeface(medium);
        edemail.setTypeface(medium);
        textDOB.setTypeface(medium);
        edumobile.setTypeface(medium);
        eduusername.setTypeface(medium);
        edupassword.setTypeface(medium);
        edurepassword.setTypeface(medium);

        //date of birth date picker
        dobdateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                textDOB.setText(date);
            }
        };


        //changing terms and condition colour
        SpannableString ss = new SpannableString("I agree to Terms and Conditions.");
        ClickableSpan clickableSpan = new ClickableSpan()
        {
            @Override
            public void onClick(View textView)
            {
                    /*  Intent go=new Intent(Register.this, TermsConditionActivity.class);
                        startActivity(go);*/
            }
            @Override
            public void updateDrawState(TextPaint ds)
            {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };

        ss.setSpan(clickableSpan, 11, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new UnderlineSpan(), 11, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txttermsncond.setText(ss);
        txttermsncond.setMovementMethod(LinkMovementMethod.getInstance());
        txttermsncond.setLinkTextColor(Color.parseColor("#3ac6cd"));

        String name = eduname.getText().toString();
        String mob = edumobile.getText().toString();
        // as now we have information in string. Lets stored them with the help of editor
        //first argument is name of the file and second is mode
        pref = getSharedPreferences("Registration", 0);

        // get editor to edit in file
        editor = pref.edit();
        editor.putString("Name", name);
        editor.putString("Mob", mob);

        //to get value from treatment userconfirm
        Intent registerintent = getIntent();
        if(registerintent.getExtras()!=null)
        {

            treatmentconfirm = getIntent().getExtras().getBoolean("treatmentconfirm");

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Register.this,ScanActivity.class));
                }
            });
        }

    }
   //on create method end

    //alert dailog box method for registration alert.
    private void openDailog()
    {
        String dob=textDOB.getText().toString();
        AlertDialog.Builder alertdailog = new AlertDialog.Builder(Register.this,R.style.MyDialogTheme);
        alertdailog.setTitle("Alert");
        alertdailog.setMessage("Please correct the information in the field having red alert, click on red alert to know the details");
        alertdailog.setCancelable(true);

        if (dob.length()< 0 || dob.equals("") || dob == null)           //username validation
        {
            alertdailog.setTitle("Alert");
            alertdailog.setMessage("Please select proper age");
            alertdailog.setCancelable(true);
        }
        alertdailog.setPositiveButton("Ok", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int which)
            {
                dialogInterface.cancel();
            }
        });
        AlertDialog diag = alertdailog.create();
         //Display the message!
         diag.show();

    }

    //date picker for birth date

    @Override
    public void onClick(View view)
    {
        if(view==textDOB)
        {
            DatePickerDialog datePickerDialog = new DatePickerDialog(Register.this,AlertDialog.THEME_HOLO_DARK,dobdateSetListener,year,month,day);
            datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            datePickerDialog.show();
        }


    }

    //email match pattern boolean method
    public static boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches())
        {
            isValid = true;
        }
        return isValid;
    }


    //validation of registration form user input
    boolean isvalidate()
    {
        String seduname = eduname.getText().toString();
        String sedemail = edemail.getText().toString().trim();

        String sedumobile = edumobile.getText().toString();
        String seduusername = eduusername.getText().toString();
        String dob=textDOB.getText().toString();
        String sedupassword = edupassword.getText().toString();
        String sedurepassword = edurepassword.getText().toString();
        String scheck = check.getText().toString();

        //email patterns
        if (seduname.isEmpty() || seduname.equals("") || seduname == null || seduname.equals("[a-zA-Z]+\\\\.?"))       //name validation
        {
            eduname.setError("Does not valid empty , null and spaces");
        }
        if (!isEmailValid(sedemail) || sedemail.isEmpty() || sedemail.equals("") || sedemail == null)  // email validation
        {
            edemail.setError("Enter Valid Email Id");
        }

         if (seduusername.isEmpty() || seduusername.equals("") || seduusername == null)           //username validation
        {
            eduusername.setError("Does not valid empty , null and spaces");
        }
       /* if (dob.length()< 0 || dob.equals("") || dob == null)           //username validation
        {

            //textDOB.setError("Date of birth should not be blanked");
            //Toast.makeText(Register.this,"Please Select DOB",Toast.LENGTH_LONG).show();
        }*/

        if (sedumobile.isEmpty() || sedumobile.equals("") || sedumobile == null || sedumobile.length() < 10)       // mobile validation
        {
            edumobile.setError("Enter valid mobile number");
        }
        if (sedupassword.isEmpty() || sedupassword.equals("") || sedupassword == null || sedupassword.length() < 6)       // password validation
        {
            edupassword.setError("Must contains Lowercase, Upper case and special character");
        }
        if (sedurepassword.isEmpty() || sedurepassword.equals("") || sedurepassword == null || sedupassword.length() < 6)       // password validation
        {
            edurepassword.setError(" Must contains Lowercase, Upper case and special character");

        }

        //check password of two string
        if (!sedupassword.equals(sedurepassword))
        {
            edurepassword.setError(" Password must be match");
        }
        if (!check.isChecked())
        {
            Toast t = Toast.makeText(this, "Please Agree Terms and conditions", Toast.LENGTH_SHORT);
            t.show();
        }

        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.call, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @OnClick({R.id.btnLogin, R.id.tvLogin})

    public void registerClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnLogin:

                //calling validation method for user validation
              //  isvalidate();

                    if(isvalidate())
                {
                    openDailog();
                }
                else
                {
                    Toast.makeText(this, "You Have registred successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this, ScrollingActivity.class);
                    startActivity(intent);
                }
                Intent intent1 = getIntent();

                break;

            case R.id.tvLogin:


                startActivity(new Intent(Register.this, LoginActivity.class));
                break;
        }
    }


}




















