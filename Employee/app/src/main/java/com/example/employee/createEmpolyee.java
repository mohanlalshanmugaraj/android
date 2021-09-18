package com.example.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.Executors;

public class createEmpolyee extends AppCompatActivity {
  private EditText eName,eId,eDept;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_empolyee);
        eName=findViewById(R.id.e_Name);
        eId=findViewById(R.id.e_Id);
        eDept=findViewById(R.id.e_dept);
        save=findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = eName.getText().toString().trim();
                final String id=eId.getText().toString().trim();
                final String dept=eDept.getText().toString().trim();
                    Note note=new Note();
                    note.setName(name);
                    note.setId(id);
                    note.setDept(dept);

                    Executors.newSingleThreadExecutor().execute(new Runnable() {
                        @Override
                        public void run() {
                            DBController.getInstance(createEmpolyee.this).getDao().getAll(note);
                        }
                    });



            }
        });
    }
}