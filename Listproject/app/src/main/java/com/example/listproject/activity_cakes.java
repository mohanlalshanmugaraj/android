package com.example.listproject;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class activity_cakes extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<cakes> cakesList =new ArrayList<>();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_cakes);
        recyclerView=findViewById(R.id.recycler_cakes);

        LinearLayoutManager layoutManager =new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        cakesList=(ArrayList<cakes>)getIntent().getExtras().getSerializable("list");
        recyclerView.setAdapter(new cake_adapter(cakesList));

    }
}
