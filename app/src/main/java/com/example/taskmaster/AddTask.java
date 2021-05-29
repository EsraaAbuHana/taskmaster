package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddTask extends AppCompatActivity {
    EditText taskTitle,taskDesc;
    Spinner addState;
    DAOsTask daOsTask;
    DBTask db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       taskTitle= findViewById(R.id.taskTitle);
        taskDesc= findViewById(R.id.taskDesc);
        addState= findViewById(R.id.state);
       TextView totalTasks= findViewById(R.id.total);

        String[] taskState = new String[]{"New", "In progress", "Complete"};
        ArrayAdapter<String> tasksAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, taskState);
        tasksAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addState.setAdapter(tasksAdapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent back = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(back);
        return true;
    }

    public void submitTask(View view) {
        String title = taskTitle.getText().toString();
        String description = taskDesc.getText().toString();
        String state = addState.getSelectedItem().toString();

        Task task = new Task();
        task.setTitle(title);
        task.setBody(description);
        task.setState(state);
        System.out.println("add task : task is here *************************************************");
        System.out.println(task);

       DBTask.getInstance(getApplicationContext()).dAOsTask().insertAll(task);

        Intent intent = new Intent(AddTask.this, MainActivity.class);
        Toast.makeText(AddTask.this, "The Task Has been Added", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

}