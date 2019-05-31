package com.example.user.myapplication.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.myapplication.AddReading;
import com.example.user.myapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogsAdapter extends RecyclerView.Adapter<LogsAdapter.LogsHolder> {

    private List<AddReading> mLogsList;
    private Activity mContext;

    public LogsAdapter(List<AddReading> mLogsList, Activity mContext) {
        this.mLogsList = mLogsList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public LogsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_logs, viewGroup, false);
        return new LogsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LogsHolder logsHolder, int i) {
        AddReading addReading = mLogsList.get(i);
        logsHolder.rrSys.setText(addReading.getrSys());
        logsHolder.rrDys.setText(addReading.getrDys());
        logsHolder.rrHr.setText(addReading.getrPulse());
        logsHolder.llSys.setText(addReading.getlSys());
        logsHolder.llDys.setText(addReading.getlDys());
        logsHolder.llHr.setText(addReading.getlPulse());
        if (addReading.getSyncStatus().equals("1")) {
            logsHolder.imgCheck.setVisibility(View.VISIBLE);
        } else {
            logsHolder.imgCheck.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mLogsList.size();
    }

    public class LogsHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rrSys)
        TextView rrSys;
        @BindView(R.id.rrDys)
        TextView rrDys;
        @BindView(R.id.rrHr)
        TextView rrHr;
        @BindView(R.id.llSys)
        TextView llSys;
        @BindView(R.id.llDys)
        TextView llDys;
        @BindView(R.id.llHr)
        TextView llHr;
        @BindView(R.id.imgCheck)
        ImageView imgCheck;

        public LogsHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
