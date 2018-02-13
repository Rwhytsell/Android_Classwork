package com.domain.ryan.chapter5;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;
import java.util.ArrayList;

/**
 * Created by user on 2/13/18.
 */

public class DatabaseManager extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "taskDB";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_TASK = "task";
    private static final String ID = "id";
    private static final String MESSAGE = "message";
    private static final String DEADLINE = "deadline";
    private static final String COMPLETED = "completed";
    private static final String COMPLETED_DATE = "completed_date";

    public DatabaseManager( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String sqlCreate = "create table " + TABLE_TASK + "(" + ID;
            sqlCreate += " integer primary key autoincrement, " + MESSAGE + " text, ";
            sqlCreate += DEADLINE + " date, " + COMPLETED + " integer, " + COMPLETED_DATE + "date)";

            db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_TASK);
        onCreate(db);
    }

    public void insert( Task task ) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "insert into " + TABLE_TASK;
        sqlInsert += " values( null, \"" + task.getMessage();
        sqlInsert += "\", \"" + task.getDeadline();
        sqlInsert += "\", 0, null)";

        db.execSQL(sqlInsert);
        db.close();
    }

    public void deleteById( int id) {
        SQLiteDatabase db = this .getWritableDatabase();
        String sqlDelete = "delete from " + TABLE_TASK;
        sqlDelete += " where " + ID + " = " + id;

        db.execSQL(sqlDelete);
        db.close();
    }

    public ArrayList<Task> selectAll() {
        String sqlQuery = "select * from " + TABLE_TASK;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery( sqlQuery, null);

        ArrayList<Task> tasks = new ArrayList<Task>();
        while( cursor.moveToNext()) {
            Task currentTask = new Task( Integer.parseInt(cursor.getString( 0)),
                    cursor.getString( 1),
                    new Date(cursor.getLong(2)*1000),
                    Integer.parseInt(cursor.getString(3)));
            tasks.add(currentTask);
        }
        db.close();
        return tasks;
    }

    public Task selectById(int id){
        String sqlQuery = "select * from " + TABLE_TASK;
        sqlQuery += " where " + ID + " = " + id;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery( sqlQuery, null);

        Task task = null;
        if(cursor.moveToFirst()){
            task = new Task( Integer.parseInt(cursor.getString( 0)),
                    cursor.getString( 1),
                    new Date(cursor.getLong(2)*1000),
                    Integer.parseInt(cursor.getString(3)));
        }
        return task;
    }

    public void updateById(int id, Task newTask) {
        deleteById(id);
        insert(newTask);
    }


}
