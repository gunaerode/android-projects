package com.guna.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void showCredentials(View view) {

        // Get the login credentials
        EditText userName = (EditText) findViewById(R.id.userNameText);
        EditText password = (EditText) findViewById(R.id.passwordText);

        // Log here
        Log.i("Login details:", ":-)");
        Log.i("UserName: ", userName.getText().toString());
        Log.i("Password: ", password.getText().toString());

        Toast.makeText(this, "Login success...!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
