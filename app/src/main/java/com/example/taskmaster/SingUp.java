package com.example.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;

import static com.amazonaws.services.cognitoidentityprovider.model.EventType.SignUp;

public class SingUp extends AppCompatActivity {
    EditText username, email, password;
    String  username1, email1, password1;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);


            username = findViewById(R.id.userName);
            email = findViewById(R.id.email);
            password = findViewById(R.id.password);

            signUp = findViewById(R.id.signUp);
        }
    public void signUp(View view) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        username1 = sharedPreferences.getString("username", "User");
        username1 = ( username.getText()).toString();
        email1 = ( email.getText()).toString();
        password1 = ( password.getText()).toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username1);
        editor.apply();
        AuthSignUpOptions options = AuthSignUpOptions.builder()
                .userAttribute(AuthUserAttributeKey.email(), email1)
                .build();
        Amplify.Auth.signUp(username1,password1, options,
                result -> Log.i("AuthQuickStart", "Result: " + result.toString()),
                error -> Log.e("AuthQuickStart", "Sign up failed", error)
        );

        Intent intent = new Intent(SignUp.this, LogIn.class);
        intent.putExtra("username", username1);
        startActivity(intent);

    }
    }
