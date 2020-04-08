package com.guna.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertUSDToINR(View view) {

        Log.i("Convertion:", "Started :-)");

        ImageView profileImage = (ImageView) findViewById(R.id.profileImageView);
        EditText dollerValue = (EditText) findViewById(R.id.amountText);
        View resetButton = findViewById(R.id.resetButton);


        if (dollerValue.getText().toString().matches("")) {
            Toast.makeText(this, "Please enter the amount?", Toast.LENGTH_SHORT).show();
            return;
        }
        // Change profile view into success
        profileImage.setImageResource(R.drawable.success);

        String amountString = dollerValue.getText().toString();

        // Parse to double
        Double amountDouble = Double.parseDouble(amountString);
        Double totalDouble = amountDouble * 75.42; // Date on 310320
        String totalString = String.format("%.2f", totalDouble);

        Toast.makeText(this, amountString + " USD = " + totalString + " INR", Toast.LENGTH_LONG).show();
        resetButton.setVisibility(View.VISIBLE);
    }

    public void resetView(View view) {

        ImageView profileImage = (ImageView) findViewById(R.id.profileImageView);
        EditText dollerValue = (EditText) findViewById(R.id.amountText);
        View resetButton = findViewById(R.id.resetButton);

        profileImage.setImageResource(R.drawable.coins);
        dollerValue.setText("");
        resetButton.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
