package com.domain.ryan.chapter5;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class Newtask extends AppCompatActivity {
    private DatabaseManager dbManager;
    private Date selectedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_newtask);

        Button submit = findViewById(R.id.SubmitBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                insert(v);
            }
        });

        CalendarView cv = findViewById(R.id.calendarView);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, month);
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                selectedDate = cal.getTime();
            }
        });
    }
    public void insert (View v){
        EditText text = findViewById(R.id.TaskText);
        CalendarView cview = findViewById(R.id.calendarView);
        String taskText = text.getText().toString();
        Date deadline = selectedDate;
        Task newTask = new Task(taskText,deadline);
        dbManager.insert(newTask);
        finish();
    }

}
