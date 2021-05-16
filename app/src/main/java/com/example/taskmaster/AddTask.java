package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddTask extends AppCompatActivity {
    TextView submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        submit = findViewById(R.id.textView4);
        submit.setVisibility(View.INVISIBLE);
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent back = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(back);
        return true;
    }

    public void submitTask(View view) {
        submit.setVisibility(View.VISIBLE);
    }

}