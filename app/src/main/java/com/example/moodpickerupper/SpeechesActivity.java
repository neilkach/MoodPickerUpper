package com.example.moodpickerupper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class SpeechesActivity extends YouTubeBaseActivity {

    YouTubePlayerView ytPlayer;
    public static final String API_KEY = "AIzaSyAqQ8Il4aVxo9dJEPPXODJ2CJAs7yzvhfs";
    Button button;
    Button button2;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    String id;
    EditText input;
    TextView tv;

    public static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speeches);
        button = findViewById(R.id.videobutton);
        button2 = findViewById(R.id.addbutton);
        ytPlayer = findViewById(R.id.ytPlayer);
        id = "";

        SharedPreferences idSave = getSharedPreferences(PREFS_NAME, 0);
        id = idSave.getString("video id", id);

        input = findViewById(R.id.input);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = input.getText().toString();
                SharedPreferences idSave = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = idSave.edit();
                editor.putString("video id", id);
                editor.commit();
                tv.setText("Your selection has been saved");
            }
        });
        tv = findViewById(R.id.textView4);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (id.equals(""))
                    tv.setText("You need to add a video first, see above");
                else
                    youTubePlayer.loadVideo(id);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ytPlayer.initialize(API_KEY, onInitializedListener);
            }
        });
    }

    public void speechVideosYoutube(View view) {
        Intent speechVideos = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=inspirational+speeches"));
        startActivity(speechVideos);
    }
}

