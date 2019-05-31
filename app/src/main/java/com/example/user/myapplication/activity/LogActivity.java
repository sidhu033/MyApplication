package com.example.user.myapplication.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.user.myapplication.AddReading;
import com.example.user.myapplication.ApiClient;
import com.example.user.myapplication.ApiInterface;
import com.example.user.myapplication.FeedReaderDbHelper;
import com.example.user.myapplication.R;
import com.example.user.myapplication.adapter.LogsAdapter;
import com.example.user.myapplication.pojo.SaveEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogActivity extends AppCompatActivity {

    @BindView(R.id.recLogs)
    RecyclerView recLogs;

    private FeedReaderDbHelper db;
    private List<AddReading> mReadings;
    private LogsAdapter logsAdapter;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        ButterKnife.bind(LogActivity.this);

        db = new FeedReaderDbHelper(this);
        mReadings = new ArrayList<>();

        final String userId = db.getUserId("true").getUserId();
        mReadings = db.getAllReadings(userId);

        recLogs.setLayoutManager(new LinearLayoutManager(this));
        logsAdapter = new LogsAdapter(mReadings, this);
        recLogs.setAdapter(logsAdapter);

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        scheduledExecutorService.schedule(new Runnable() {

                                              @Override
                                              public void run() {
                                                  LogActivity.this.runOnUiThread(new Runnable() {

                                                      @Override
                                                      public void run() {

                                                          List<AddReading> mUnsyncRecords = db.getAllReadingsUnsync(userId);
                                                          if (mUnsyncRecords != null) {
                                                              if (mUnsyncRecords.size() > 0)
                                                                  saveReadingsOnServer(mUnsyncRecords.get(0));
                                                          }


                                                      }
                                                  });

                                              }
                                          },
                5,
                TimeUnit.SECONDS);

    }

    /**
     * Method to save readings on server
     *
     * @param reading
     */
    private void saveReadingsOnServer(final AddReading reading) {

        String username = db.getUserId("true").getUsername();
//        ApiInterface apiInterface = ApiClient.getClient("http://192.168.1.101/Android/").create(ApiInterface.class);
        ApiInterface apiInterface = ApiClient.getClient("http://gamsystech.com/login/login2018/").create(ApiInterface.class);
        Call<SaveEntity> mEntity = apiInterface.saveReadings(username, "2018/08/11 03:30:22", reading.getrSys(), reading.getrDys(),
                reading.getrPulse(), reading.getlSys(), reading.getlDys(), reading.getlPulse());

        mEntity.enqueue(new Callback<SaveEntity>() {
            @Override
            public void onResponse(Call<SaveEntity> call, Response<SaveEntity> response) {
                if (response.isSuccessful()) {
                    SaveEntity saveEntity = response.body();
                    if (!saveEntity.getError()) {
                        db.changeSyncStatus(reading.getId());
                        mReadings = db.getAllReadings(reading.getUserId());
                        logsAdapter.notifyDataSetChanged();
//                        index++;
                    }

                }
            }

            @Override
            public void onFailure(Call<SaveEntity> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
