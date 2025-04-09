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

public class CambrExDip_Add extends AppCompatActivity {

    private EditText minGrade, maxGrade;
    private Button submitButton;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambr_ex_dip_add);

        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        minGrade = findViewById(R.id.etPassword3);
        maxGrade = findViewById(R.id.etPassword1);
        submitButton = findViewById(R.id.button4);

        submitButton.setOnClickListener( v -> addOCR());
    }

    private void addOCR() {
        String MinGrade = minGrade.getText().toString().trim();
        String MaxGrade = maxGrade.getText().toString().trim();

        if (MinGrade.isEmpty() || MaxGrade.isEmpty()) {
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        OCRResponse ocrResponse = new OCRResponse(null, MinGrade, MaxGrade);

        adminApi.addOCR(ocrResponse).enqueue(new Callback<OCRResponse>() {
            @Override
            public void onResponse(Call<OCRResponse> call, Response<OCRResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(CambrExDip_Add.this, "OCR added successfully!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(CambrExDip_Add.this, "Failed to add OCR!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OCRResponse> call, Throwable t) {
                Toast.makeText(CambrExDip_Add.this, "Network error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}