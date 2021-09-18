package com.example.employee;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class},version = 1)
public abstract class DBController extends RoomDatabase {
        private static DBController mDBController;
    public static DBController getInstance(Context context){
        if(mDBController==null){
            mDBController= Room.databaseBuilder(context.getApplicationContext(),
                    DBController.class,"Note").build();
        }
        return mDBController;
    }
    public abstract Dao getDao();
}
