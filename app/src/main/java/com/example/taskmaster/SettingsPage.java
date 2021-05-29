package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class SettingsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        Button submit =findViewById(R.id.button7);

        submit.setOnClickListener((view)->{
            EditText user_name_field=findViewById(R.id.editTextTextPersonName3);
            String name =user_name_field.getText().toString();
            SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor passed_name=sharedPreferences.edit();
                        passed_name.putString("username",name);
passed_name.apply();
            Intent main=new Intent(SettingsPage.this,MainActivity.class);
            startActivity(main);

        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent back = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(back);
        return true;
    }
}