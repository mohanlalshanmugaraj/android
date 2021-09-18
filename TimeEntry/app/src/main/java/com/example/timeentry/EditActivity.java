package com.example.timeentry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.timeentry.database.DataBaseController;
import com.example.timeentry.database.TimeSheet;
import com.example.timeentry.databinding.ActivityEditBinding;

import java.io.Serializable;
import java.sql.Time;
import java.util.concurrent.Executors;

public class EditActivity extends AppCompatActivity {
    private String[] date1={"sep-4","sep-11","sep-18","sep-25","Oct-2","Oct-9","Oct-16","Oct-23","Oct-30"};
    ActivityEditBinding mActivityEditBinding;
    private Serializable mTimeSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityEditBinding= DataBindingUtil.setContentView(this,R.layout.activity_edit);
//        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,date1);
//        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        mActivityEditBinding.spinnerDate.setAdapter(aa);

        mTimeSheet=getIntent().getSerializableExtra("timesheet");
        lodeSheet((TimeSheet) mTimeSheet);

        mActivityEditBinding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mActivityEditBinding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTimeSheet((TimeSheet) mTimeSheet);
            }
        });

    }

    private void lodeSheet(TimeSheet timeSheet) {
        //mActivityEditBinding.spinnerDate.setOnItemSelectedListener(this);
        mActivityEditBinding.task1.setText(timeSheet.getTask1());
        mActivityEditBinding.task2.setText(timeSheet.getTask2());
        mActivityEditBinding.task3.setText(timeSheet.getTask3());
        mActivityEditBinding.task4.setText(timeSheet.getTask4());
        mActivityEditBinding.task5.setText(timeSheet.getTask5());
        mActivityEditBinding.hour1.setText(timeSheet.getHour1());
        mActivityEditBinding.hour2.setText(timeSheet.getHour2());
        mActivityEditBinding.hour3.setText(timeSheet.getHour3());
        mActivityEditBinding.hour4.setText(timeSheet.getHour4());
        mActivityEditBinding.hour5.setText(timeSheet.getHour5());
        mActivityEditBinding.tvDate.setText(timeSheet.getDate());
        mActivityEditBinding.TotalHours.setText(timeSheet.getTotalhours()); }

    private void editTimeSheet(TimeSheet timeSheets) {
        String task1 =mActivityEditBinding.task1.getText().toString();
        String task2= mActivityEditBinding.task2.getText().toString();
        String task3=mActivityEditBinding.task3.getText().toString();
        String task4=mActivityEditBinding.task4.getText().toString();
        String task5=mActivityEditBinding.task5.getText().toString();
        int hour1= Integer.parseInt(mActivityEditBinding.hour1.getText().toString());
        int hour2=Integer.parseInt(mActivityEditBinding.hour2.getText().toString());
        int hour3=Integer.parseInt(mActivityEditBinding.hour3.getText().toString());
        int hour4=Integer.parseInt(mActivityEditBinding.hour4.getText().toString());
        int hour5=Integer.parseInt(mActivityEditBinding.hour5.getText().toString());
        int totalhours=hour1+hour2+hour3+hour4+hour5;
        String th=Integer.toString(totalhours);

        String h1=mActivityEditBinding.hour1.getText().toString();
        String h2=mActivityEditBinding.hour2.getText().toString();
        String h3=mActivityEditBinding.hour3.getText().toString();
        String h4=mActivityEditBinding.hour4.getText().toString();
        String h5=mActivityEditBinding.hour5.getText().toString();
        //String date= (String) mActivityEditBinding.spinnerDate.getSelectedItem();
        mActivityEditBinding.TotalHours.setText(Integer.toString(totalhours));


        timeSheets.setHour1(h1);
        timeSheets.setHour2(h2);
        timeSheets.setHour3(h3);
        timeSheets.setHour4(h4);
        timeSheets.setHour5(h5);
        timeSheets.setTotalhours(Integer.toString(totalhours));
        timeSheets.setDate(mActivityEditBinding.tvDate.getText().toString());

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                DataBaseController.getInstance(EditActivity.this).getDaoall().updateAllData(timeSheets);
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
                        finish();
                    }
                });
            }
        });

    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
}