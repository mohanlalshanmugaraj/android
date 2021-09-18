package com.example.timeentry.adapter;

import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timeentry.EditActivity;
import com.example.timeentry.database.DataBaseController;
import com.example.timeentry.database.TimeSheet;
import com.example.timeentry.databinding.ListItemBinding;

import java.util.List;
import java.util.concurrent.Executors;

public class TimeSheetAdapter extends RecyclerView.Adapter<TimeSheetAdapter.TimeSheetHolder> {
    Context mContext;
    List<TimeSheet> mList;

    public  TimeSheetAdapter(List<TimeSheet> lists){
        this.mList=lists;
    }


    @NonNull
    @Override
    public TimeSheetAdapter.TimeSheetHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        ListItemBinding mitemLayoutBinding = ListItemBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new TimeSheetHolder(mitemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull  TimeSheetHolder holder, int position) {
        TimeSheet timeSheets =mList.get(position);
        holder.mBinding.setTimesheet(timeSheets);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();


    }

    public class TimeSheetHolder extends RecyclerView.ViewHolder {
        ListItemBinding mBinding;
        public TimeSheetHolder(@NonNull ListItemBinding itemView) {
            super(itemView.getRoot());
            mBinding=itemView;

            itemView.edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimeSheet timeSheet=mList.get(getAdapterPosition());
                    Intent edit = new Intent(itemView.getRoot().getContext(), EditActivity.class);
                    edit.putExtra("timesheet",timeSheet);
                    itemView.getRoot().getContext().startActivity(edit);

                }
            });

            itemView.delect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    delectTimeSheet();
                }
            });
        }
        private void delectTimeSheet() {
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    TimeSheet timeSheet=mList.get(getAdapterPosition());
                    DataBaseController.getInstance(itemView.getContext()).getDaoall().delectAllData(timeSheet);
                    new Handler(Looper.getMainLooper()).post(() -> {
                        mList.remove(timeSheet);
                        notifyDataSetChanged();
                    });
                }
            });
        }


    }
}
