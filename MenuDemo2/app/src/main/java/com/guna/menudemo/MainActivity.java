package com.guna.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView textView;
    String language;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void setLanguage(String language) {

        sharedPreferences.edit().putString("language", language).apply();
        textView.setText(language);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        super.onOptionsItemSelected(item);

        switch(item.getItemId()) {
            case R.id.clear:
                setLanguage("clear");
                Toast.makeText(this, "Language cleared", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.tamil:
                setLanguage("Tamil");
                Log.i("Item", "Settings");
                Toast.makeText(this, "Tamil", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.english:
                setLanguage("English");
                Log.i("Item", "Help");
                Toast.makeText(this, "English", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.language:
                if (language.equals("clear")) {
                    new AlertDialog.Builder(this)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Are you sure?")
                            .setMessage("Do you really want to continue?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    setLanguage("English");
                                    Toast.makeText(MainActivity.this, "Yes, dialogue", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    setLanguage("Tamil");
                                    Toast.makeText(MainActivity.this, "No dialogue", Toast.LENGTH_SHORT).show();
                                }
                            }).show();
                }
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("com.guna.menudemo", Context.MODE_PRIVATE);
        textView = (TextView) findViewById(R.id.textView);
        language = sharedPreferences.getString("language", "");

        if (!language.equals("clear")) {
            textView.setText(language);
        }
    }
}