package com.example.timeentry.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class TimeSheet implements Serializable {
    @NonNull
    @PrimaryKey(autoGenerate = false)

    private String task1;
    private String task2;
    private String task3;
    private String task4;
    private String task5;
    private String hour1;
    private String hour2;
    private String hour3;
    private String hour4;
    private String hour5;
    private String totalhours;
    private String date;

    public String getHour1() {
        return hour1;
    }

    public void setHour1(String hour1) {
        this.hour1 = hour1;
    }

    public String getHour2() {
        return hour2;
    }

    public void setHour2(String hour2) {
        this.hour2 = hour2;
    }

    public String getHour3() {
        return hour3;
    }

    public void setHour3(String hour3) {
        this.hour3 = hour3;
    }

    public String getHour4() {
        return hour4;
    }

    public void setHour4(String hour4) {
        this.hour4 = hour4;
    }

    public String getHour5() {
        return hour5;
    }

    public void setHour5(String hour5) {
        this.hour5 = hour5;
    }

    public String getTotalhours() {
        return totalhours;
    }

    public void setTotalhours(String totalhours) {
        this.totalhours = totalhours;
    }

    public String getTask1() {
        return task1;
    }

    public void setTask1(String task1) {
        this.task1 = task1;
    }

    public String getTask2() {
        return task2;
    }

    public void setTask2(String task2) {
        this.task2 = task2;
    }

    public String getTask3() {
        return task3;
    }

    public void setTask3(String task3) {
        this.task3 = task3;
    }

    public String getTask4() {
        return task4;
    }

    public void setTask4(String task4) {
        this.task4 = task4;
    }

    public String getTask5() {
        return task5;
    }

    public void setTask5(String task5) {
        this.task5 = task5;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
