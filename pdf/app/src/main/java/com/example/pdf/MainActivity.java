package com.example.pdf;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout layoutList;
    Button add;


     List <String>  itemListkg =new ArrayList<>();
    List <String>  itemListquentity =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutList=findViewById(R.id.layout_list);
        add=findViewById(R.id.btn_add);

        add.setOnClickListener(this);

        itemListkg.add("1 kg");
        itemListkg.add("1/2 kg");
        itemListkg.add("1 1/2 kg");
        itemListkg.add("2 kg");

        itemListquentity.add("1");
        itemListquentity.add("2");
        itemListquentity.add("3");
        itemListquentity.add("4");
        itemListquentity.add("5");
        itemListquentity.add("6");
        itemListquentity.add("7");
        itemListquentity.add("8");
        itemListquentity.add("9");
        itemListquentity.add("10");
        itemListquentity.add("11");
        itemListquentity.add("12");
        itemListquentity.add("13");
        itemListquentity.add("14");
        itemListquentity.add("15");
        itemListquentity.add("16");
        itemListquentity.add("17");
        itemListquentity.add("18");
        itemListquentity.add("19");
        itemListquentity.add("20");



    }

    @Override
    public void onClick(View v) {
        addView();
    }

    private void addView() {

        View  item=getLayoutInflater().inflate(R.layout.row_add,null,false);
        EditText editText =(EditText)item.findViewById(R.id.eid_name);
        AppCompatSpinner spinner=(AppCompatSpinner)item.findViewById(R.id.spinner_kg);

        ImageView image_close=(ImageView)item.findViewById(R.id.img_removeal);

        ArrayAdapter arrayAdapter1 =new ArrayAdapter(this, android.R.layout.simple_spinner_item,itemListkg);
        spinner.setAdapter(arrayAdapter1);



        image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removal(item);
            }
        });




        layoutList.addView(item);

    }
    private void removal(View view){
        layoutList.removeView(view);

    }
}
