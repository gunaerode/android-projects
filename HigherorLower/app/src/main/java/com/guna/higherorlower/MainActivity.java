package com.guna.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;
    public void randomNumberGenerator() {
        Random  randomObject = new Random();
        randomNumber = randomObject.nextInt(77) + 1;
        Log.i("Random Number: ", String.valueOf(randomNumber));
    }

    public void guessNumber(View view) {

        EditText guessNumberObject = (EditText) findViewById(R.id.guessBoxText);
        String guessNumberString = guessNumberObject.getText().toString();
        String message = "";

        if (guessNumberString != null && !guessNumberString.trim().isEmpty()) {

            // parse the string into integer
            int guessNumber = Integer.parseInt(guessNumberString);

            if (guessNumber > randomNumber) {
                message = "Higher value";
            } else if (guessNumber < randomNumber) {
                message = "Lower value";
            } else {
                message = "Good one, you found the number :-)";
                randomNumberGenerator();
            }
        } else {
            message = "Please enter the number?";
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // call randome number generator
        randomNumberGenerator();
    }
}
