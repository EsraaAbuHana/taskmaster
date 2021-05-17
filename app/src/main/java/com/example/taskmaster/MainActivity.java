package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button addTask,allTasks;
Button task1,task2,task3;
String title1;
    String title2;
    String title3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addTask=findViewById(R.id.button2);
        allTasks=findViewById(R.id.button);
        task1=findViewById(R.id.button4);
        task2=findViewById(R.id.button5);
        task3=findViewById(R.id.button6);
//        display “{username}’s tasks” above the three task buttons.
        TextView userTasks=findViewById(R.id.textView8);
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
userTasks.setText(sharedPreferences.getString("username","User")+"'s Tasks");
   task1.setText("TASK 1");
        task2.setText("TASK 2");
        task3.setText("TASK 3");
        title1=task1.getText().toString();
        title2=task2.getText().toString();
        title3=task3.getText().toString();


    }

    public void addTask(View view) {
        Intent add=new Intent(MainActivity.this,AddTask.class);
        startActivity(add);
    }


    public void allTasks(View view) {
        Intent all=new Intent(MainActivity.this,AllTasks.class);
        startActivity(all);
    }

    public void taskDetails1(View view) {
        Intent details1 = new Intent( MainActivity.this, TaskDetailPage.class);
            details1.putExtra("title", title1);
            startActivity(details1);
    }

    public void taskDetails2(View view) {
        Intent details2 = new Intent( MainActivity.this, TaskDetailPage.class);
        details2.putExtra("title", title2);
        startActivity(details2);
    }

    public void taskDetails3(View view) {
        Intent details3 = new Intent( MainActivity.this, TaskDetailPage.class);
        details3.putExtra("title", title3);
        startActivity(details3);
    }

    public void setting(View view) {
        Intent setting=new Intent(MainActivity.this,SettingsPage.class);
        startActivity(setting);
    }
}