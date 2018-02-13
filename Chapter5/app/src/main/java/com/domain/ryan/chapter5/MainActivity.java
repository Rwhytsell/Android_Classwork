package com.domain.ryan.chapter5;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DatabaseManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_main);
        setSupportActionBar(null);

        setListView();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newTask(view);
            }
        });
    }

    public void newTask(View view) {
        Intent newtask = new Intent(this, Newtask.class);
        startActivity(newtask);
    }

    public void setListView(){
        ArrayList<Task> tasks = dbManager.selectAll();

        Task[] taskArray = (Task[]) tasks.toArray(new Task[0]);

        ListView lView = findViewById(R.id.TaskList);
        lView.setAdapter(new taskAdapter(this, taskArray, dbManager));
    }

    protected void onResume(){
        super.onResume();
        setListView();
    }
}
