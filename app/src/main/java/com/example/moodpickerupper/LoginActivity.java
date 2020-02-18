package com.example.moodpickerupper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void mainScreen(View view) {
        Intent mainIntent = new Intent(this, MainScreenActivity.class);
        startActivity(mainIntent);
    }

    public void signup(View view) {
        Intent signupIntent = new Intent(this, SignUpActivity.class);
        startActivity(signupIntent);
    }

}
