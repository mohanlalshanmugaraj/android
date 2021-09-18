package com.example.twonumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2,b3,b4,reset;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.e1);
        e2=(EditText)findViewById(R.id.e2);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        reset=findViewById(R.id.reset);
        t1=findViewById(R.id.t1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int fn=Integer.parseInt(e1.getText().toString());
                int sn=Integer.parseInt(e2.getText().toString());
                int equal=fn+sn;
                t1.setText(Integer.toString(equal));
                Toast.makeText(getApplicationContext(),"Adding two numbers",Toast.LENGTH_LONG).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int fn=Integer.parseInt(e1.getText().toString());
                int sn=Integer.parseInt(e2.getText().toString());
                int equal=fn-sn;
                t1.setText(Integer.toString(equal));
                Toast.makeText(getApplicationContext(),"Subtract two numbers",Toast.LENGTH_LONG).show();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int fn=Integer.parseInt(e1.getText().toString());
                int sn=Integer.parseInt(e2.getText().toString());
                int equal=fn*sn;
                t1.setText(Integer.toString(equal));
                Toast.makeText(getApplicationContext(),"Multiple two numbers",Toast.LENGTH_LONG).show();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int fn=Integer.parseInt(e1.getText().toString());
                int sn=Integer.parseInt(e2.getText().toString());
                int equal=fn/sn;
                t1.setText(Integer.toString(equal));
                Toast.makeText(getApplicationContext(),"Divisable two numbers",Toast.LENGTH_LONG).show();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(" ");
                e2.setText(" ");
                t1.setText(" ");
                Toast.makeText(getApplicationContext(),"Reset the Text",Toast.LENGTH_LONG).show();
            }
        });
    }
}