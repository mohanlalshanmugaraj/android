package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class moreGirdView extends AppCompatActivity {
    Button bmi,age,tip,milege,fuel,emi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();                  //title hideing
        setContentView(R.layout.activity_more_gird_view);
        bmi=findViewById(R.id.bmi);
        age=findViewById(R.id.agecalculator);
        tip=findViewById(R.id.tipcalculator);
        milege=findViewById(R.id.milege_calculator);
        fuel=findViewById(R.id.fuel_calculator);
        emi=findViewById(R.id.emI_calculator);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(moreGirdView.this,bmi.class);
                startActivity(intent);
            }
        });
        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(moreGirdView.this,agecalculator.class);
                startActivity(intent);


            }
        });
        tip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(moreGirdView.this,tip_calculator.class);
                startActivity(intent);
            }
        });
        milege.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(moreGirdView.this,milege_calculator.class);
                startActivity(intent);
            }
        });
        fuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(moreGirdView.this,fuel_calculator.class);
                startActivity(intent);
            }
        });
        emi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(moreGirdView.this,emi_calculator.class);
                startActivity(intent);
            }
        });

    }
}