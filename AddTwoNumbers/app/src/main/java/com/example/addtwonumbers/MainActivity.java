package com.example.addtwonumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView answer;
    EditText e1,e2;
    Button add,sub,mul,div,reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer=findViewById(R.id.answer);
        e1=findViewById(R.id.eid1);
        e2=findViewById(R.id.eid2);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        mul=findViewById(R.id.multiple);
        div=findViewById(R.id.div);
        reset=findViewById(R.id.reset);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sub();
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiple();
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                division();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText(" ");
                e2.setText(" ");
                answer.setText(" ");

                Toast.makeText(MainActivity.this, "reseted", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void division() {
        try {
            int temp1 = Integer.parseInt(e1.getText().toString());
            int temp2 = Integer.parseInt(e2.getText().toString());
            int temp3 = temp1 / temp2;
            answer.setText((Integer.toString(temp3)));
            Toast.makeText(this, "answer visible", Toast.LENGTH_SHORT).show();
        }catch (NumberFormatException e){
            Toast.makeText(this, "somthing is worng", Toast.LENGTH_SHORT).show();
        }
    }

    private void multiple() {
        try {
            int temp1 = Integer.parseInt(e1.getText().toString());
            int temp2 = Integer.parseInt(e2.getText().toString());
            int temp3 = temp1 * temp2;
            answer.setText((Integer.toString(temp3)));
            Toast.makeText(this, "answer visible", Toast.LENGTH_SHORT).show();
        }catch (NumberFormatException e){
            Toast.makeText(this, "somthing is worng", Toast.LENGTH_SHORT).show();
        }
    }

    private void sub() {
        try {
            int temp1 = Integer.parseInt(e1.getText().toString());
            int temp2 = Integer.parseInt(e2.getText().toString());
            int temp3 = temp1 - temp2;
            answer.setText((Integer.toString(temp3)));
            Toast.makeText(this, "answer visible", Toast.LENGTH_SHORT).show();
        }catch (NumberFormatException e){
            Toast.makeText(this, "somthing is worng", Toast.LENGTH_SHORT).show();
        }

    }

    private void add() {
        try {
            int temp1 = Integer.parseInt(e1.getText().toString());
            int temp2 = Integer.parseInt(e2.getText().toString());
            int temp3 = temp1 + temp2;
            answer.setText((Integer.toString(temp3)));
            Toast.makeText(this, "answer visible", Toast.LENGTH_SHORT).show();
        }catch (NumberFormatException e){
            Toast.makeText(this, "somthing is worng", Toast.LENGTH_SHORT).show();
        }
    }
}