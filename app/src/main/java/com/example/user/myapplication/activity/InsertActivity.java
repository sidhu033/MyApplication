package com.example.user.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.user.myapplication.AddReading;
import com.example.user.myapplication.FeedReaderContract;
import com.example.user.myapplication.FeedReaderDbHelper;
import com.example.user.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InsertActivity extends AppCompatActivity {

    @BindView(R.id.rSys)
    EditText rSys;
    @BindView(R.id.rdys)
    EditText rDys;
    @BindView(R.id.rHr)
    EditText rHr;
    @BindView(R.id.lSys)
    EditText lSys;
    @BindView(R.id.ldys)
    EditText ldys;
    @BindView(R.id.lHr)
    EditText lHr;

    private FeedReaderDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        ButterKnife.bind(InsertActivity.this);

        db = new FeedReaderDbHelper(this);
    }

    @OnClick({R.id.btnSave})
    public void save(View view) {
        switch (view.getId()) {
            case R.id.btnSave:
                FeedReaderContract feedReaderContract = db.getUserId("true");
                String strSys = rSys.getText().toString();
                String strDys = rDys.getText().toString();
                String strPulse = rHr.getText().toString();
                String stlSys = lSys.getText().toString();
                String stlDys = ldys.getText().toString();
                String stlPulse = lHr.getText().toString();
                String userId = feedReaderContract.getUserId();
                String syncStatus = "0";
                long id = db.insertReading(userId, syncStatus, strSys, strDys, strPulse, stlSys, stlDys, stlPulse);

                if (id > 0) {

                   startActivity(new Intent(InsertActivity.this, LogActivity.class));
                }

                break;
        }
    }
}
