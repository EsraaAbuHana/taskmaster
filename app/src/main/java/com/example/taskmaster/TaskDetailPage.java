package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.TextView;

public class TaskDetailPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail_page);

        TextView task_heading = findViewById(R.id.textView6);
        TextView body = findViewById(R.id.textView7);
        TextView state = findViewById(R.id.textView8);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String title = getIntent().getStringExtra("title");
        String body1 = getIntent().getStringExtra("body");
        String state1 = getIntent().getStringExtra("state");
        task_heading.setText(sharedPreferences.getString("username", "User") + "'s " + title + " Detail");

        if(title==null){
        task_heading.setText(sharedPreferences.getString("username", "User") + "'s " + " Detail");
        body.setText(body1);
            body.setText(state1);

        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent back = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(back);
        return true;
    }
}