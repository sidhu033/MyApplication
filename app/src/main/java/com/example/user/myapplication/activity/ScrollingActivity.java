package com.example.user.myapplication.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.user.myapplication.R;
import com.example.user.myapplication.MenuVo;

import com.example.user.myapplication.adapter.ExapandableListAdapter;
import com.example.user.myapplication.adapter.MenusAdapter;
import com.example.user.myapplication.pojo.ExpandableMenuModel;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScrollingActivity extends AppCompatActivity
{

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;    //toogle
    private NavigationView nv;
    private ImageView img;
    Context context;
    TextView txtnewcurrent;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recMenus)
    RecyclerView recMenus;

    // CardView cd;
    private List<MenuVo> menuVoList = null;                 //setting menus of right side. with model object

    ExapandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;

    ArrayList<ExpandableMenuModel> listDataHeader;
    HashMap<ExpandableMenuModel, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        click();    //card menus like blog , news on right image click
        ButterKnife.bind(ScrollingActivity.this);

        //Creating exapdable list view


        prepareListData();


        //recycle view menus for viewing all menus
        recMenus.setLayoutManager( new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));

         initializeMenuItemList();               //intilize menus items in card view

        //menu adapter instance cast in recycle menus
        MenusAdapter adapter = new MenusAdapter(menuVoList, this);
        recMenus.setAdapter(adapter);



        //intitlizations
        expandableList = findViewById(R.id.expadablelist);
        expandableList = findViewById(R.id.expadablelist);

        mMenuAdapter = new ExapandableListAdapter(this, listDataHeader, listDataChild, expandableList);
        expandableList.setAdapter(mMenuAdapter);                                        // setting list adapter


        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
        {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l)
            {
                //Log.d("DEBUG", "submenu item clicked");
                return false;
            }
        });
        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
        {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l)
            {

                //Log.d("DEBUG", "heading clicked");
                return false;
            }
        });


        //ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(context, R.dimen.item_offset);
        //recMenus.addItemDecoration(itemDecoration);

        //adapters for menu


       // recMenus.setOnClickListener(new );
       /* recMenus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScrollingActivity.this,Pin.class);
                startActivity(i);
            }
        });*/

        //recylce view


        recMenus = (RecyclerView) findViewById(R.id.recMenus);
        setSingleEvent(recMenus);


        /*  public void setSingleEvent(GridLayoutManager recMenus) {

            for (int i = 0; i<recMenus.getChildCount();i++){
                CardView cardView = (CardView)recMenus.getChildAt(i);

                final int finalI = i;
                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (finalI == 0)
                        {
                            Intent intent = new Intent(ScrollingActivity.this, Pin.class);
                        }
                        else if (finalI == 0)
                        {
                            Toast.makeText(ScrollingActivity.this,"Second Activity" ,Toast.LENGTH_SHORT).show();
                            //Intent intent = new Intent(ScrollingActivity.this, Pin.class);
                        }
                    }
                });
            }


        }*/


       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       // getSupportActionBar().setLogo(R.drawable.web);
      //  getSupportActionBar().setIcon(R.drawable.web);
        // getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDisplayUseLogoEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(false);
        //toolbar.setNavigationIcon(R.drawable. web);

