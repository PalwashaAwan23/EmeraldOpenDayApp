package com.example.emeraldopendayapp;



import android.health.connect.datatypes.StepsCadenceRecord;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.checkerframework.checker.units.qual.A;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class alevel_add extends AppCompatActivity {

    private EditText minGrade, maxGrade;
    private Button submitButton;

    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alevel_add);

        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        minGrade = findViewById(R.id.etMinGrade);
        maxGrade = findViewById(R.id.etMaxGrade);
        submitButton = findViewById(R.id.buttonAdd);

        submitButton.setOnClickListener( v -> addALevel());
    }

    private void addALevel() {
        String MinGrade = minGrade.getText().toString().trim();
        String MaxGrade = maxGrade.getText().toString().trim();

        if (MinGrade.isEmpty() || MaxGrade.isEmpty()) {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        ALevelResponse alevel = new ALevelResponse(null, MinGrade, MaxGrade);

        adminApi.addALevel(alevel).enqueue(new Callback<ALevelResponse>() {
            @Override
            public void onResponse(Call<ALevelResponse> call, Response<ALevelResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(alevel_add.this, "ALevel added successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(alevel_add.this, "Failed to add degree!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ALevelResponse> call, Throwable t) {
                Toast.makeText(alevel_add.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}