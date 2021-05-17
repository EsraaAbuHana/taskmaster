package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button addTask,allTasks;
Button task1,task2,task3;
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
        TextView user=findViewById(R.id.textView8)

    }

    public void addTask(View view) {
        Intent add=new Intent(MainActivity.this,AddTask.class);
        startActivity(add);
    }


    public void allTasks(View view) {
        Intent all=new Intent(MainActivity.this,AllTasks.class);
        startActivity(all);
    }
}