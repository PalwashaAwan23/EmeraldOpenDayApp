package com.example.emeraldopendayapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HEDiploma_Add extends AppCompatActivity {

    private EditText minGrade, maxGrade;
    private Button submitButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hediploma_add);

        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        minGrade = findViewById(R.id.etPassword3);
        maxGrade = findViewById(R.id.etPassword1);
        submitButton = findViewById(R.id.button4);

        submitButton.setOnClickListener( v -> addHEDiploma());
    }

    private void addHEDiploma() {
        String MinGrade = minGrade.getText().toString().trim();
        String MaxGrade = maxGrade.getText().toString().trim();

        if (MinGrade.isEmpty() || MaxGrade.isEmpty()) {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        HEDiplomaResponse heDiploma = new HEDiplomaResponse(null, MinGrade, MaxGrade);

        adminApi.addHE(heDiploma).enqueue(new Callback<HEDiplomaResponse>() {
            @Override
            public void onResponse(Call<HEDiplomaResponse> call, Response<HEDiplomaResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(HEDiploma_Add.this, "ALevel added successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(HEDiploma_Add.this, "Failed to add degree!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<HEDiplomaResponse> call, Throwable t) {
                Toast.makeText(HEDiploma_Add.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}