/*

*/


       //set date on current textview



        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.gham);

        dl = (DrawerLayout)findViewById(R.id.drawer_main);          //Drawer layout intialzation



      /*  t.setDrawerIndicatorEnabled(false);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.gham, getTheme());
        t.setHomeAsUpIndicator(drawable);
        t.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dl.isDrawerVisible(GravityCompat.START)) {
                    dl.closeDrawer(GravityCompat.START);
                } else {
                    dl.openDrawer(GravityCompat.START);
                }
            }
        });
*/
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);      //toogle button
        dl.addDrawerListener(t);                //on drawer toggle button add
        t.syncState();


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.gham);


        nv = (NavigationView)findViewById(R.id.nv);

        View headerview = nv.getHeaderView(0);
        String Date= DateFormat.getDateTimeInstance().format(new Date());
        txtnewcurrent= headerview.findViewById(R.id.txtnewdate);
        txtnewcurrent.setText(Date);
        txtnewcurrent.setTextColor(Color.WHITE);


        //setting color and split of txt in date
        SpannableString spannableString = new SpannableString(Date);
        spannableString.setSpan(new RelativeSizeSpan(3f),0,2,0);
        spannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, 0);// set color
        txtnewcurrent.setText(spannableString);

        String[] results = Date.split(" ",2);
        results[0] = results[0].trim();
        Log.e("current date",Date);

        //to change colour of menus
        nv.setItemTextColor(new ColorStateList
                (

                new int [] [] {

                        new int [] {android.R.attr.state_checked},
                        new int [] {}
                },
                new int [] {

                        Color.parseColor("#f8a519"),
                       // Color.rgb (97, 65, 10),
                        Color.WHITE
                }



        ));

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                item.setChecked(true);
                dl.closeDrawers();
                switch(id)
                {
                  /*  case R.id.account:

                           Toast.makeText(ScrollingActivity.this, "My Profle",Toast.LENGTH_SHORT).show();*/
                    case R.id.paccount:
                         if(id==R.id.paccount)
                        {

                          startActivity(new Intent(ScrollingActivity.this, ManageSelfProfile.class));
                        }
                    case R.id.caccount:

                        if(id==R.id.caccount)
                        {
                            startActivity(new Intent(ScrollingActivity.this, CreateChild.class));
                        }
                    case  R.id.healthmeter:
                        if(id==R.id.healthmeter)
                        {
                            startActivity(new Intent(ScrollingActivity.this, HealthMone.class));
                        }
                    case  R.id.treatment:
                        if(id==R.id.treatment)
                        {
                            AlertDialog.Builder builder;
                            builder = new AlertDialog.Builder(ScrollingActivity.this,R.style.MyDialogTheme);
                            builder.setMessage("Do You Have Device ?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i)
                                {
                                    startActivity(new Intent(getApplicationContext(), Pin.class));

                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i)
                                {
                                    dialogInterface.cancel();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.putExtra("isDevice",true);
                                    startActivity(intent);
                                }
                            });
                            AlertDialog alert = builder.create();
                            alert.setTitle("You Cannot Take Treatment Without Device");
                            alert.show();
                        }
                        //R.id.caccount:
                      //  startActivity(new Intent(ScrollingActivity.this, ManageChildProfile.class));

                   /* case  R.id.treatment:
                        Toast.makeText(ScrollingActivity.this, "Treatment",Toast.LENGTH_SHORT).show();

                    case  R.id.analytics:
                        Toast.makeText(ScrollingActivity.this, "analytics",Toast.LENGTH_SHORT).show();

                    case  R.id.healthmeter:
                        Toast.makeText(ScrollingActivity.this, "Helath meter",Toast.LENGTH_SHORT).show();

                    case  R.id.enterntainment:
                        Toast.makeText(ScrollingActivity.this, "Entertainment",Toast.LENGTH_SHORT).show();

                    case  R.id.healthtips:
                        Toast.makeText(ScrollingActivity.this, "Health tips",Toast.LENGTH_SHORT).show();

                    case  R.id.gamservices:
                        Toast.makeText(ScrollingActivity.this, "Gam Services",Toast.LENGTH_SHORT).show();

                    case  R.id.news:
                        Toast.makeText(ScrollingActivity.this, "News",Toast.LENGTH_SHORT).show();

                    case R.id.settings:
                        Toast.makeText(ScrollingActivity.this, "Settings",Toast.LENGTH_SHORT).show();
*/
                    default:
                        return true;
                }
            }
        });
        t.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.yellow));

    }
    //on create closed









    //card menus on right click of image view click
    public void click ()
    {
        img = (ImageView)findViewById(R.id.imageView2);
        //cv =  (CardView)findViewById(R.id.card_view);

        img.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ScrollingActivity.this, Card.class);
                startActivity(intent);
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
//set event on signle item of recycle view
    private void setSingleEvent(RecyclerView recyclerView)
    {
        for (int i = 0; i<recMenus.getChildCount();i++)
        {
            GridLayout gridLayout = (GridLayout) recMenus.getChildAt(i);
            final int finalI = i;

            gridLayout.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                   /* if (finalI==0)
                    {
                        Intent intent = new Intent(ScrollingActivity.this, Pin.class);
                        startActivity(intent);

                    }*/

                }

            });
        }
    }

   /* private void setSing  leEvent(RecyclerView recMenus) {
        for (int i = 0; i<recMenus.getChildCount();i++) {
            LinearLayout linearLayout = (LinearLayout) recMenus.getChildAt(i);

            final int finalI = i;
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                   // Toast.makeText(ScrollingActivity.this,"Clicked at Index"+finalI ,Toast.LENGTH_SHORT).show();
                    if (finalI == 0) {
                        Intent intent = new Intent(ScrollingActivity.this, Pin.class);
                        startActivity(intent);

                    }
                }
            });
        }
        }*/

    /* Initialise menu items in  card list. */
    private void initializeMenuItemList()
    {
        if(menuVoList == null)
        {
            menuVoList = new ArrayList<MenuVo>();
            menuVoList.add(new MenuVo(R.drawable.ic_launcher_setting, "TREATMENT"));
            menuVoList.add(new MenuVo(R.drawable.ic_launcher_heart, "HEALTH METER"));
            menuVoList.add(new MenuVo(R.drawable.ic_launcher_tv, "ENTERNTAINMENT"));
            menuVoList.add(new MenuVo(R.drawable.ic_launcher_tips, "HEALTH TIPS"));
            menuVoList.add(new MenuVo(R.drawable.ic_settings, "SETTING"));
            menuVoList.add(new MenuVo(R.drawable.gamservice, "GAM SERVICES"));
        }
    }
    //prepare menus for dropdown with child and parents
    private void prepareListData()
    {
        listDataHeader = new ArrayList<ExpandableMenuModel>();
        listDataChild = new HashMap<ExpandableMenuModel, List<String>>();

        ExpandableMenuModel item1 = new ExpandableMenuModel();

        //adding items
        item1.setIconName("My Profile");
        item1.setIconNameColor(Color.WHITE);
        listDataHeader.add(item1);


        // Adding child data
        List<String> heading1 = new ArrayList<String>();
        heading1.add("Parent Profile");
        heading1.add("Child Profile");
        listDataChild.put(listDataHeader.get(0), heading1);     // Header, Child data*/


    }


   /* public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space)
        {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.top = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.top = space;
            } else {
                outRect.top =  0 ;
                outRect.right = 0;
                outRect.bottom = 0;
            }
        }
    }*/

   /* private class ItemOffsetDecoration extends RecyclerView.ItemDecoration {

        private int mItemOffset;

        public ItemOffsetDecoration(int itemOffset) {
            mItemOffset = itemOffset;
        }

        public ItemOffsetDecoration(@NonNull Context context, @DimenRes int itemOffsetId) {
            this(context.getResources().getDimensionPixelSize(itemOffsetId));
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
        }
    }*/
}

