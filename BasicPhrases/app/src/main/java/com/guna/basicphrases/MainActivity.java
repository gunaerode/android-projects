package com.guna.basicphrases;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void playPhrase(View view) {

        Button buttonObj = (Button) view;

        // Get the tag
        String tagName = buttonObj.getTag().toString();
        // Toast.makeText(this, tagName, Toast.LENGTH_SHORT).show();


        MediaPlayer mediaPlayer = MediaPlayer.create(this, getResources().getIdentifier(tagName, "raw", getPackageName()));
        mediaPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
