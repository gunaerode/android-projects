package com.guna.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {

        int number;

        public boolean isSquare() {

            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)) {

                return true;
            } else {

                return false;

            }

        }

        public boolean isTriangular() {

            int x = 1;

            int triangularNumber = 1;

            while (triangularNumber < number) {

                x++;
                triangularNumber = triangularNumber + x;
            }

            if (triangularNumber == number) {

                return true;
            } else {
                return false;
            }
        }
    }
    public void testNumber(View view) {

        EditText testNumberObject = (EditText) findViewById(R.id.numberBoxText);
        String testNumberString = testNumberObject.getText().toString();
        String message;

        if (testNumberString.isEmpty()) {

            message = "Please enter a number";

        } else {

            Number myNumber = new Number();

            myNumber.number = Integer.parseInt(testNumberString);

            message = testNumberString;

            if (myNumber.isSquare() && myNumber.isTriangular()) {

                message += " is square and triangular!";

            } else if (myNumber.isSquare()) {

                message += " is square but not triangular.";

            } else if (myNumber.isTriangular()) {

                message += " is triangular but not square.";

            } else {

                message += " is neither triangular nor square.";

            }

        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        Log.i("Given number", message);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
