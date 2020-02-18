package com.example.moodpickerupper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void quote(View view) {
        Intent quoteIntent = new Intent(this, QuotesActivity.class);
        startActivity(quoteIntent);
    }

    public void videos(View view) {
        Intent videoIntent = new Intent(this, ChooseVideoActivity.class);
        startActivity(videoIntent);
    }

    public void info (View view) {
        Intent infoIntent = new Intent(this, MentalHealthActivity.class);
        startActivity(infoIntent);
    }
}
