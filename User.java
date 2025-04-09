package com.example.emeraldopendayapp;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.euicc.DownloadableSubscription;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class User extends AppCompatActivity {

    private Button faculties, chatbot, speechTimeTable, uniMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        faculties = findViewById(R.id.button4);
        chatbot = findViewById(R.id.button2);
        speechTimeTable = findViewById(R.id.button);
        uniMap = findViewById(R.id.button5);

        faculties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User.this, faculties.class);
                startActivity(intent);
            }
        });

        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(User.this, ChatBot.class);
                startActivity(intent);
            }
        });

        speechTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pdfUrl = "https://drive.google.com/uc?export=download&id=1o0Ti8PpeGYBZBE1Fne49BW16D4AW2zAi";
                String fileName = "speech_timetable.pdf";

                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(pdfUrl));
                request.setTitle("Downloading Speech Timetable");
                request.setDescription("Downloading: " + fileName);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    request.setDestinationInExternalFilesDir(User.this, Environment.DIRECTORY_DOWNLOADS, fileName);
                } else {
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
                }

                DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                if (downloadManager != null) {
                    downloadManager.enqueue(request);
                    Toast.makeText(User.this, "Download Started...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(User.this, "Failed to start download", Toast.LENGTH_SHORT).show();
                }
            }
        });

        uniMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pdfUrl = "https://drive.google.com/uc?export=download&id=14iCJR9It_j8ixgg7gKr24tUJTizY2X6a";
                String fileName = "university_map.pdf";

                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(pdfUrl));
                request.setTitle("Downloading University Map");
                request.setDescription("Downloading: " + fileName);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                // ✅ Use this for Android 10+ (Scoped Storage)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    request.setDestinationInExternalFilesDir(User.this, Environment.DIRECTORY_DOWNLOADS, fileName);
                } else {
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
                }

                DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                if (downloadManager != null) {
                    downloadManager.enqueue(request);
                    Toast.makeText(User.this, "Download Started...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(User.this, "Failed to start download", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}