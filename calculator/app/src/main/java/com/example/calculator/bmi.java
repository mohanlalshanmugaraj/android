package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bmi extends AppCompatActivity {
    TextView bmipounds,bmi;
    EditText weight,height;
    Button result,reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();                  //title hideing

        setContentView(R.layout.activity_bmi);
        bmipounds=findViewById(R.id.bmipounds);
        bmi=findViewById(R.id.bmi);
        weight=findViewById(R.id.weight1);
        height=findViewById(R.id.height1);
        result=findViewById(R.id.result);
        reset=findViewById(R.id.reset);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(weight.length()==0){
                    weight.setError("plase enter a weight");

                }
                else if(height.length()==0){
                    height.setError("plase enter a height");
                }
                else {
                    bmicalculate();
                }



            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight.setText("");
                height.setText("");
                bmi.setText("");
                bmipounds.setText("");
            }
        });
    }


    private void bmicalculate() {
        int weight1=Integer.parseInt(weight.getText().toString());
        float height1=Float.parseFloat(height.getText().toString());
        float height2=height1/100;
        float bmiresult=weight1/(height2*height2);
        bmi(bmiresult);
        bmipounds.setText("BMI = "+Float.toString(bmiresult));
    }
    private void bmi(float result) {
        if(result<18){
            bmi.setText("Under weight");
        }
        else if(result<25){
            bmi.setText("Normal Weight");
        }
        else if(result<30){
            bmi.setText("Over weight");
        }
        else{
            bmi.setText("Obese");
        }

    }
}