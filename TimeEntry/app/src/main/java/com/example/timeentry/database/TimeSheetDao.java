package com.example.timeentry.database;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.timeentry.database.TimeSheet;

import java.util.List;

@androidx.room.Dao
public interface TimeSheetDao {

    @Query("SELECT * FROM timeSheet")
    List<TimeSheet> getAlldatas();

    @Insert
    void insertAllData(TimeSheet timeSheet);

    @Update
    void updateAllData(TimeSheet timeSheet);

    @Delete
    void delectAllData(TimeSheet timeSheet);
}
