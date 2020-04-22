package com.guna.activitydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DetailsPage extends AppCompatActivity {

    public void goBack(View view) {

        // Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        // startActivity(intent);

        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        Toast.makeText(this, String.valueOf(name), Toast.LENGTH_SHORT).show();
    }
}
