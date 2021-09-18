package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.Instant;

public class Loginpage extends AppCompatActivity {
    EditText name1;
    Button btn1,skip1;

    private DatabaseReference mdataBaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();                  //title hideing

        setContentView(R.layout.activity_loginpage);

        name1=findViewById(R.id.name);
        btn1=findViewById(R.id.login);
        skip1=findViewById(R.id.skip);

       mdataBaseReference= FirebaseDatabase.getInstance().getReference();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mname=name1.getText().toString();
                mdataBaseReference.child(mname).setValue("present");
                Intent intent =new Intent(Loginpage.this,MainActivity.class);
                startActivity(intent);
            }
        });


        skip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Loginpage.this,MainActivity.class);
                startActivity(intent);
            }
        });



    }
}