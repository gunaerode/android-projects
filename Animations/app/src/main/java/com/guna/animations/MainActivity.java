package com.guna.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean imageShow = true;
    public void showAnimation(View view){

        // just checking the tag attribute
        // Button buttonTag = (Button) view;
        // Log.i("Tag value for button: ", buttonTag.getTag().toString());
        ImageView animationImage = (ImageView) findViewById(R.id.animationImageView);

        if (imageShow) {

            // animationImage.animate().translationX(1100).setDuration(1000);
            animationImage.animate().scaleX(-0.1f).scaleY(-0.1f).setDuration(1000);
            imageShow = false;
        } else {

            // animationImage.animate().translationX(0).setDuration(1000);
            animationImage.animate().scaleX(0.9f).scaleY(0.9f).setDuration(1000);
            imageShow = true;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
