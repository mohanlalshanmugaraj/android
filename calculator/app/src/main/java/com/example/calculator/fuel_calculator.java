package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class fuel_calculator extends AppCompatActivity {
    EditText distance,milege,litre;
    Button result,reset;
    TextView fuel_litre,fuel_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();                  //title hideing

        setContentView(R.layout.activity_fuel_calculator);

        distance=findViewById(R.id.distance);
        milege=findViewById(R.id.milege);
        litre=findViewById(R.id.litre);
        fuel_litre=findViewById(R.id.fuel_litre);
        fuel_amount=findViewById(R.id.fuel_amount);
        result=findViewById(R.id.result);
        reset=findViewById(R.id.reset);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(distance.length()==0){
                    distance.setError("Plase Enter a Distance");
                }
                else if(milege.length()==0){
                    milege.setError("Plase Enter a Milege");
                }
                else if(litre.length()==0){
                    litre.setError("Plase Enter a Fuel Price");
                }
                else {
                    float distance1 = Float.parseFloat(distance.getText().toString());
                    float milege1 = Float.parseFloat(milege.getText().toString());
                    float litre1 = Float.parseFloat(litre.getText().toString());
                    float fuel_litre1 = distance1 / milege1;
                    float fuel_amount1 = fuel_litre1 * litre1;
                    fuel_litre.setText("Litre :" + Float.toString(fuel_litre1));
                    fuel_amount.setText("Fuel Amount :" + Float.toString(fuel_amount1));


                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                distance.setText("");
                milege.setText("");
                litre.setText("");
                fuel_litre.setText("");
                fuel_amount.setText("");

            }
        });

    }
}