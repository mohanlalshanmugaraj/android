package com.example.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    Button creatEmpoyee,punch,reports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creatEmpoyee=findViewById(R.id.createEmployee1);
        punch=findViewById(R.id.punch1);
        reports=findViewById(R.id.reports1);
        creatEmpoyee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,createEmpolyee.class);
                startActivity(intent);
            }
        });
        punch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,punchInOut.class);
                startActivity(intent);
            }
        });
        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,reports.class);
                startActivity(intent);

            }
        });


    }
}