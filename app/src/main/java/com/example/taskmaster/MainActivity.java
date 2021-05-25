package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TaskAdapter.OnTaskListener {
    Button addTask, allTasks;
//    Button task1, task2, task3;
//    String title1;
//    String title2;
//    String title3;
    private TextView taskTitle;
    private TextView taskBody;
    private TextView taskState;
    String title;
    String body;
    String state;
    ///stuck
    DBTask db;
    DAOsTask daOsTask;
    ArrayList<Task> tasks ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addTask = findViewById(R.id.button2);
        allTasks = findViewById(R.id.button);

        //create an instance of the database
        db = Room.databaseBuilder(getApplicationContext(),
                DBTask.class, "dataBaseTask").allowMainThreadQueries().build();
        //get an instance of the DAO
        daOsTask = db.dAOsTask();
        tasks =(ArrayList<Task>)  daOsTask.getAll();

//        display “{username}’s tasks” above the three task buttons.
        TextView userTasks = findViewById(R.id.textView8);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        userTasks.setText(sharedPreferences.getString("username", "User") + "'s Tasks");


//        taskTitle = findViewById(R.id.textView11);
//        taskBody = findViewById(R.id.textView12);
//        taskState = findViewById(R.id.textView13);
//        tasks.add(new Task("First Task", "lorem ipsum", "Complete"));
//        tasks.add(new Task("Second Task", "lorem ipsum", "New"));
//        tasks.add(new Task("Third Task", "lorem ipsum ", "In progress"));

        RecyclerView tasksRecyclerView = findViewById(R.id.recyclerView);
        TaskAdapter taskAdapter = new TaskAdapter(tasks, this);
        tasksRecyclerView.setAdapter(taskAdapter);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this).setOrientation(RecyclerView.VERTICAL));

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

    //    Intent details3 = new Intent(MainActivity.this, TaskDetailPage.class);
//        details3.putExtra("title",title3);
//
//    startActivity(details3);
//
//}
    @Override
    public void onTaskClick(int position) {
//        tasks.get(position);
////        Log.d(TAG, "onTaskClick: clicked");
//
//        Intent intent = new Intent(this, TaskDetailPage.class);
//        Task task=new task(tasks.get(position).getTitle(), tasks.get(position).getBody(),tasks.get(position).getState()
//        );
//        DBTask.get
////        intent.putExtra("title", tasks.get(position).getTitle());
////        intent.putExtra("body", tasks.get(position).getBody());
////        intent.putExtra("state", tasks.get(position).getState());
//
//        startActivity(intent);
    }


//    @Override
//    protected void onResume() {
//        super.onResume();
//        tasks =  daOsTask.getAll();
//        RecyclerView tasksRecyclerView = findViewById(R.id.recyclerView);
//        TaskAdapter taskAdapter = new TaskAdapter(tasks, this);
//        tasksRecyclerView.setAdapter(taskAdapter);
//        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//
//    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        tasks =  daOsTask.getAll();
//        RecyclerView tasksRecyclerView = findViewById(R.id.recyclerView);
//        TaskAdapter taskAdapter = new TaskAdapter(tasks, this);
//        tasksRecyclerView.setAdapter(taskAdapter);
//        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        tasks =  daOsTask.getAll();
//        RecyclerView tasksRecyclerView = findViewById(R.id.recyclerView);
//        TaskAdapter taskAdapter = new TaskAdapter(tasks, this);
//        tasksRecyclerView.setAdapter(taskAdapter);
//        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }
}