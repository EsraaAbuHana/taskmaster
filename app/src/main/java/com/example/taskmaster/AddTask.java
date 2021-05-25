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
    TextView submit;
    EditText taskTitle,taskDesc;
    Spinner addState;
    DAOsTask daOsTask;
    DBTask db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
//        submit.setVisibility(View.INVISIBLE);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       taskTitle= findViewById(R.id.taskTitle);
        taskDesc= findViewById(R.id.taskDesc);
        addState= findViewById(R.id.state);
        submit = findViewById(R.id.textView4);
       TextView totalTasks= findViewById(R.id.total);

        String[] taskState = new String[]{"New", "In progress", "Complete"};
        ArrayAdapter<String> tasksAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, taskState);
        tasksAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addState.setAdapter(tasksAdapter);
//        DBTask.getInstance(getApplicationContext()).dAOsTask();
        ArrayList<Task> taskList =   (ArrayList<Task>)  DBTask.getInstance(getApplicationContext()).dAOsTask().getAll();
        totalTasks.setText("Total Tasks: "+ taskList.size());

        db= Room.databaseBuilder(getApplicationContext(),
                DBTask.class, "task_database").allowMainThreadQueries().build();
        daOsTask=db.dAOsTask();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent back = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(back);
        return true;
    }

    public void submitTask(View view) {
        submit.setVisibility(View.VISIBLE);
//
//        EditText taskTitle= findViewById(R.id.taskTitle);
//        EditText taskDesc= findViewById(R.id.taskDesc);
//        state= findViewById(R.id.state);
////        submit = findViewById(R.id.textView4);
//        TextView totalTasks= findViewById(R.id.total);
        String title = taskTitle.getText().toString();
        String description = taskDesc.getText().toString();
        String state = addState.getSelectedItem().toString();

        Task task = new Task(title,description,state);
        task.setTitle(title);
        task.setBody(description);
        task.setState(state);
        daOsTask.insertAll(task);

        Intent intent = new Intent(AddTask.this, MainActivity.class);
        Toast.makeText(AddTask.this, "The Task Has been Added", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

}