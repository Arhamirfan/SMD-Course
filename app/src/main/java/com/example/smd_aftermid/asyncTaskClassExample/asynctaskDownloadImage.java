package com.example.smd_aftermid.asyncTaskClassExample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.smd_aftermid.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class asynctaskDownloadImage extends AppCompatActivity {
    ImageView imageView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask_download_image);

        imageView = findViewById(R.id.asyncimgdownloadimage);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DownloadImage downloadImage=new DownloadImage();
                try {
                    Bitmap bitmap=
                            downloadImage.execute("https://media.istockphoto.com/photos/bigeyed-naughty-obese-cat-behind-the-desk-with-red-hat-grey-color-picture-id1199279669").get();
                    imageView.setImageBitmap(bitmap);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }



    class DownloadImage extends AsyncTask<String,Void, Bitmap>
    {
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url=new URL(strings[0]);
                try {
                    HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                    connection.connect();
                    InputStream inputStream = connection.getInputStream();
                    Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                    return bitmap;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
//    class DownloadImage extends AsyncTask<String,Void, Bitmap> //address, progress, imagetype
//    {
//
//        @Override
//        protected Bitmap doInBackground(String... strings) {
//            Log.d("TAG", "do in background ");
//            try {
//                URL url = new URL(strings[0]);
//                try {
//                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                    connection.connect();//jo url mille ga whan se us ko le aaye ga
//                    Log.d("TAG", "connection ");
//                    InputStream inputStream = connection.getInputStream();//stream result mai aaye ge wo store ho gye gi(bitmap); if text/load website read by streamReader
//                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream);// making a readable file
//                    return bitmap;
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }
}