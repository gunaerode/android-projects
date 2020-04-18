package com.guna.downloadwebcontent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public class DownloadContent extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            String result = null;
            URL url;
            HttpURLConnection urlConnection = null;

            try {

                url = new URL(urls[0]); // Only one url
                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                int data = inputStreamReader.read();

                while(data != -1) { // If content is not empty

                    char alphanumericChar = (char) data;

                    result += alphanumericChar;

                    data = inputStreamReader.read();

                }

                return result;
            } catch (Exception e) {
                e.printStackTrace();

                return "Something went wrong...";
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadContent downloadContent = new DownloadContent();
        String results = null;
        try {

            results = downloadContent.execute("http://placecorgi.com").get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("HTML Data: ", results);
    }

}

