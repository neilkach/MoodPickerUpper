package com.example.moodpickerupper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_video);
    }

    public void speech(View view) {
        Intent speechIntent = new Intent(this, SpeechesActivity.class);
        startActivity(speechIntent);
    }

}
