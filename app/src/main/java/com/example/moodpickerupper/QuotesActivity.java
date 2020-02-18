package com.example.moodpickerupper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.style.QuoteSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class QuotesActivity extends AppCompatActivity {

    String text;
    public static final String PREFS_NAME = "MyPrefsFile";
    SharedPreferences fav;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        text = null;
        fav = getSharedPreferences(PREFS_NAME, 0);
        tv = findViewById(R.id.textView2);
        printQuote();
    }

    public void printQuote() {
        int lineNum = 0;
        int rand = (int) (Math.random()*101);
        BufferedReader reader;

        try{
            final InputStream file = getAssets().open("inspirationalQuotes.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            text = reader.readLine();
            while(true){
                if (lineNum == rand) {
                    text = reader.readLine();
                    if (text != "" && text!= null) {
                        tv.setText(text);
                        break;
                    }
                }
                reader.readLine();
                lineNum ++;
                if (text == null)
                    break;
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void addFavs(View view) {
        SharedPreferences.Editor editor = fav.edit();
        editor.putString("fav", text);
        editor.commit();
        TextView added = findViewById(R.id.added);
        added.setText("Added to favorites");
    }

    public void printFav(View view) {
        String favorite = "";
        favorite = fav.getString("fav", favorite);
        if (favorite.equals(""))
            tv.setText("Keep your face always toward the sunshine—and shadows will fall behind you.” —Walt Whitman");
        else
            tv.setText(favorite);
    }
}
