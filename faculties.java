package com.example.emeraldopendayapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class faculties extends AppCompatActivity {

    private Button engineerinng, mathsCompsci, contactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculties);

        engineerinng = findViewById(R.id.Engineering);
        mathsCompsci = findViewById(R.id.mathsCompsci);
        contactUs = findViewById(R.id.contactUs);


        engineerinng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.wlv.ac.uk/schools-and-institutes/faculty-of-science-and-engineering/school-of-engineering-computing-and-mathematical-sciences/engineering-/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        mathsCompsci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.wlv.ac.uk/schools-and-institutes/faculty-of-science-and-engineering/school-of-engineering-computing-and-mathematical-sciences/mathematics-and-computer-science/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.wlv.ac.uk/about-us/contacts-and-maps/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}