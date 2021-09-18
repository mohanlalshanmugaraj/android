package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class emi_calculator extends AppCompatActivity {
    EditText p,r,t;
    Button result,reset;
    TextView emi,interest,totalamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();                  //title hideing

        setContentView(R.layout.activity_emi_calculator);
        p=findViewById(R.id.amount);
        r=findViewById(R.id.interest);
        t=findViewById(R.id.year);
        emi=findViewById(R.id.amount_view);
        interest=findViewById(R.id.interest_view);
        totalamount=findViewById(R.id.year_view);
        result=findViewById(R.id.result);
        reset=findViewById(R.id.reset);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(p.getText().toString().trim().equalsIgnoreCase("")){
                    p.setError("plase enter a amount");

                }
                else if(r.getText().toString().trim().equalsIgnoreCase("")){
                    r.setError("plase enter a interest");
                }
                else if(t.getText().toString().trim().equalsIgnoreCase("")){
                    t.setError("plase enter a year");
                }
                else{
                    float p1=Float.parseFloat(p.getText().toString());
                    float r1=Float.parseFloat(r.getText().toString());
                    float t1=Float.parseFloat(t.getText().toString());

                    int emiamount= (int) emi(p1,r1,t1);
                    emi.setText("Monthly EMI :"+emiamount);

                    int totalmoney= (int) ((t1*12)*emiamount);
                    totalamount.setText("Total amount :"+totalmoney);

                    int i= (int) (p1-totalmoney);
                    interest.setText("Interest payable :"+i);
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setText("");
                r.setText("");
                t.setText("");
                emi.setText("");
                interest.setText("");
                totalamount.setText("");
            }
        });


    }

    public static float emi(float principal,float interest,float time) {
        interest=interest / (12*100);
        time=time*12;
        float emi=(principal*interest*(float)Math.pow(1+interest,time))/(float)(Math.pow(1+interest, time)-1);
        return emi;
    }
}