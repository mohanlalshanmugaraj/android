package com.example.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class agecalculator extends AppCompatActivity {
    EditText date1,date2;
    Button calculator,reset,calendarview;
    TextView year1,month1,day1;

    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();                  //title hideing

        setContentView(R.layout.activity_agecalculator);
        date1=findViewById(R.id.date1);
       // date2=findViewById(R.id.date2);
        year1=findViewById(R.id.year);
        month1=findViewById(R.id.month);
        day1=findViewById(R.id.day);
        reset=findViewById(R.id.reset);
        calculator=findViewById(R.id.calculator);
        calendarview=findViewById(R.id.calendar);

        Calendar calendar=Calendar.getInstance();
        final int year0 =calendar.get(Calendar.YEAR);
        final int month0 =calendar.get(Calendar.MONTH);
        final int date0 =calendar.get(Calendar.DAY_OF_MONTH);


       /* final int year01 =calendar.get(Calendar.YEAR);
        final int month01 =calendar.get(Calendar.MONTH);
        final int date01 =calendar.get(Calendar.DAY_OF_MONTH);*/



        calendarview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        agecalculator.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date=day+"/"+month+"/"+year;
                        date1.setText(date);

                    }
                },year0,month0,date0);
                        datePickerDialog.show();
            }
        });
        /*date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        agecalculator.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month=month+1;
                        String date=day+"/"+month+"/"+year;
                        date2.setText(date);

                    }
                },year01,month01,date01);
                datePickerDialog.show();
            }
        });*/
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String birthday = date1.getText().toString();
                //String today = date2.getText().toString();


                try {


                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
                    Date date1 = simpleDateFormat1.parse(birthday);
                   // Date date2 = simpleDateFormat1.parse(today);
                    Date date3 =  Calendar.getInstance().getTime();



                    long startdate = date1.getTime();
                    long endDate=date3.getTime();
                   // long endDate = date2.getTime();


                    if (startdate <= endDate) {
                        org.joda.time.Period period = new Period(startdate, endDate, PeriodType.yearMonthDay());
                        int years = period.getYears();
                        int months = period.getMonths();
                        int days = period.getDays();
                        year1.setText("Years of : "+Integer.toString(years));
                        month1.setText("Months of :"+Integer.toString(months));
                        day1.setText("Days of :"+Integer.toString(days));

                        // show the final output

                    } else {
                        // show message
                        Toast.makeText(agecalculator.this, "BirthDate should not be larger then today's date!", Toast.LENGTH_SHORT).show();
                    }
                }catch (ParseException e){
                    e.printStackTrace();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date1.setText("");
                year1.setText("");
                month1.setText("");
                day1.setText("");
            }
        });






    }


}