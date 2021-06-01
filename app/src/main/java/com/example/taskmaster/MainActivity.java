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

import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TaskAdapter.OnTaskListener {
    Button addTask, allTasks;
    ArrayList<Task> tasks=new ArrayList<>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        super.onCreate();

        try {
            Amplify.configure(getApplicationContext());
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Log.i("MyAmplifyApp", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("MyAmplifyApp", "Could not initialize Amplify", error);
        }


        setContentView(R.layout.activity_main);
        addTask = findViewById(R.id.button2);
        allTasks = findViewById(R.id.button);
//        System.out.println("task here**********************************************************************");
        System.out.println(DBTask.getInstance(getApplicationContext()).dAOsTask().getAll());
        tasks=(ArrayList<Task>) DBTask.getInstance(getApplicationContext()).dAOsTask().getAll();
//        System.out.println(tasks);
        //AWS
        //////////////////////////////////////////////////////
//        try {
//
//
//            Log.i("Tutorial", "Initialized Amplify");
//        } catch (AmplifyException e) {
//            Log.e("Tutorial", "Could not initialize Amplify", e);
//        }
        //////////////////////////////////////////////////////////////////////
        TextView userTasks = findViewById(R.id.textView8);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        userTasks.setText(sharedPreferences.getString("username", "User") + "'s Tasks");
        RecyclerView tasksRecyclerView = findViewById(R.id.recyclerView);

       tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//       AWS
       Task item = Task.builder()
                .title("Build Android application")
                .description("Build an Android application using Amplify")
                .build();
        Amplify.DataStore.save(item,
                success -> Log.i("Tutorial", "Saved item: " + success.item().getName()),
                error -> Log.e("Tutorial", "Could not save item to DataStore", error)
        );
        //////////////////////////////////////////////////////////////////
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
    @Override
    public void onTaskClick(int position) {
        Intent intent =new Intent(this, TaskDetailPage.class);
        System.out.println(tasks.get(position).getTitle());
        intent.putExtra("title",tasks.get(position).getTitle());
//        System.out.println(tasks.get(position).getBody());
//        intent.putExtra("body",tasks.get(position).getBody());
//        System.out.println(tasks.get(position).getState());
//        intent.putExtra("state",tasks.get(position).getState());
        startActivity(intent);
    }
}