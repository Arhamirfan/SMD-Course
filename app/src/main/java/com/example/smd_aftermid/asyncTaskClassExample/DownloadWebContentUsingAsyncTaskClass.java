package com.example.smd_aftermid.asyncTaskClassExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.smd_aftermid.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class DownloadWebContentUsingAsyncTaskClass extends AppCompatActivity {
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_web_content_using_async_task_class);

        editText = findViewById(R.id.edtmultiline);
        button = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadContent downloadContent = new DownloadContent();
                try {
                    String webcontent = downloadContent.execute("https://www.google.com/").get();
                    editText.setText(webcontent);
                    editText.setFocusable(false);
                    Log.d("TAG", "Back in main");
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    class DownloadContent extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            Log.d("TAG", "Do in Background in progress ");
            try {
                URL url = new URL(strings[0]);
                try {
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.connect();
                    Log.d("TAG", "connection");
                    InputStream inputStream = connection.getInputStream();
                    InputStreamReader reader = new InputStreamReader(inputStream);
                    int data = reader.read();
                    String CompleteContent = "";
                    while (data != -1)
                    {
                        char ch = (char) data;
                        CompleteContent +=ch;
                        data = reader.read();
                    }
                    return CompleteContent;
                } catch (IOException e) {
                    Log.d("TAG", "connection exception");
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                Log.d("TAG", "main try");
                e.printStackTrace();
            }
            return null;
        }
    }
}