package com.example.timeentry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.timeentry.database.DataBaseController;
import com.example.timeentry.database.TimeSheet;
import com.example.timeentry.databinding.ActivityCreateTimeSheetBinding;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.Executors;

public class CreateTimeSheetActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ActivityCreateTimeSheetBinding mActivityCreateTimeSheetsBinding;
    private String[] date1={"sep-4","sep-11","sep-18","sep-25","Oct-2","Oct-9","Oct-16","Oct-23","Oct-30"};
    private DatePickerDialog dpd;
    private static final Integer MAX_YEAR = 5 * 365;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_time_sheet);


        mActivityCreateTimeSheetsBinding= DataBindingUtil.setContentView(this,R.layout.activity_create_time_sheet);
//        mActivityCreateTimeSheetsBinding.spinnerDate.setOnItemSelectedListener(this);
//        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,date1);
//        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        mActivityCreateTimeSheetsBinding.spinnerDate.setAdapter(aa);

        mActivityCreateTimeSheetsBinding.tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDate();
            }

            private void getDate() {
                dpd = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(new com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(com.wdullaer.materialdatetimepicker.date.DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                        mActivityCreateTimeSheetsBinding.tvDate.setText(dayOfMonth + "-" + monthOfYear);
                    }
                });

                ArrayList<Calendar> weekends = new ArrayList<>();
                Calendar day = Calendar.getInstance();
                for (int i = 0; i < MAX_YEAR; i++) {
                    if (day.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        Calendar d = (Calendar) day.clone();
                        weekends.add(d);
                    }
                    day.add(Calendar.DATE, 1);
                }
                Calendar[] weekendDays = weekends.toArray(new Calendar[weekends.size()]);

                dpd.setSelectableDays(weekendDays);

                dpd.show(getSupportFragmentManager(), "Date Picker");

            }
        });




        mActivityCreateTimeSheetsBinding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CreateTimeSheetActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        mActivityCreateTimeSheetsBinding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task1 =mActivityCreateTimeSheetsBinding.task1.getText().toString();
                String task2= mActivityCreateTimeSheetsBinding.task2.getText().toString();
                String task3=mActivityCreateTimeSheetsBinding.task3.getText().toString();
                String task4=mActivityCreateTimeSheetsBinding.task4.getText().toString();
                String task5=mActivityCreateTimeSheetsBinding.task5.getText().toString();
                int hour1= Integer.parseInt(mActivityCreateTimeSheetsBinding.hour1.getText().toString());
                int hour2=Integer.parseInt(mActivityCreateTimeSheetsBinding.hour2.getText().toString());
                int hour3=Integer.parseInt(mActivityCreateTimeSheetsBinding.hour3.getText().toString());
                int hour4=Integer.parseInt(mActivityCreateTimeSheetsBinding.hour4.getText().toString());
                int hour5=Integer.parseInt(mActivityCreateTimeSheetsBinding.hour5.getText().toString());
                int totalhours=hour1+hour2+hour3+hour4+hour5;
                String th=Integer.toString(totalhours);

                String h1=mActivityCreateTimeSheetsBinding.hour1.getText().toString();
                String h2=mActivityCreateTimeSheetsBinding.hour2.getText().toString();
                String h3=mActivityCreateTimeSheetsBinding.hour3.getText().toString();
                String h4=mActivityCreateTimeSheetsBinding.hour4.getText().toString();
                String h5=mActivityCreateTimeSheetsBinding.hour5.getText().toString();

                // String date= mActivityCreateTimeSheetsBinding.spinnerDate.getSelectedItem().toString();
                mActivityCreateTimeSheetsBinding.TotalHours.setText(Integer.toString(totalhours));

                if (TextUtils.isEmpty(task1)) {
                    mActivityCreateTimeSheetsBinding.task1.setError("Pleas enter task1");
                } else if (TextUtils.isEmpty(task2)) {
                    mActivityCreateTimeSheetsBinding.task2.setError("Pleas enter task2");
                } else if (TextUtils.isEmpty(task3)) {
                    mActivityCreateTimeSheetsBinding.task3.setError("Pleas enter task3");
                } else if (TextUtils.isEmpty(task4)) {
                    mActivityCreateTimeSheetsBinding.task4.setError("Pleas enter task4");
                } else if (TextUtils.isEmpty(task5)) {
                    mActivityCreateTimeSheetsBinding.task5.setError("Pleas enter task5");

                } else if (TextUtils.isEmpty(h1)) {
                    mActivityCreateTimeSheetsBinding.hour1.setError("Pleas enter hours1");
                } else if (TextUtils.isEmpty(h2)) {
                    mActivityCreateTimeSheetsBinding.hour2.setError("Pleas enter hours2");
                } else if (TextUtils.isEmpty(h3)) {
                    mActivityCreateTimeSheetsBinding.hour3.setError("Pleas enter hours3");
                } else if (TextUtils.isEmpty(h4)) {
                    mActivityCreateTimeSheetsBinding.hour4.setError("Pleas enter hours4");
                } else if (TextUtils.isEmpty(h5)) {
                    mActivityCreateTimeSheetsBinding.hour5.setError("Pleas enter hours5");
                }  else {
                    TimeSheet timeSheets = new TimeSheet();
                    timeSheets.setTask1(task1);
                    timeSheets.setTask2(task2);
                    timeSheets.setTask3(task3);
                    timeSheets.setTask4(task4);
                    timeSheets.setTask5(task5);
                    timeSheets.setHour1(h1);
                    timeSheets.setHour2(h2);
                    timeSheets.setHour3(h3);
                    timeSheets.setHour4(h4);
                    timeSheets.setHour5(h5);
                    timeSheets.setTotalhours(th);
                    timeSheets.setDate(mActivityCreateTimeSheetsBinding.tvDate.getText().toString());
                    Executors.newSingleThreadExecutor().execute(new Runnable() {
                        @Override
                        public void run() {
                            DataBaseController.getInstance(getApplicationContext()).getDaoall().insertAllData(timeSheets);
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    });
                }


            }
        });

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}