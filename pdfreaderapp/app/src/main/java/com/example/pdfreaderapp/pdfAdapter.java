package com.example.pdfreaderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.List;

public class pdfAdapter extends RecyclerView.Adapter<pdfViewHolder> {
    private Context context;
    private List<File> pdffiles;

    public pdfAdapter(Context mainActivity, List<File> pdfList) {
        this.context=context;
        this.pdffiles=pdfList;
    }


    @NonNull
    @Override
    public pdfViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        return new pdfViewHolder(LayoutInflater.from(context).inflate(R.layout.element_holder,parent,false));


    }

    @Override
    public void onBindViewHolder(@NonNull  pdfViewHolder holder, int position) {
        holder.tvname.setText(pdffiles.get(position).getName());
        holder.tvname.setSelected(true);

    }

    @Override
    public int getItemCount() {
        return pdffiles.size();
    }



}
