package com.example.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class punchInOut extends AppCompatActivity {
    DBController mDBController;
    TextView timeAndDate;
  private String selectedDate="";

    private ArrayList<String> userType;
    List<Note> users;
    private  Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punch_in_out);
        Spinner spin = (Spinner) findViewById(R.id.spinner);


        userType=new ArrayList<>();
        timeAndDate=findViewById(R.id.select_date);
        selectedDate=getTodaydate(new Date());
        timeAndDate.setText(selectedDate +"/"+getCurrentTime());


    }

    private String getTodaydate(Date time) {
        return DateFormat.getDateInstance(DateFormat.MEDIUM).format(time);
    }
    private String getCurrentTime() {
        return DateFormat.getTimeInstance(DateFormat.DATE_FIELD).format(new Date());
    }
}