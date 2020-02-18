package com.example.moodpickerupper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MentalHealthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health);
    }

    public void site(View view) {
        Intent website = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mentalhealth.gov"));
        startActivity(website);
    }
}
