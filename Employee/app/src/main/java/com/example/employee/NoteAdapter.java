package com.example.employee;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private List<Note> mNotes;
    private Context mContext;

    public NoteAdapter(Context context, List<Note> notes){
        mNotes =notes;
        mContext=context;
        ItemClicklistner deleteItemClicklistner;
    }

    @NonNull

    @Override
    public NoteAdapter.NoteViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NoteViewHolder holder, int position) {
        Note t=mNotes.get(position);
        holder.aName.setText(t.getName());
        holder.aId.setText(t.getId());
        holder.aDept.setText(t.getDept());

    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView aName, aId, aDept;
        Button mSave;

        public NoteViewHolder(@NonNull  View itemView) {
            super(itemView);
            aName=itemView.findViewById(R.id.tname);
            aId=itemView.findViewById(R.id.tdate);
            aDept=itemView.findViewById(R.id.punch_in_time);
            mSave=itemView.findViewById(R.id.save);
 mSave.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
            List<Note> note = new ArrayList<>(mNotes);

         Intent intent = new Intent(mContext, reports.class);
         intent.putExtra("note", (Parcelable) note);
         itemView.getContext().getApplicationContext().startActivity(intent);
     }
 });




        }
    }
}
