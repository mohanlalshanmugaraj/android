package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class tip_calculator extends AppCompatActivity {
    EditText amount,persent;
    Button result,reset;
    TextView tipamount,totalamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();                  //title hideing
        setContentView(R.layout.activity_tip_calculator);


        amount=findViewById(R.id.amount);
        persent=findViewById(R.id.percent);
        result=findViewById(R.id.result);
        reset=findViewById(R.id.reset);
        tipamount=findViewById(R.id.tipamount);
        totalamount=findViewById(R.id.totalamount);


        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(amount.length()==0){
                    amount.setError("plase enter a Amount");

                }
                else if(persent.length()==0){
                    persent.setError("plase enter a persentage");
                }
                else {
                    int amount1 = Integer.parseInt(amount.getText().toString());
                    Float persent1 = Float.parseFloat(persent.getText().toString());
                    float tip = amount1 * persent1 / 100;
                    float total = amount1 + tip;
                    tipamount.setText("tip amount is : " + Float.toString(tip));
                    totalamount.setText("total amount is : " + Float.toString(total));
                }

            }
        });


        }
    }

