package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button addTask, allTasks;
    Button task1, task2, task3;
    String title1;
    String title2;
    String title3;
    private TextView taskTitle;
    private TextView taskBody;
    private TextView taskState;
    String title;
    String body;
    String state;
    ArrayList<Task> tasks=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addTask = findViewById(R.id.button2);
        allTasks = findViewById(R.id.button);

//        display “{username}’s tasks” above the three task buttons.
        TextView userTasks = findViewById(R.id.textView8);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        userTasks.setText(sharedPreferences.getString("username", "User") + "'s Tasks");


        taskTitle = findViewById(R.id.textView11);
        taskBody = findViewById(R.id.textView12);
        taskState = findViewById(R.id.textView13);

        RecyclerView tasksRecyclerView = findViewById(R.id.recyclerView);
        TaskAdapter taskAdapter=new  TaskAdapter(this,tasks);
        tasksRecyclerView.setAdapter(taskAdapter);

        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void addTask(View view) {
        Intent add = new Intent(MainActivity.this, AddTask.class);
        startActivity(add);
    }

    public void allTasks(View view) {
        Intent all = new Intent(MainActivity.this, AllTasks.class);
        startActivity(all);
    }

    public void setting(View view) {
        Intent setting = new Intent(MainActivity.this, SettingsPage.class);
        startActivity(setting);
    }
}