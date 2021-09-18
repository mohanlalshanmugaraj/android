package com.example.timeentry.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TimeSheet.class},version = 1,exportSchema = false)
public abstract class DataBaseController extends RoomDatabase {
    private static DataBaseController mDbController;
    public static DataBaseController getInstance(Context context)
    {
        if(mDbController==null) {
            mDbController = Room.databaseBuilder(context.getApplicationContext(), DataBaseController.class, "timeSheet")
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return mDbController;
    }
    public abstract TimeSheetDao getDaoall();
}