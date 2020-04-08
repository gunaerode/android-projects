package com.guna.catswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void changeCatImage(View view) {

        ImageView catImage = (ImageView) findViewById(R.id.catImageView);
        catImage.setImageResource(R.drawable.cat_3);

        Toast.makeText(this, "Hi, Cuty", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
