package com.guna.interactiviydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void showName(View view) {
        EditText nameEdit = (EditText) findViewById(R.id.nameEdit);

        Log.i("Event", "Click :-)");
        Log.i("Name:", nameEdit.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
