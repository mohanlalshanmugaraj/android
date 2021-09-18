package com.example.listproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout layoutList;
    Button buttonAdd;
    Button buttonsubmit;





    List<String> itemListkg =new ArrayList<>();
    List<String> itemListqu =new ArrayList<>();

    ArrayList<cakes> cakesList =new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutList=findViewById(R.id.layout_list);
        buttonAdd=findViewById(R.id.button_add);
        buttonsubmit=findViewById(R.id.button_submit_list);
       



        buttonAdd.setOnClickListener(this);
        buttonsubmit.setOnClickListener(this);

        itemListkg.add("kg");
        itemListkg.add("1 kg");
        itemListkg.add("1/2 kg");
        itemListkg.add("1 1/2 kg");
        itemListkg.add("2 kg");

        itemListqu.add("quantity");
        itemListqu.add("1");
        itemListqu.add("2");
        itemListqu.add("3");
        itemListqu.add("4");
        itemListqu.add("5");
        itemListqu.add("6");
        itemListqu.add("7");
        itemListqu.add("8");
        itemListqu.add("9");
        itemListqu.add("10");

        //toast message starting
        //Toast toast=Toast.makeText(getApplicationContext(),"Enter a cake details",Toast.LENGTH_SHORT);
        //toast.show();


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_add:
                addView();
                break;
            case R.id.button_submit_list:;
            if(checkifVaildAndRead()){
                Intent intent=new Intent(MainActivity.this,activity_cakes.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("list",cakesList);
                intent.putExtras(bundle);
                startActivity(intent);

            }

            break;

        }


    }

    private boolean checkifVaildAndRead() {
        cakesList.clear();
        boolean result=true;

        for(int i=0;i<layoutList.getChildCount();i++){
            View itemview=layoutList.getChildAt(i);

            EditText editTextName =(EditText)itemview.findViewById(R.id.edit_cricketer_name);
            AppCompatSpinner spinner1=(AppCompatSpinner)itemview.findViewById(R.id.spinner_team1);
            AppCompatSpinner spinner2=(AppCompatSpinner)itemview.findViewById(R.id.spinner_team2);

            cakes cake=new cakes();
            if(!editTextName.getText().toString().equals("")){
                cake.setCake_name(editTextName.getText().toString());
            }else{
                result = false;
                break;
            }

            if(spinner1.getSelectedItemPosition()!=0 ){
                cake.setCake_kg(itemListkg.get(spinner1.getSelectedItemPosition()));
            }else{
                result = false;
                break;
            }

            if(spinner2.getSelectedItemPosition()!=0 ){
                cake.setCake_quentity(itemListqu.get(spinner2.getSelectedItemPosition()));
            }else{
                result = false;
                break;
            }
            cakesList.add(cake);

        }
        if(cakesList.size()==0){
            result=false;
            Toast.makeText(this, "Add cake name First", Toast.LENGTH_SHORT).show();
        }else if(!result){
            Toast.makeText(this, "Enter all details correctly", Toast.LENGTH_SHORT).show();
        }
        return result;

    }


    private void addView() {
        View  item=getLayoutInflater().inflate(R.layout.row_add_layout,null,false);
        EditText editText =(EditText)item.findViewById(R.id.edit_cricketer_name);
        AppCompatSpinner spinner1=(AppCompatSpinner)item.findViewById(R.id.spinner_team1);
        AppCompatSpinner spinner2=(AppCompatSpinner)item.findViewById(R.id.spinner_team2);
        ArrayAdapter<String> adapter;


        ImageView image_close=(ImageView)item.findViewById(R.id.image_remove);

        ArrayAdapter arrayAdapter1 =new ArrayAdapter(this, android.R.layout.simple_spinner_item,itemListkg);
        spinner1.setAdapter(arrayAdapter1);
        ArrayAdapter arrayAdapter2 =new ArrayAdapter(this, android.R.layout.simple_spinner_item,itemListqu);
        spinner2.setAdapter(arrayAdapter2);

        //toast message for adding
        //Toast toast=Toast.makeText(getApplicationContext(),"added item, Enter a cake name..",Toast.LENGTH_SHORT);
        //toast.show();
        //lv.setAdapter(item);

        image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeView(item);
            }
        });
        layoutList.addView(item);


    }
    private void removeView(View view){
        layoutList.removeView(view);

        //toast messege for removeal
        Toast toast=Toast.makeText(getApplicationContext(),"item removed",Toast.LENGTH_SHORT);
        toast.show();

    }
}