package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddTask extends AppCompatActivity {
TextView submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
submit=findViewById(R.id.textView4);
submit.setVisibility(View.INVISIBLE);
    }


    public void submitTask(View view) {
submit.setVisibility(View.VISIBLE);
    }
}