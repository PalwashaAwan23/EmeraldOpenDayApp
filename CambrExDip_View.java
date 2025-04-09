package com.example.emeraldopendayapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CambrExDip_View extends AppCompatActivity {

    private EditText inputMinGrade, inputMaxGrade, inputBTECID;
    private Button fetchButton;
    private TextView ocrDetails;
    private AdminApi adminApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambr_ex_dip_view);

        inputBTECID = findViewById(R.id.etPassword4);
        inputMinGrade = findViewById(R.id.etPassword2);
        inputMaxGrade = findViewById(R.id.etPassword3);
        ocrDetails = findViewById(R.id.textView7);
        fetchButton = findViewById(R.id.button4);

        adminApi = RetrofitClient.getClient().create(AdminApi.class);

        fetchButton.setOnClickListener(v -> fetchOCR());
    }

    private void fetchOCR() {
        String minGrade = inputMinGrade.getText().toString().trim();
        String maxGrade = inputMaxGrade.getText().toString().trim();
        String ocrId = inputBTECID.getText().toString().trim();


        if (!ocrId.isEmpty()) {
            int OCRId = Integer.parseInt(ocrId);
            viewOCRById(OCRId);
        } else if (!maxGrade.isEmpty()) {
            viewOCRByMaxGrade(maxGrade);
        } else if (!minGrade.isEmpty()) {
            viewOCRByMinGrade(minGrade);
        } else {
            Toast.makeText(this, "Please enter either OCR ID or Grade", Toast.LENGTH_SHORT).show();
        }
    }

    private void viewOCRById (int OCRId) {
        adminApi.getOCRById(OCRId).enqueue(new Callback<OCRResponse>() {
            @Override
            public void onResponse(Call<OCRResponse> call, Response<OCRResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    OCRResponse OCR = response.body();
                    updateUI(OCR);
                } else {
                    ocrDetails.setText("Error: OCR not found!");
                }
            }

            @Override
            public void onFailure(Call<OCRResponse> call, Throwable t) {
                ocrDetails.setText("Network error: " + t.getMessage());
            }
        });

    }

    private void viewOCRByMaxGrade(String maxgrade) {
        adminApi.getOCRByMaxGrade(maxgrade).enqueue(new Callback<OCRResponse>() {
            @Override
            public void onResponse(Call<OCRResponse> call, Response<OCRResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    OCRResponse BTEC = response.body();
                    updateUI(BTEC);
                } else {
                    ocrDetails.setText("Error: OCR not found!");
                }
            }

            @Override
            public void onFailure(Call<OCRResponse> call, Throwable t) {
                ocrDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void viewOCRByMinGrade(String mingrade) {
        adminApi.getOCRByMinGrade(mingrade).enqueue(new Callback<OCRResponse>() {
            @Override
            public void onResponse(Call<OCRResponse> call, Response<OCRResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    OCRResponse BTEC = response.body();
                    updateUI(BTEC);
                } else {
                    ocrDetails.setText("Error: OCR not found!");
                }
            }

            @Override
            public void onFailure(Call<OCRResponse> call, Throwable t) {
                ocrDetails.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void updateUI(OCRResponse ocr) {
        String details = "OCR ID: " + ocr.getOcrCaID() +
                "\nMax Grade: " + ocr.getMaxGrade() +
                "\nMin Grade: " + ocr.getMinGrade();

        ocrDetails.setText(details);
    }
}