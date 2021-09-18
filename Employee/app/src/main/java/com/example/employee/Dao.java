package com.example.employee;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface Dao  {

    @Query("select * from Note")
    List<Note> getAll();

    @Insert
    void insertData(Note note);

    @Query("select * from Note where id=:id")
    Note getId(String id);




}
