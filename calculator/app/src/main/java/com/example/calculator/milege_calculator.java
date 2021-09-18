package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class milege_calculator extends AppCompatActivity {
   EditText fr,sr,litre;
   Button result,reset;
   TextView milege;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();                  //title hideing
        setContentView(R.layout.activity_milege_calculator);
        fr=findViewById(R.id.first_reading);
        sr=findViewById(R.id.second_reading);
        litre=findViewById(R.id.litre);
        result=findViewById(R.id.result);
        reset=findViewById(R.id.reset);
        milege=findViewById(R.id.milege_view);
        if (litre.length() == 0) {
            litre.setError("how many litre");
        }
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fr.length() == 0) {
                    fr.setError("Plase Enter a First Reading");
                } else if (sr.length() == 0) {
                    sr.setError("Plase Enter a Secound Reading");
                } else if (litre.length() == 0) {
                    litre.setError("how many litre of fuel");
                } else {
                    int fr1 = Integer.parseInt(fr.getText().toString());
                    int sr1 = Integer.parseInt(sr.getText().toString());
                    float litre1 = Float.parseFloat(litre.getText().toString());
                    float result = (sr1 - fr1) / litre1;
                    milege.setText("Milege :" + Float.toString(result));
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fr.setText("");
                sr.setText("");
                litre.setText("");
                milege.setText("");
            }
        });
    }
}