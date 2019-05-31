package com.example.user.myapplication.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.user.myapplication.R;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CreateChild extends AppCompatActivity
{
    TextView txtcreatechild1,txtset1stchild,txtset2stchild;
    Button btnchild1,btnchild2,btnpremium;

    SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_child);




        getSupportActionBar().setHomeAsUpIndicator(R.drawable.glogo);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CREATE CHILD");
        //intitilze
        //txtset1stchild =findViewById(R.id.txtset1stchild);
        //txtset2stchild = findViewById(R.id.txtset2stchild);
        txtcreatechild1 = findViewById(R.id.txtcreatechild1);
        btnchild1 = findViewById(R.id.btnchild1);
        btnchild2 = findViewById(R.id.btnchild2);
        btnpremium = findViewById(R.id.btnpremium);

        //changing terms and condition colour
        SpannableString ss = new SpannableString("As Per Policy , You Can Create Two Child Users");
        ClickableSpan clickableSpan = new ClickableSpan()
        {
            @Override
            public void onClick( View view)
            {

            }
        };
        ss.setSpan(clickableSpan,31, 34, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtcreatechild1.setText(ss);
        txtcreatechild1.setLinkTextColor(Color.parseColor("#f8a519"));

        //on first child click
        btnchild1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent();
                startActivity(new Intent(CreateChild.this,ChildRegister.class));
                intent.putExtra("is1stchild",true);
                // retrieving value from Registration

               /* String name = pref.getString("Name", null);
                String mob = pref.getString("Mob", null);

                // Now set these value into textview of second activity
                txtset1stchild.setText(name);
                txtset2stchild.setText(mob);*/
            }
        });
        //on second child click
        btnchild2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(CreateChild.this,ChildRegister.class));

            }
        });

        btnpremium.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //startActivity(new Intent(CreateChild.this,CreatePremium.class));
                Toast.makeText(CreateChild.this,"Premium user",Toast.LENGTH_LONG).show();

            }
        });

    }
}
