package com.example.timeentry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.timeentry.adapter.TimeSheetAdapter;
import com.example.timeentry.database.DataBaseController;
import com.example.timeentry.database.TimeSheet;
import com.example.timeentry.databinding.ActivityMainBinding;
import com.example.timeentry.databinding.ActivityViewTimeSheetBinding;

import java.util.List;
import java.util.concurrent.Executors;

public class ViewTimeSheetActivity extends AppCompatActivity {
    private TimeSheetAdapter mTimeSheetAdapter;
    private ActivityViewTimeSheetBinding mActivityViewTimeSheetBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityViewTimeSheetBinding= DataBindingUtil.setContentView(this,R.layout.activity_view_time_sheet);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                List<TimeSheet>timeSheets=DataBaseController.getInstance(ViewTimeSheetActivity.this).getDaoall().getAlldatas();
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mActivityViewTimeSheetBinding.recyclerview.setLayoutManager(new LinearLayoutManager(ViewTimeSheetActivity.this));
                        mTimeSheetAdapter=new TimeSheetAdapter(timeSheets);
                        mActivityViewTimeSheetBinding.recyclerview.setAdapter(mTimeSheetAdapter);
                    }
                });
            }
        });
    }
}