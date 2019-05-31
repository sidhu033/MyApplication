package com.example.user.myapplication.activity;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;
import com.example.user.myapplication.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LogFinal extends AppCompatActivity
{
    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());
    TextView txtloghdate;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_final);

        getSupportActionBar().setLogo(R.drawable.glogo);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setTitle("LOGS");

        //Set an event for Teachers' Professional Day 2016 which is 21st of October

        txtloghdate = findViewById(R.id.txtloghdate);

        String Date = DateFormat.getDateTimeInstance().format(new Date());
        txtloghdate.setText(Date);
        txtloghdate.setTextColor(Color.BLACK);

        compactCalendar = findViewById(R.id.compactCalendar);
        Event ev1 = new Event(Color.BLACK, 1477040400000L, "Teachers' Professional Day");
        compactCalendar.addEvent(ev1);

        Log.e("ev1","null object");
        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener()
        {
            @Override
            public void onDayClick(Date dateClicked)
            {

                Context context = getApplicationContext();
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth)
            {

            }
        });
    }
}
