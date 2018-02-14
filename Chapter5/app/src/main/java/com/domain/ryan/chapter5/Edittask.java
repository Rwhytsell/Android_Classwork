package com.domain.ryan.chapter5;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import java.sql.Date;
import java.util.Calendar;

public class Edittask extends AppCompatActivity {
    private DatabaseManager dbManager;
    private Date selectedDate;
    private Task thisTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_edittask);

        thisTask = TaskHolder.getInstance().getTask();

        Button update = findViewById(R.id.UpdateBtn);
        Button delete = findViewById(R.id.DeleteBtn);
        update.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                update(v);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                delete(v);
            }
        });

        EditText message = findViewById(R.id.TaskText);
        message.setText(thisTask.getMessage());

        CalendarView cal = findViewById(R.id.calendarView);
        cal.setDate(thisTask.getDeadline().getTime());
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                selectedDate = new Date(cal.getTime().getTime());
            }
        });
    }
    public void update (View v){
        EditText text = findViewById(R.id.TaskText);
        CalendarView cview = findViewById(R.id.calendarView);
        String taskText = text.getText().toString();
        Date deadline = selectedDate;
        Task newTask = new Task(taskText,deadline);
        dbManager.insert(newTask);
        dbManager.deleteById(thisTask.getID());
        finish();
    }

    public void delete(View v){
        dbManager.deleteById(thisTask.getID());
        finish();
    }

}
