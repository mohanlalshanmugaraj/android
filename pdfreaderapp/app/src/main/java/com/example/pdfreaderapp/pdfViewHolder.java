package com.example.pdfreaderapp;

import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class pdfViewHolder extends RecyclerView.ViewHolder {
    public TextView tvname;
    public CalendarView container;

    public pdfViewHolder(@NonNull View itemView) {
        super(itemView);
        tvname =itemView.findViewById(R.id.textpdfname);
        container=itemView.findViewById(R.id.cardview);

    }
}
