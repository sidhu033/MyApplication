package com.example.user.myapplication.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.user.myapplication.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{
    private DrawerLayout dl;
    private NavigationView nv;
    private android.support.v7.widget.Toolbar maintoolbar1;

    //private ActionBarDrawerToggle t
    //0private ActionBar actionBar;
    //   @BindView(R.id.recMenus)
    //    RecyclerView recMenus;
    //    @BindView(R.id.btnYes)
    //    Button btnYes;
    //    @BindView(R.id.btnNo)
    //    Button btnNo;

    Button btnYes, btnNo;
    TextView maintxttitle, txtrevolution, txtdhr;
    Typeface regular, bold, medium;
    private boolean isDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(MainActivity.this);

        //setting up of custom fonts

        regular = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.regular));
        bold = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.bold));
        medium = Typeface.createFromAsset(this.getAssets(), getResources().getString(R.string.medium));

        //intilization
        maintxttitle = findViewById(R.id.maintxttitle);
        txtrevolution = findViewById(R.id.txtrevolution);
        txtdhr = findViewById(R.id.txtdhr);


        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);
        android.support.v7.widget.Toolbar maintoolbar1 = findViewById(R.id.maintoolbar1);
        //setting custom fonts for varaible
        btnYes.setTypeface(medium);
        btnNo.setTypeface(medium);

        maintxttitle.setTypeface(medium);                   //medium condense
        txtrevolution.setTypeface(bold);
        txtdhr.setTypeface(medium);


        //change the textview of activity Main activity for previous for already registered user screen
            Intent intent = getIntent();
            if (getIntent().getExtras()!=null)
            {
                isDevice = getIntent().getExtras().getBoolean("isDevice");
            }
            if(isDevice)
            {
                txtrevolution.setText("YOU CANNOT TAKE TREATMENT WITHOUT DEVICE");
                txtrevolution.setTextSize(18);
                maintxttitle.setText("WANT DEVICE?");

                btnYes.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        startActivity(new Intent(MainActivity.this, PaymentAsk.class));
                    }
                });
            }

      /*  setSupportActionBar(maintoolbar1);
        getSupportActionBar().setTitle("DO YOU HAVE REDOXER");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
*/

;


        // ActionBar actionBar = null;
        //actionBar.setTitle("ic_launcher_logo");
        // int drawerArrowDrawable;


        //   getSupportActionBar().setHomeButtonEnabled(false);
       /* dl = (DrawerLayout)findViewById(R.id.drawer_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.str


        ing.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.account:
                        Toast.makeText(MainActivity.this, "My Account",Toast.LENGTH_SHORT).show();
                    case R.id.settings:
                        Toast.makeText(MainActivity.this, "Settings",Toast.LENGTH_SHORT).show();
                    case R.id.mycart:
                        Toast.makeText(MainActivity.this, "My Cart",Toast.LENGTH_SHORT).show();
                    default:
                        return true;
                }




            }
        });
*/

    }

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
*/
 /* @Override
  public  boolean onCreateOptionsMenu(Menu menu)
  {
      MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.right_menu,menu);
      return super.onCreateOptionsMenu(menu);
  }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       /* if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }*/


    @OnClick({R.id.btnYes, R.id.btnNo})
    public void btnClick(View view)
    {
        switch (view.getId())
        {

            case R.id.btnYes:
                Intent intentInst = new Intent(MainActivity.this, Yes.class);
                startActivity(intentInst);
                break;

            case R.id.btnNo:
                Intent intent = new Intent(MainActivity.this, Slider2.class);
                startActivity(intent);
                break;
        }
    }

}
