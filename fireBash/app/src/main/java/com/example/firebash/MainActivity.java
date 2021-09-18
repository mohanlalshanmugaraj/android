package com.example.firebash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button btn;
    TextView emname;

    private ListView listView;
    private String names[]={"anand","akash","boobathiraj","boobathi","dinesh","dhanush","dharani","esther","guru","gayathri","jagathiesh",
    "karthik","kanesh","kamalakannan","lalith","mohanlal","mohanraj","moni","monisha","nanthini","ramesh","narmatha","nandha",
      "oviya","murugesh","parameshwari","sridhar","sabari","karthika","karthi","kamali","karvanthan"};

    private DatabaseReference mdataBaseReference;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.ename);
        btn=findViewById(R.id.btn);
        listView=findViewById(R.id.list);
        emname=findViewById(R.id.em_name);



        adapter =new ArrayAdapter<String>(this,R.layout.name,R.id.em_name,names);
        listView.setAdapter(adapter);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(getApplicationContext(),"before text change",Toast.LENGTH_LONG).show();
            }

            @Override
            public void afterTextChanged(Editable s) {
                Toast.makeText(getApplicationContext(),"after text change",Toast.LENGTH_LONG).show();
            }
        });
       



        mdataBaseReference= FirebaseDatabase.getInstance().getReference();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String mname=name.getText().toString();
               mdataBaseReference.child(mname).setValue("present");
                Toast.makeText(MainActivity.this, "attendance submited", Toast.LENGTH_SHORT).show();



            }
        });
    }
}