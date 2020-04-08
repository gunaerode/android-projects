package com.guna.audiodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    public void playMusic(View view) {
        mediaPlayer.start();
    }

    public void pauseMusic(View view) {
        mediaPlayer.pause();
    }

    public void stopMusic(View view) {
        mediaPlayer.stop();
        playAgain();
    }

    public void playAgain() {

        mediaPlayer = MediaPlayer.create(this, R.raw.uchiha_sarada);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.shikamaru);

        // Get the System audio service details
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        // get max volume from device
        int deviceMaxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        // get current volume
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        // Volume controller using seek bar
        SeekBar volumeControl = (SeekBar) findViewById(R.id.volumeSeekBar);

        // set max volume for seek bar
        volumeControl.setMax(deviceMaxVolume);
        // set current value
        volumeControl.setProgress(currentVolume);

        volumeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Log.i("Volume: ", Integer.toString(progress));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Audio progress seek bar
        final SeekBar audioProgress = (SeekBar) findViewById(R.id.scrubSeekBar);

        audioProgress.setMax(mediaPlayer.getDuration());

        audioProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // long minutes = TimeUnit.SECONDS.toMinutes(progress);
                // Toast.makeText(MainActivity.this, minutes + "", Toast.LENGTH_SHORT).show();

                // grab it or drag to starting the progress
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mediaPlayer.pause();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.start();
            }
        });

        // Get the media player current position to show the audio progress
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                audioProgress.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 1000);
    }
}
